package com.lisitsin.cotrollers;

import com.lisitsin.entities.Writer;
import com.lisitsin.repositories.WriterRepository;
import com.lisitsin.repositories.impl.jsonImpl.JsonWriterRepositoryImpl;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLWriterRepository;
import com.lisitsin.services.WriterService;
import com.lisitsin.services.impl.WriterServiceImpl;

import java.util.List;

public class WriterController {

    private final WriterService writerService;

    public WriterController(){
        writerService = new WriterServiceImpl(new MySQLWriterRepository());
    }

    public void deleteWriter(long id){
        writerService.deleteById(id);
    }

    public void addWriter(Writer writer){
        writerService.save(writer);
    }

    public Writer getWriterById(long id){
        return writerService.getById(id);
    }

    public Writer modifyWriter(Writer writer){
        writerService.update(writer);
        return writer;
    }

    public List<Writer> getAllWriters(){
        return writerService.getAll();
    }
}
