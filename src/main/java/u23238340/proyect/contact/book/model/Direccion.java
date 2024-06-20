package u23238340.proyect.contact.book.model;

public class Direccion {
    private int idDireccion;
    private int idContacto;
    private String calle;
    private String ciudad;
    private String pais;
    private String tipoDireccion;

    public Direccion() {
    }

    public Direccion(int idDireccion, int idContacto, String calle, String ciudad, String pais, String tipoDireccion) {
        this.idDireccion = idDireccion;
        this.idContacto = idContacto;
        this.calle = calle;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tipoDireccion = tipoDireccion;
    }
    
    public Direccion(int idDireccion, String calle, String ciudad, String pais, String tipoDireccion) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tipoDireccion = tipoDireccion;
    }
    
      public Direccion(String calle, String ciudad, String pais, String tipoDireccion) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tipoDireccion = tipoDireccion;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(String tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "idDireccion=" + idDireccion +
                ", idContacto=" + idContacto +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", tipoDireccion='" + tipoDireccion + '\'' +
                '}';
    }
}
