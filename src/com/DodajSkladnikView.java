package com;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DodajSkladnikView extends Stage {


    private Label nazwaSkladnikaLabel = new Label("Podaj nazwę Skladnika:");
    private Label typSkladnikaLabel = new Label("Wybierz Typ skladnika");
    private TextField nazwaSkladnikaTextField = new TextField();
    private Button dodajSkladnikButton = new Button("Dodaj Skladnik");

    ObservableList<OkreslenieSmaku> smakList = FXCollections.observableArrayList(OkreslenieSmaku.GORZKI, OkreslenieSmaku.KWASNY, OkreslenieSmaku.NEUTRALNY,
                                                OkreslenieSmaku.SLODKI, OkreslenieSmaku.SLONY);
    private ComboBox typSkladnikaComboBox = new ComboBox(smakList);
    private HBox hbox = new HBox(10);
    private VBox vboxPrzepis = new VBox();
    private VBox vboxSkladniki = new VBox();
    private Scene scene = new Scene(hbox);


    public DodajSkladnikView(){

        vboxPrzepis.getChildren().addAll(nazwaSkladnikaLabel, nazwaSkladnikaTextField);
        vboxPrzepis.getChildren().addAll(typSkladnikaLabel, typSkladnikaComboBox,dodajSkladnikButton);
        hbox.getChildren().addAll(vboxPrzepis, vboxSkladniki);

        dodajSkladnikButton.setOnAction(e->{
            if(nazwaSkladnikaTextField.getText().equals("") || typSkladnikaComboBox.getSelectionModel().getSelectedItem().equals(null)){
                Dialog d = new Dialog();
                d.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
                d.setContentText("Skladnik musi miec nazwe oraz typ");
                d.show();
            }
            else{
                new Skladnik(nazwaSkladnikaTextField.getText(), (OkreslenieSmaku) typSkladnikaComboBox.getSelectionModel().getSelectedItem());
                close();
            }
        });
        setScene(scene);
        setTitle("Dodaj Składnik");
        show();


    }
}
