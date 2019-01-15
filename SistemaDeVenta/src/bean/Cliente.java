package bean;

public class Cliente {

    private String nombesCli; //nombre + apePat + apeMat
    private String dniCli; //7
    private String correoCli; //11
    private String generoCli;

    public Cliente(String nombesCli, String dniCli, String correoCli, String generoCli) {
        this.nombesCli = nombesCli;
        this.dniCli = dniCli;
        this.correoCli = correoCli;
        this.generoCli = generoCli;
    }

    public String getNombesCli() {
        return nombesCli;
    }

    public void setNombesCli(String nombesCli) {
        this.nombesCli = nombesCli;
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

    public String getGeneroCli() {
        return generoCli;
    }

    public void setGeneroCli(String generoCli) {
        this.generoCli = generoCli;
    }

    
}
