package Metier;

import Dao.Database;
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

    public int checkDoubleInput(Scanner sc) {
        while(true) {
            try {
                int input = sc.nextInt();
                sc.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Erreur de saisie, Veuillez saisir un entier ou un nombre avec \".\" : ");
                sc.next();
            }
        }
    }

    public boolean moduleEtudiant(Etudiant etudiant, Module md){
       for(Module mod : etudiant.getListModules()){
           if (mod.getMatricule().equals(md.getMatricule())){
               return true;
           }
       }
        return false;
    }

    public void removeModuleToEtudiant(Etudiant etudiant, Module md){
        md.getListEtudiant().remove(etudiant);
        etudiant.getListModules().remove(md);
        System.out.println("Module retire a l'etudiant avec succes");
    }

}
