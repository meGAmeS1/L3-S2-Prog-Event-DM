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
public enum Niveau {
    SIXIEME("Sixième", "6e"),
    CINQUIEME("Cinquième", "5e"),
    QUATRIEME("Quatrième", "4e"),
    TROISIEME("Troisième", "3e");/*,
    SECONDE("Seconde", "2nde"),
    PREMIERE("Première", "1ère"),
    TERMINALE("Terminale", "T");*/
    
    private String name;
    private String affichage;
    
    Niveau(String name, String aff)
    {
        this.name = name;
        this.affichage = aff;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getAffichage()
    {
        return affichage;
    }
    
    public String toString()
    {
        return name;
    }
}
