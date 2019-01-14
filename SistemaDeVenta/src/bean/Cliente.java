package bean;

public class Cliente {
    
    private int codCli;
    private String nombCli; //nombre + apePat + apeMat
    private String dniCli; //7
    private String rucCli; //11
    private String generoCli;
    
    public Cliente() {
        
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public String getNombCli() {
        return nombCli;
    }

    public void setNombCli(String nombCli) {
        this.nombCli = nombCli;
    }

    public String getDniCli() {
        return dniCli;
    }

    public void setDniCli(String dniCli) {
        this.dniCli = dniCli;
    }

    public String getRucCli() {
        return rucCli;
    }

    public void setRucCli(String rucCli) {
        this.rucCli = rucCli;
    }

    public String getGeneroCli() {
        return generoCli;
    }

    public void setGeneroCli(String generoCli) {
        this.generoCli = generoCli;
    }
    
    
    
}
