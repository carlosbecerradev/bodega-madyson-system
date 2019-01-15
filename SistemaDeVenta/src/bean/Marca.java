package bean;

public class Marca {

    private int codMarca;
    private String nomMarca;

    public Marca(int codMarca, String nomMarca) {
        this.codMarca = codMarca;
        this.nomMarca = nomMarca;
    }

    public int getCodMarca() {
        return codMarca;
    }

    public void setCodMarca(int codMarca) {
        this.codMarca = codMarca;
    }

    public String getNomMarca() {
        return nomMarca;
    }

    public void setNomMarca(String nomMarca) {
        this.nomMarca = nomMarca;
    }

}
