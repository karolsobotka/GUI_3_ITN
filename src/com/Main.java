package com;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) throws Exception {

        Skladnik skladnik1 = new Skladnik("sól", OkreslenieSmaku.SLONY);
        Skladnik skladnik2 = new Skladnik("cukier", OkreslenieSmaku.SLODKI);
        Skladnik skladnik3 = new Skladnik("mąka", OkreslenieSmaku.NEUTRALNY);
        Skladnik skladnik4 = new Skladnik("jajka", OkreslenieSmaku.KWASNY);
        Skladnik skladnik5 = new Skladnik("cynamon", OkreslenieSmaku.SLODKI);
        Skladnik skladnik6 = new Skladnik("olej", OkreslenieSmaku.GORZKI);
        Skladnik skladnik7 = new Skladnik("woda", OkreslenieSmaku.NEUTRALNY);


        ArrayList<Skladnik> listaSkladnikow1 = new ArrayList<>();
        ArrayList<Skladnik> listaSkladnikow2 = new ArrayList<>();
        ArrayList<Skladnik> listaSkladnikow3 = new ArrayList<>();
        ArrayList<Skladnik> listaSkladnikow4 = new ArrayList<>();
        ArrayList<Skladnik> listaSkladnikow5 = new ArrayList<>();

        //ble niedobre danie
        listaSkladnikow1.add(skladnik1);
        listaSkladnikow1.add(skladnik2);
        listaSkladnikow1.add(skladnik3);
        listaSkladnikow1.add(skladnik4);
        listaSkladnikow1.add(skladnik6);

        //slone
        listaSkladnikow2.add(skladnik1);
        listaSkladnikow2.add(skladnik1);
        listaSkladnikow2.add(skladnik7);

        //slodkie
        listaSkladnikow3.add(skladnik2);
        listaSkladnikow3.add(skladnik3);
        listaSkladnikow3.add(skladnik5);

        //gorzkie
        listaSkladnikow4.add(skladnik4);
        listaSkladnikow4.add(skladnik6);
        listaSkladnikow4.add(skladnik2);

        //kwasne
        listaSkladnikow5.add(skladnik4);
        listaSkladnikow5.add(skladnik4);



        Przepis p1 = new Przepis("Danie niedobre",listaSkladnikow1);
        Przepis p2 = new Przepis("Solanka",listaSkladnikow2);
        Przepis p3 = new Przepis("Ciastko",listaSkladnikow3);
        Przepis p4 = new Przepis("Pizza",listaSkladnikow4);
        Przepis p5 = new Przepis("Żelki",listaSkladnikow5);


        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
         MainView mv = new MainView();
    }
}
