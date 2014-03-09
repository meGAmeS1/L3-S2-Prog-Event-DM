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
    Niveau niveau;
    int numero;
    TreeSet<Eleve> listeEleves;
    Enseignant[] listeEnseignants;
    Enseignant professeurPrincipal;
    
    public Classe(Niveau niveau, int numero)
    {
        listeEnseignants = new Enseignant[Matiere.values().length];
        listeEleves = new TreeSet<Eleve>(new EleveComparator());
        this.niveau = niveau;
        this.numero = numero;
    }
    
    public void ajouterEnseignant(Enseignant e, boolean principal)
    {
        listeEnseignants[e.getMatiere().ordinal()] = e;
        if(principal)
            professeurPrincipal = e;
    }
    
    public void ajouterEleve(String nom, String prenom)
    {
         listeEleves.add(new Eleve(nom, prenom));
    }
    
    public String toString()
    {
        StringBuffer aff = new StringBuffer(niveau.getAffichage());
        aff.append(numero);
        return aff.toString();
    }
    
    public int getNombreEleves()
    {
        return listeEleves.size();
    }
}
