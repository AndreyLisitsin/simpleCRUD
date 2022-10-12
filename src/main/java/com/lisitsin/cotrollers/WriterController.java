package com.lisitsin.cotrollers;

import com.lisitsin.entities.Writer;
import com.lisitsin.repositories.WriterRepository;
import com.lisitsin.repositories.impl.JsonWriterRepositoryImpl;

import java.util.List;
import java.util.Scanner;

public class WriterController {

    WriterRepository writerRepository;

    public WriterController(){
        writerRepository = new JsonWriterRepositoryImpl();
    }

    public void deleteWriter(long id){
            writerRepository.deleteById(id);
    }

    public void addWriter(Writer writer){
        writerRepository.save(writer);
    }

    public Writer getWriterById(long id){
        return writerRepository.getById(id);
    }

    public Writer modifyWriter(Writer writer){
        writerRepository.update(writer);
        return writer;
    }

    public List<Writer> getAllWriters(){
        return writerRepository.getAll();
    }
}
