
package bean;

public class Proveedor {
     private int codProveedor;
     private String Ruc;
     private String nombre;
     private int telefono;
     private String direccion;
     private String observacion;

    public Proveedor(int codProveedor, String Ruc, String nombre, int telefono, String direccion, String observacion) {
        this.codProveedor = codProveedor;
        this.Ruc = Ruc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.observacion = observacion;
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String Ruc) {
        this.Ruc = Ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
     
}
