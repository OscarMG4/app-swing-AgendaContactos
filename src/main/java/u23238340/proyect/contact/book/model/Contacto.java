package u23238340.proyect.contact.book.model;

import java.sql.Date;

public class Contacto {

    private int idContacto;
    private int idUsuario;
    private String nombre;
    private String email;
    private Date cumpleanios;
    private byte[] foto;
    private String nota;
    private String direccion;
    private String telefonos;

    // Constructor vacío necesario para algunas operaciones
    public Contacto() {
    }

    // Constructor con los parámetros necesarios
    public Contacto(String nombre, String email, Date cumpleanios, byte[] foto, String nota, String direccion, String telefonos) {
        this.nombre = nombre;
        this.email = email;
        this.cumpleanios = cumpleanios;
        this.foto = foto;
        this.nota = nota;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    // Getters y setters para todos los campos
    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCumpleanios() {
        return cumpleanios;
    }

    public void setCumpleanios(Date cumpleanios) {
        this.cumpleanios = cumpleanios;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "Contacto{"
                + "idContacto=" + idContacto
                + ", idUsuario=" + idUsuario
                + ", nombre='" + nombre + '\''
                + ", email='" + email + '\''
                + ", cumpleanios='" + cumpleanios + '\''
                + ", foto=" + (foto == null ? "null" : "byte[" + foto.length + "]")
                + ", nota='" + nota + '\''
                + ", direccion='" + direccion + '\''
                + ", telefonos='" + telefonos + '\''
                + '}';
    }
}
