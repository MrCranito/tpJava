package Tp_IO;

import java.io.File;
import java.util.Scanner;
import java.io.*;

public class ReadingFileExtension {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);                                //Scan for what the user will prompt as path
        System.out.println("Veuillez Votre chemin :");
        String myPathFile= sc.nextLine();
        System.out.println("Veuillez écrire votre extension de fichier à rechercher :");
        String myExtension =sc.nextLine();
        File myFile = new File(myPathFile);
        try{
            if (myFile.isFile()|| myFile.isDirectory()){
                System.out.println("Chemin du fichier "+myFile.getAbsolutePath());
            }
        }
        catch(NullPointerException e){
            System.out.println("Error" + e);

        }

        try{

            for (File myAnswerFile : myFile.listFiles()){

                if(myAnswerFile.getName().endsWith(myExtension)==true){             //la méthode .endsWith renvoi un Booléan, donc si celui-ci correspond à true, alors les fichiers affichés ont bien l'extension demandée
                    System.out.println(myAnswerFile.getName());
                }


            }
            System.out.println("\n");

        }
        catch(NullPointerException e){
            System.out.println("Error "+e);

        }
    }
}

