package u23238340.proyect.contact.book.model;

import java.sql.Timestamp;

public class Reporte {
    private int idReporte;
    private int idUsuario;
    private int numTotalContactos;
    private int numContactosEditados;
    private int numContactosEliminados;
    private int numContactosAgregados;
    private Timestamp fechaGenerado;

    public Reporte() {
    }

    public Reporte(int idReporte, int idUsuario, int numTotalContactos, int numContactosEditados, int numContactosEliminados, int numContactosAgregados, Timestamp fechaGenerado) {
        this.idReporte = idReporte;
        this.idUsuario = idUsuario;
        this.numTotalContactos = numTotalContactos;
        this.numContactosEditados = numContactosEditados;
        this.numContactosEliminados = numContactosEliminados;
        this.numContactosAgregados = numContactosAgregados;
        this.fechaGenerado = fechaGenerado;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getNumTotalContactos() {
        return numTotalContactos;
    }

    public void setNumTotalContactos(int numTotalContactos) {
        this.numTotalContactos = numTotalContactos;
    }

    public int getNumContactosEditados() {
        return numContactosEditados;
    }

    public void setNumContactosEditados(int numContactosEditados) {
        this.numContactosEditados = numContactosEditados;
    }

    public int getNumContactosEliminados() {
        return numContactosEliminados;
    }

    public void setNumContactosEliminados(int numContactosEliminados) {
        this.numContactosEliminados = numContactosEliminados;
    }

    public int getNumContactosAgregados() {
        return numContactosAgregados;
    }

    public void setNumContactosAgregados(int numContactosAgregados) {
        this.numContactosAgregados = numContactosAgregados;
    }

    public Timestamp getFechaGenerado() {
        return fechaGenerado;
    }

    public void setFechaGenerado(Timestamp fechaGenerado) {
        this.fechaGenerado = fechaGenerado;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "idReporte=" + idReporte +
                ", idUsuario=" + idUsuario +
                ", numTotalContactos=" + numTotalContactos +
                ", numContactosEditados=" + numContactosEditados +
                ", numContactosEliminados=" + numContactosEliminados +
                ", numContactosAgregados=" + numContactosAgregados +
                ", fechaGenerado=" + fechaGenerado +
                '}';
    }
}
