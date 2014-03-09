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
public class Classe {
    private Niveau niveau;
    private int numero;
    private TreeSet<Eleve> eleves;
    private Enseignant[] enseignants;
    private Enseignant professeurPrincipal;
    
    public Classe(Niveau niveau, int numero)
    {
        enseignants = new Enseignant[Matiere.values().length];
        eleves = new TreeSet<Eleve>(new EleveComparator());
        this.niveau = niveau;
        this.numero = numero;
    }
    
    public void addEnseignant(Enseignant e, boolean principal)
    {
        enseignants[e.getMatiere().ordinal()] = e;
        if(principal)
            professeurPrincipal = e;
    }
    
    public void addEleve(String nom, String prenom)
    {
         eleves.add(new Eleve(nom, prenom));
    }
    
    public String toString()
    {
        return niveau.getAffichage() + numero;
    }
    
    public int getNombreEleves()
    {
        return eleves.size();
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public int getNumero() {
        return numero;
    }
    
    public String getAffichage() {
        return niveau.getAffichage() + numero;
    }

    public TreeSet<Eleve> getEleves() {
        return eleves;
    }

    public Enseignant[] getEnseignants() {
        return enseignants;
    }

    public Enseignant getProfesseurPrincipal() {
        return professeurPrincipal;
    }
    
    
}
