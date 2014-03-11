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

    public Enseignant(String login, String password, String nom, String prenom, Matiere matiere) {
        super(login, password, nom, prenom);
        this.matiere = matiere;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + matiere + ")"; //To change body of generated methods, choose Tools | Templates.
    }

}
