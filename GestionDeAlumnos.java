import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GestionDeAlumnos {
    private HashMap<String, Integer> estudiantes;

    public GestionDeAlumnos() {
        estudiantes = new HashMap<>();
    }

    public void registrarEstudiante(String nombre, int calificacion) {
        estudiantes.put(nombre, calificacion);
    }

    public void mostrarEstudiantes() {
        estudiantes.forEach((nombre, calificacion) -> 
            System.out.println("Nombre: " + nombre + ", Calificacion: " + calificacion));
    }

    public void buscarEstudiantesConCalificacionMayorOIgualA80() {
        estudiantes.entrySet().stream()
            .filter(entry -> entry.getValue() >= 80)
            .forEach(entry -> 
                System.out.println("Nombre: " + entry.getKey() + ", Calificacion: " + entry.getValue()));
    }

    public void eliminarEstudiante(String nombre) {
        estudiantes.remove(nombre);
    }

    public List<String> obtenerListaDeEstudiantes() {
        return new ArrayList<>(estudiantes.keySet());
    }

    public static void main(String[] args) {
        GestionDeAlumnos gestion = new GestionDeAlumnos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar todos los estudiantes");
            System.out.println("3. Buscar estudiantes con calificaciones >= 80");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Mostrar lista de estudiantes");
            System.out.println("6. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de linea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Calificacion del estudiante: ");
                    int calificacion = scanner.nextInt();
                    gestion.registrarEstudiante(nombre, calificacion);
                    break;
                case 2:
                    gestion.mostrarEstudiantes();
                    break;
                case 3:
                    gestion.buscarEstudiantesConCalificacionMayorOIgualA80();
                    break;
                case 4:
                    System.out.print("Nombre del estudiante a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    gestion.eliminarEstudiante(nombreEliminar);
                    break;
                case 5:
                    List<String> listaEstudiantes = gestion.obtenerListaDeEstudiantes();
                    System.out.println("Lista de estudiantes: " + listaEstudiantes);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
