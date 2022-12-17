package View;

import Dao.Database;
import Entity.Permanant;
import Entity.Vacataire;

import java.util.Scanner;

public class Main {

    private static Database db = new Database();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nom, prenom, grade, specialite;
        double primePermanant, primeVacataire;

        int choice = 0;
        do {
            System.out.println("1- Ajouter un enseignant permanant");
            System.out.println("2- Ajouter un enseignant vacataire");
            System.out.println("3- Lister les enseignants permanants");
            System.out.println("4- Lister les enseignants vacataires");
            System.out.println("5- Lister tous les enseignants");
            System.out.println("6- Quitter");
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
                    Permanant permanant = new Permanant(nom, prenom, grade, specialite,primePermanant);
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
                    Vacataire vacataire = new Vacataire(nom, prenom, grade, specialite, primeVacataire);
                    db.addVacataire(vacataire);
                    break;
                case 3:
                    System.out.println("Liste des enseinants permanants ");
                    db.showPermanant();
                    break;
                case 4:
                    System.out.println("Liste des enseignants vacataires ");
                    db.showVacataire();
                    break;
                case 5:
                    System.out.println("Liste de tous les enseignants");
                    db.showAllENseignants();
                    break;
                default:
                    System.out.println("Saisie invalide !!! ");
            }


        } while (choice!=6);
        System.out.println("Merci d'avoir utilisé ce programme");
    }
}