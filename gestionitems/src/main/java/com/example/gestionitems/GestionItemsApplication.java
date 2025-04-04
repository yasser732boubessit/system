package com.example.gestionitems;

import com.example.gestionitems.model.Item;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class GestionItemsApplication implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String replyServiceUrl = "http://localhost:8082/reply";

    public static void main(String[] args) {
        SpringApplication.run(GestionItemsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sendCsvData();
    }

    @Scheduled(fixedRate = 10000) // Envoyer toutes les 10 secondes  src\main\java\com\example\gestionitems\Items_plista.csv
    public void sendCsvData() {
        try {
            File file = new File(getClass().getClassLoader().getResource("Items_plista.csv").toURI());
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Item> iterator = csvMapper.readerFor(Item.class).with(schema).readValues(file);

            List<Item> items = iterator.readAll();
            
            for (Item item : items) {
                System.out.println("🔵 Sending item: " + item.getCategories());
                restTemplate.postForObject(replyServiceUrl, item, String.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
