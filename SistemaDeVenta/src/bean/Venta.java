package bean;

import java.sql.Date;

public class Venta {

    Date fechaVenta;
    float totalVenta;
    int codEmpleado1;
    int codCliente1;

    public Venta(Date fechaVenta, float totalVenta, int codEmpleado1, int codCliente1) {
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.codEmpleado1 = codEmpleado1;
        this.codCliente1 = codCliente1;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getCodEmpleado1() {
        return codEmpleado1;
    }

    public void setCodEmpleado1(int codEmpleado1) {
        this.codEmpleado1 = codEmpleado1;
    }

    public int getCodCliente1() {
        return codCliente1;
    }

    public void setCodCliente1(int codCliente1) {
        this.codCliente1 = codCliente1;
    }

}
