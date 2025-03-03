# Documentacion del Ejercicio Gestion de Estudiantes

Gestión de Alumnos en Java

Este proyecto es una aplicación en Java que permite gestionar estudiantes y sus calificaciones utilizando un HashMap. Ofrece funcionalidades como registrar, mostrar, buscar y eliminar estudiantes, así como obtener una lista de los registrados.

📌 Características
	•	Registrar un estudiante con su calificación.
	•	Mostrar todos los estudiantes y sus calificaciones.
	•	Buscar estudiantes con calificación mayor o igual a 80.
	•	Eliminar un estudiante por su nombre.
	•	Obtener una lista con los nombres de todos los estudiantes.
	•	Interfaz de línea de comandos para interactuar con el usuario.

📜 Código y Explicación

Importación de Librerías

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

	•	ArrayList: Para manejar listas dinámicas de estudiantes.
	•	HashMap: Para almacenar estudiantes con sus calificaciones.
	•	List: Interfaz utilizada para manejar listas.
	•	Scanner: Para leer la entrada del usuario.

Definición de la Clase

public class GestionDeAlumnos {
    private HashMap<String, Integer> estudiantes;

	•	HashMap<String, Integer> estudiantes: Almacena los nombres y calificaciones.

Constructor

    public GestionDeAlumnos() {
        estudiantes = new HashMap<>();
    }

	•	Inicializa el HashMap vacío.

Registrar un Estudiante

    public void registrarEstudiante(String nombre, int calificacion) {
        estudiantes.put(nombre, calificacion);
    }

	•	Guarda el nombre y la calificación en el HashMap.

Mostrar Todos los Estudiantes

    public void mostrarEstudiantes() {
        estudiantes.forEach((nombre, calificacion) -> 
            System.out.println("Nombre: " + nombre + ", Calificacion: " + calificacion));
    }

	•	Usa forEach para recorrer y mostrar cada estudiante.

Buscar Estudiantes con Calificación ≥ 80

    public void buscarEstudiantesConCalificacionMayorOIgualA80() {
        estudiantes.entrySet().stream()
            .filter(entry -> entry.getValue() >= 80)
            .forEach(entry -> 
                System.out.println("Nombre: " + entry.getKey() + ", Calificacion: " + entry.getValue()));
    }

	•	Filtra y muestra estudiantes con calificación >= 80.

Eliminar un Estudiante

    public void eliminarEstudiante(String nombre) {
        estudiantes.remove(nombre);
    }

	•	Elimina un estudiante por su nombre.

Obtener Lista de Estudiantes

    public List<String> obtenerListaDeEstudiantes() {
        return new ArrayList<>(estudiantes.keySet());
    }

	•	Devuelve una lista con los nombres de los estudiantes.

Método main (Interfaz de Usuario)

    public static void main(String[] args) {
        GestionDeAlumnos gestion = new GestionDeAlumnos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

	•	Crea una instancia de GestionDeAlumnos.
	•	Inicializa un Scanner para leer entrada de usuario.
	•	Declara opcion para el menú.

Menú de Opciones

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

	•	Muestra las opciones disponibles.
	•	Captura la opción elegida.

Opciones del Menú

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Calificacion del estudiante: ");
                    int calificacion = scanner.nextInt();
                    gestion.registrarEstudiante(nombre, calificacion);
                    break;

	•	Pide el nombre y la calificación y los registra.

                case 2:
                    gestion.mostrarEstudiantes();
                    break;

	•	Llama al método mostrarEstudiantes().

                case 3:
                    gestion.buscarEstudiantesConCalificacionMayorOIgualA80();
                    break;

	•	Llama al método correspondiente.

                case 4:
                    System.out.print("Nombre del estudiante a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    gestion.eliminarEstudiante(nombreEliminar);
                    break;

	•	Pide el nombre y lo elimina.

                case 5:
                    List<String> listaEstudiantes = gestion.obtenerListaDeEstudiantes();
                    System.out.println("Lista de estudiantes: " + listaEstudiantes);
                    break;

	•	Obtiene la lista de nombres y la imprime.

Salir del Programa

                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 6);

        scanner.close();
    }

	•	Opción 6 termina el programa.
	•	scanner.close(); libera recursos.

🏃‍♂️ Cómo Ejecutarlo
	1.	Copia el código en un archivo GestionDeAlumnos.java.
	2.	Compila el programa:

javac GestionDeAlumnos.java


	3.	Ejecuta el programa:

java GestionDeAlumnos
