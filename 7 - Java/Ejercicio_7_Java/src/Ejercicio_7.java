
import java.util.Scanner;

/*
 Crear un programa en java en el cual se pida al usuario ingresar su nombre, 
apellido, edad, hobbie, editor de código preferido, sistema operativo que utiliza,
luego deberá mostrarse por consola los datos ingresados.
El programa deber ser subido a un repositorio de GitHub, pegar el link del 
ejercicio resuelto en el siguiente recuadro
*/

public class Ejercicio_7 {


    public static void main(String[] args) {
        String nombre, apellido, hobbie, editorCodigoPrefer, sistOperativo;
        int edad;
        
        
        System.out.print("Ingrese su nombre: ");
        Scanner scan = new Scanner(System.in);
        nombre = scan.nextLine();
        
        System.out.print("Apellido: ");
        scan = new Scanner(System.in);
        apellido = scan.nextLine();
        
        System.out.print("Edad: ");
        scan = new Scanner(System.in);
        edad = scan.nextInt();
        
        System.out.print("Hobbie: ");
        scan = new Scanner(System.in);
        hobbie = scan.nextLine();
        
        System.out.print("Editor de código preferido: ");
        scan = new Scanner(System.in);
        editorCodigoPrefer = scan.nextLine();
        
        System.out.print("Sistema Operativo: ");
        scan = new Scanner(System.in);
        sistOperativo = scan.nextLine();
        
        System.out.println(" ");       
        System.out.println("-------------------------");
        System.out.println("Bienvenido al Sistema");
        System.out.println("-------------------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Hobbie: " + hobbie);
        System.out.println("Editor de código favorito: " + editorCodigoPrefer);
        System.out.println("Sistema operativo: " + sistOperativo);
   
    
}
    
    /*
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[39m";
    
    
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[6m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
*/
}
