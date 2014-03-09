/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.Classe;
import model.Enseignant;
import model.Etablissement;
import model.Matiere;
import model.Niveau;
import model.Proviseur;
import view.VueLogin;

/**
 *
 * @author flemoal
 */
public class ControllerEtablissement {
    Etablissement etablissement;
    
    public ControllerEtablissement() {
        this.etablissement = new Etablissement(new Proviseur("test", "test", "test", "test"));
        
        this.etablissement.getClasses().add(new Classe(Niveau.SIXIEME, 1));
        this.etablissement.getEnseignants().add(new Enseignant("robert", "toto", "robert", "dupont", Matiere.ANGLAIS));
    }
    
    public void demarrerControllerEtablissement() {
        new VueLogin().setVisible(true);
    }
}
