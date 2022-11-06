package com.lisitsin.view;

import com.lisitsin.cotrollers.LabelController;
import com.lisitsin.entities.Label;

import java.util.Scanner;

public class LabelView {

    private LabelController labelController;
    private Scanner scanner;

/*    public LabelView(){
        labelController = new LabelController();
        scanner = new Scanner(System.in);
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
                addLabel();
                break;
            case(2):
                getLabels();
                break;
            case(3):
                getLabelById();
                break;
            case(4):
                updateLabel();
                break;
            case(5):
                deleteLabel();
                break;
        }
    }

    private void addLabel() {
        System.out.println("Enter the labelName");
        String labelName = new Scanner(System.in).nextLine();
        System.out.println("Label successfully saved: " + labelController.save(labelName));
    }

    private void getLabels() {
        System.out.println(labelController.getAll());
    }

    private void getLabelById() {
        System.out.println("Enter id of te label, that you want to get");
        long id = scanner.nextInt();
        System.out.println(labelController.getById(id));
    }

    private void updateLabel() {
        System.out.println("Enter id of te label, that you want to update");
        long id = scanner.nextLong();
        System.out.println("Enter new label name: ");
        String newLabelName = scanner.nextLine();
        Label label = new Label(newLabelName);
        label.setId(id);
        System.out.println(labelController.updateLabel(label));
    }

    private void deleteLabel() {
        System.out.println("Enter id of te label, that you want to delete");
        long id = scanner.nextLong();
        labelController.deleteLabel(id);
        System.out.println("Post successfully deleted");
    }*/
}

