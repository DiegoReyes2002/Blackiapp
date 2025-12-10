package com.braki.utils;

public class FriccionCalculator {

    public static double getMu(String superficie, String condicion){
        String s = superficie == null ? "" : superficie.toLowerCase();
        String c = condicion == null ? "" : condicion.toLowerCase();

        if(s.contains("asfalto")){
            if(c.contains("seco")) return 0.8;
            if(c.contains("mojado")) return 0.45;
            if(c.contains("hielo")) return 0.12;
            if(c.contains("compacta")) return 0.25;
        }
        if(s.contains("tierra")){
            if(c.contains("seco")) return 0.6;
            if(c.contains("mojado")) return 0.35;
        }
        if(s.contains("grava")) return 0.55;
        if(s.contains("nieve")) return 0.25;
        if(s.contains("hielo")) return 0.10;
        return 0.7;
    }
}
