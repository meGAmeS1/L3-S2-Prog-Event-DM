/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Comparator;

/**
 *
 * @author flemoal
 */
public class EleveComparator implements Comparator<Eleve>
{
    public int compare(Eleve o1, Eleve o2) 
    {
        if(o1.getNom().equals(o2.getNom()))
            return o1.getPrenom().compareTo(o2.getPrenom());
        return o1.getNom().compareTo(o2.getNom());
    }
    
}

