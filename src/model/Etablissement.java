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
        this.classes = new TreeSet<>(new ClasseComparator());
        this.enseignants = new TreeSet<>(new EnseignantComparator());
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

    public boolean addEnseignant(Enseignant e) {
        return this.enseignants.add(e);
    }

    public boolean addClasse(Classe c) {
        return this.classes.add(c);
    }

    public Classe getClasse(Niveau niv, int num) {
        for (Classe c : this.classes) {
            if (c.getNiveau().equals(niv) && c.getNumero() == num) {
                return c;
            }
        }

        return null;
    }
}
