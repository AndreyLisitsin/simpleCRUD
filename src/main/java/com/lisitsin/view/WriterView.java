package com.lisitsin.view;

import com.lisitsin.cotrollers.WriterController;
import com.lisitsin.entities.Writer;

import java.util.List;
import java.util.Scanner;

public class WriterView {
    private Scanner scanner;
    private WriterController writerController;


    public WriterView(){
        writerController = new WriterController();
        scanner = new Scanner(System.in);

    }
    public void handleMessage(){
        System.out.println("Какую операцию вы хотите произвести? \n" +
                "1- добавление новой записи\n" +
                "2- вывести весь список записей\n" +
                "3 - получение записи по id\n" +
                "4 - редактирование записи\n" +
                "5 - удаление записи по id\n");
        int i = scanner.nextInt();

        switch (i){
            case (1):
                addWriter();
                break;
            case(2):
                getAllWriters();
                break;
            case(3):
                getWriterById();
                break;
            case(4):
                updateWriter();
                break;
            case(5):
                deleteWriter();
                break;
        }
    }

    public void addWriter(){
        String firstName;
        String lastName;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите имя:");
            firstName = scanner.nextLine().trim();
            System.out.println("Введите фамилию:");
            lastName = scanner.nextLine().trim();
            if (!firstName.isEmpty() || !lastName.isEmpty())
                break;
        }
        Writer writer = new Writer(firstName,lastName);
        writerController.addWriter(writer);
    }

    public List<Writer> getAllWriters(){

        List<Writer> writers = writerController.getAllWriters();
        for (Writer writer : writers) {
            System.out.println(writer);
        }
        return writers;
    }

    public Writer getWriterById(){
        System.out.println("Enter writer`s id:");
        long id = scanner.nextLong();
        Writer writer = writerController.getWriterById(id);
        System.out.println("Information about writer:\n" + writer);
        return writer;
    }

    public Writer updateWriter(){
        System.out.println("Enter writer`s id:");
        long id = scanner.nextLong();
        Writer writer = writerController.getWriterById(id);
        System.out.println("what field would your prefer to update?\n" +
                "1 - firstName\n" +
                "2 - lastName");
            int i = scanner.nextInt();
            if (i == 1) {
                System.out.println("Enter new Firstname:");
                String firstName = new Scanner(System.in).nextLine();
                writer.setFirstName(firstName);
                writerController.modifyWriter(writer);
            }
            if (i == 2) {
                System.out.println("Enter new Lastname:");
                String lastName = new Scanner(System.in).nextLine();
                writer.setLastName(lastName);
                writerController.modifyWriter(writer);

            }
            else
                System.out.println("Incorrect input data");

        System.out.println(writer);

        return writer;
    }

    public void deleteWriter(){
        System.out.println("Enter writer`s id:");
        long id = scanner.nextLong();
        writerController.deleteWriter(id);
    }
}
