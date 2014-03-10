/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import model.Classe;
import model.Enseignant;
import model.Etablissement;
import model.Matiere;
import model.Niveau;
import model.Proviseur;
import view.VueAddEnseignant;
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
        Enseignant e3 = new Enseignant("idiot", "test", "idiot", "dupont", Matiere.PHYSIQUE);
        c11.addEnseignant(e1, true);
        c11.addEnseignant(e2, false);
        c11.addEleve("Eric", "Cartman");
        
        this.etablissement.addEnseignant(e1);
        this.etablissement.addEnseignant(e2);
        this.etablissement.addEnseignant(e3);
        
        this.etablissement.addClasse(c11);
        this.etablissement.addClasse(c21);
        this.etablissement.addClasse(c12);
        
        System.out.println(this.etablissement.getEnseignants().toString());
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

            if (ens != null) {
                vl.dispose();
            } else {
                JOptionPane.showMessageDialog(vl, "La combinaison login/mot de passe est érronée", "Connexion impossible", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void deleteEnseignants(List<Enseignant> le, VueProviseur vp) {
        if (le.size() != 0) {
            int reponse = JOptionPane.showConfirmDialog(
                    vp,
                    "Voulez-vous vraiment supprimer " + le.size() + " élément" + (le.size() == 1 ? "" : "s") + " ?",
                    "Suppression ?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            if (reponse == JOptionPane.YES_OPTION) {
                boolean assigned = false;
                
                for(Classe c : this.etablissement.getClasses()) {
                    if(!Collections.disjoint(Arrays.asList(c.getEnseignants()), le)) {
                        assigned = true;
                        break;
                    }
                }
                
                if(assigned) {
                    JOptionPane.showMessageDialog(vp, "Aucun élément n'a été supprimé car certains enseignants sont affectés à une classe","Suppression impossible",JOptionPane.WARNING_MESSAGE);
                } else {
                    this.etablissement.getEnseignants().removeAll(le);
                }
            }
        } else {
            JOptionPane.showMessageDialog(vp, "Aucun élément sélectionné","Suppression impossible",JOptionPane.WARNING_MESSAGE);

        }
    }

    public void addEnseignant(VueAddEnseignant vae, String nom, String prenom, String login, String mdp1, String mdp2, Matiere mat) {
        if(nom.isEmpty() || prenom.isEmpty() || login.isEmpty() ||
                mdp1.isEmpty() || mdp2.isEmpty()) {
            JOptionPane.showMessageDialog(vae, "Tous les champs sont obligatoires","Ajout impossible",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(!mdp1.equals(mdp2)) {
            JOptionPane.showMessageDialog(vae, "Les deux mots de passe ne correspondent pas","Ajout impossible",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Enseignant e = new Enseignant(login, mdp1, nom, prenom, mat);
        
        if (this.etablissement.addEnseignant(e)) {
            JOptionPane.showMessageDialog(vae, "L'enseignant a bien été ajouté","Ajout éffectué",JOptionPane.INFORMATION_MESSAGE);
            vae.dispose();
        } else {
            JOptionPane.showMessageDialog(vae, "Erreur lors de l'ajout","Ajout impossible",JOptionPane.ERROR_MESSAGE);
        }
    }
}
