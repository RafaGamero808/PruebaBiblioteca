import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //creamos algunos libros para poder comprobar si funciona el scanner
        Libro libro1 = new Libro("abc123", "50 sombras de tu vieja", 420, "Cincuentona Frustrada", true);
        Libro libro2 = new Libro("abc234", "Eduardo Manos-Ligeras", 500, "Timoteo Burtoniano", false);
        Libro libro3 = new Libro("abc345", "Noseque de fantasía", 1800, "Brandon Sanderson", true);

        //Creamos el Scanner, que irá con resultadoConsulta para que el usuario pida los libros por ISBN
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ISBN del libro que necesitas");
        String resultadoConsulta = sc.nextLine();
        sc.close();

        if (resultadoConsulta.equals("abc123")) {
            libro1.disponibilidad();
        }
        else if (resultadoConsulta.equals("abc234")) {
            libro2.disponibilidad();
        }
        else if (resultadoConsulta.equals("abc345")) {
            libro3.disponibilidad();
        }
        else {
            System.out.println("El ISBN no pertenece a ningún libro que tengamos");
        }



        }







    }
