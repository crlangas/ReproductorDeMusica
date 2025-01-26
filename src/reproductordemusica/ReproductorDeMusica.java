package reproductordemusica;

import java.util.Scanner;

/**
 * Vamos a terminar estos ejercicios con un poco de música. Se ha programar un
 * reproductor de videoclips. Para ello, se mostrará un menú con 10 canciones
 * que te gusten, y se podrá elegir cuál reproducir (en una estructura guarda
 * título - autor - URL en Youtube).
 *
 * AYUDA PARA REPRODUCIR: se puede lanzar un proceso con el siguiente código. En
 * mi caso uso el navegador Brave, pero tú puedes hacer lo mismo con tu
 * navegador, mirando la ubicación en el sistema:
 *
 * ProcessBuilder pb = new ProcessBuilder("C:\\Program
 * Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe", URL);
 * pb.start(); Ha de estar en un try-catch. El segundo dato es la URL que se
 * desea abrir de Youtube: cada canción tendrá la suya, y al seleccionar la
 * canción se traerá la URL para ejecutarla.
 *
 *
 * BONUS: Si te animas, añade opciones en el menú. Además de Reproducir canción,
 * que se pueda:
 *
 * A) Mostrar las canciones disponibles. 
 * B) Añadir canción: se pedirá una nueva
 * canción (Título - autor- URL). 
 * C) Borrar canción.
 *
 * @author Carlos
 */
public class ReproductorDeMusica {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        // Variables
        String canciones[][] = new String [10][3];
        String decicison = "";
        
        System.out.println("Escribe lo que quieres hacer, \"play\" para reproducir, \"stop\" para dejar de reproducir, \n \"show\" para monstar las canciones disponibles,\n \"add\" para añadir una cancion nueva y \n \"delete\" para borrar una existente");
        decicison = reader.next();
        switch (decicison.toLowerCase()) {
            case "show":
                monstrarCanciones(canciones);
                break;
            case "add":
                añadirCanciones(canciones);
                break;
            case "delete":
                borrarCanciones(canciones);
                break;
            default:
                throw new AssertionError();
        }
        
        
        
    }

    private static void monstrarCanciones(String[][] canciones) {
        //recore el array y va monstrando cada canción junto con el numero de cancion que es
        System.out.println("-  |    Nombre   | |     Autor     |  |                        URL                        |");   
        for (int i = 0; i < canciones.length; i++) {
            System.out.print("- " + i );
            for (int j = 0; j < canciones[0].length; j++) { 
                if (canciones[i][j] == (null)) {
                    if (j == 2) { //solo ajusta el tamaño de la barra al espacio para que se vea bien en la terminal
                        System.out.print("  ---------------------------------------------------  ");
                    } else{
                        System.out.print("  -------------  ");
                    }
                    
                } else{
                   System.out.print(" " + canciones[i][j]); 
                }
                
            }
            System.out.println("");   
        }
    }

    private static void añadirCanciones(String[][] canciones) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void borrarCanciones(String[][] canciones) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
