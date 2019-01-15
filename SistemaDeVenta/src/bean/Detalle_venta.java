package bean;

public class Detalle_venta {

    private int codVentaDetalle;
    private int codPro;
    private int cantidad;
    private float importe;

    public Detalle_venta(int codVentaDetalle, int codPro, int cantidad, float importe) {
        this.codVentaDetalle = codVentaDetalle;
        this.codPro = codPro;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public int getCodVentaDetalle() {
        return codVentaDetalle;
    }

    public void setCodVentaDetalle(int codVentaDetalle) {
        this.codVentaDetalle = codVentaDetalle;
    }

    public int getCodPro() {
        return codPro;
    }

    public void setCodPro(int codPro) {
        this.codPro = codPro;
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
