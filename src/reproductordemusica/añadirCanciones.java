package reproductordemusica;

import static reproductordemusica.ReproductorDeMusica.reader;
import static reproductordemusica.borrarCanciones.borrarCanciones;

/**
 *
 * @author Carlos
 */
public class añadirCanciones {

        //inicializo esta funcion para que devuelva la matriz canciones con la nueva cancion
    public static String[][] añadirCanciones(String[][] canciones) {
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
}
