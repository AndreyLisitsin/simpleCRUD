package com.lisitsin.cotrollers;

import com.lisitsin.models.Label;
import com.lisitsin.services.LabelService;

import java.util.List;

public class LabelController {

    private final LabelService labelService;

    public LabelController(LabelService labelService){
        this.labelService = labelService ;
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
