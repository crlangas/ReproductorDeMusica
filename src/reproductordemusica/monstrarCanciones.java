/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reproductordemusica;

/**
 *
 * @author Usuario
 */
public class monstrarCanciones {
        public static void monstrarCanciones(String[][] canciones) {
        //recore el array y va monstrando cada canción junto con el numero de cancion que es
        System.out.println("-  |    Nombre   | |     Autor     |  |                        URL                        |");
        for (int i = 0; i < canciones.length; i++) {
            System.out.print("- " + (i + 1));
            for (int j = 0; j < canciones[0].length; j++) {
                if (canciones[i][j] == (null)) {
                    if (j == 2) { //solo ajusta el tamaño de la barra al espacio para que se vea bien en la terminal
                        System.out.print("  ---------------------------------------------------  ");
                    } else {
                        System.out.print("  -------------  ");
                    }

                } else {
                    System.out.print(" " + canciones[i][j]);
                }

            }
            System.out.println("");
        }
    }
}
