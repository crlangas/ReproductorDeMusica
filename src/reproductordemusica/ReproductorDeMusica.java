package reproductordemusica;

import java.util.Scanner;
//importo las clases para usar sus funciones y asi tenerlo mas estructurado.
import static reproductordemusica.añadirCanciones.añadirCanciones;
import static reproductordemusica.borrarCanciones.borrarCanciones;
import static reproductordemusica.monstrarCanciones.monstrarCanciones;
import static reproductordemusica.reproducirCanciones.reproducirCancion;

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
 * A) Mostrar las canciones disponibles. B) Añadir canción: se pedirá una nueva
 * canción (Título - autor- URL). C) Borrar canción.
 *
 * @author Carlos
 */
public class ReproductorDeMusica {

    static String canciones[][] = new String[10][3]; // pongo esto como static para poder usarlo en las funciones mejor.
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        // Variables
        String decicison = "";
        boolean seguir = true;

        try { //try catch para la gestion de errores
        System.out.println("Escribe lo que quieres hacer, \"play\" para reproducir, \"stop\" para dejar de reproducir, \n \"show\" para monstar las canciones disponibles,\n \"add\" para añadir una cancion nueva y \n \"delete\" para borrar una existente");
        decicison = reader.next();
        while (seguir) { //bucle para que el programa no deje de ejecutarse
            switch (decicison.toLowerCase()) { //swhich en funcion
                case "play"://decision a ajecutar
                    reproducirCancion(canciones);
                    break;
                case "stop":
                    System.out.println("not avitable");
                    break;
                case "show":
                    monstrarCanciones(canciones);
                    break;
                case "add":
                    canciones = añadirCanciones(canciones);

                    break;
                case "delete":
                    canciones = borrarCanciones(canciones);
                    break;
                default: //por si el usuario se equivoca
                    System.out.println("la entrada: " + decicison + " no es valida porfavor introduce un valor valido.");
            }
            System.out.println("Para Salir puedes poner \"salir\" sino quieres salir pon lo que sea y te preguntare que quieres hacer otra vez");
            decicison = reader.next();//va recogiendo lo que pide el usuario.
            if (decicison.toLowerCase().equals("salir")) { //funcion de exit
                System.out.println("Adios :)");
                break;
            }
        }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("La ejecucion termino de manera abrupta por un error :_-( ");  
        }

    }


}
