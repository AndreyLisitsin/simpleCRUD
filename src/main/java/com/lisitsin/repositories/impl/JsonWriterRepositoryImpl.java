package com.lisitsin.repositories.impl;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.lisitsin.entities.Writer;
import com.lisitsin.repositories.WriterRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JsonWriterRepositoryImpl implements WriterRepository {

    private final String path = "src/main/resources/rep/writer.json";
    private List<Writer> list = new ArrayList<>();
    public JsonWriterRepositoryImpl(){
        updateWritersList();
    }


    @Override
    public Writer getById(Long id) {
        return list.stream().filter(w ->w.getId()== id).findAny().get();
    }

    @Override
    public List<Writer> getAll() {
        return list;
    }

    @Override
    public Writer save(Writer writer) {
        writer.setId(list.stream()
                .map(Writer::getId)
                .max((Comparator.naturalOrder()))
                .get()
                .intValue()+1);
        list.add(writer);
        saveWritersList(list);
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        for (Writer writer1 : list) {
            if (writer.getId() == writer1.getId()){
                if (writer.getFirstName().equals(writer1.getFirstName())){
                    writer1.setLastName(writer.getLastName());
                }
                else
                    writer1.setFirstName(writer.getFirstName());
            }
        }
        saveWritersList(list);
        return writer;
    }

    @Override
    public void deleteById(Long id) {
        List<Writer> writers = getAll();
        list = writers.stream().filter(w -> w.getId() != id).collect(Collectors.toList());
        saveWritersList(list);
    }

    private void saveWritersList(List<Writer> list) {
        try(PrintWriter out = new PrintWriter(new FileWriter(path))){
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String jsonWriter = gson.toJson(list);
            out.write(jsonWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateWritersList() {
        StringBuilder builder = new StringBuilder();
        String s ="";
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while ((s = reader.readLine())!= null){
                builder.append(s).append("\n");
            }
            Type type = new TypeToken<List<Writer>>(){}.getType();
            list = gson.fromJson(builder.toString(), type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
