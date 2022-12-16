package Entity;

import java.io.Serializable;

public class Vacataire extends Enseignant implements Serializable {

    private double primeVacataire;

    public Vacataire(String nom, String prenom, String grade, String specialite, double primeVacataire) {
        super(nom, prenom, grade, specialite);
        this.primeVacataire = primeVacataire;
    }

    public double getPrimeVacataire() {
        return primeVacataire;
    }

    public void setPrimeVacataire(double primeVacataire) {
        this.primeVacataire = primeVacataire;
    }

    @Override
    public void afficher() {
        System.out.println("Matricule : "+matricule);
        System.out.println("Nom : "+ nom);
        System.out.println("Prenom : "+prenom);
        System.out.println("Grade : "+grade);
        System.out.println("Specialite : "+specialite);
        System.out.println("Prime vacataire : "+primeVacataire);
    }
}
