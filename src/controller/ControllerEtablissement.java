/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Classe;
import model.Eleve;
import model.Enseignant;
import model.Etablissement;
import model.Matiere;
import model.Niveau;
import model.Proviseur;
import view.VueAddClasse;
import view.VueAddEleve;
import view.VueAddEnseignant;
import view.VueAffectEnseignant;
import view.VueEnseignant;
import view.VueLogin;
import view.VueProviseur;

/**
 *
 * @author flemoal
 */
public class ControllerEtablissement {

    private Etablissement etablissement;
    private VueProviseur vp;
    private VueEnseignant ve;

    public ControllerEtablissement() {
        this.etablissement = new Etablissement(new Proviseur("1", "1", "Principal", "Victoria"));
        
        initComponents();
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void demarrerControllerEtablissement() {
        new VueLogin(this, null).setVisible(true);
    }

    public void quitApp(JFrame jf) {
        int reponse = JOptionPane.showConfirmDialog(
                jf,
                "Voulez-vous vraiment quitter l'application ?",
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
            // Affichage fenêtre proviseur
            vp = new VueProviseur(this, vl);
            vl.dispose();
            vp.setVisible(true);

        } else {
            Enseignant ens = null;
            for (Enseignant e : etablissement.getEnseignants()) {
                if (e.getLogin().equals(login) && e.getPassword().equals(pass)) {
                    ens = e;
                    break;
                }
            }

            if (ens != null) {
                // Affichage fenêtre enseignant
                ve = new VueEnseignant(this, ens, vl);
                vl.dispose();
                ve.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(vl, "La combinaison login/mot de passe est érronée", "Connexion impossible", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public void deleteEnseignants(List<Enseignant> le) {
        if (le.isEmpty()) {
            JOptionPane.showMessageDialog(this.vp, "Aucun élément sélectionné", "Suppression impossible", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int reponse = JOptionPane.showConfirmDialog(
                vp,
                "Voulez-vous vraiment supprimer " + le.size() + " élément" + (le.size() == 1 ? "" : "s") + " ?",
                "Suppression ?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (reponse == JOptionPane.YES_OPTION) {
            boolean assigned = false;

            for (Classe c : this.etablissement.getClasses()) {
                if (!Collections.disjoint(Arrays.asList(c.getEnseignants()), le)) {
                    assigned = true;
                    break;
                }
            }

            if (assigned) {
                JOptionPane.showMessageDialog(this.vp, "Aucun élément n'a été supprimé car certains enseignants sont affectés à une classe", "Suppression impossible", JOptionPane.WARNING_MESSAGE);
            } else {
                this.etablissement.getEnseignants().removeAll(le);
                this.vp.refreshTableEnseignants();
            }
        }
    }

    public void addEnseignant(VueAddEnseignant vae, String nom, String prenom, String login, String mdp1, String mdp2, Matiere mat) {
        if (nom.isEmpty() || prenom.isEmpty() || login.isEmpty()
                || mdp1.isEmpty() || mdp2.isEmpty() || mat == null) {
            JOptionPane.showMessageDialog(vae, "Tous les champs sont obligatoires", "Ajout impossible", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Vérification de la concordance des mots de passe
        if (!mdp1.equals(mdp2)) {
            JOptionPane.showMessageDialog(vae, "Les deux mots de passe ne correspondent pas", "Ajout impossible", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Vérification que le login n'est pas déjà pris
        boolean loginExist = false;
        if (this.etablissement.getProviseur().getLogin().equals(login)) {
            loginExist = true;
        } else {
            for (Enseignant e : this.etablissement.getEnseignants()) {
                if (e.getLogin().equals(login)) {
                    loginExist = true;
                }
            }
        }

        if (loginExist) {
            JOptionPane.showMessageDialog(vae, "Ce login existe déjà", "Ajout impossible", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (this.etablissement.addEnseignant(new Enseignant(login, mdp1, nom, prenom, mat))) {
            JOptionPane.showMessageDialog(vae, "L'enseignant a bien été ajouté", "Ajout éffectué", JOptionPane.INFORMATION_MESSAGE);
            this.vp.refreshTableEnseignants();
            vae.dispose();
        } else {
            JOptionPane.showMessageDialog(vae, "Erreur lors de l'ajout", "Ajout impossible", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addEleve(VueAddEleve vae, String nom, String prenom, Niveau niveau, int numero) {
        if (nom.isEmpty() || prenom.isEmpty() || niveau == null || numero == 0) {
            JOptionPane.showMessageDialog(vae, "Tous les champs sont obligatoires", "Ajout impossible", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (this.etablissement.getClasse(niveau, numero).addEleve(nom, prenom)) {
            JOptionPane.showMessageDialog(vae, "L'élève a bien été ajouté", "Ajout éffectué", JOptionPane.INFORMATION_MESSAGE);
            vp.refreshClasseInfos();
            vae.dispose();
        } else {
            JOptionPane.showMessageDialog(vae, "Erreur lors de l'ajout", "Ajout impossible", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addClasse(VueAddClasse vac, Niveau niveau, int numero) {
        if (niveau == null || numero == 0) {
            JOptionPane.showMessageDialog(vac, "Tous les champs sont obligatoires", "Ajout impossible", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (this.etablissement.addClasse(new Classe(niveau, numero))) {
            JOptionPane.showMessageDialog(vac, "La classe a bien été ajoutée", "Ajout éffectué", JOptionPane.INFORMATION_MESSAGE);
            vac.dispose();
            vp.refreshTreeClasses();
            vp.refreshClasseInfos();
        } else {
            JOptionPane.showMessageDialog(vac, "Erreur lors de l'ajout", "Ajout impossible", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void affectEnseignant(VueAffectEnseignant vae, Enseignant enseignant, Niveau niveau, int numero, boolean pp) {
        if (enseignant == null || niveau == null || numero == 0) {
            JOptionPane.showMessageDialog(vae, "Tous les champs sont obligatoires", "Ajout impossible", JOptionPane.WARNING_MESSAGE);
            return;
        }

        this.etablissement.getClasse(niveau, numero).addEnseignant(enseignant, pp);

        JOptionPane.showMessageDialog(vae, "Le professeur a bien été affecté à cette classe", "Affectation éffectuée", JOptionPane.INFORMATION_MESSAGE);
        vae.dispose();
        vp.refreshClasseInfos();
    }

    public void disconnect(JFrame jf) {

        int reponse = JOptionPane.showConfirmDialog(
                jf,
                "Voulez-vous vraiment revenir à l'écran de connexion ?",
                "Déconnexion ?",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (reponse == JOptionPane.YES_OPTION) {
            new VueLogin(this, jf).setVisible(true);
            jf.dispose();
            this.vp = null;
            this.ve = null;
        }
    }

    private void initComponents() {
        // Création de classe
        Classe c6e1 = new Classe(Niveau.SIXIEME, 1);
        Classe c6e2 = new Classe(Niveau.SIXIEME, 2);
        Classe c5e1 = new Classe(Niveau.CINQUIEME, 1);
        Classe c3e1 = new Classe(Niveau.TROISIEME, 1);
        
        // Création d'enseignants
        Enseignant e1 = new Enseignant("2", "2", "Dupont", "Robert", Matiere.HISTOIRE_GEO);
        Enseignant e2 = new Enseignant("3", "3", "Garrison", "Herbert", Matiere.FRANCAIS);
        Enseignant e3 = new Enseignant("4", "4", "Mackey", "M.", Matiere.ANGLAIS);
        Enseignant e4 = new Enseignant("5", "5", "Simpson", "Homer", Matiere.PHYSIQUE);
        Enseignant e5 = new Enseignant("6", "6", "Stinson", "Barney", Matiere.EPS);
        Enseignant e6 = new Enseignant("7", "7", "Instrument", "Texas", Matiere.MATHS);
        Enseignant e7 = new Enseignant("8", "8", "Tomie", "Anna", Matiere.SVT);
        
        // Ajout d'enseignants aux classes
        c6e1.addEnseignant(e1, true);
        c6e1.addEnseignant(e2, false);
        c6e1.addEnseignant(e3, false);
        c6e1.addEnseignant(e4, false);
        c6e1.addEnseignant(e5, false);
        c6e1.addEnseignant(e6, false);
        c6e1.addEnseignant(e7, false);
        c6e2.addEnseignant(e1, false);
        c6e2.addEnseignant(e4, true);;
        c3e1.addEnseignant(e1, false);
        c3e1.addEnseignant(e3, false);
        c3e1.addEnseignant(e5, true);
        c3e1.addEnseignant(e6, true);
        c3e1.addEnseignant(e7, true);
        
        // Ajout d'élèves aux classes
        c6e1.addEleve("Cartman", "Eric");
        c6e1.addEleve("Broflovski", "Kyle");
        c6e1.addEleve("Marsh", "Stan");
        c6e1.addEleve("McCormick", "Kenny");
        c6e1.addEleve("Faulk", "Anne");
        c6e1.addEleve("Stevens", "Bebe");
        c6e1.addEleve("Biggle", "Bradley");
        c6e1.addEleve("Guermont", "Brydon");
        c6e1.addEleve("Donovan", "Clyde");
        c6e1.addEleve("Tucker", "Craig");
        c6e1.addEleve("Harrison", "Gary");
        c6e1.addEleve("Turner", "Heidi");
        c6e1.addEleve("Valmer", "Jimmy");
        c6e1.addEleve("Stoley", "Kevin");
        c6e1.addEleve("Stotch", "Butters");
        c6e1.addEleve("Pirrup", "Philip");
        c6e1.addEleve("Turner", "Sally");
        c6e1.addEleve("Burch", "Timmy");
        c6e1.addEleve("Black", "Token");
        c6e1.addEleve("Tweak", "Tweek");
        c6e1.addEleve("Testaburger", "Wendy");
        c6e2.addEleve("Simpson", "Bart");
        c6e2.addEleve("Van Houten", "Milhouse");
        c6e2.addEleve("Prince", "Martin");
        c6e2.addEleve("Muntz", "Nelson");
        c3e1.addEleve("Morgendorffer", "Daria");
        c3e1.addEleve("Lane", "Jane");
        c3e1.addEleve("Taylor", "Brittany");
        c3e1.addEleve("Griffin", "Sandi");
        c3e1.addEleve("Rowe", "Stacy");
        c3e1.addEleve("Blum-Deckler", "Tiffany");
        c3e1.addEleve("Lane", "Trent");
        c3e1.addEleve("Morgendorffer", "Quinn");
        
        for(Eleve e : c6e1.getEleves()){
            for(Matiere m : Matiere.values()){
                e.setNote(m, (float)Math.random()*20);
            }
        }
        
        for(Eleve e : c6e2.getEleves()){
            for(Matiere m : Matiere.values()){
                e.setNote(m, (float)Math.random()*20);
            }
        }
        
        for(Eleve e : c3e1.getEleves()){
            for(Matiere m : Matiere.values()){
                e.setNote(m, (float)Math.random()*20);
            }
        }
        
        // Inscription des enseignants dans l'établissement
        this.etablissement.addEnseignant(e1);
        this.etablissement.addEnseignant(e2);
        this.etablissement.addEnseignant(e3);
        this.etablissement.addEnseignant(e4);
        this.etablissement.addEnseignant(e5);
        this.etablissement.addEnseignant(e6);
        this.etablissement.addEnseignant(e7);
        
        // Inscriptions des classes dans l'établissement
        this.etablissement.addClasse(c6e1);
        this.etablissement.addClasse(c5e1);
        this.etablissement.addClasse(c6e2);
        this.etablissement.addClasse(c3e1);
    }
}
