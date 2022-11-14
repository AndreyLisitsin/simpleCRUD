package com.lisitsin;

import com.lisitsin.view.LabelView;
import com.lisitsin.view.PostView;
import com.lisitsin.view.WriterView;

import java.util.Scanner;

public class ApplicationRunner {

    WriterView writerView = new WriterView();
    PostView po = new PostView();
    LabelView labelView = new LabelView();

    void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("С какой сущностью необходимо поработать? \n" +
                    "1 - Writer \n" +
                    "2 - Post \n" +
                    "3 - Label\n" +
                    "Другая цифра - выход из программы");
            int i = scanner.nextInt();
            switch (i) {
                case (1):
                    writerView.handleMessage();
                    break;
                case (2):
                    po.handle();
                    break;
                case (3):
                    labelView.handle();
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
