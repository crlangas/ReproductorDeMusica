/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductordemusica;

import java.io.IOException;
import static reproductordemusica.ReproductorDeMusica.reader;

/**
 *
 * @author Usuario
 */
public class reproducirCanciones {
        //funcion para reproducir las canciones
    public static void reproducirCancion(String[][] canciones) throws IOException {
        int posCancion = 0;
        String URL = "";
        System.out.println("cual es la posicion de la cancion que quieres reproducir");
        while (true) { //pide la posicion de la cancion a reproducir y compreueba que sea valida
            posCancion = reader.nextInt();
            posCancion--;
            if (canciones[posCancion][2] == null) { //porsi en esa posicion no hay cancion
                System.out.println("El la posicion " + posCancion + " no se encuentra nada pordfavor añade una cancion si lo deseas");
                break;
            }
            if (posCancion < 0 || posCancion > 10) {
                System.out.println("Posicion seleccionada invalida porfavor pon una del 1-10 ");
            } else {
                URL = canciones[posCancion][2];
                //ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe", URL); 
                //pb.start(); 
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start", URL); // usa esta llamada al cmd para abrir el navegador por defecto.
                pb.start();
                break;
            }
        }

    }
}
