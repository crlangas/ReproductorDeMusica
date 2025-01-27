package reproductordemusica;

import static reproductordemusica.ReproductorDeMusica.reader;

/**
 *
 * @author Usuario
 */
public class borrarCanciones {  
    
    //inicializo esta funcion para que devuelva la matriz canciones con la nueva cancion
    //funcion de borrar normal
    public static String[][] borrarCanciones(String[][] canciones) {
        int posCancion = 0;
        System.out.println("cual es la posicion de la cancion que quieres borrar");
        while (true) { //pide la posicion de la cancion a borrar hasta que sea valida
            posCancion = reader.nextInt();
            if (posCancion < 0 && posCancion > 10) {
                System.out.println("Posicion seleccionada invalida porfavor pon una del 1-10 ");
            } else {
                break;
            }
        }
        posCancion--;

        for (int i = 0; i < canciones[posCancion].length; i++) { //resetea los valores de la cancion y la borra asi
            canciones[posCancion][i] = null;
        }
        System.out.println("La cancion de la posicion: " + posCancion + " se borro correctamente");
        return canciones;
    }

    //inicializo esta funcion para que devuelva la matriz canciones con la nueva cancion
    //funcion esclusiva para usarla en el bucle de añadir
    public static String[][] borrarCanciones(String[][] canciones, int posCancion) {
        for (int i = 0; i < canciones[posCancion].length; i++) { //resetea los valores de la cancion y la borra asi
            canciones[posCancion][i] = null;
        }
        System.out.println("La cancion de la posicion: " + posCancion + " se borro correctamente");
        return canciones;
    }
}
