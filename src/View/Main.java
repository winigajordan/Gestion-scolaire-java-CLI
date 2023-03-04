package View;

import Dao.Database;
import Entity.*;
import Entity.Module;
import Metier.Checker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Database db = new Database();
    private static Checker checker = new Checker();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nom, prenom, grade, specialite, matricule  ;
        double primePermanant, primeVacataire;
        Enseignant enseignant = null;
        Vacataire vacataire;
        Permanant permanant;
        Module module;
        Etudiant etudiant;
        int volume;
        int choice, choiceEtu, choiceProf = 0;

        do {
            System.out.println("");
            System.out.println("1- Ajouter un enseignant permanant");
            System.out.println("2- Ajouter un enseignant vacataire");
            System.out.println("3- Lister les enseignants permanants");
            System.out.println("4- Lister les enseignants vacataires");
            System.out.println("5- Lister tous les enseignants");
            System.out.println("6- Supprimer un enseignant");

            System.out.println("7- Creer un module");
            System.out.println("8- Lister les modules");
            System.out.println("9- Ajouter un module a un enseignant");
            System.out.println("10- Lister les modules d'un enseigant");
            System.out.println("11- Supprimer un module d'un enseignant");
            System.out.println("12- Supprimer un module");

            System.out.println("13- Ajouter un etudiant");
            System.out.println("14- Lister tous les etudiants");
            System.out.println("15- Ajouter un module a un etudiant");
            System.out.println("16- Supprimer un etudiant d'un module");
            System.out.println("17- Lister les modules suivi par un étudiant");
            System.out.println("18- Supprimer un etudiant");


            System.out.println("19- Lister tous etudiants inscrit à un module");
            System.out.println("20- Quitter");
            System.out.print("\n Faites un choix ");
            choice = checker.checkIntegerInput(sc);
            switch (choice){
                case 1:
                    System.out.println("---- Ajouter un enseignant permanant ----");
                    System.out.print("Nom : ");
                    nom = sc.nextLine();
                    System.out.print("Prenom : ");
                    prenom = sc.nextLine();
                    System.out.print("Grade : ");
                    grade = sc.nextLine();
                    System.out.print("Spécialité : ");
                    specialite = sc.nextLine();
                    System.out.print("Prime : ");
                    primePermanant = checker.checkDoubleInput(sc);
                    permanant = new Permanant(nom, prenom, grade, specialite,primePermanant);
                    db.addPermanant(permanant);
                    break;
                case 2:
                    System.out.println("---- Ajouter un enseignant vacataire ----");
                    System.out.print("Nom : ");
                    nom = sc.nextLine();
                    System.out.print("Prenom : ");
                    prenom = sc.nextLine();
                    System.out.print("Grade : ");
                    grade = sc.nextLine();
                    System.out.print("Spécialité : ");
                    specialite = sc.nextLine();
                    System.out.print("Prime : ");
                    primeVacataire = checker.checkDoubleInput(sc);
                    vacataire = new Vacataire(nom, prenom, grade, specialite, primeVacataire);
                    db.addVacataire(vacataire);
                    break;
                case 3:
                    System.out.println("---- Liste des enseinants permanants ----");
                    db.showPermanant();
                    break;
                case 4:
                    System.out.println("---- Liste des enseignants vacataires ----");
                    db.showVacataire();
                    break;
                case 5:
                    System.out.println("---- Liste de tous les enseignants ----");
                    db.showAllENseignants();
                    break;
                case 6:
                    System.out.println("---- Supprimer un enseignant ----");
                    System.out.print("Saisir le code de l'enseignant : ");
                    matricule = sc.nextLine();
                    enseignant = db.searchEnseignant(matricule);
                    if (enseignant==null){
                        System.out.println("Code invalide");
                    } else {
                        db.deleteEnseignant(enseignant);
                    }
                    break;
                case 7:

                    System.out.println("---- Creer un module ----");
                    System.out.print("Nom du module : ");
                    nom = sc.nextLine();
                    System.out.print("Volume horaire : ");
                    volume = checker.checkIntegerInput(sc);
                    module = new Module(nom, volume);
                    db.addModule(module);
                    break;

                case 8:
                    System.out.println("---- Liste de tous les modules ----");
                    db.showAllModule();
                    break;
                case 9 :
                    System.out.println("---- Ajouter un module a un enseignant ----");
                    System.out.print("Saisir le code de l'enseignant : ");
                    matricule = sc.nextLine();
                    enseignant = db.searchEnseignant(matricule);
                    if (enseignant==null){
                        System.out.println("Code invalide");
                    } else {

                        do {
                            System.out.println("1- Lister les module");
                            System.out.println("2- Ajouter un module a l'enseignant");
                            System.out.println("3- Quitter");
                            System.out.print("Faites votre choix : ");
                            choiceProf = checker.checkIntegerInput(sc);
                            switch (choiceProf){
                                case 1:
                                    db.showAllModuleMatricule();
                                    break;
                                case 2:
                                    System.out.print("Matricule : ");
                                    matricule = sc.nextLine();
                                    module = db.searchModule(matricule);
                                    if (module==null){
                                        System.out.println("Matricule invalide");
                                        System.out.println();
                                    } else {
                                        if (!db.moduleEnseignant(enseignant, module)){
                                            db.addModuleToEnseignant(enseignant, module);
                                            System.out.println("Module affecté à la liste des modules de l'enseignant avec succès");
                                            System.out.println();
                                        }
                                        else {
                                            System.out.println("Ce module a deja ete attribue a l'etudiant");
                                            System.out.println();
                                        }
                                    }
                                    break;
                                case 3:
                                    break;
                            }
                        }
                        while (choiceProf!=3);
                    }
                    break;
                case 10:
                    System.out.print("Saisir le code de l'enseignant : ");
                    matricule = sc.nextLine();
                    enseignant = db.searchEnseignant(matricule);
                    if (enseignant==null){
                        System.out.println("Code invalide");
                    } else {
                        db.showModuleByEnseignant(enseignant);
                    }
                    break;
                case 11:
                    System.out.println("---- Retirer un module a un enseignant ----");
                    System.out.print("Saisir le code de l'enseignant : ");
                    matricule = sc.nextLine();
                    enseignant = db.searchEnseignant(matricule);
                    if (enseignant==null){
                        System.out.println("Code invalide");
                    } else {
                        System.out.println("---- Liste des modules de l'enseignant ----");
                        db.showModuleByEnseignant(enseignant);
                        System.out.println();
                        System.out.print("Saisir le code du module : ");
                        matricule = sc.nextLine();
                        module = db.searchModule(matricule);
                        if (module==null){
                            System.out.println("Code invalide");
                        } else {
                            db.removeModuleToEnseignant(enseignant, module);
                        }
                    }
                    break;
                case 12:
                    System.out.println("---- Supprimer un module ----");
                    System.out.print("Saisir le code du module : ");
                    matricule = sc.nextLine();
                    module = db.searchModule(matricule);
                    if (module==null){
                        System.out.println("Code invalide");
                    } else {
                        db.deleteModule(module);
                    }
                    break;

                case 13:
                    System.out.println("---- Ajout d'étudiant ----");
                    System.out.print("Nom : ");
                    nom = sc.nextLine();
                    System.out.print("Prenom : ");
                    prenom = sc.nextLine();
                    etudiant = new Etudiant(nom, prenom);
                    System.out.println("---- Ajouter un/des modules à un étudiant ----");
                    db.addEtudiant(etudiant);

                case 14:
                    db.showAllEtudiants();
                    break;
                case 15:
                    System.out.print("Matricule de l'etudiant : ");
                    matricule = sc.nextLine();
                    etudiant = db.searchEtudiant(matricule);
                    if (etudiant==null){
                        System.out.println("Matricule invalide");
                    } else {
                        System.out.println("-+-+-+-+-+-+-+-+-+-+-+");
                        etudiant.afficher();
                        System.out.println("-+-+-+-+-+-+-+-+-+-+-+");
                        System.out.print("Matricule du module '");
                        matricule = sc.nextLine();
                        module = db.searchModule(matricule);
                        if (module==null){
                            System.out.println("Matricule invalide");
                        } else {
                            if (!db.moduleEtudiant(etudiant, module)){
                                db.createEtudiant(etudiant, module);
                                System.out.println("Module affecté à la liste des modules de l'étudiant avec succès");
                            }
                            else {
                                System.out.println("Ce module a deja ete attribue a l'etudiant");
                            }
                        }
                    }
                    break;
                case 16:
                    System.out.print("Matricule de l'etudiant : ");
                    matricule = sc.nextLine();
                    etudiant = db.searchEtudiant(matricule);
                    if (etudiant==null){
                        System.out.println("Matricule invalide");
                    } else {
                        System.out.println("-+-+-+-+-+-+-+-+-+-+-+");
                        System.out.println("Liste des modules de l'etudiant");
                        System.out.println("-+-+-+-+-+-+-+-+-+-+-+");
                        db.showModuleByEtudiant(etudiant);
                        System.out.println("-+-+-+-+-+-+-+-+-+-+-+");
                        System.out.print("Veuillez saisir le matricule du module a retirer a l'etudiant");
                        matricule = sc.nextLine();
                        module = db.searchModule(matricule);
                        if (module == null){
                            System.out.println("Matricule invalide");
                        } else {
                            db.removeModuleToEtudiant(etudiant, module);
                        }
                    }
                    break;
                case 17:
                    System.out.println("---- Module suivi par un etudiant ----");
                    System.out.print("Matricule : ");
                    matricule = sc.nextLine();
                    etudiant = db.searchEtudiant(matricule);
                    if (etudiant==null){
                        System.out.println("Matricule invalide");
                    } else {
                        db.showModuleByEtudiant(etudiant);
                    }
                    break;
                case 18:
                    System.out.println("---- Supprimer un etudiant ----");
                    System.out.print("Matricule : ");
                    matricule = sc.nextLine();
                    etudiant = db.searchEtudiant(matricule);
                    if (etudiant==null){
                        System.out.println("Matricule invalide");
                    } else {
                        db.deleteEtudiant(etudiant);
                    }
                    break;
                case 19:
                    System.out.println("---- Etudiants inscrit à un module ----");
                    System.out.print("Matricule : ");
                    matricule = sc.nextLine();
                    module = db.searchModule(matricule);
                    if (module==null){
                        System.out.println("Matricule invalide");
                    } else {
                        db.showEtudiantByModule(module);
                    }
                    break;
                case 20:
                    break;
                default:
                    System.out.println("Saisie invalide !!! ");
            }



        } while (choice!=20);

        System.out.println("Merci d'avoir utilisé ce programme");
    }



}