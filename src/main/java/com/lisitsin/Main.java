package com.lisitsin;

import com.lisitsin.entities.Label;
import com.lisitsin.entities.Post;
import com.lisitsin.entities.Writer;
import com.lisitsin.repositories.impl.JsonWriterRepositoryImpl;
import com.lisitsin.view.LabelView;
import com.lisitsin.view.PostView;
import com.lisitsin.view.WriterView;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException {

       /* JsonWriterRepositoryImpl writerRepository = new JsonWriterRepositoryImpl();
        Post post = new Post(1,"First post", new Date(), new Date(), List.of(new Label(1,"Title")));
        List<Post> posts = new ArrayList<>();
        posts.add(post);
        writerRepository.save(new Writer("Misha", "Zuev", posts));
        writerRepository.save(new Writer("Andrey", "Lisitsin", posts));
*/

        Scanner scanner;

        while(true){
            System.out.println("С какой сущностью необходимо поработать? \n" +
                    "1 - Writer \n" +
                    "2 - Post \n" +
                    "3 - Label");

            scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i) {
                case (1) :
                    WriterView writerView = new WriterView();
                    writerView.handleMessage();
                case(2):
                    PostView po = new PostView();
                    po.handle();

                case(3):
                    LabelView labelView = new LabelView();
                    labelView.handle();

            }
        }

    }
}