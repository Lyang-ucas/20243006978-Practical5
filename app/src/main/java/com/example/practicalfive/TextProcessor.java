package com.example.practicalfive;

public class TextProcessor {

    public String processMunicipality(String municipality) {
        if (municipality == null) {
            return null;
        }

        String name = municipality.trim();
        if (name.isEmpty()) {
            return null;
        }

        if (name.equalsIgnoreCase("Beijing")) {
            return "Beijing";
        } else if (name.equalsIgnoreCase("Shanghai")) {
            return "Shanghai";
        } else if (name.equalsIgnoreCase("Chongqing")) {
            return "Chongqing";
        } else if (name.equalsIgnoreCase("Tianjin")) {
            return "Tianjin";
        }

        return null;
    }
}
