package Metier;

import Dao.Database;
import Entity.Enseignant;
import Entity.Etudiant;
import Entity.Module;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Checker {

    private Database db = new Database();

    public int checkIntegerInput(Scanner sc) {
        while(true) {
            try {
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Erreur de saisie, Veuillez saisir un entier : ");
                sc.next();
            }
        }
    }

    public double checkDoubleInput(Scanner sc) {
        while(true) {
            try {
                double input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Erreur de saisie, Veuillez saisir un entier ou un nombre avec \".\" : ");
                sc.next();
            }
        }
    }
}
