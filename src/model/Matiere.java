/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author flemoal
 */
public enum Matiere {

    ANGLAIS("Anglais"),
    EPS("EPS"),
    FRANCAIS("Français"),
    HISTOIRE_GEO("HistoireGéo"),
    MATHS("Maths"),
    PHYSIQUE("Physique"),
    SVT("SVT");

    private String name;

    Matiere(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
