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

    public Etablissement() {
        classes = new TreeSet<Classe>(new ClasseComparator());
        enseignants = new TreeSet<Enseignant>(new EnseignantComparator());
    }

    public TreeSet<Classe> getClasses() {
        return classes;
    }

    public TreeSet<Enseignant> getEnseignants() {
        return enseignants;
    }
}
