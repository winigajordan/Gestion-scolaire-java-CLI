package Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Etudiant implements Serializable {
    private String matriculeEtudiant;
    private String nom;
    private String prenom;
    private static int cpt=0;

    private ArrayList<Module> listModules;

    public Etudiant(String nom, String prenom) {
        cpt++;
        this.matriculeEtudiant = "ETU--"+String.valueOf(cpt);
        this.nom = nom;
        this.prenom = prenom;
        this.listModules = new ArrayList<Module>();
    }

    public ArrayList<Module> getListModules() {
        return listModules;
    }

    public void setListModules(ArrayList<Module> listModules) {
        this.listModules = listModules;
    }

    public String getMatriculeEtudiant() {
        return matriculeEtudiant;
    }

    public void setMatriculeEtudiant(String matriculeEtudiant) {
        this.matriculeEtudiant = matriculeEtudiant;
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

    public void afficher(){
        System.out.println("Matricule : "+matriculeEtudiant);
        System.out.println("Nom : "+nom);
        System.out.println("Prenom : "+prenom);
    }
}
