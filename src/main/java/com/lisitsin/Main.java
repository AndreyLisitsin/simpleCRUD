package com.lisitsin;

import com.lisitsin.repositories.WriterRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLWriterRepository;
import com.lisitsin.view.LabelView;
import com.lisitsin.view.PostView;
import com.lisitsin.view.WriterView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

/*        Scanner scanner;

        while(true){
            System.out.println("С какой сущностью необходимо поработать? \n" +
                    "1 - Writer \n" +
                    "2 - Post \n" +
                    "3 - Label\n" +
                    "Другая цифра - выход из программы");

            scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i) {
                case (1) :
                    WriterView writerView = new WriterView();
                    writerView.handleMessage();
                    break;
                case(2):
                    PostView po = new PostView();
                    po.handle();
                    break;
                case(3):
                    LabelView labelView = new LabelView();
                    labelView.handle();
                    break;
                default:
                    System.exit(0);
            }
        }*/


    }
}