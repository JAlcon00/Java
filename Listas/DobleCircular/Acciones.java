package Listas.DobleCircular;

public class Acciones {
    Nodo_doble inicio;

    // .add(nueva_tarea);
    // .sort(lista,comparacion de prioridades);

    public void Agregar_tarea(String tarea, String encargado, String descripcion, int prioridad) {
        Tarea nueva_tarea = new Tarea(tarea, encargado, descripcion, prioridad);
        Nodo_doble nuevo_nodo = new Nodo_doble(nueva_tarea);

        if (inicio == null) {
            inicio = nuevo_nodo;
            inicio.siguiente = inicio; // Hacer que el primer nodo apunte a sí mismo para indicar que es el único nodo en la lista.
            inicio.anterior = inicio; // Hacer que el primer nodo apunte a sí mismo como anterior.
        }
        // Si la nueva tarea tiene mayor prioridad que la primera tarea de la lista,
        // inserta el nuevo nodo al inicio de la lista.
        else if (prioridad < inicio.tarea.Prioridad) {
            nuevo_nodo.siguiente = inicio; // El nuevo nodo apunta al actual inicio como su siguiente.
            inicio.anterior = nuevo_nodo; // El actual inicio apunta al nuevo nodo como su anterior.
            inicio = nuevo_nodo; // El nuevo nodo se convierte en el nuevo inicio de la lista.
        }
        // Si la nueva tarea no tiene la mayor prioridad,
        // encuentra el lugar correcto en la lista basado en su prioridad.
        else {
            Nodo_doble Nodo_actual = inicio; // Comienza desde el inicio de la lista.
            // Recorre la lista hasta encontrar el punto de inserción basado en la
            // prioridad.
            while (Nodo_actual.siguiente != null && prioridad >= Nodo_actual.siguiente.tarea.Prioridad) {
                Nodo_actual = Nodo_actual.siguiente; // Avanza al siguiente nodo.
            }
            // Inserta el nuevo nodo en su lugar correcto en la lista.
            nuevo_nodo.siguiente = Nodo_actual.siguiente; // El nuevo nodo apunta al siguiente del nodo actual.
            if (Nodo_actual.siguiente != null) {
                Nodo_actual.siguiente.anterior = nuevo_nodo; // El siguiente del nodo actual apunta al nuevo nodo como
                                                             // su anterior.
            }
            Nodo_actual.siguiente = nuevo_nodo; // El nodo actual apunta al nuevo nodo como su siguiente.
            nuevo_nodo.anterior = Nodo_actual; // El nuevo nodo apunta al nodo actual como su anterior.
        }
    }

    // removeIf (tarea --> nombre de la tarea coincide con el nombre dado);
    // Define el método para eliminar una tarea específica por su nombre.
    public void borrar_tarea(String tarea) {

        if (inicio == null)
            return;

        // Si la tarea a eliminar está en el primer nodo de la lista.
        if (inicio.tarea.Tarea.equals(tarea)) {
            // Mueve el inicio al siguiente nodo, efectivamente eliminando el primer nodo.
            inicio = inicio.siguiente;
            // Si la lista no se ha vuelto vacía después de la eliminación,
            // elimina la referencia al nodo anterior del nuevo primer nodo.
            if (inicio != null) {
                inicio.anterior = null; // Eliminar la referencia al nodo anterior.
            }

            return;
        }
        // Inicializa un nodo temporal para buscar la tarea a eliminar.
        Nodo_doble Nodo_actual = inicio;
        // Recorre la lista hasta encontrar la tarea especificada o hasta llegar al
        // final de la lista.
        while (Nodo_actual != null && !Nodo_actual.tarea.Tarea.equals(tarea)) {
            Nodo_actual = Nodo_actual.siguiente;
        }

        // Si no se encontró la tarea (Nodo_actual es null), sale del método ya que la
        // tarea no existe.
        if (Nodo_actual == null)
            return; // La tarea no existe.

        // Si la tarea a eliminar no es el primer nodo y se encontró en la lista:
        // Si hay un nodo después del nodo actual, ajusta el enlace 'anterior' de ese
        // nodo para saltarse el nodo actual.
        if (Nodo_actual.siguiente != null) {
            Nodo_actual.siguiente.anterior = Nodo_actual.anterior; // Ajustar el enlace anterior del siguiente nodo.
        }

        // Si hay un nodo antes del nodo actual, ajusta el enlace 'siguiente' de ese
        // nodo para saltarse el nodo actual.
        if (Nodo_actual.anterior != null) {
            Nodo_actual.anterior.siguiente = Nodo_actual.siguiente; // Ajustar el enlace siguiente del nodo anterior.
        }
        // Después de ajustar los enlaces anterior y siguiente, el nodo actual queda
        // efectivamente eliminado de la lista.
    }

    public void mostrar_tarea() {
        Nodo_doble Nodo_actual = inicio;
        while (Nodo_actual != null) {
            System.out.println("\tLa tarea: " + Nodo_actual.tarea.Tarea
                    + ", se encuentra a cargo de: " + Nodo_actual.tarea.Encargado
                    + ", tiene un prioridad de: " + Nodo_actual.tarea.Prioridad);
            if(Nodo_actual.siguiente == null){
                 break;
            }
            Nodo_actual = Nodo_actual.siguiente;
        }
        System.out.println("Listas de tareas desde el final hasta el inicio: ");
        while(Nodo_actual != null){
            System.out.println("\tLa tarea: " + Nodo_actual.tarea.Tarea
                    + ", se encuentra a cargo de: " + Nodo_actual.tarea.Encargado
                    + ", tiene un prioridad de: " + Nodo_actual.tarea.Prioridad);
                    Nodo_actual = Nodo_actual.anterior;
        }
    }

}
