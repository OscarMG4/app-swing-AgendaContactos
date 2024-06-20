package u23238340.proyect.contact.book.model;

public class Telefono {
    private int idTelefono;
    private int idContacto;
    private String telefono;
    private String tipoTelefono;

    public Telefono() {
    }

    public Telefono(int idTelefono, int idContacto, String telefono, String tipoTelefono) {
        this.idTelefono = idTelefono;
        this.idContacto = idContacto;
        this.telefono = telefono;
        this.tipoTelefono = tipoTelefono;
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(String tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "idTelefono=" + idTelefono +
                ", idContacto=" + idContacto +
                ", telefono='" + telefono + '\'' +
                ", tipoTelefono='" + tipoTelefono + '\'' +
                '}';
    }
}
