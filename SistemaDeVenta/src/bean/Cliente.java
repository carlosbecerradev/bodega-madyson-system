package bean;

public class Cliente {

    private String nombCli; //nombre + apePat + apeMat
    private String dniCli; //7
    private String rucCli; //11
    private String generoCli;

    public Cliente(String nombCli, String dniCli, String rucCli, String generoCli) {
        this.nombCli = nombCli;
        this.dniCli = dniCli;
        this.rucCli = rucCli;
        this.generoCli = generoCli;
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
