import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creamos algunos libros para probar
        Libro libro1 = new Libro("abc123", "50 sombras de tu vieja", 420, "Cincuentona Frustrada", true);
        Libro libro2 = new Libro("abc234", "Eduardo Manos-Ligeras", 500, "Timoteo Burtoniano", false);
        Libro libro3 = new Libro("abc345", "Noseque de fantasía", 1800, "Brandon Sanderson", true);

        ArrayList<Libro> biblioteca = new ArrayList<>();
        biblioteca.add(libro1);
        biblioteca.add(libro2);
        biblioteca.add(libro3);

        consulta(biblioteca);  // llamamos al método consulta
    }

    private static void consulta(ArrayList<Libro> biblioteca) {
        Scanner sc = new Scanner(System.in);

        while (true) {  // empezamos el bucle
            System.out.println("¿Qué quieres hacer? sacar / devolver / info / salir");
            String accion = sc.nextLine();  // Leemos la entrada del usuario

            if (accion.equalsIgnoreCase("salir")) {
                System.out.println("Cerrando sesión...");
                break;  // Rompemos bucle con "salir"
            } else if (accion.equalsIgnoreCase("info")) {
                System.out.println("Introduce el ISBN del libro del que deseas saber");
                String buscarISBN = sc.nextLine();
                boolean encontrado = false; // Variable para saber si encontramos el libro
                for (Libro libro : biblioteca) {
                    if (libro.getIsbn().equals(buscarISBN)) {
                        libro.disponibilidad();  // Mostramos la disponibilidad
                        encontrado = true;
                        break;  // Salimos del bucle una vez encontrado
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontró el libro con el ISBN: " + buscarISBN);
                }
            }
            else if (accion.equalsIgnoreCase("sacar")) {
                System.out.println("Introduce el ISBN del libro que deseas sacar");
                String isbnSacar = sc.nextLine();
                boolean encontrado = false;
                for (Libro libro : biblioteca) {
                    if (libro.getIsbn().equals(isbnSacar)) {
                        if (libro.isPrestado()) {
                            System.out.println("El libro está prestado, no se puede sacar.");
                        } else {
                            libro.setPrestado(true);  // Cambiamos el estado a prestado
                            System.out.println("El libro ha sido sacado.");
                        }
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontró el libro con el ISBN: " + isbnSacar);
                }
            }
            else if (accion.equalsIgnoreCase("devolver")) {
                System.out.println("Introduce el ISBN del libro que deseas devolver");
                String isbnDevolver = sc.nextLine();
                boolean encontrado = false;
                for (Libro libro : biblioteca) {
                    if (libro.getIsbn().equals(isbnDevolver)) {
                        if (!libro.isPrestado()) {
                            System.out.println("El libro no está prestado.");
                        } else {
                            libro.setPrestado(false);  // Cambiamos el estado a libre
                            System.out.println("El libro ha sido devuelto.");
                        }
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontró el libro con el ISBN: " + isbnDevolver);
                }
            }
            else {
                System.out.println("Comando no válido. Por favor, ingresa una opción válida.");
            }
        }
        sc.close();  // Cerramos el scanner al acabar, aunque no tengo muy claro por qué
    }
}
