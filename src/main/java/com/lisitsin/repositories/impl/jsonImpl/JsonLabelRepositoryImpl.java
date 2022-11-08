package com.lisitsin.repositories.impl.jsonImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lisitsin.models.Label;
import com.lisitsin.repositories.LabelRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@Deprecated
public class JsonLabelRepositoryImpl {

/*    private final String PATH = "src/main/resources/rep/label.json";

    @Override
    public Label getById(Long id) {
        return readListFromJson().stream().filter(l -> l.getId() == id).findAny().orElse(null);
    }

    @Override
    public List<Label> getAll() {
        return readListFromJson();
    }

    @Override
    public Label save(Label label) {
        List<Label> labels = readListFromJson();
        label.setId(generateLabelId(labels));
        labels.add(label);
        writeListToJson(labels);
        return label;
    }

    @Override
    public Label update(Label label) {
        List<Label> newLabels = readListFromJson();
        for (Label label1 : newLabels) {
            if (label1.getId() == label.getId()){
                label1.setName(label.getName());
            }
        }
        writeListToJson(newLabels);
        return label;
    }

    @Override
    public void deleteById(Long id) {
        List<Label> labels = readListFromJson();
        labels.removeIf(l -> l.getId() == id);
        writeListToJson(labels);

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

    private List<Label> readListFromJson() {
        StringBuilder builder = new StringBuilder();
        String s ="";
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PATH));
            while ((s = reader.readLine())!= null){
                builder.append(s).append("\n");
            }
            Type type = new TypeToken<List<Label>>(){}.getType();
                return gson.fromJson(builder.toString(), type);
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    private Long generateLabelId(List<Label> labels) {
        Label maxIdLabel = labels.stream().max(Comparator.comparing(Label::getId)).orElse(null);
        return Objects.nonNull(maxIdLabel) ? maxIdLabel.getId() + 1 : 1L;
    }*/
}
