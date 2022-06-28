package com;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static void main(String[] args) throws Exception {
        ArrayList<Skladnik> listaSkladnikow = new ArrayList<>();
        Skladnik slony1 = new Skladnik("sól", OkreslenieSmaku.SLODKI);
        Skladnik slony2 = new Skladnik("sól", OkreslenieSmaku.SLODKI);
        Skladnik slony3 = new Skladnik("sól", OkreslenieSmaku.SLODKI);
        Skladnik slony4 = new Skladnik("sól", OkreslenieSmaku.SLONY);
        Skladnik slony5 = new Skladnik("sól", OkreslenieSmaku.SLONY);
        Skladnik slony6 = new Skladnik("sól", OkreslenieSmaku.SLONY);
        listaSkladnikow.add(slony1);
        listaSkladnikow.add(slony2);
        listaSkladnikow.add(slony3);
        listaSkladnikow.add(slony4);
        listaSkladnikow.add(slony5);
        listaSkladnikow.add(slony6);

        Przepis p1 = new Przepis("Solanka",listaSkladnikow);
        Przepis p2 = new Przepis("chuj",listaSkladnikow);
        Przepis p3 = new Przepis("zupa",listaSkladnikow);
        Przepis p4 = new Przepis("Pizza",listaSkladnikow);
        Przepis p5 = new Przepis("burger",listaSkladnikow);
        Przepis p6 = new Przepis("hotdog??",listaSkladnikow);
        Przepis p7 = new Przepis("elo",listaSkladnikow);
        Przepis p8 = new Przepis("hej",listaSkladnikow);

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
         MainView mv = new MainView();
    }
}
