package com.lisitsin.view;

import com.lisitsin.cotrollers.LabelController;
import com.lisitsin.cotrollers.PostController;
import com.lisitsin.models.Label;
import com.lisitsin.models.Post;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLLabelRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQlPostRepository;
import com.lisitsin.services.impl.LabelServiceImpl;
import com.lisitsin.services.impl.PostServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PostView {

    private Scanner scanner;
    private PostController postController;
    private LabelController labelController;
    public PostView(){
        scanner = new Scanner(System.in);
        postController = new PostController(new PostServiceImpl(new MySQlPostRepository()));
        labelController = new LabelController(new LabelServiceImpl(new MySQLLabelRepository()));
    }

    public void handle(){
        System.out.println("Какую операцию вы хотите произвести? \n" +
                "1- добавление новой записи\n" +
                "2- вывести весь список записей\n" +
                "3 - получение записи по id\n" +
                "4 - редактирование записи\n" +
                "5 - удаление записи по id\n");
        int i = scanner.nextInt();

        switch (i){
            case (1):
                addPost();
                break;
            case(2):
                getPosts();
                break;
            case(3):
                getPostById();
                break;
            case(4):
                updatePost();
                break;
            case(5):
                deletePost();
                break;
        }
    }

    private void addPost() {
        System.out.println("Enter the content of the Post");
        String content = scanner.nextLine();
        List<Label> labels = new ArrayList<>();

        System.out.println("Enter label`s names, that you prefer to use. Enter `Enter` to finish adding labels");
        while (true){
            String labelName = scanner.nextLine();
            if (labelName == null)
                break;
            Label label = labelController.save(labelName);
            labels.add(label);
        }
        postController.savePost(content,labels);

    }

    private void getPosts() {
        System.out.println(postController.getPosts());
    }

    private void getPostById() {
        System.out.println("Enter id of te post, that you want to get");
        int id = scanner.nextInt();
        System.out.println(postController.getPostById(id));
    }

    private void updatePost() {
        System.out.println("Enter id of te post, that you want to update");
        long id = scanner.nextInt();
        Post post = postController.getPostById(id);
        System.out.println("What field would yoy prefer yo update?\n" +
                "1 - content\n" +
                "2 - remove labels from list\n" +
                "3 - add labels to list");
        int i = scanner.nextInt();
        switch (i) {
            case (1):
                System.out.println("Enter new content: ");
                String newContent = scanner.nextLine();
                post.setContent(newContent);
                break;
            case (2):
                System.out.println(post.getLabels().stream()
                        .map(Label::getId)
                        .collect(Collectors.toList()));
                while (true){
                    System.out.println("Write id, that you want to delete\n" +
                            "0 - exit");
                    long labelId = scanner.nextLong();
                    if (labelId == 0){
                        break;
                    }
                    post.getLabels().removeIf(p -> p.getId() == labelId);
                }
                break;
            case (3):
                System.out.println("Enter label`s name: ");
                while (true) {
                    String labelName = scanner.nextLine();
                    if (labelName == null)
                        break;
                    Label label = labelController.save(labelName);
                    post.getLabels().add(label);
                    postController.update(post);
                }
                break;

        }
        System.out.println(postController.update(post));
    }

    private void deletePost() {
        System.out.println("Enter id of te post, that you want to delete");
        int id = scanner.nextInt();
        postController.delete(id);
        System.out.println("Post successfully deleted");
    }
}
