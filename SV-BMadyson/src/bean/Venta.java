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
public class Venta {
    private int codVenta;
    private String fechaVenta;
    private String totalVenta;
    private int codEmp1;
    private int codCli1;

    public Venta(int codVenta, String fechaVenta, String totalVenta, int codEmp1, int codCli1) {
        this.codVenta = codVenta;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.codEmp1 = codEmp1;
        this.codCli1 = codCli1;
    }

    public int getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(int codVenta) {
        this.codVenta = codVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(String totalVenta) {
        this.totalVenta = totalVenta;
    }

    public int getCodEmp1() {
        return codEmp1;
    }

    public void setCodEmp1(int codEmp1) {
        this.codEmp1 = codEmp1;
    }

    public int getCodCli1() {
        return codCli1;
    }

    public void setCodCli1(int codCli1) {
        this.codCli1 = codCli1;
    }
    
    
    
}
