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
public class Cliente {
    private int  codCli;
    private String nombApeCli;
    private String dniCli;
    private String correoCli;
    private String genCli;

    public Cliente(int codCli, String nombApeCli, String dniCli, String correoCli, String genCli) {
        this.codCli = codCli;
        this.nombApeCli = nombApeCli;
        this.dniCli = dniCli;
        this.correoCli = correoCli;
        this.genCli = genCli;
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getNombApeCli() {
        return nombApeCli;
    }

    public void setNombApeCli(String nombApeCli) {
        this.nombApeCli = nombApeCli;
    }

    public String getDniCli() {
        return dniCli;
    }

    public void setDniCli(String dniCli) {
        this.dniCli = dniCli;
    }

    public String getCorreoCli() {
        return correoCli;
    }

    public void setCorreoCli(String correoCli) {
        this.correoCli = correoCli;
    }

    public String getGenCli() {
        return genCli;
    }

    public void setGenCli(String genCli) {
        this.genCli = genCli;
    }
    
    
}
