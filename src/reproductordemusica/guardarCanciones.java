/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductordemusica;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class guardarCanciones {
        //funcion para guardar las canciones
    public static void guardarCanciones(String[][] canciones) {

        try {
            FileWriter escritorDeFichero = new FileWriter("USER_PLAYLIST.csv");
            for (int i = 0; i < canciones.length; i++) { //recorre canciones y guarda cada valor seprador por un ;
                escritorDeFichero.write((canciones[i][0] == null ? "" : canciones[i][0]) + ";" + (canciones[i][1] == null ? "  -------------  ;" : canciones[i][1]) + ";" + canciones[i][2] + "\n");
            }
            escritorDeFichero.close();
            System.out.println("Fichero playlist guardada con exito");
        } catch (IOException error) { //con este try catch el programa sigue su curso y no para pero salta el error si no se guarda bien
            System.out.println("Error al guardar la playlist.");
        }
    }
}
