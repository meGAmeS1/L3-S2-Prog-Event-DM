/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.Etablissement;

/**
 *
 * @author flemoal
 */
public class EntryPoint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControllerEtablissement ce = new ControllerEtablissement();
        ce.demarrerControllerEtablissement();
    }
    
}
