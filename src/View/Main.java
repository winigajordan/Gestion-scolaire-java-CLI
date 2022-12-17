package View;

import Dao.Database;
import Entity.*;
import Entity.Module;

import java.util.Scanner;

public class Main {

    private static Database db = new Database();

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
        int choice, choiceEtu= 0;
        do {
            System.out.println("1- Ajouter un enseignant permanant");
            System.out.println("2- Ajouter un enseignant vacataire");
            System.out.println("3- Lister les enseignants permanants");
            System.out.println("4- Lister les enseignants vacataires");
            System.out.println("5- Lister tous les enseignants");
            System.out.println("6- Creer un module");
            System.out.println("7- Lister les modules");
            System.out.println("8- Ajouter un etudiant");
            System.out.println("9- Lister tous les etudiants");
            System.out.println("10- Lister les modules suivi par un étudiant");
            System.out.println("11- Lister tous etudiants inscrit à un module");
            System.out.println("12- Quitter");
            System.out.print("\n Faites un choix ");
            choice = sc.nextInt();
            sc.nextLine();
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
                    primePermanant = sc.nextDouble();
                    sc.nextLine();
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
                    primeVacataire = sc.nextDouble();
                    sc.nextLine();
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
                    System.out.println("---- Creer un module ----");
                    System.out.print("Saisir le code de l'enseignant : ");
                    matricule = sc.nextLine();
                    enseignant = db.searchEnseignant(matricule);
                    if (enseignant==null){
                        System.out.println("Matricule invalide");
                    } else {
                        System.out.println("---- Ajouter un module");
                        System.out.print("Nom : ");
                        nom = sc.nextLine();
                        System.out.print("Volume horaire : ");
                        volume = sc.nextInt();
                        sc.nextLine();
                        module = new Module(nom, volume);
                        db.createModule(module, enseignant);
                    }
                    break;
                case 7:
                    System.out.println("---- Liste de tous les modules ----");
                    db.showAllModule();
                    break;
                case 8:
                    System.out.println("---- Ajout d'étudiant ----");
                    System.out.print("Nom : ");
                    nom = sc.nextLine();
                    System.out.print("Prenom : ");
                    prenom = sc.nextLine();
                    etudiant = new Etudiant(nom, prenom);
                    System.out.println("---- Ajouter un/des modules à un étudiant ----");
                    do {
                        System.out.println("1- Lister les module");
                        System.out.println("2- Ajouter un module à l'étudiant crée");
                        System.out.println("3- Quitter");
                        System.out.print("Faites votre choix : ");
                        choiceEtu = sc.nextInt();
                        sc.nextLine();

                        /*
                        if (choiceEtu==1){
                            db.showAllModuleMatricule();
                        } else if(choiceEtu==2){
                            System.out.print("Matricule : ");
                            matricule = sc.nextLine();
                            module = db.searchModule(matricule);
                            if (module==null){
                                System.out.println("Matricule invalide");
                            } else {
                                db.createEtudiant(etudiant, module);
                                System.out.println("Module affecté à la liste des modules de l'étudiant avec succès");
                            }
                        } else {
                            continue;
                        }*/

                        switch (choiceEtu){
                            case 1:
                                db.showAllModuleMatricule();
                                break;
                            case 2:
                                System.out.print("Matricule : ");
                                matricule = sc.nextLine();
                                module = db.searchModule(matricule);
                                if (module==null){
                                    System.out.println("Matricule invalide");
                                } else {
                                    db.createEtudiant(etudiant, module);
                                    System.out.println("Module affecté à la liste des modules de l'étudiant avec succès");
                                }
                                break;
                            case 3:
                                break;
                        }
                    } while (choiceEtu!=3);

                case 9:
                    db.showAllEtudiants();
                    break;
                case 10:
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
                case 11:
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
                case 12:
                    break;
                default:
                    System.out.println("Saisie invalide !!! ");
            }

        } while (choice!=12);
        System.out.println("Merci d'avoir utilisé ce programme");
    }
}