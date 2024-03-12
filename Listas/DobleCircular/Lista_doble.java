package Listas.DobleCircular;

public class Lista_doble extends Acciones{
    public static void main(String[] args) {
        Acciones accion = new Acciones();
         accion.Agregar_tarea("Mantenimiento", "Luis", "Dar mantenimiento a los equipos del departamento de ventas", 3);
         accion.Agregar_tarea("Servidor", "Paco", "Mantenimiento al Servidor", 1);
         accion.Agregar_tarea("Instalación", "Hugo", "Instalación de Office ", 4);
         accion.Agregar_tarea("Instalación", "Karla", "Instalación de equipo ", 1);
  
         System.out.println("Tareas en espera:");
         accion.mostrar_tarea();
  
         accion.borrar_tarea("Mantenimiento");
  
         System.out.println("Tareas en espera:");
         accion.mostrar_tarea();
     }
}
    

