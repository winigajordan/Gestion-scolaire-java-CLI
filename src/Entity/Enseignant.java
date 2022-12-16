package Entity;

import java.io.Serializable;

public abstract class Enseignant implements Serializable {
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected String grade;
    protected String specialite;
    private static int cpt=0;

    public Enseignant(String nom, String prenom, String grade, String specialite) {
        cpt++;
        this.matricule = "ENS--"+String.valueOf(cpt);
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
        this.specialite = specialite;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public abstract void afficher();
}
