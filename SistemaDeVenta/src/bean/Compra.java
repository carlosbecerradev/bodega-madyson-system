package bean;

import java.sql.Date;


public class Compra {

    private int CodCompra;
    private int CodProveedor1;  
    private Date fechaCompra;
    private boolean totalCompra;  

    public Compra(int CodCompra, int CodProveedor1, Date fechaCompra, boolean totalCompra) {
        this.CodCompra = CodCompra;
        this.CodProveedor1 = CodProveedor1;
        this.fechaCompra = fechaCompra;
        this.totalCompra = totalCompra;
    }

    public int getCodCompra() {
        return CodCompra;
    }

    public void setCodCompra(int CodCompra) {
        this.CodCompra = CodCompra;
    }

    public int getCodProveedor1() {
        return CodProveedor1;
    }

    public void setCodProveedor1(int CodProveedor1) {
        this.CodProveedor1 = CodProveedor1;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(boolean totalCompra) {
        this.totalCompra = totalCompra;
    }

}
