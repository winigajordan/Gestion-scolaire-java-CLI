package Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Module implements Serializable {
    private String matricule;
    private String nom;
    private int volume;
    private static int inc=0;
    private Enseignant enseignant;
    private ArrayList<Etudiant> listEtudiant;

    public Module(String nom, int volume) {
        inc ++;
        this.matricule = "MDL--"+String.valueOf(inc);
        this.nom = nom;
        this.volume = volume;
        listEtudiant = new ArrayList<Etudiant>();
    }

    public ArrayList<Etudiant> getListEtudiant() {
        return listEtudiant;
    }

    public void setListEtudiant(ArrayList<Etudiant> listEtudiant) {
        this.listEtudiant = listEtudiant;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void afficher(){
        System.out.println("Matricule du module :" + matricule);
        System.out.println("Nom du module : " + nom);
        System.out.println("Volume horaire : " + String.valueOf(volume)+ " heures");
        //enseignant.afficher();
    }

    @Override
    public String toString() {
        String output="Nom : "+nom+
                "\n Matricule : "+matricule;
        return output;
    }
}
