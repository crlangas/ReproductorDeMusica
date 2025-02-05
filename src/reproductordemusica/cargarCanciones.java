/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductordemusica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class cargarCanciones {
        public static String[][] cargarCanciones() {
        String[][] cancionesDelArchivo = new String[10][3];
        try {
            File playlist = new File("USER_PLAYLIST.csv");
            Scanner scanner = new Scanner(playlist);

            //recorre la lineas del archivo y la guarda en cancionesDelArchivo
            for (int i = 0; i < 10; i++) {
                cancionesDelArchivo[i] = scanner.nextLine().split(";");
            }

            // retorna el array lleno con las canciones guardadas en otra sesión
            System.out.println("Canciones Cargadas con exito");
            return cancionesDelArchivo;
            
        } catch (FileNotFoundException e) {
            System.out.println("Error archivo de guardado no encontrado");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return cancionesDelArchivo;
    }
}
