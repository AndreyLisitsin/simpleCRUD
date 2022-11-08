package com.lisitsin.cotrollers;

import com.lisitsin.models.Writer;
import com.lisitsin.myAnnotations.InjectByType;
import com.lisitsin.services.WriterService;

import java.util.List;

public class WriterController {

    @InjectByType
    private WriterService writerService;

    public void deleteWriter(Long id){
        writerService.deleteById(id);
    }

    public void addWriter(Writer writer){
        writerService.save(writer);
    }

    public Writer getWriterById(Long id){
        return writerService.getById(id);
    }

    public Writer modifyWriter(Writer writer){
        return writerService.update(writer);
    }

    public List<Writer> getAllWriters(){
        return writerService.getAll();
    }
}
