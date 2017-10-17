import java.util.Scanner;
public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir votre X");
        int x = sc.nextInt();
        System.out.println("Veuillez saisir votre Y");
        int y = sc.nextInt();
        Permuter(x,y);
    }
    public static String Permuter(int x, int y){
        int z;
        z = y;
        y = x;
        x = z;
        return "Voici vos variables permutées : X"+x+" et votre Y:"+y+"";
    }
};

