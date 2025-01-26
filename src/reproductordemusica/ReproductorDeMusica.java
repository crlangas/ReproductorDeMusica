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

        //try { //try catch para la gestion de errores
        System.out.println("Escribe lo que quieres hacer, \"play\" para reproducir, \"stop\" para dejar de reproducir, \n \"show\" para monstar las canciones disponibles,\n \"add\" para añadir una cancion nueva y \n \"delete\" para borrar una existente");
        decicison = reader.next();
        while (seguir) { //bucle para que el programa no deje de ejecutarse
            switch (decicison.toLowerCase()) { //swhich en funcion
                case "play"://decision a ajecutar
                    System.out.println("not avitable");
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
        //} catch (Exception e) {
        //System.out.println(e);
        //} finally { // para que siempre salga este mensaje si hay un error y el usuario este tranquilo y sepa que el programa termino.
        //    System.out.println("La ejecucion termino de manera abrupta por un error :_-( ");
        //}

    }

    private static void monstrarCanciones(String[][] canciones) {
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

    //inicializo esta funcion para que devuelva la matriz canciones con la nueva cancion
    private static String[][] añadirCanciones(String[][] canciones) {
        int posCancion;
        String borrar = "";

        try { //por si el usuario mete una letra se usa un try catch
            System.out.println("Elije la posicion que deseas para la cancion (1-10):");
            while (true) {
                posCancion = reader.nextInt() - 1; //pìde el numero de cancion que vas poner y comprueba si es valido

                if (posCancion >= 0 && posCancion < 10) {
                    //comprobar que no haya una cancion ya en la posicion que elijio el usuario
                    //bucle para que despues de borrar la cancio poner la que quieres seguido
                    while (true) {
                        if (canciones[posCancion][2] == null) {
                            //pedir nombre...
                            System.out.println("Introduce el nombre:");
                            canciones[posCancion][0] = reader.nextLine();// linea duplicada porque da problemas al introducir los valores :-)
                            canciones[posCancion][0] = reader.nextLine();

                            System.out.println("Introduce el autor (si noquieres que tenga puede poner \"no author\")");
                            //reader.next(); //limpia el scanner porque sino no pilla la linea de poner el autor
                            canciones[posCancion][1] = reader.nextLine();
                            if (canciones[posCancion][1].toLowerCase().equals("no author")) {
                                canciones[posCancion][1] = null;
                            }

                            System.out.println("Introduce la URL:"); //interesante while para validar la url
                            canciones[posCancion][2] = reader.nextLine();
                            //regresa la nueva cancion añadida
                            return canciones;
                        } else {
                            System.out.println("En la posicion que seleccionaste ya esta la cancion: " + canciones[posCancion][0]);
                            System.out.println("Quieres borrarla pon si para borrarla sino quieres borrarla pon cualquier otracosa:");
                            borrar = reader.next();
                            if (borrar.toLowerCase().equals("si")) { //si dices si borra la cancion
                                borrarCanciones(canciones, posCancion);
                            } else {
                                System.out.println("decidiste no borrar la cancion");
                                break; //corta el bucle porque no borraste la cancion que habia
                            }
                        }
                    }

                } else {
                    System.out.println("Introduciste un número que no esta en la lista, pon uno valido: ");
                }
            }
            //devuelve las canciones añadidas:
            //return canciones;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Indroduciste un caracter no valido");
        } catch (Exception e) {
            System.out.println(e);
        }
        //retorna por ultimo el array
        return canciones;
    }

    //inicializo esta funcion para que devuelva la matriz canciones con la nueva cancion
    //funcion de borrar normal
    private static String[][] borrarCanciones(String[][] canciones) {
        int posCancion = 0;
        System.out.println("cual es la posicion de la cancion que quieres borrar");
        while (true) { //pide la posicion de la cancion a borrar hasta que sea valida
            posCancion = reader.nextInt();
            if (posCancion < 0 && posCancion > 10) {
                System.out.println("Posicion seleccionada invalida porfavor pon una del 1-10 ");  
            } else{
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
    private static String[][] borrarCanciones(String[][] canciones, int posCancion) {
        for (int i = 0; i < canciones[posCancion].length; i++) { //resetea los valores de la cancion y la borra asi
            canciones[posCancion][i] = null;
        }
        System.out.println("La cancion de la posicion: " + posCancion + " se borro correctamente");
        return canciones;
    }

}
