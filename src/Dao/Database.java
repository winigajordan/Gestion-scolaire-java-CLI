package Dao;

import Entity.*;
import Entity.Module;

import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Serializable {
    private ArrayList<Enseignant> listEnseignantDb = new ArrayList<Enseignant>();
    private  ArrayList<Module> listModuleDb = new ArrayList<Module>();
    private ArrayList<Etudiant> listEtudiantDb = new ArrayList<Etudiant>();

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

    public Enseignant searchEnseignant(String matricule){
        Enseignant enseignant = null;
        for (Enseignant en : listEnseignantDb){
            if (en.getMatricule().equals(matricule)){
                enseignant = en;
            }
        }
        return enseignant;
    }

    public void createModule(Module module, Enseignant enseignant){
        module.setEnseignant(enseignant);
        enseignant.getListModules().add(module);
        listModuleDb.add(module);
    }

    public void addModule(Module module){
        listModuleDb.add(module);
    }

    public void showAllModule(){
        for(Module module:listModuleDb){
            System.out.println("-------------");
            module.afficher();
        }
        System.out.println("-------------");
    }

    public void showAllModuleMatricule(){
        for(Module module:listModuleDb){
            System.out.println("-------------");
            System.out.println(module);
        }
        System.out.println("-------------");
    }

    public Module searchModule(String matricule){
        Module module = null;
        for (Module md:listModuleDb){
            if (md.getMatricule().equals(matricule)) module = md;
        }
        return module;
    }

    public void createEtudiant(Etudiant etudiant, Module module){
        etudiant.getListModules().add(module);
        module.getListEtudiant().add(etudiant);
        if (!listEtudiantDb.contains(etudiant)){
            listEtudiantDb.add(etudiant);
        }
    }

    public void showAllEtudiants(){
        for (Etudiant etudiant : listEtudiantDb){
            System.out.println("-------------");
            etudiant.afficher();
        }
        System.out.println("-------------");
    }

    public Etudiant searchEtudiant(String matricule){
        Etudiant etudiant = null;
        for (Etudiant et : listEtudiantDb){
            if (et.getMatriculeEtudiant().equals(matricule)) etudiant=et;
        }
        return etudiant;
    }

    public void showModuleByEtudiant(Etudiant etudiant){
        for (Module mod : etudiant.getListModules()){
            System.out.println("-------------");
            mod.afficher();
        }
        System.out.println("-------------");
    }

    public void showEtudiantByModule(Module module){
        for (Etudiant etudiant:module.getListEtudiant()){
            System.out.println("-------------");
            etudiant.afficher();
        }
        System.out.println("-------------");
    }

    public void showModuleByEnseignant(Enseignant e){
        for (Module mod : e.getListModules()){
            System.out.println("-------------");
            System.out.println(mod);
        }
        System.out.println("-------------");
    }

    public void deleteEnseignant(Enseignant e){
        for (Module m : e.getListModules()) {
            m.setEnseignant(null);
        }
        listEnseignantDb.remove(e);
        System.out.println("Enseignant supprimé");
    }

    public void deleteModule(Module m){
       for (Enseignant e: listEnseignantDb){
           if (e.getListModules().contains(m)){
               e.getListModules().remove(m);
           }
       }
        for (Etudiant et : listEtudiantDb){
          if (et.getListModules().contains(m)){
            et.getListModules().remove(m);
          }
        }
        listModuleDb.remove(m);
        System.out.println("Module supprimé");
    }

    public void addModuleToEnseignant(Enseignant e, Module m){
        if (!e.getListModules().contains(m)){
            e.getListModules().add(m);
        } else {
            System.out.println("Ce module existe déjà");
        }
    }

    public void removeModuleToEnseignant(Enseignant e, Module m){
        if (e.getListModules().contains(m)){
            e.getListModules().remove(m);
        } else {
            System.out.println("Ce module n'existe pas");
        }
    }

    public void deleteEtudiant(Etudiant et){
        for (Module m : et.getListModules()){
            m.getListEtudiant().remove(et);
        }
        listEtudiantDb.remove(et);
        System.out.println("Etudiant supprimé");
    }


    public void addEtudiant(Etudiant etudiant){
        listEtudiantDb.add(etudiant);
        System.out.println("Etudiant ajouté");
    }

    public boolean moduleEtudiant(Etudiant etudiant, Module md){
        for(Module mod : etudiant.getListModules()){
            if (mod.getMatricule().equals(md.getMatricule())){
                return true;
            }
        }
        return false;
    }

    public boolean moduleEnseignant(Enseignant e, Module md){
        for(Module mod : e.getListModules()){
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