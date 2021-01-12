package com.example.emergency;

public class EmergencyModel {
    private String name;
    private int image;
    private int number;
    private int raw;

    public EmergencyModel(String name, int image, int number, int raw) {
        this.name = name;
        this.image = image;
        this.number = number;
        this.raw = raw;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getNumber() {
        return number;
    }

    public int getRaw() {
        return raw;
    }
}
