package com;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


public class Przepis {
    @Getter
    private String nazwaPrzepisu;

    @Getter
    private static List<Przepis> listaWszystkichPrzepisow = new ArrayList<>();

    public void setListaSkladnikow(List<Skladnik> listaSkladnikow) throws Exception {
        if(listaSkladnikow.size()<2){
            throw new Exception("Za mało skladnikow co ty chcesz ugotowac? wode?");
        }
        this.listaSkladnikow = listaSkladnikow;
    }

    @Getter
    private List<Skladnik> listaSkladnikow;
    @Getter
    private AutoOcena ocena;

    public Przepis(String nazwaPrzepisu, ArrayList<Skladnik> listaSkladnikow) throws Exception {
        this.nazwaPrzepisu = nazwaPrzepisu;
        setListaSkladnikow(listaSkladnikow);
        ocena = new AutoOcena(listaSkladnikow);
        listaWszystkichPrzepisow.add(this);

    }

    @Override
    public String toString() {
        return nazwaPrzepisu;
    }
}
