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
public class Empleado {
    private int codEmp;
    private String nombApeEmp;
    private String cargoEmp;
    private String dniEmp;
    private String usuEmp;
    private String contraEmp;
    private String genEmp;
    private int estado;

    public Empleado(int codEmp, String nombApeEmp, String cargoEmp, String dniEmp, String usuEmp, String contraEmp, String genEmp, int estado) {
        this.codEmp = codEmp;
        this.nombApeEmp = nombApeEmp;
        this.cargoEmp = cargoEmp;
        this.dniEmp = dniEmp;
        this.usuEmp = usuEmp;
        this.contraEmp = contraEmp;
        this.genEmp = genEmp;
        this.estado = estado;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public String getNombApeEmp() {
        return nombApeEmp;
    }

    public void setNombApeEmp(String nombApeEmp) {
        this.nombApeEmp = nombApeEmp;
    }

    public String getCargoEmp() {
        return cargoEmp;
    }

    public void setCargoEmp(String cargoEmp) {
        this.cargoEmp = cargoEmp;
    }

    public String getDniEmp() {
        return dniEmp;
    }

    public void setDniEmp(String dniEmp) {
        this.dniEmp = dniEmp;
    }

    public String getUsuEmp() {
        return usuEmp;
    }

    public void setUsuEmp(String usuEmp) {
        this.usuEmp = usuEmp;
    }

    public String getContraEmp() {
        return contraEmp;
    }

    public void setContraEmp(String contraEmp) {
        this.contraEmp = contraEmp;
    }

    public String getGenEmp() {
        return genEmp;
    }

    public void setGenEmp(String genEmp) {
        this.genEmp = genEmp;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
}
