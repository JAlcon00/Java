package Listas.Circular;

public class Acciones {
    NodoCircular inicio;

    public void Agregar_tarea(String tarea, String encargado, String descripcion, int prioridad) {
        Tarea nueva_tarea = new Tarea(tarea, encargado, descripcion, prioridad);
        NodoCircular nuevo_nodo = new NodoCircular(nueva_tarea);

        if (inicio == null) {
            inicio = nuevo_nodo;
            inicio.siguiente = inicio; // Hacerlo circular
        } else {
            NodoCircular temp = inicio;
            while (temp.siguiente != inicio && prioridad >= temp.siguiente.tarea.Prioridad) {
                temp = temp.siguiente;
            }
            nuevo_nodo.siguiente = temp.siguiente;
            temp.siguiente = nuevo_nodo;
            if (prioridad < inicio.tarea.Prioridad) {
                inicio = nuevo_nodo;
            }
        }
    }

    public void borrar_tarea(String tarea) {
        if (inicio == null) {
            return;
        }
        if (inicio.tarea.Tarea.equals(tarea)) {
            inicio = inicio.siguiente;
        }
        NodoCircular temp = inicio;
        while (temp.siguiente != inicio && !temp.siguiente.tarea.Tarea.equals(tarea)) {
            temp = temp.siguiente;
        }
        if (temp.siguiente != null && temp.siguiente != inicio) {
            temp.siguiente = temp.siguiente.siguiente;
        }
    }

    public void mostrar_tarea() {
        if (inicio == null) {
            return;
        }
        NodoCircular temp = inicio;
        do {
            System.out.println("\tLa tarea: " + temp.tarea.Tarea
                    + ", se encuentra a cargo de: " + temp.tarea.Encargado
                    + ", tiene una prioridad de: " + temp.tarea.Prioridad);
            temp = temp.siguiente;
        } while (temp != inicio);
    }
}