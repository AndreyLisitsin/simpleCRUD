package com.lisitsin.services.impl;

import com.lisitsin.models.Label;
import com.lisitsin.myAnnotations.DBService;
import com.lisitsin.myAnnotations.InjectByType;
import com.lisitsin.repositories.LabelRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLLabelRepository;
import com.lisitsin.services.LabelService;

import java.util.List;

public class LabelServiceImpl implements LabelService {

    @InjectByType
    LabelRepository labelRepository;

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
