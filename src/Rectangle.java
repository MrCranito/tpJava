import java.util.Scanner;
public class Rectangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir la largeur");
        int x = sc.nextInt();
        System.out.println("Veuillez saisir la longueur");
        int y= sc.nextInt();
        System.out.println("Vous voulez calculez la Surface (S) ou le périmètre (P) ?");
        String answer = sc.nextLine();
        if (answer =="S"){
            calculerSurface(x,y);
        }
        else if(answer=="P"){
            calculerPerimetre(x,y);

        }
        else
        {
            System.out.println("Got damn a mistake happened!");
        }
    }
    public static String calculerSurface(int x, int y){
        int mycalcul = x*y;
        return "La surface de votre rectangle est :"+mycalcul+"";
    }
    public static String calculerPerimetre(int x, int y){
        int mycalculperimetre = 2*(x+y);
        return "La surface de votre rectangle est:"+mycalculperimetre+"";
    }

}
