package com;

import lombok.Getter;

public class Skladnik {
    @Getter
    private String nazwa;

    public Skladnik(String nazwa, com.OkreslenieSmaku okreslenieSmaku) {
        this.nazwa = nazwa;
        OkreslenieSmaku = okreslenieSmaku;
    }

    public OkreslenieSmaku getOkreslenieSmaku() {
        return OkreslenieSmaku;
    }

    @Getter
    private OkreslenieSmaku OkreslenieSmaku;


}
