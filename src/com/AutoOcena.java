package com;

import java.util.ArrayList;

public class AutoOcena {
    private int slony = 0;
    private int slodki =0;
    private int gorzki = 0;
    private int kwasny = 0;
    private int neutralny = 0;
    public AutoOcena(ArrayList<Skladnik>  listaSkladnikow){
        System.out.println(ocenaSkladnikow(listaSkladnikow));

    }

    private String ocenaSkladnikow(ArrayList<Skladnik> listaSkladnikow){
        for (Skladnik s : listaSkladnikow) {
            if(s.getOkreslenieSmaku().equals(OkreslenieSmaku.GORZKI))
                gorzki++;
            if(s.getOkreslenieSmaku().equals(OkreslenieSmaku.SLODKI))
                slodki++;
            if(s.getOkreslenieSmaku().equals(OkreslenieSmaku.SLONY))
                slony++;
            if(s.getOkreslenieSmaku().equals(OkreslenieSmaku.KWASNY))
                kwasny++;
            if(s.getOkreslenieSmaku().equals(OkreslenieSmaku.NEUTRALNY))
                neutralny++;
        }
        int[] skladniki = new int[]{
                slony,
                slodki,
                gorzki,
                kwasny,
                neutralny
        };
        int temp =0;
        int neutral =0;

        for (int i = 0; i < skladniki.length; i++) {
            for (int j = i+1; j <skladniki.length ; j++) {
                if (skladniki[i]>skladniki[j]){
                    temp = skladniki[i];
                    skladniki[i] = skladniki[j];
                    skladniki[j] = temp;
                }
                else if(skladniki[i] == skladniki[j]){
                    neutral++;
                }
            }
        }


        if (neutral == 5){
            return "To danie jest tak złe że aż ciężko na nie patrzeć";
        }
        else {
            if(temp == gorzki){
                return "To danie jest strasznie gorzkie!";
            }
            if(temp == slodki){
                return "To danie jest tak słodkie, że nadaje się na deser!";
            }
            if(temp == slony){
                return "Zmarnowalas mi 20 lat zycia ty stara.... ";
            }
            if(temp == kwasny){
                return "Kwasne jak zelki fuj";
            }
            if(temp == neutralny){
                return "Nijakie to danie dośc neutralne";
            }
        }


        return "brak skladnikow do porownania";
    }
}
