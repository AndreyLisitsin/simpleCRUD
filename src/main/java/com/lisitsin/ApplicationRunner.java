package com.lisitsin;

import com.lisitsin.repositories.WriterRepository;
import com.lisitsin.repositories.impl.mySqlImpl.MySQLWriterRepository;
import com.lisitsin.view.LabelView;
import com.lisitsin.view.PostView;
import com.lisitsin.view.WriterView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

    ApplicationRunner runner = new ApplicationRunner();
    runner.start();

    }
}