package u23238340.proyect.contact.book.data;

public class Contacto {
    String nombre;
    String numero;
    String correo;
    String direccion;
    String cumpleanios;
    String notas;

    public Contacto() {
    }

    public Contacto(String nombre, String numero, String correo, String direccion, String cumpleanios, String notas) {
        this.nombre = nombre;
        this.numero = numero;
        this.correo = correo;
        this.direccion = direccion;
        this.cumpleanios = cumpleanios;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCumpleanios() {
        return cumpleanios;
    }

    public void setCumpleanios(String cumpleanios) {
        this.cumpleanios = cumpleanios;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", numero=" + numero + ", correo=" + correo + ", direccion=" + direccion + ", cumpleanios=" + cumpleanios + ", notas=" + notas + '}';
    }
    
    
}
