package Tp_IO;
import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;


public class WriteInFile {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez mentionner le chemin du fichier à modifier :");
        String myPathFile = sc.nextLine();
        File myFile = new File(myPathFile);
        try {
            if (myFile.isFile() || myFile.isDirectory()) {              //On vérifie que le chemin entré est correct
                System.out.println("Chemin du fichier " + myFile.getAbsolutePath());
            }
        } catch (NullPointerException e) {
            System.out.println("Error" + e);

        }

        String str, filename = "test.txt";                              //Nom du fichier qui serra créé à la racine du project

        PrintWriter outfile = new PrintWriter(new FileWriter(filename),true);

        System.out.println("Saisir le texte à ajouter : ");
        String myText = sc.nextLine();

        while (!myText.equals("quit")) {                               //Tant que l'utilisateur ne rentrera pas "quit" toutes ces commandes s'enregistrent dans le fichier
            outfile.println(myText);
            System.out.println("Saisir le texte ou \"quit\" pour quitter : ");
            myText = sc.nextLine();
        }

        outfile.close();
    }
}



