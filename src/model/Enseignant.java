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
public class Enseignant extends Personne {
    private final Matiere matiere;

    public Enseignant(String login, String password, String nom, String personne, Matiere matiere) {
        super(login, password, nom, personne);
        this.matiere = matiere;
    }

    public Matiere getMatiere() {
        return matiere;
    }
}
