package com.lisitsin.cotrollers;

import com.lisitsin.entities.Label;
import com.lisitsin.repositories.LabelRepository;
import com.lisitsin.repositories.impl.JsonLabelRepositoryImpl;

import java.util.List;

public class LabelController {

    private LabelRepository labelRepository;


    public LabelController(){
        labelRepository = new JsonLabelRepositoryImpl();
    }

    public Label save(String labelName){
        Label label = new Label(labelName);
        return labelRepository.save(label);
    }

    public List<Label> getAll(){
        return labelRepository.getAll();
    }

    public Label getById(Long id){
        return labelRepository.getById(id);
    }

    public Label updateLabel(Label label){
        return labelRepository.update(label);
    }

    public void deleteLabel(Long id){
        labelRepository.deleteById(id);
    }
}
