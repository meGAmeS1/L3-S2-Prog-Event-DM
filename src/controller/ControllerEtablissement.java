/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.swing.JOptionPane;
import model.Classe;
import model.Eleve;
import model.Enseignant;
import model.Etablissement;
import model.Matiere;
import model.Niveau;
import model.Proviseur;
import view.VueLogin;
import view.VueProviseur;

/**
 *
 * @author flemoal
 */
public class ControllerEtablissement {
    Etablissement etablissement; 
    
    public ControllerEtablissement() {
        this.etablissement = new Etablissement(new Proviseur("test", "test", "test", "test"));
        Classe c11 = new Classe(Niveau.SIXIEME, 1);
        Classe c12 = new Classe(Niveau.SIXIEME, 2);
        Classe c21 = new Classe(Niveau.CINQUIEME, 1);
        Enseignant e1 = new Enseignant("robert", "toto", "robert", "dupont", Matiere.ANGLAIS);
        Enseignant e2 = new Enseignant("plop", "toto", "plop", "dupont", Matiere.FRANCAIS);
        c11.addEnseignant(e1, true);
        c11.addEnseignant(e2, false);
        c11.addEleve("Eric", "Cartman");
        this.etablissement.addClasse(c11);
        this.etablissement.addClasse(c21);
        this.etablissement.addClasse(c12);
        this.etablissement.addEnseignant(e1);
        this.etablissement.addEnseignant(e2);
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }
    
    public void demarrerControllerEtablissement() {
//        new VueLogin(this).setVisible(true);
        new VueProviseur(this).setVisible(true);
    }
    
    public void quitLogin(VueLogin vl) {
        int reponse = JOptionPane.showConfirmDialog(
                        vl,
                        "Voulez-vous vraiment quitter ?",
                        "Quitter ?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
        if (reponse == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    public void login(VueLogin vl, String login, char[] password) {
        String pass = new String(password);
        
        if (etablissement.getProviseur().getLogin().equals(login) && etablissement.getProviseur().getPassword().equals(pass)) {
            vl.dispose();
            new VueProviseur(this).setVisible(true);
            
        } else {
            Enseignant ens = null;
            for (Enseignant e : etablissement.getEnseignants()) {
                if (e.getLogin().equals(login) && e.getPassword().equals(pass)) {
                    ens = e;
                    break;
                }
            }
            
            if(ens != null) {
                vl.dispose();
            } else {
                JOptionPane.showMessageDialog(vl, "La combinaison login/mot de passe est érronée","Connexion impossible",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
