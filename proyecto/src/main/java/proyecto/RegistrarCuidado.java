package proyecto;

import javax.swing.JOptionPane;

public class RegistrarCuidado {
    public Cuidados registrarCuidados() {
        int estadoInicialOption = JOptionPane.showOptionDialog(
                null,
                "¿Cuál es el estado actual de la planta?",
                "Estado inicial",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Sana", "Enferma"},
                null
        );

        String estadoInicial = (estadoInicialOption == JOptionPane.YES_OPTION) ? "Sana" : "Enferma";
        if (estadoInicial.equals("Sana")) {
            JOptionPane.showMessageDialog(null, "La planta se encuentra bien de salud. \nNo se registrarán cuidados específicos.");
            return null;
        } else {

            String nombreLugar = JOptionPane.showInputDialog("Zona correspondiente donde se encuentra la planta:");
            String ubicacion = JOptionPane.showInputDialog("Área donde esta ubicada la planta:");
            String fechaCuidado = JOptionPane.showInputDialog("Ingrese la fecha del cuidado (DD/MM/AA):");
            String horaCuidado = JOptionPane.showInputDialog("Ingrese la hora de cuidado:");
            String crecimientoPlanta = JOptionPane.showInputDialog("¿Cúal es el estado de crecimiento de la planta?");

            int estadoCuidadoOption = JOptionPane.showOptionDialog(
                    null,
                    "¿Cuál es el estado final de la planta?",
                    "Estado final",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Pendiente", "En Proceso", "Finalizado", "Aplazado"},
                    null
            );

            String estadoCuidado = (estadoCuidadoOption == JOptionPane.YES_OPTION) ? "Pendiente" : (estadoCuidadoOption == JOptionPane.NO_OPTION) ? "En proceso" : (estadoCuidadoOption == 2) ? "Finalizado" : "Aplazado";

            Cuidados nuevosCuidados = new Cuidados(nombreLugar, estadoInicial, ubicacion, fechaCuidado, horaCuidado, crecimientoPlanta, estadoCuidado);

            String mensajeEstadoCuidado = obtenerMensajeEstadoCuidado(estadoCuidado);
            JOptionPane.showMessageDialog(null, mensajeEstadoCuidado);

            JOptionPane.showMessageDialog(null, "Cuidados registrados con éxito.");
            return nuevosCuidados;
        }
    }

    private String obtenerMensajeEstadoCuidado(String estadoCuidado) {
        switch (estadoCuidado) {
            case "Pendiente":
                return "La planta aún está pendiente por agendarsele un cuidado";
            case "En proceso":
                return "La planta está siendo atendida por el Botánico";
            case "Finalizado":
                return "Ya finalizó el cuidado de la planta, está en proceso de curación";
            case "Aplazado":
                return "El cuidado de la planta fue aplazado";
            default:
                return "";
        }
    }
}
