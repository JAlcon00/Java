package Listas.Simple;

public class Acciones {
    Nodo_simple inicio;
    //.add(nueva_tarea);
    //.sort(lista,comparacion de prioridades);
    public void Agregar_tarea(String tarea, String encargado, String descripcion, int prioridad) {
        Tarea nueva_tarea = new Tarea(tarea, encargado, descripcion, prioridad);
        Nodo_simple nuevo_nodo = new Nodo_simple(nueva_tarea);
 
        if (inicio == null || prioridad < inicio.tarea.Prioridad) {
            nuevo_nodo.siguiente = inicio;
            inicio = nuevo_nodo;
        } else {
            Nodo_simple Nodo_actual = inicio;
            while (Nodo_actual.siguiente != null && prioridad >= Nodo_actual.siguiente.tarea.Prioridad) {
                Nodo_actual = Nodo_actual.siguiente;
            }
            nuevo_nodo.siguiente = Nodo_actual.siguiente;
            Nodo_actual.siguiente = nuevo_nodo;
        }
    }
    //removeIf (tarea --> nombre de la tarea coincide con el nombre dado);
    public void borrar_tarea(String tarea) {
        if (inicio == null) {
        }
        if (inicio.tarea.Tarea.equals(tarea)) {
            inicio = inicio.siguiente;
        }
        Nodo_simple Nodo_actual = inicio;
        while (Nodo_actual.siguiente != null && !Nodo_actual.siguiente.tarea.Tarea.equals(tarea)) {
            Nodo_actual = Nodo_actual.siguiente;
        }
        if (Nodo_actual.siguiente != null) {
            Nodo_actual.siguiente = Nodo_actual.siguiente.siguiente;
        }
    }
 
    public void mostrar_tarea() {
        Nodo_simple Nodo_actual = inicio;
        while (Nodo_actual != null) {
            System.out.println("\tLa tarea: " + Nodo_actual.tarea.Tarea
                            + ", se encuentra a cargo de: " + Nodo_actual.tarea.Encargado
                            +", tiene un prioridad de: " + Nodo_actual.tarea.Prioridad);
            Nodo_actual = Nodo_actual.siguiente;
        }
    }
 
   
}
