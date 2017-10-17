public class ProdMami {
    private final static int annee = 2017;

    public static void main(String[] args){
        Ustensile[] us = new Ustensile[5];
        us[0] = new AssietteRonde(1926, 8.4);
        us[1] = new Cuillere(1881, 7.3);
        us[2] = new AssietteCarree(1935, 5.6);
        us[3] = new Cuillere(1917, 8.8);
        us[4] = new AssietteRonde(1837, 5.4);

        afficherCuilleres(us);
        afficherSurfaceAssiettes(us);
        afficherValeurTotale(us);
    }
    static void afficherCuilleres(Ustensile[] us) {
        int nbCuilleres = 0;
        for (int i = 0; i < us.length; i++) {
            if (us[i] instanceof Cuillere) {
                nbCuilleres++;
            }
        }
        System.out.println("Il y a " + nbCuilleres + " cuillères.");
    }

    static void afficherSurfaceAssiettes(Ustensile[] us) {
        double somme = 0;
        for (int i = 0; i < us.length; i++) {
            if (us[i] instanceof Assiette) {
                somme = somme + ((Assiette) us[i]).calculerSurface();
            }
        }
        System.out.println("Surface totale des assiettes : " + somme);
    }

    static void afficherValeurTotale(Ustensile[] us) {
        double somme = 0;
        for (int i = 0; i < us.length; i++) {
            somme = somme + us[i].calculerValeur(annee);
        }
        System.out.println("Valeur totale de la collection : " + somme);
    }

}
abstract class Ustensile{
    private int annee;

    public Ustensile(int annee){
        this.annee = annee;
    }
    public int getAnneeUstensile(){
        return annee;
    }
    public double calculerValeur(int annee_actuelle){
        int age = (annee_actuelle-getAnneeUstensile());
        double valeur=0;
        if(age >50){
                valeur=age -50;
        }
        return valeur;
    }
}
abstract class Assiette extends Ustensile{
    public Assiette(int année){
        super(année);
    }
    public abstract double calculerSurface();

}

class AssietteRonde extends Assiette{
    private double rayon;

    public AssietteRonde(int annee,double rayon){
        super(annee);
        this.rayon = rayon;

    }
    public double getRayon(){
        return rayon;
    }
    public double calculerSurface(){
        return (3.14 * getRayon()* getRayon());
    }

}
class AssietteCarree extends Assiette{
    private double cote;

    public AssietteCarree(int annee, double cote){
        super(annee);
        this.cote = cote;
    }
    public double getCote(){
        return cote;
    }
    public double calculerSurface(){
        return (getCote()*getCote());
    }
    public double calculerValeur(int annee_actuelle){
        double valeur = 5 * super.calculerValeur(annee_actuelle);
        return valeur;
    }

}
class Cuillere extends Ustensile{
    private double longueur;
    public Cuillere(int annee, double longueur){
        super(annee);
        this.longueur = longueur;
    }
    public double getLongueur(){
        return longueur;
    }
}
