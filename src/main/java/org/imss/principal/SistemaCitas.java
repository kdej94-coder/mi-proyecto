package org.imss.principal;

import org.imss.modelos.Cita;
import org.imss.modelos.Doctor;
import org.imss.modelos.Paciente;
import org.imss.servicios.GestorCitas;
import org.imss.servicios.GestorDoctores;
import org.imss.servicios.GestorPacientes;
import org.imss.servicios.ServicioAutenticacion;

import java.util.Scanner;

public class SistemaCitas {
    private static GestorDoctores gestorDoctores = new GestorDoctores();
    private static GestorPacientes gestorPacientes = new GestorPacientes();
    private static GestorCitas gestorCitas = new GestorCitas();
    private static ServicioAutenticacion auth = new ServicioAutenticacion();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CITAS IMSS ===");
        
        boolean autenticado = false;
        while (!autenticado) {
            System.out.print("ID Administrador: ");
            String id = scanner.nextLine();
            System.out.print("Contraseña: ");
            String pass = scanner.nextLine();
            
            if (auth.login(id, pass)) {
                autenticado = true;
                System.out.println("Bienvenido al sistema.");
            } else {
                System.out.println("Credenciales incorrectas. Intente nuevamente.");
            }
        }

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Dar de alta Doctor");
            System.out.println("2. Dar de alta Paciente");
            System.out.println("3. Crear Cita");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            String opcionStr = scanner.nextLine();
            int opcion;
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido. El programa no se cerrará gracias al manejo de excepciones.");
                continue;
            }

            switch (opcion) {
                case 1:
                    altaDoctor();
                    break;
                case 2:
                    altaPaciente();
                    break;
                case 3:
                    crearCita();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void altaDoctor() {
        System.out.println("\n--- ALTA DE DOCTOR ---");
        System.out.print("ID único: ");
        String id = scanner.nextLine();
        System.out.print("Nombre Completo: ");
        String nombre = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        
        Doctor doc = new Doctor(id, nombre, especialidad);
        gestorDoctores.registrarDoctor(doc);
        System.out.println("Doctor registrado con éxito.");
    }

    private static void altaPaciente() {
        System.out.println("\n--- ALTA DE PACIENTE ---");
        System.out.print("ID único: ");
        String id = scanner.nextLine();
        System.out.print("Nombre Completo: ");
        String nombre = scanner.nextLine();
        
        Paciente pac = new Paciente(id, nombre);
        gestorPacientes.registrarPaciente(pac);
        System.out.println("Paciente registrado con éxito.");
    }

    private static void crearCita() {
        System.out.println("\n--- CREAR CITA ---");
        
        if (gestorDoctores.getDoctores().isEmpty() || gestorPacientes.getPacientes().isEmpty()) {
            System.out.println("Error: Se necesita al menos un doctor y un paciente registrados para crear una cita.");
            return;
        }

        System.out.print("ID de la Cita: ");
        String idCita = scanner.nextLine();
        System.out.print("Fecha y Hora (dd/mm/aaaa hh:mm): ");
        String fechaHora = scanner.nextLine();
        System.out.print("Motivo de la Cita: ");
        String motivo = scanner.nextLine();
        
        System.out.print("ID del Doctor asignado: ");
        String idDoctor = scanner.nextLine();
        System.out.print("ID del Paciente: ");
        String idPaciente = scanner.nextLine();
        
        Cita nuevaCita = new Cita(idCita, fechaHora, motivo, idDoctor, idPaciente);
        boolean exito = gestorCitas.registrarCita(nuevaCita);
        if (exito) {
            System.out.println("Cita creada correctamente.");
        } else {
            System.out.println("No se pudo crear la cita. Existe un conflicto de horario.");
        }
    }
}
