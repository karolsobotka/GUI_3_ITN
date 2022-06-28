package com;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Skladnik {
    @Getter
    private String nazwa;
    private OkreslenieSmaku OkreslenieSmaku;
    private static List<Skladnik> listaWszystkichSkladnikow = new ArrayList<>();
    public Skladnik(String nazwa, OkreslenieSmaku okreslenieSmaku) {
        this.nazwa = nazwa;
        OkreslenieSmaku = okreslenieSmaku;
        listaWszystkichSkladnikow.add(this);
    }
    public OkreslenieSmaku getOkreslenieSmaku() {
        return OkreslenieSmaku;
    }




}
