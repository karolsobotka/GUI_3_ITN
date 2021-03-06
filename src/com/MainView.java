package com;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Stage {
    BorderPane borderPane = new BorderPane();
    private Scene mainScene;

    public static ListView<Przepis> getListaPrzepisow() {
        return listaPrzepisow;
    }

    public static void setListaPrzepisow(ListView<Przepis> listaPrzepisow) {
        MainView.listaPrzepisow = listaPrzepisow;
    }

    private static ListView<Przepis> listaPrzepisow;
    private MenuBar menuBar= new MenuBar();
    private Menu dodaj = new Menu("Dodaj");
    private MenuItem przepis = new MenuItem("Przepis");
    private MenuItem skladnik= new MenuItem("Składnik");
    private Label nazwaPrzepisuLabel= new Label("Nazwa przepisu:");
    private TextField nazwaPrzepisuTextField = new TextField();
    private Label ocenaAutoLabel = new Label("Automatyczna ocena przepisu:");
    private TextArea ocenaPrzepisuTextArea = new TextArea();
    private Label skladnikiLabel = new Label("Składniki");
    private ListView<Skladnik> listaSkladnikowPrzepisu;
    private VBox przepisVbox = new VBox(10);

    public MainView(){
        new Thread(()->{
            listaPrzepisow = new ListView(FXCollections.observableArrayList(Przepis.getListaWszystkichPrzepisow()));

        }).start();
        listaSkladnikowPrzepisu = new ListView<>();

        dodaj.getItems().addAll(przepis,skladnik);
        menuBar.getMenus().addAll(dodaj);
        przepis.setOnAction(e ->{
            DodajPrzepisView dodaj = new DodajPrzepisView();

        });
        skladnik.setOnAction(e->{
            DodajSkladnikView dodaj= new DodajSkladnikView();
        });



        listaPrzepisow.setOnMouseClicked(event -> {
            if(listaPrzepisow.getSelectionModel().getSelectedItem() == null){
                nazwaPrzepisuTextField.setText("");
                ocenaPrzepisuTextArea.setText("");
                listaSkladnikowPrzepisu.setItems(null);

            }
            else{
                nazwaPrzepisuTextField.setText(listaPrzepisow.getSelectionModel().getSelectedItem().getNazwaPrzepisu());
                ocenaPrzepisuTextArea.setText(listaPrzepisow.getSelectionModel().getSelectedItem().getOcena().toString());
                listaSkladnikowPrzepisu.setItems(FXCollections.observableArrayList(listaPrzepisow.getSelectionModel().getSelectedItem().getListaSkladnikow()));

            }
        });

        listaPrzepisow.getSelectionModel().getSelectedItem();

        przepisVbox.getChildren().addAll(nazwaPrzepisuLabel,
                nazwaPrzepisuTextField,ocenaAutoLabel,ocenaPrzepisuTextArea,
                skladnikiLabel,listaSkladnikowPrzepisu);


        nazwaPrzepisuTextField.setEditable(false);
        ocenaPrzepisuTextArea.setEditable(false);
        borderPane.setLeft(listaPrzepisow);
        borderPane.setTop(menuBar);
        borderPane.setCenter(przepisVbox);

        mainScene = new Scene(borderPane);
        setScene(mainScene);
        setHeight(600);
        setWidth(800);
        show();

    }
}
