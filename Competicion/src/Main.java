import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Competicion miCompeticion = new Competicion(null, null, null);
        int opcion = 1, dorsalJug, disponibilidad;
        String codigoComp, descripcion, provincia, codigoEq, descripcionEq, nombreRepresentanteEq, ciudadEq, emailEq, telefonoEq, nombreJug, apellidosJug, dniJug, emailJug, telefonoJug;

        while (opcion != 9) {
            System.out.println("1. Proporcionar datos de la competición");
            System.out.println("2. Añadir un nuevo equipo");
            System.out.println("3. Eliminar un equipo");
            System.out.println("4. Buscar equipos por localidad");
            System.out.println("5. Listar todos los equipos");
            System.out.println("6. Dar de alta un nuevo Jugador");
            System.out.println("7. Eliminar un jugador de un equipo");
            System.out.println("8. Cambiar disponibilidad de un Jugador");
            System.out.println("Cualquier otra tecla para salir");

            opcion = Integer.parseInt(input.nextLine());

            switch (opcion) {
                case 1:
                    if (miCompeticion.getProvincia() == null) {
                        System.out.println("Introduzca el codigo de la competicion");
                        codigoComp = input.nextLine();
                        miCompeticion.setCodigoComp(codigoComp);
                        System.out.println("Introduzca la descripcion");
                        descripcion = input.nextLine();
                        miCompeticion.setDescripcion(descripcion);
                        System.out.println("Introduzca la provincia");
                        provincia = input.nextLine();

                        miCompeticion = new Competicion(codigoComp, descripcion, provincia);
                        System.out.println("Datos introducidos");

                    } else {
                        System.out.println("Los datos de la competicion ya estan introducidos");
                    }
                    break;
                case 2:
                    if (miCompeticion.getProvincia() != null) {
                        System.out.println("Introduzca el codigo del equipo");
                        codigoEq = input.nextLine();
                        if (codigoEq.length() != 5) {
                            System.out.println("El codigo debe contener 5 digitos");
                            break;
                        }
                        System.out.println("Introduzca una descripcion");
                        descripcionEq = input.nextLine();
                        System.out.println("Introduzca el nombre del representante");
                        nombreRepresentanteEq = input.nextLine();
                        System.out.println("Introduzca la ciudad");
                        ciudadEq = input.nextLine();
                        System.out.println("Introduzca el email de contacto");
                        emailEq = input.nextLine();
                        System.out.println("Introduzca el telefono");
                        telefonoEq = input.nextLine();

                        if (miCompeticion.addEquipo(codigoEq, descripcionEq, nombreRepresentanteEq, ciudadEq, emailEq, telefonoEq)) {
                            System.out.println("Equipo añadido");
                        } else {
                            System.out.println("Error al añadir equipo");
                        }
                    } else {
                        System.out.println("Tiene que introducir los datos de la competicion antes de utilizar el programa");
                    }
                    break;
                case 3:
                    if (miCompeticion.getProvincia() != null) {
                        System.out.println("Introduzca el codigo del equipo que desea eliminar");
                        codigoEq = input.nextLine();

                        if (miCompeticion.removeEquipo(codigoEq)) {
                            System.out.println("Equipo eliminado");
                        } else {
                            System.out.println("Error al eliminar equipo, compruebe que el equipo no tenga ningun jugador");
                        }
                    } else {
                        System.out.println("Tiene que introducir los datos de la competicion antes de utilizar el programa");
                    }
                    break;
                case 4:
                    if (miCompeticion.getProvincia() != null) {
                        System.out.println("Introduzca la localidad");
                        ciudadEq = input.nextLine();
                        System.out.println(miCompeticion.buscarEquipos(ciudadEq));
                    } else {
                        System.out.println("Debe introducir los datos de la competicion primero");
                    }
                    break;
                case 5:
                    if (miCompeticion.getProvincia() != null) {
                        System.out.println(miCompeticion.listEquipos());
                    } else {
                        System.out.println("Debe introducir los datos de la competicion primero");
                    }
                    break;
                case 6:
                    if (miCompeticion.getProvincia() != null) {
                        System.out.println("Introduzca el codigo de equipo");
                        codigoEq = input.nextLine();
                        System.out.println("Introduzca el nombre del Jugador");
                        nombreJug = input.nextLine();
                        System.out.println("Introduzca los apellidos del Jugador");
                        apellidosJug = input.nextLine();
                        System.out.println("Introduzca el dorsal del Jugador");
                        dorsalJug = Integer.parseInt(input.nextLine());
                        if (dorsalJug > 99 || dorsalJug < 1) {
                            System.out.println("El numero del dorsal debe estar entre el 1 y el 99, ambos incluidos");
                            break;
                        }
                        System.out.println("Introduzca DNI del jugador");
                        dniJug = input.nextLine();
                        System.out.println("Introduzca email del Jugador");
                        emailJug = input.nextLine();
                        System.out.println("Introduzca telefono del Jugador");
                        telefonoJug = input.nextLine();

                        if (miCompeticion.addJugador(codigoEq, nombreJug, apellidosJug, dorsalJug, dniJug, emailJug, telefonoJug)) {
                            System.out.println("Jugador añadido correctamente");
                        } else {
                            System.out.println("Error al añadir jugador");
                        }
                    } else {
                        System.out.println("Debe introducir los datos de la competicion primero");
                    }
                    break;
                case 7:
                    if (miCompeticion.getProvincia() != null) {
                        System.out.println("Introduzca el codigo de equipo");
                        codigoEq = input.nextLine();
                        System.out.println("Introduzca el DNI del jugador que desea eliminar");
                        dniJug = input.nextLine();

                        if (miCompeticion.eliminarJugador(codigoEq, dniJug)) {
                            System.out.println("Jugador eliminado correctamente");
                        } else {
                            System.out.println("Error al eliminar jugador");
                        }
                    } else {
                        System.out.println("Debe introducir los datos de la competicion primero");
                    }
                    break;
                case 8:
                    if (miCompeticion.getProvincia() != null) {
                        System.out.println("Introduzca el codigo del equipo del jugador");
                        codigoEq = input.nextLine();
                        System.out.println("Introduzca DNI del jugador del que desea cambiar la disponibilidad");
                        dniJug = input.nextLine();
                        System.out.println("Disponibilidad del jugador:");
                        System.out.println("1. Disponible");
                        System.out.println("2. No disponible");
                        disponibilidad = Integer.parseInt(input.nextLine());

                        if (miCompeticion.cambiarDisponibilidad(codigoEq, dniJug, disponibilidad)) {
                            System.out.println("Disponibilidad cambiada correctamente");
                        } else {
                            System.out.println("Error al cambiar la disponibilidad");
                        }
                    } else {
                        System.out.println("Debe introducir los datos de la competicion primero");
                    }
                    break;
                case 9:
                    System.out.println("Finalizando el programa");
                    break;
                default:
                    System.out.println("Elija una opcion valida");
                    break;
            }
        }
        input.close();
    }
}
