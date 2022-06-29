package com;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DodajPrzepisView extends Stage {


    private Label nazwaPrzepisuLabel = new Label("Podaj nazwę przepisu:");
    private Label wybierzSkladnikiLabel = new Label("Wybierz minimum 2 składniki:");
    private TextField nazwaPrzepisuTextField = new TextField();
    private Button dodajPrzepisButton = new Button("Dodaj Przepis");
    private ListView<Skladnik> listaWszystkichSkladnikow = new ListView<>(FXCollections.observableArrayList(Skladnik.getListaWszystkichSkladnikow()));
    private HBox hbox = new HBox(10);
    private VBox vboxPrzepis = new VBox();
    private VBox vboxSkladniki = new VBox();
    private Scene scene = new Scene(hbox);


    public DodajPrzepisView(){

        listaWszystkichSkladnikow.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);;
        vboxPrzepis.getChildren().addAll(nazwaPrzepisuLabel, nazwaPrzepisuTextField);
        vboxPrzepis.getChildren().addAll(wybierzSkladnikiLabel, listaWszystkichSkladnikow,dodajPrzepisButton);
        hbox.getChildren().addAll(vboxPrzepis, vboxSkladniki);




        dodajPrzepisButton.setOnAction(e->{
            long selectedItems = listaWszystkichSkladnikow.getSelectionModel().getSelectedItems().stream().count();
            if((nazwaPrzepisuTextField.getText().equals("") || selectedItems < 2) && nazwaPrzepisuTextField.getText().equals("") ){
                Dialog d = new Dialog();
                d.setContentText("Przepis musi miec nazwe oraz minimum 2 składniki");
                d.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
                d.show();
            }
            try {
                new Przepis(nazwaPrzepisuTextField.getText(), new ArrayList<>(listaWszystkichSkladnikow.getSelectionModel().getSelectedItems()));
                MainView.getListaPrzepisow().setItems(FXCollections.observableArrayList(Przepis.getListaWszystkichPrzepisow()));
                close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        setScene(scene);
        setTitle("Dodaj Przepis");
        show();


    }
}
