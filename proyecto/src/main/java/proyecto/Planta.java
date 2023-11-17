package proyecto;

import javax.swing.*;
import java.util.List;

public class Planta {
    private String nombreComun;
    private String nombreCientifico;
    private String tipo;
    private Cuidados cuidados;

    public Planta(String nombreComun, String nombreCientifico, String tipo) {
        this.nombreComun = nombreComun;
        this.nombreCientifico = nombreCientifico;
        this.tipo = tipo;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cuidados getCuidados() {
        return cuidados;
    }

    public void setCuidados(Cuidados nuevosCuidados) {
        this.cuidados = nuevosCuidados;
    }

    public static void mostrarInformacionPlantas(List<Planta> plantasRegistradas, List<Botanicos> botanicosRegistrados) {
        if (!plantasRegistradas.isEmpty()) {
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("\nPlantas Registradas\n ");
            int contador = 1;
            for (Planta infoPlanta : plantasRegistradas) {
                mensaje.append("\nInformacion de la Planta: #").append(contador).append("\n");
                mensaje.append("Tipo de planta: ").append(infoPlanta.getTipo()).append("\n");
                mensaje.append("Nombre común de la planta: ").append(infoPlanta.getNombreComun()).append("\n");
                mensaje.append("Nombre cientifico de la planta: ").append(infoPlanta.getNombreCientifico()).append("\n");

                if (botanicosRegistrados != null && contador <= botanicosRegistrados.size()) {
                    mensaje.append("Botánico encargado: ").append(botanicosRegistrados.get(contador - 1).getNombre()).append("\n");
                } else {
                    mensaje.append("Botánico encargado: Sin asignar\n");
                }

                Cuidados cuidados = infoPlanta.getCuidados();
                if (cuidados != null) {
                    mensaje.append("Cuidados:\n");
                    mensaje.append("Estado de salud inicial: ").append(cuidados.getEstadoInicial()).append("\n");
                    mensaje.append("Zona donde está ubicada la planta: ").append(cuidados.getNombreLugar()).append("\n");
                    mensaje.append("Área donde está ubicada la planta: ").append(cuidados.getUbicacion()).append("\n");
                    mensaje.append("Fecha registrada para el cuidado: ").append(cuidados.getFechaCuidado()).append("\n");
                    mensaje.append("Hora registrada para el cuidado: ").append(cuidados.getHoraCuidado()).append("\n");
                    mensaje.append("Crecimiento: ").append(cuidados.getCrecimientoPlanta()).append("\n");
                    mensaje.append("Estado actual del cuidado: ").append(cuidados.getEstadoCuidado()).append("\n");
                } else {
                    mensaje.append("Esta planta no tiene cuidados registrados.\n");
                }
                contador++;
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se han registrado plantas.");
        }
    }
}
