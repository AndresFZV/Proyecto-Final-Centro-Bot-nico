package proyecto;

import javax.swing.*;
import java.util.List;

public class GestorPlantas {
    
    private List<Planta> plantasRegistradas;
    private List<Botanicos> botanicosRegistrados;

    public GestorPlantas(List<Planta> plantasRegistradas, List<Cuidados> cuidadosRegistrados, List<Botanicos> botanicosRegistrados) {
        this.plantasRegistradas = plantasRegistradas;
        this.botanicosRegistrados = botanicosRegistrados;
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

    public int seleccionarPlanta() {
        if (!plantasRegistradas.isEmpty()) {
            do {
                String input = JOptionPane.showInputDialog("¿Qué planta desea seleccionar? (Ingrese el número):");
                try {
                    int numeroPlantaSeleccionada = Integer.parseInt(input);
                    if (numeroPlantaSeleccionada >= 1 && numeroPlantaSeleccionada <= plantasRegistradas.size()) {
                        return numeroPlantaSeleccionada - 1; // Restar 1 para obtener el índice correcto
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

    public void registrarCuidados(Planta plantaSeleccionada) {
        RegistrarCuidado registro = new RegistrarCuidado();
        Cuidados nuevosCuidados = registro.registrarCuidados();
        plantaSeleccionada.setCuidados(nuevosCuidados);
        JOptionPane.showMessageDialog(null, "Cuidados registrados con éxito para la planta " + plantaSeleccionada.getNombreComun(), "Cuidados Registrados", JOptionPane.INFORMATION_MESSAGE);
    }

    public void registrarCuidadosParaPlantaSeleccionada() {
        mostrarPlantasDisponibles();
        int numeroPlantaSeleccionada = seleccionarPlanta();

        if (numeroPlantaSeleccionada != -1) {
            Planta plantaSeleccionada = plantasRegistradas.get(numeroPlantaSeleccionada);
            JOptionPane.showMessageDialog(null, "Ha seleccionado la planta: " + plantaSeleccionada.getNombreComun(), "Planta Seleccionada", JOptionPane.INFORMATION_MESSAGE);
            registrarCuidados(plantaSeleccionada);
        }
    }

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
    public void hacerAsignaciones(){
        mostrarPlantasDisponibles();
        seleccionarPlanta();
        asignarBotanico();
        JOptionPane.showMessageDialog(null, "Botánico asignado con éxito");
    }

}