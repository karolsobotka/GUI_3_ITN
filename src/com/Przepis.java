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

    public void setNazwaPrzepisu(String nazwaPrzepisu) throws Exception {
        if(nazwaPrzepisu == "" || nazwaPrzepisu.equals(null)){
            throw new Exception("dodaj nazwe przepisu");
        }
        this.nazwaPrzepisu = nazwaPrzepisu;
    }

    public Przepis(String nazwaPrzepisu, ArrayList<Skladnik> listaSkladnikow) throws Exception {
        setNazwaPrzepisu(nazwaPrzepisu);
        setListaSkladnikow(listaSkladnikow);
        ocena = new AutoOcena(listaSkladnikow);
        addPrzepis(this);
    }

    public void addPrzepis(Przepis przepis) throws Exception {
        if(listaWszystkichPrzepisow.contains(przepis)){
            throw new Exception("Juz istnieje taki przepis ");
        }
        else
            listaWszystkichPrzepisow.add(przepis);
    }

    @Override
    public String toString() {
        return nazwaPrzepisu;
    }
}
