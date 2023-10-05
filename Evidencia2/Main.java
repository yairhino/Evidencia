package Evidencia2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Doctores doctores = new Doctores();
        Pacientes pacientes = new Pacientes();
        Citas citas = new Citas();
        int num;

        doctores.load();
        pacientes.load();
        citas.load();

        do{
            System.out.println("Selecciona una opcion: ");
            System.out.println("1 Alta doctor");
            System.out.println("2 Alta paciente");
            System.out.println("3 Alta cita");
            System.out.println("4 Lista doctores");
            System.out.println("5 Lista pacientes");
            System.out.println("6 Lista citas");
            System.out.println("7 Salir");

            num = scan.nextInt();

            switch (num) {
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = scan.next();
                    System.out.println("Especialidad: ");
                    String especialidad = scan.next();
                    doctores.create(nombre, especialidad);
                    break;
                case 2:
                    System.out.println("Id: ");
                    String id = scan.next();
                    System.out.println("Nombre: ");
                    String nom = scan.next();
                    pacientes.create(id, nom);
                    break;
                case 3:
                    System.out.println("Fecha y hora: ");
                    String fyh = scan.next();
                    System.out.println("Motivo: ");
                    String motiv = scan.next();
                    System.out.println("Doctor: ");
                    String doc = scan.next();
                    System.out.println("Paciente: ");
                    String pac = scan.next();
                    citas.create(fyh,motiv,doc,pac);
                    break;
                case 4:
                    doctores.list();
                    break;
                case 5:
                    pacientes.list();
                    break;
                case 6:
                    citas.list();
                    break;
                case 7:
                    break;
            }
        }while(num != 7);

        doctores.save(doctores.Doctor);
    }
}