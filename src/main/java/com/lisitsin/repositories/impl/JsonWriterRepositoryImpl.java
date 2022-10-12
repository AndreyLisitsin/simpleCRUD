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

    @Override
    public Writer getById(Long id) {
        readListFromJson();
        return list.stream().filter(w ->w.getId()== id).findAny().get();
    }

    @Override
    public List<Writer> getAll() {
        readListFromJson();
        return list;
    }

    @Override
    public Writer save(Writer writer) {
        readListFromJson();
        if (list.size() == 0){
            writer.setId(1);
        }
        else
            writer.setId(list.stream()
                    .map(Writer::getId)
                    .max((Comparator.naturalOrder()))
                    .get()
                    .intValue()+1);
        list.add(writer);
        writeListToJson(list);
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        readListFromJson();
        for (Writer writer1 : list) {
            if (writer.getId() == writer1.getId()) {
                writer1.setLastName(writer.getLastName());
                writer1.setFirstName(writer.getFirstName());
                writer1.setPosts(writer.getPosts());
            }
        }
        writeListToJson(list);
        return writer;
    }

    @Override
    public void deleteById(Long id) {
        readListFromJson();
        List<Writer> newList = list.stream().filter(w -> w.getId() != id).collect(Collectors.toList());
        writeListToJson(newList);
    }

    private void writeListToJson(List<Writer> list) {
        try(PrintWriter out = new PrintWriter(new FileWriter(path))){
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            String jsonWriters = gson.toJson(list);
            out.write(jsonWriters);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readListFromJson() {
        StringBuilder builder = new StringBuilder();
        String s ="";
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while ((s = reader.readLine())!= null){
                builder.append(s).append("\n");
            }
            Type type = new TypeToken<List<Writer>>(){}.getType();
            if (builder.length() != 0) {
                list = gson.fromJson(builder.toString(), type);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
