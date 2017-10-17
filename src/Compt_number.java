import java.util.Scanner;
import java.lang.String;
import java.lang.System;
public class Compt_number {
    public static String my_sign(int my_number){
        if (my_number % 2==0){
            return "pair";

        }
        else return "impair";
    }

    public static String my_value (int my_number){
        if (my_number < 0){
            return "Votre chiffre est negatif et ";
        }
        else
            return "Votre chiffre est positif et ";

        }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un nombre ou un chiffre :");
        int i = sc.nextInt();
        System.out.println(my_value(i)+my_sign(i));
    }

}








