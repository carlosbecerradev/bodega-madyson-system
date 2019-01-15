package bean;

import java.sql.Date;

public class Venta {

    int codVenta;
    Date fechaVenta;
    boolean totalVenta;
    int codEmpleado1;
    int codCliente1;

    public Venta(int codVenta, Date fechaVenta, boolean totalVenta, int codEmpleado1, int codCliente1) {
        this.codVenta = codVenta;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.codEmpleado1 = codEmpleado1;
        this.codCliente1 = codCliente1;
    }

    public int getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(int codVenta) {
        this.codVenta = codVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public boolean isTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(boolean totalVenta) {
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
