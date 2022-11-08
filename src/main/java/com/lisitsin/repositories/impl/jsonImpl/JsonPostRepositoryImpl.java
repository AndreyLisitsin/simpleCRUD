package com.lisitsin.repositories.impl.jsonImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lisitsin.models.Post;
import com.lisitsin.repositories.PostRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Deprecated
public class JsonPostRepositoryImpl  {

/*    private final String PATH = "src/main/resources/rep/post.json";
    List<Post> posts = new ArrayList<>();

    @Override
    public Post getById(Long id) {
        readListFromJson();
        return posts.stream().filter(p -> p.getId() == id).findAny().get();
    }

    @Override
    public List<Post> getAll() {
        readListFromJson();
        return posts;
    }

    @Override
    public Post save(Post post) {
        readListFromJson();
        if (posts.size() == 0){
            post.setId(1L);
        }
        else
            post.setId(posts.stream()
                    .map(Post::getId)
                    .max((Comparator.naturalOrder()))
                    .get()
                    .intValue()+1L);
        posts.add(post);
        writeListToJson(posts);
        return post;
    }

    @Override
    public Post update(Post post) {
        readListFromJson();
        for (Post post1 : posts) {
            if (post1.getId() == post.getId()){
                post1.setContent(post.getContent());
                post1.setUpdated(new Date());
                post1.setLabels(post.getLabels());
            }
        }
        writeListToJson(posts);
        return post;
    }

    @Override
    public void deleteById(Long id) {
        readListFromJson();
        List<Post> newPosts = posts.stream().filter(p -> p.getId() != id).collect(Collectors.toList());
        writeListToJson(newPosts);

    }
    private void writeListToJson(List<Post> list) {
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
            Type type = new TypeToken<List<Post>>(){}.getType();
            if (builder.length() != 0) {
                posts = gson.fromJson(builder.toString(), type);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/
}
