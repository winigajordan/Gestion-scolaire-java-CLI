package Dao;

import Entity.Enseignant;
import Entity.Permanant;
import Entity.Vacataire;

import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {
    private ArrayList<Enseignant> listEnseignantDb = new ArrayList<Enseignant>();

    public void addPermanant(Permanant permanant){
        listEnseignantDb.add(permanant);
    }

    public void addVacataire(Vacataire vacataire){
        listEnseignantDb.add(vacataire);
    }

    public void showPermanant(){
        for(Enseignant enseignant : listEnseignantDb){
            if (enseignant instanceof Permanant){
                Permanant p = (Permanant) enseignant;
                System.out.println("-------------");
                p.afficher();
            }
        }
        System.out.println("-------------");
    }

    public void showVacataire(){
        for(Enseignant enseignant : listEnseignantDb){
            if (enseignant instanceof Vacataire){
                Vacataire vac = (Vacataire) enseignant;
                System.out.println("-------------");
                vac.afficher();
            }
        }
        System.out.println("-------------");
    }

    public void showAllENseignants(){
        for (Enseignant enseignant : listEnseignantDb){
            System.out.println("-------------");
            enseignant.afficher();
        }
        System.out.println("-------------");
    }

}
