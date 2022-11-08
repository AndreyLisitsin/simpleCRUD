package com.lisitsin.services.impl;

import com.lisitsin.models.Writer;
import com.lisitsin.myAnnotations.DBService;
import com.lisitsin.myAnnotations.InjectByType;
import com.lisitsin.repositories.WriterRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLWriterRepository;
import com.lisitsin.services.WriterService;

import java.util.List;

public class WriterServiceImpl implements WriterService {

    @InjectByType
    private WriterRepository writerRepository;

    @Override
    public Writer getById(Long id) {
        return writerRepository.getById(id);
    }

    @Override
    public List<Writer> getAll() {
        return writerRepository.getAll();
    }

    @Override
    public Writer save(Writer writer) {
        return writerRepository.save(writer);
    }

    @Override
    public Writer update(Writer writer) {
        return writerRepository.update(writer);
    }

    @Override
    public void deleteById(Long id) {
        writerRepository.deleteById(id);
    }
}
