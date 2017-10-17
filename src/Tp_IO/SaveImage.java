package Tp_IO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SaveImage
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);                                // On créer un scanner pour récuperer la valeur que l'utilisateur va entrer
        System.out.println("Veuillez le chemin de votre image:");
        String myPathFile= sc.nextLine();                                   //Donner un fichier à la racine
        String path1 = myPathFile;
        System.out.println("Veuillez saisir le chemin de votre image enregistrer:");
        String myPathFileSaved= sc.nextLine();
        String path2 = myPathFileSaved;
        File oldFile = new File( path1);
        File newFile = new File( path2);

        try
        {
            FileInputStream fis = new FileInputStream( oldFile );           //L'input corrrespond à notre image à enregistrer
            FileOutputStream fos = new FileOutputStream( newFile );         //L'output correspond à l'image qui va être enregistrer

            try
            {
                int currentByte = fis.read();                   //On affecte à currentByte la valeur "lu" du fichier input
                while( currentByte != -1 )
                {
                    fos.write( currentByte );
                    currentByte = fis.read();
                }
            }
            catch( IOException exception )
            {
                System.err.println( "IOException "+exception );
                exception.printStackTrace();
            }
            finally
            {
                fis.close();                                //On ferme l'input et l'output
                fos.close();
                System.out.println( "Image enregistrée" );
            }
        }
        catch( IOException exception )
        {
            System.err.println( "Probleme avec l'image" );
            exception.printStackTrace();
        }
    }
}
