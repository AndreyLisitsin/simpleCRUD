package com.lisitsin.cotrollers;

import com.lisitsin.entities.Label;
import com.lisitsin.repositories.LabelRepository;
import com.lisitsin.repositories.impl.jsonImpl.JsonLabelRepositoryImpl;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLLabelRepository;
import com.lisitsin.services.LabelService;
import com.lisitsin.services.impl.LabelServiceImpl;

import java.util.List;

public class LabelController {

    private final LabelService labelService;

    public LabelController(){
        labelService = new LabelServiceImpl(new MySQLLabelRepository());
    }

    public Label save(String labelName){
        Label label = new Label(labelName);
        return labelService.save(label);
    }

    public List<Label> getAll(){
        return labelService.getAll();
    }

    public Label getById(Long id){
        return labelService.getById(id);
    }

    public Label updateLabel(Label label){
        return labelService.update(label);
    }

    public void deleteLabel(Long id){
        labelService.deleteById(id);
    }
}
