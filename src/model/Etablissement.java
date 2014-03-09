/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.TreeSet;

/**
 *
 * @author flemoal
 */
public class Etablissement {
    private TreeSet<Classe> classes;
    private TreeSet<Enseignant> enseignants;
    private Proviseur proviseur;
    
    public Etablissement(Proviseur proviseur) {
        this.classes = new TreeSet<Classe>(new ClasseComparator());
        this.enseignants = new TreeSet<Enseignant>(new EnseignantComparator());
        this.proviseur = proviseur;
    }

    public TreeSet<Classe> getClasses() {
        return classes;
    }

    public TreeSet<Enseignant> getEnseignants() {
        return enseignants;
    }

    public Proviseur getProviseur() {
        return proviseur;
    }
}
