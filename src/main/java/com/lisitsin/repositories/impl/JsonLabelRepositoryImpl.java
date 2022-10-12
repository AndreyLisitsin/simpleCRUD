package com.lisitsin.repositories.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lisitsin.entities.Label;
import com.lisitsin.entities.Post;
import com.lisitsin.repositories.LabelRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JsonLabelRepositoryImpl implements LabelRepository {

    private final String PATH = "src/main/resources/rep/label.json";
    List<Label> labels;
    public JsonLabelRepositoryImpl(){
        labels = new ArrayList<>();
    }
    @Override
    public Label getById(Long id) {
        readListFromJson();
        return labels.stream().filter(l -> l.getId() == id).findAny().get();
    }

    @Override
    public List<Label> getAll() {
        readListFromJson();
        return labels;
    }

    @Override
    public Label save(Label label) {
        readListFromJson();
        if (labels.size() == 0){
            label.setId(1);
        }
        else
            label.setId(labels.stream()
                    .map(Label::getId)
                    .max((Comparator.naturalOrder()))
                    .get()
                    .intValue()+1);
        labels.add(label);
        writeListToJson(labels);
        return label;
    }

    @Override
    public Label update(Label label) {
        readListFromJson();
        for (Label label1 : labels) {
            if (label1.getId() == label.getId()){
                label1.setName(label.getName());
            }
        }
        writeListToJson(labels);
        return label;
    }

    @Override
    public void deleteById(Long id) {
        readListFromJson();
        List<Label> labels1 = labels.stream().filter(l -> l.getId() != id).collect(Collectors.toList());
        writeListToJson(labels1);

    }
    private void writeListToJson(List<Label> list) {
        try(PrintWriter out = new PrintWriter(new FileWriter(PATH))){
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String json = gson.toJson(list);
            out.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readListFromJson() {
        StringBuilder builder = new StringBuilder();
        String s ="";
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH));
            while ((s = reader.readLine())!= null){
                builder.append(s).append("\n");
            }
            Type type = new TypeToken<List<Label>>(){}.getType();
            if (builder.length() != 0) {
                labels = gson.fromJson(builder.toString(), type);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
