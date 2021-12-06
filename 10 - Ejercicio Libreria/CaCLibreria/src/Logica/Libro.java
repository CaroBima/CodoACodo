/*
Crea una clase llamada Libro que guarde la información de cada uno de los libros 
de una biblioteca. La clase debe guardar el título del libro, autor, número de 
ejemplares del libro y número de ejemplares prestados. La clase contendrá los siguientes métodos:
Constructor por defecto.
Constructor con parámetros.
Métodos Setters/getters
Método préstamo que incremente el atributo correspondiente cada vez que se realice
un préstamo del libro. No se podrán prestar libros de los que no queden ejemplares disponibles 
para prestar. Devuelve true si se ha podido realizar la operación y false en caso contrario.
Método devolución que decremente el atributo correspondiente cuando se produzca la 
devolución de un libro. No se podrán devolver libros que no se hayan prestado. Devuelve true si se 
ha podido realizar la operación y false en caso contrario.
Método toString para mostrar los datos de los libros. Este método se heredada de 
Object y lo debemos modificar (override) para adaptarlo a la clase Libro
Escribe un programa para probar el funcionamiento de la clase Libro

 */
package Logica;

/**
 *
 * @author Caro
 */
public class Libro {
    private String nombreLibro;
    private String autor;
    private int nroEjemplares;
    private int ejemplaresPrestados;

    
    //verifica si hay ejemplares disponibles e incrementa el contador de prestados en caso de haber disponibles
    public boolean prestamoLibro(String nombreLibro){
        if(hayejemplares(nombreLibro)){
            this.ejemplaresPrestados ++;
            return true;
        } else return false;
    }

    //busca si el libro existe en la bd
    private boolean hayejemplares(String nombreLibro){
    
        return true; //a modificar para agregarle funcionalidad al metodo
    
    }
    
    //constructor vacío (por defecto)
    public Libro() {
    }

    public Libro(String nombreLibro, String autor, int nroEjemplares, int ejemplaresPrestados) {
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.nroEjemplares = nroEjemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
    }
    

    //getters y setters
    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNroEjemplares() {
        return nroEjemplares;
    }

    public void setNroEjemplares(int nroEjemplares) {
        this.nroEjemplares = nroEjemplares;
    }

    public int getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(int ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    
 
}
