package Tp_IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
class Entreprise_Biff_compt
{
    public static void main(String[] args)throws IOException{

        Personnel p = new Personnel();
        p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
        p.ajouterEmploye(new Technicien("Wahel","Turfu", 50, "1960", 4000));
        p.ajouterEmploye(new Technicien("god","daam", 50, "1960", 2000));
        p.afficherSalaires();
        System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + "€");

        System.out.println("Veuillez saisir : \n A pour ajouter un employee \n C pour calculer le salaire \n S pour sauvegarder vos employés");
        Scanner sc = new Scanner(System.in);
        String Choix = sc.nextLine();
        if(Choix.equals("A")){
            System.out.println("Vous avez décidé d'ajouter un nouvel employé : \n 1: Un nouveau Vendeur \n 2: un nouveau Représentant \n 3: un nouveau Technicien \n 4: un nouveau Manutentionnaire ");
            Choix = sc.nextLine();
            switch (Choix){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Veuillez Saisir un chiffre entre 1 et 5");
                    Choix = sc.nextLine();
                    break;
            }

        }
        else if (Choix.equals("C")){
            System.out.println("Voici le calcul du salaire : ");
            p.salaireMoyen();


        }
        else if(Choix.equals("S")){
            System.out.println("Voici la liste des employées à sauvegarder");
            p.sauvegarderEmploye();
        }
        else{
            System.out.println("Couscous");

        }

    }
}
abstract class Employee{ //Classe Mère
    private String nom;
    private String prenom;
    private int age;
    private String date_entrée;

    public Employee(String prenom, String nom,int age, String date_entrée){

        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.date_entrée = date_entrée;
    }
    public abstract double calculerSalaire();

    public String getNom(){
        return "L'employé " + prenom +" "+ nom;
    }

    public String getAttribute(){return " "+prenom+" "+nom+" "+age+" "+date_entrée;
    }
}
abstract class  Commercial extends Employee{ //Classe qui étend la classe mère Employee
    private double chiffreAffaire;

    public Commercial(String prenom, String nom, int age,String date, double chiffreAffaire){
        super(prenom,nom,age
                ,date);
        this.chiffreAffaire = chiffreAffaire;
    }
    public double getChiffreAffaire()
    {
        return chiffreAffaire;
    }


}
class Vendeur extends Commercial{
    private   static double Pourcent_vendeur=0.2;
    private  static int Bonus_vente =400;

    public Vendeur(String prenom, String nom, int age, String date, double chiffreAffaire){
        super(prenom,nom,age,date,chiffreAffaire);
    }

    public double calculerSalaire(){
        return (Pourcent_vendeur * getChiffreAffaire()) + Bonus_vente;

    }
}
class Representant extends Commercial{
    private final static double Pourcent_representant = 0.2;
    private final static int Bonus_representant = 800;

    public Representant(String prenom, String nom, int age, String date, double chiffreAffaire){
        super(prenom, nom, age, date, chiffreAffaire);
    }
    public double calculerSalaire(){
        return (Pourcent_representant*getChiffreAffaire())+ Bonus_representant;
    }
}
class Technicien extends Employee {
    private final static double facteur = 5.0;
    private int unites;

    public Technicien(String prenom, String nom, int age, String date, int unites){
        super(prenom, nom,age , date);
        this.unites = unites;
    }
    public  double calculerSalaire(){
        return facteur * unites;
    }
}
class Manutentionnaire extends Employee{
    private static int Salaire_heure = 65;
    private int heures;

    public Manutentionnaire(String prenom, String nom, int age, String date, int heures){
        super(prenom,nom,age,date);
        this.heures= heures;
    }
    public double calculerSalaire(){
        return Salaire_heure * heures;
    }
}

interface EmployeeArisk{
    int primederisque();
}
abstract class TechnicienArisk extends Technicien implements EmployeeArisk{
    public TechnicienArisk(String prenom, String nom, int age, String date,int unites){
        super(prenom, nom, age, date, unites);
    }

    @Override
    public double calculerSalaire() {
        return super.calculerSalaire();

    }
    public double primerisques(){
        return super.calculerSalaire()+primederisque();
    }
}
abstract class ManuARisk extends Manutentionnaire implements EmployeeArisk{
    public ManuARisk(String prenom,String nom, int age, String date,int heures){
        super(prenom, nom, age, date, heures);
    }

    @Override
    public double calculerSalaire() {
        return super.calculerSalaire();
    }

    public double primerisques(){
        return super.calculerSalaire()+primederisque();
    }
}
class Personnel {
    public Employee[] tableau_employee;
    private int nbreEmploye;
    private final static int MAXEMPLOYE = 10000; //fixer la valeur du nombre d'employée voulu
    ArrayList<Employee> uneListe = new ArrayList<Employee>();
    public Personnel() {
        tableau_employee = new Employee[MAXEMPLOYE];
        nbreEmploye = 0;
    }
    public void ajouterEmploye(Employee e) {

        ++nbreEmploye;
        if (nbreEmploye <= MAXEMPLOYE) {
            tableau_employee[nbreEmploye - 1] = e;
        } else {
            System.out.println("Pas plus de " + MAXEMPLOYE + " employés");

        }
    }

    public double salaireMoyen() {
        double somme = 0.0;
        for (int i = 0; i < nbreEmploye; i++) {

            somme += tableau_employee[i].calculerSalaire();
        }

        return somme / nbreEmploye;
    }

    public void afficherSalaires() {

        for (int i = 0; i < nbreEmploye; i++) {

            System.out.println(tableau_employee[i].getNom() + " gagne "

                    + tableau_employee[i].calculerSalaire() + "€");

        }
    }

    public void sauvegarderEmploye() throws IOException {

        String str, filename = "sauvegarde.txt";
        File dir = new File ("sauvegarde/employee/");
        dir.mkdirs();
        PrintWriter outfile = new PrintWriter(new FileWriter(dir.getName()+filename),true);
        for (int i = 0; i < nbreEmploye; i++) {
            uneListe.add(tableau_employee[i]);
            String path = "sauvegarde/employee/"+uneListe.get(i).getClass();
            dir = new File(path);
            dir.mkdirs();
            filename = dir.getAbsolutePath()+"/"+tableau_employee[i].getNom();
            PrintWriter fileCreate = new PrintWriter(new FileWriter(filename),true);

            fileCreate.println(tableau_employee[i].getNom()+" gagne "+ tableau_employee[i].calculerSalaire()+" €");
            String new_affichage = afficher();
            fileCreate.println(new_affichage);






        }
        outfile.close();
        System.out.println("Tous vos employées ont été sauvegardés dans le fichier sauvegarde/employee/");
    }
    public String afficher() {

        for (int i = 0; i < uneListe.size(); i++) {
            return uneListe.get(i).getAttribute();
        }

        return null;
    }
}