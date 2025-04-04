package com.example.gestionitems.service;

import com.example.gestionitems.model.Item;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CSVReaderService {

    public List<Item> readCSV(String filePath) throws IOException {
        File csvFile = new File(filePath);
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        MappingIterator<Item> iterator = csvMapper.readerFor(Item.class).with(schema).readValues(csvFile);
        return iterator.readAll();
    }
}
