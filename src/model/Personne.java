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
public abstract class Personne {
    private String login, password;
    private String nom, prenom;

    public Personne(String login, String password, String nom, String personne) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
}
