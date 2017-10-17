package Tp_IO;

import java.io.IOException;
import java.nio.file.*;
import java.io.*;
import java.util.Scanner;


public class CopyFile {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez Votre chemin :");
        String myPathFile = sc.nextLine();
        File myFile = new File(myPathFile);
        try {
            if (myFile.isFile() || myFile.isDirectory()) {                           //On vérifie que le chemin entré est correct
                System.out.println("Chemin du fichier " + myFile.getAbsolutePath());
            }
        } catch (NullPointerException e) {
            System.out.println("Error" + e);

        }

        ////////////////////////////////////////////////////////////////////////////////////



        System.out.println("Veuillez indiquez le nom du fichier que vous souhaitez créer");
        String myNewFile = sc.nextLine();
        File myNewFileF = new File(myNewFile);

        try{
            copyFile(myFile,myNewFileF);                                //copy de myFile dans myNewFileF *(si le fichier n'existe pas il serra créé)*
        }
        catch (Exception e){
            System.out.println("Impossible de copier le fichier" + e);

        }


    }
    private static void copyFile(File myFile, File myNewFileF) throws IOException {
        Files.copy(myFile.toPath(), myNewFileF.toPath());
    }












}
