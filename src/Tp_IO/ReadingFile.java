package Tp_IO;
import java.io.*;
import java.io.File;
import java.util.Scanner;
public class ReadingFile {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez Votre chemin :");
        String myPathFile= sc.nextLine();
        File myFile = new File(myPathFile);
       try{
        if (myFile.isFile()|| myFile.isDirectory()){                            //On vérifie que le chemin entré est correct
            System.out.println("Chemin du fichier "+myFile.getAbsolutePath());
        }
       }
       catch(NullPointerException e){
           System.out.println("Le chemin entrée n'est pas valide, le fichier est inéxistant" + e);

        }

            try{
                int x= 1;

                for (File myAnswerFile : myFile.listFiles()){

                    if(myAnswerFile.isDirectory()==true){
                        System.out.println("\n");
                        File myChildFile = new File(String.valueOf(myAnswerFile.getPath()));
                        System.out.println("Voici vos fichiers dans le dossier "+myAnswerFile.getName());
                        for (File myChild :myChildFile.listFiles()){
                            System.out.println(myChild.getName());      // *Amélioration* Si le fichier est un dossier on affiche son contenu
                        }
                        System.out.println("\n");


                    }
                    else{
                        System.out.println(myAnswerFile.getName());
                    }

                    if((x%10)==0){
                        System.out.print("\n");
                    }
                    x++;
                }
                System.out.println("\n");

            }
            catch(NullPointerException e){
                System.out.println("Error "+e);

            }
        }
    }


