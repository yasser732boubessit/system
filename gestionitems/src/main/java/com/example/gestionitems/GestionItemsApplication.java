package com.example.gestionitems;

import com.example.gestionitems.model.Item;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class GestionItemsApplication implements CommandLineRunner {

    private final KafkaTemplate<String, Item> kafkaTemplate;

    @Value("${kafka.topic.items}")
    private String topic;

    public GestionItemsApplication(KafkaTemplate<String, Item> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionItemsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        File file = new File(getClass().getClassLoader().getResource("Items_plista.csv").toURI());

        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Item> iterator = csvMapper.readerFor(Item.class).with(schema).readValues(file);

        List<Item> items = iterator.readAll();

        for (Item item : items) {
            System.out.println("🔵 Sending item to Kafka: " + item.getCategories());
            kafkaTemplate.send(topic, item);
        }
    }
}
