package MAgi;
import java.util.ArrayList;
public class Magi {
    public static void main(String[] args){
        Jeu maMain = new Jeu(10);
        maMain.piocher(new Terrain(0,"b"));
        maMain.piocher(new Creature(6,"Golem",4,6));
        maMain.piocher(new Sortilege(1,"Croissance Gigantesque","La creature cible recoit +3/3"));
        System.out.println("Il me reste : ");
        maMain.afficher();

    }
}
class Cartes {
    private int cout;



    public Cartes(int cout){
        this.cout = cout;

    }

}

class Jeu {
    private int Nbr_cartes;
    private int tableauCarte;
    private int cout;
    ArrayList<Cartes> uneListe = new ArrayList<Cartes>();

    public Jeu (int Nbr_cartes){
        this.Nbr_cartes = Nbr_cartes;
        tableauCarte =10;
        cout =0;
    }


    public void piocher(Cartes unJeu) {

        uneListe.add(unJeu);
    }
    public void afficher(){
                for(int i = 0 ; i < uneListe.size(); i++) {
                    if (uneListe.get(i) instanceof Terrain) {
                        System.out.println(((Terrain) uneListe.get(i)).afficherT());
                    }
                    if(uneListe.get(i) instanceof Creature){
                        System.out.println(((Creature) uneListe.get(i)).afficherC());
                    }
                    if(uneListe.get(i) instanceof Sortilege){
                        System.out.println(((Sortilege) uneListe.get(i)).afficherS());
                    }
                }
            }

    public void joue(){
        return;
    }

}
class Creature extends Cartes {
    private String nom_cretaure;
    private int nbr_degat;
    private int life_point;
    private int cout;

    public Creature(int cout, String nom_cretaure,int nbr_degat,int life_point){
        super(cout);
        this.nom_cretaure = nom_cretaure;
        this.nbr_degat = nbr_degat;
        this.life_point = life_point;
    }

    public String afficherC(){
        return "Creature: "+cout+","+nom_cretaure+","+nbr_degat+","+life_point;
    }


}

class Terrain extends Cartes{
    private String couleur_terrain;



    public Terrain(int cout, String couleur_terrain){
        super(0);
        this.couleur_terrain= couleur_terrain;

    }

    public String afficherT(){
        return "Le terrain est: "+couleur_terrain;
    }
}
class Sortilege extends Cartes{
    private String nom_sortilege;
    private String explication_sortilege;
    private int cout;
    public Sortilege(int cout, String nom_sortilege, String explication_sortilege){
        super(cout);
        this.nom_sortilege = nom_sortilege;
        this.explication_sortilege = explication_sortilege;
    }

    public String afficherS(){
        return "Sortilege: "+cout+","+nom_sortilege+","+explication_sortilege;
    }
}








