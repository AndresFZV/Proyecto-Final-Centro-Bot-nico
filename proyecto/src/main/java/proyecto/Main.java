package proyecto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Planta> plantasRegistradas = new ArrayList<>();
    private static List<Cuidados> cuidadosRegistrados = new ArrayList<>();
    private static List<Botanicos> botanicosRegistrados = new ArrayList<>();
    private static GestorPlantas gestorPlantas;
    private static AsignarBotanico asignarBotanico = new AsignarBotanico(plantasRegistradas, cuidadosRegistrados, botanicosRegistrados);

    public static void main(String[] args) {
        int opcion;
        boolean regresarAlMenuInicial = false;

        do {
            boolean regresarAlMenuUsuario = false;

            if (regresarAlMenuInicial) {
                String[] opciones = {"Botánico", "Administrador"};

                int usuario = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione su cargo, por favor :D",
                        "Bienvenido",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[0]
                );

                if (usuario == 0) {
                    String nombreBotanico = JOptionPane.showInputDialog("Por favor, inicie sesión. \nIngrese su nombre de usuario:");
                    JOptionPane.showInputDialog("Ingrese su contraseña:");
                    gestorPlantas = new GestorPlantas(plantasRegistradas, cuidadosRegistrados, botanicosRegistrados);

                    do {
                        String[] opcionesEmpleado = {
                                "Registrar una planta",
                                "Registrar cuidados",
                                "Mostrar información de plantas",
                                "Cerrar sesión"
                        };

                        String seleccion = (String) JOptionPane.showInputDialog(
                                null,
                                "Opciones del botánico " + nombreBotanico + ":",
                                "Seleccionar opción",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                opcionesEmpleado,
                                opcionesEmpleado[0]
                        );

                        opcion = obtenerOpcionSeleccionada(seleccion, opcionesEmpleado);

                        switch (opcion) {
                            case 0:
                                RegistrarPlanta registroPlanta = new RegistrarPlanta();
                                Planta nuevaPlanta = registroPlanta.registrarPlanta();
                                plantasRegistradas.add(nuevaPlanta);
                                break;
                            case 1:
                                gestorPlantas.registrarCuidadosParaPlantaSeleccionada();
                                break;
                            case 2:
                                Planta.mostrarInformacionPlantas(plantasRegistradas, botanicosRegistrados);
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Cerrando sesión...\nSesión finalizada.");
                                break;
                            default:
                                regresarAlMenuUsuario = true;
                                break;
                        }
                    } while (opcion != 3 && !regresarAlMenuUsuario);
                } else if (usuario == 1) {
                    String nombreAdmin = JOptionPane.showInputDialog("Por favor inicie sesión. \nIngrese su usuario de administrador:");
                    JOptionPane.showInputDialog("Ingrese su contraseña:");

                    do {
                        String[] opcionesAdmin = {
                                "Contratar Botánicos",
                                "Asignar Botánico",
                                "Información de los Botánicos",
                                "Información de las plantas",
                                "Información Asignaciones",
                                "Cerrar sesión"
                        };

                        opcion = JOptionPane.showOptionDialog(
                                null,
                                "Seleccione una opción, adminstrador " + nombreAdmin + ":",
                                "Seleccionar opción",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                opcionesAdmin,
                                opcionesAdmin[0]
                        );

                        switch (opcion) {
                            case 0:
                                RegistrarBotanicos registroBotanicos = new RegistrarBotanicos();
                                Botanicos nuevosBotanicos = registroBotanicos.registrarBotanicos();
                                botanicosRegistrados.add(nuevosBotanicos);
                                break;
                            case 1:
                                asignarBotanico.mostrarAsignaciones();
                                break;
                            case 2:
                                Botanicos.mostrarInformacionBotanicos(botanicosRegistrados);
                                break;
                            case 3:
                                Planta.mostrarInformacionPlantas(plantasRegistradas, botanicosRegistrados);
                                break;
                            case 4:
                                asignarBotanico.mostrarAsignacionesRegistradas();
                                break;
                            default:
                                regresarAlMenuUsuario = true;
                                break;
                        }
                    } while (opcion != 2 && !regresarAlMenuUsuario);
                } else {
                    JOptionPane.showMessageDialog(null, "La opción no existe, por favor inténtelo de nuevo.");
                }
            }

            String[] opcionesMenuInicial = {"Entrar al menú principal", "Salir"};
            opcion = JOptionPane.showOptionDialog(
                    null,
                    "¡Bienvenido al Centro Botánico de PerúKistan!",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcionesMenuInicial,
                    opcionesMenuInicial[0]
            );

            regresarAlMenuInicial = (opcion == 0 || regresarAlMenuInicial);

        } while (opcion != 1);
    }

    private static int obtenerOpcionSeleccionada(String seleccion, String[] opcionesEmpleado) {
        if (seleccion == null) {
            return -1; // Opción "Cancelar" devuelve -1
        }

        for (int i = 0; i < opcionesEmpleado.length; i++) {
            if (seleccion.equals(opcionesEmpleado[i])) {
                return i;
            }
        }

        return -1;
    }
}
