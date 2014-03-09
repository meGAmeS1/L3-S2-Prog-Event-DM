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
public class ClasseComparator implements Comparator<Classe> {
    public int compare(Classe o1, Classe o2) 
    {
        if(o1.niveau.ordinal() != o2.niveau.ordinal())
            return o1.niveau.ordinal() - o2.niveau.ordinal();
        return o1.numero-o2.numero;
    }
}
