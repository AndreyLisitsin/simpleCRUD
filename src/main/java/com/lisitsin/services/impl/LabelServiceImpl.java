package com.lisitsin.services.impl;

import com.lisitsin.entities.Label;
import com.lisitsin.repositories.LabelRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLLabelRepository;
import com.lisitsin.services.LabelService;

import java.util.List;

public class LabelServiceImpl implements LabelService {

    LabelRepository labelRepository;

    public LabelServiceImpl(LabelRepository labelRepository){
        this.labelRepository = new MySQLLabelRepository();
    }

    @Override
    public Label getById(Long id) {
        return labelRepository.getById(id);
    }

    @Override
    public List<Label> getAll() {
        return labelRepository.getAll();
    }

    @Override
    public Label save(Label label) {
        return labelRepository.save(label);
    }

    @Override
    public Label update(Label label) {
        return labelRepository.update(label);
    }

    @Override
    public void deleteById(Long id) {
        labelRepository.deleteById(id);
    }
}
