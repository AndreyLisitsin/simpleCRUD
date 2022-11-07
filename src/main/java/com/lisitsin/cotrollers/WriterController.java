package com.lisitsin.cotrollers;

import com.lisitsin.models.Writer;
import com.lisitsin.services.WriterService;

import java.util.List;

public class WriterController {

    private final WriterService writerService;

    public WriterController(WriterService writerService) {
        this.writerService = writerService;
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
