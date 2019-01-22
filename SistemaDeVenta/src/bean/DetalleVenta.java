package bean;

public class DetalleVenta {

    private int codVenta;
    private int codPro;
    private int codCliente;
    private int codEmpleado;
    private int cantidad;
    private float importe;

    public DetalleVenta(int codVenta, int codPro, int codCliente, int codEmpleado, int cantidad, float importe) {
        this.codVenta = codVenta;
        this.codPro = codPro;
        this.codCliente = codCliente;
        this.codEmpleado = codEmpleado;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(int codVenta) {
        this.codVenta = codVenta;
    }

    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

}
