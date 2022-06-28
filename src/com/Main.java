package com;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    Stage mainWindow;


    public static void main(String[] args) throws Exception {
        ArrayList<Skladnik> listaSkladnikow = new ArrayList<>();
        Skladnik slony1 = new Skladnik("sól", OkreslenieSmaku.SLONY);
        Skladnik slony2 = new Skladnik("sól", OkreslenieSmaku.SLONY);
        Skladnik slony3 = new Skladnik("sól", OkreslenieSmaku.SLONY);
        Skladnik slony4 = new Skladnik("sól", OkreslenieSmaku.SLONY);
        Skladnik slony5 = new Skladnik("sól", OkreslenieSmaku.SLONY);
        listaSkladnikow.add(slony1);
        listaSkladnikow.add(slony2);
        listaSkladnikow.add(slony3);
        listaSkladnikow.add(slony4);
        listaSkladnikow.add(slony5);

        Przepis p1 = new Przepis("Solanka",listaSkladnikow);



    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        mainWindow.setTitle("Książka Kucharska");

    }
}
