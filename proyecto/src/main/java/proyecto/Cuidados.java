package proyecto;

public class Cuidados {
    private String nombreLugar;
    private String estadoInicial;
    private String ubicacion;
    private String fechaCuidado;
    private String horaCuidado;
    private String crecimientoPlanta;
    private String estadoCuidado;

    public Cuidados(String nombreLugar, String estadoInicial, String ubicacion, String fechaCuidado, String horaCuidado, String crecimientoPlanta, String estadoCuidado) {
        this.nombreLugar = nombreLugar;
        this.estadoInicial = estadoInicial;
        this.ubicacion = ubicacion;
        this.fechaCuidado = fechaCuidado;
        this.horaCuidado = horaCuidado;
        this.crecimientoPlanta = crecimientoPlanta;
        this.estadoCuidado = estadoCuidado;
    }

    public String obtenerMensajeEstadoCuidado() {
        switch (estadoCuidado) {
            case "Pendiente":
                return "La planta aún está pendiente por ser cuidada";
            case "En proceso":
                return "La planta está siendo atendida por el Botánico";
            case "Finalizado":
                return "Ya finalizó el cuidado de la planta, actualmente está mejor";
            case "Aplazado":
                return "El cuidado de la planta fue aplazado";
            default:
                return "";
        }
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getFechaCuidado() {
        return fechaCuidado;
    }

    public String getHoraCuidado() {
        return horaCuidado;
    }

    public String getCrecimientoPlanta() {
        return crecimientoPlanta;
    }

    public String getEstadoCuidado() {
        return estadoCuidado;
    }
}





