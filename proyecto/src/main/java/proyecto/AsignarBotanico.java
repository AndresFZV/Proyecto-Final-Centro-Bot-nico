package proyecto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AsignarBotanico {

    private List<Planta> plantasRegistradas;
    private List<Botanicos> botanicosRegistrados;
    private List<AsignacionBotanico> asignaciones;

    public AsignarBotanico(List<Planta> plantasRegistradas, List<Cuidados> cuidadosRegistrados, List<Botanicos> botanicosRegistrados) {
        this.plantasRegistradas = plantasRegistradas;
        this.botanicosRegistrados = botanicosRegistrados;
        this.asignaciones = new ArrayList<>();
    }
    
    public void mostrarPlantasDisponibles() {
        if (!plantasRegistradas.isEmpty()) {
            StringBuilder plantasDisponibles = new StringBuilder("Lista de plantas disponibles:\n");
            for (int i = 0; i < plantasRegistradas.size(); i++) {
                plantasDisponibles.append((i + 1)).append(". ").append(plantasRegistradas.get(i).getNombreComun()).append("\n");
            }
            JOptionPane.showMessageDialog(null, plantasDisponibles.toString(), "Plantas Disponibles", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay plantas disponibles.", "Plantas Disponibles", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    // Otros métodos existentes...
        public int asignarBotanico(){
                //nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn 
                    if (!botanicosRegistrados.isEmpty()) {
                        StringBuilder botanicosDisponibles = new StringBuilder("Lista de botánicos disponibles:\n");
                        for (int i = 0; i < botanicosRegistrados.size(); i++) {
                            botanicosDisponibles.append((i + 1)).append(". ").append(botanicosRegistrados.get(i).getNombre()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, botanicosDisponibles.toString(), "Botánicos Disponibles", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay botánicos disponibles.", "Plantas Disponibles", JOptionPane.INFORMATION_MESSAGE);
                    }
                //nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
                if (!botanicosRegistrados.isEmpty()){
                    do {
                        String input = JOptionPane.showInputDialog("¿Qué Botánico desea seleccionar? (Ingrese el número):");
                        try {
                            int numeroBotanicoSeleccionado = Integer.parseInt(input);
                            if (numeroBotanicoSeleccionado >= 1 && numeroBotanicoSeleccionado <= botanicosRegistrados.size()) {
                                return numeroBotanicoSeleccionado - 1;
                            } else {
                                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (true);
                }
                return -1;
            }
    public int seleccionarPlanta() {
        if (!plantasRegistradas.isEmpty()) {
            do {
                String input = JOptionPane.showInputDialog("¿Qué planta desea seleccionar? (Ingrese el número):");
                try {
                    int numeroPlantaSeleccionada = Integer.parseInt(input);
                    if (numeroPlantaSeleccionada >= 1 && numeroPlantaSeleccionada <= plantasRegistradas.size()) {
                        return numeroPlantaSeleccionada - 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Número de planta no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } while (true);
        }
        return -1;
    }

    public void mostrarAsignaciones() {
        mostrarPlantasDisponibles();
        int numeroPlantaSeleccionada = seleccionarPlanta();
        int numeroBotanicoSeleccionado = asignarBotanico();

        if (numeroPlantaSeleccionada != -1 && numeroBotanicoSeleccionado != -1) {
            Planta plantaSeleccionada = plantasRegistradas.get(numeroPlantaSeleccionada);
            Botanicos botanicoSeleccionado = botanicosRegistrados.get(numeroBotanicoSeleccionado);

            AsignacionBotanico asignacion = new AsignacionBotanico(plantaSeleccionada, botanicoSeleccionado);
            asignaciones.add(asignacion);

            JOptionPane.showMessageDialog(null, "Asignación registrada con éxito:\n" +
                    "Planta: " + plantaSeleccionada.getNombreComun() + "\n" +
                    "Botánico: " + botanicoSeleccionado.getNombre(), "Asignación Registrada", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrarAsignacionesRegistradas() {
        if (!asignaciones.isEmpty()) {
            StringBuilder asignacionesRegistradas = new StringBuilder("Asignaciones Registradas:\n");
            for (AsignacionBotanico asignacion : asignaciones) {
                asignacionesRegistradas.append("Planta: ").append(asignacion.getPlanta().getNombreComun()).append(", ")
                        .append("Botánico: ").append(asignacion.getBotanico().getNombre()).append("\n");
            }
            JOptionPane.showMessageDialog(null, asignacionesRegistradas.toString(), "Asignaciones Registradas", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay asignaciones registradas.", "Asignaciones Registradas", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static class AsignacionBotanico {
        private Planta planta;
        private Botanicos botanico;

        public AsignacionBotanico(Planta planta, Botanicos botanico) {
            this.planta = planta;
            this.botanico = botanico;
        }

        public Planta getPlanta() {
            return planta;
        }

        public Botanicos getBotanico() {
            return botanico;
        }
    }
}
