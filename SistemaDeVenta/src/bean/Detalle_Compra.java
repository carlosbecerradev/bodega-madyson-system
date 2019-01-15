package bean;

public class Detalle_Compra {

    private int codCompra;
    private int codProducto2;
    private boolean precioCompra;
    private int cantidad;
    private boolean descuento;
    private boolean importe;

    public Detalle_Compra(int codCompra, int codProducto2, boolean precioCompra, int cantidad, boolean descuento, boolean importe) {
        this.codCompra = codCompra;
        this.codProducto2 = codProducto2;
        this.precioCompra = precioCompra;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.importe = importe;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }

    public int getCodProducto2() {
        return codProducto2;
    }

    public void setCodProducto2(int codProducto2) {
        this.codProducto2 = codProducto2;
    }

    public boolean isPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(boolean precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isDescuento() {
        return descuento;
    }

    public void setDescuento(boolean descuento) {
        this.descuento = descuento;
    }

    public boolean isImporte() {
        return importe;
    }

    public void setImporte(boolean importe) {
        this.importe = importe;
    }

}
