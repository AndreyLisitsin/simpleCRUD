package com.lisitsin.services.impl;

import com.lisitsin.entities.Writer;
import com.lisitsin.repositories.WriterRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLWriterRepository;
import com.lisitsin.services.WriterService;

import java.util.List;

public class WriterServiceImpl implements WriterService {

    private final WriterRepository writerRepository;

    public WriterServiceImpl(WriterRepository writerRepository){
        this.writerRepository = writerRepository;
    }
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
