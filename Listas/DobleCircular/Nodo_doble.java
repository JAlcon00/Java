package Listas.DobleCircular;

public class Nodo_doble {
    Tarea tarea;
    Nodo_doble siguiente;
    Nodo_doble anterior;
    
    public Nodo_doble(Tarea tarea) {
        this.tarea = tarea;
        this.siguiente = null;
        this.anterior = null;
    }   
    
}
