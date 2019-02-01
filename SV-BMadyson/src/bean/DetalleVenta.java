/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Administrador
 */
public class DetalleVenta {
    
    private int codVenta;
    private int codProd;
    private int codCliente;
    private int codEmpleado;
    private String cantidad;
    private int importe;

    public DetalleVenta(int codVenta, int codProd, int codCliente, int codEmpleado, String cantidad, int importe) {
        this.codVenta = codVenta;
        this.codProd = codProd;
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

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }
    
    
}
