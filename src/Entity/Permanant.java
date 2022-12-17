package Entity;

import java.io.Serializable;

public class Permanant extends Enseignant implements Serializable {
    private double primePermanant;

    public Permanant(String nom, String prenom, String grade, String specialite, double primePermanant) {
        super(nom, prenom, grade, specialite);
        this.primePermanant = primePermanant;
    }

    public double getPrimePermanant() {
        return primePermanant;
    }

    public void setPrimePermanant(double primePermanant) {
        this.primePermanant = primePermanant;
    }

    @Override
    public void afficher() {
        System.out.println("Matricule : "+matricule);
        System.out.println("Nom : "+ nom);
        System.out.println("Prenom : "+prenom);
        System.out.println("Grade : "+grade);
        System.out.println("Specialite : "+specialite);
        System.out.println("Prime permanant : "+primePermanant);
    }
}
