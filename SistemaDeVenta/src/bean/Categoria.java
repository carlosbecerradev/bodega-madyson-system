
package bean;

public class Categoria {
    private int codCategoria;
    private String nomCategoria;

    public Categoria(int codCategoria, String nomCategoria) {
        this.codCategoria = codCategoria;
        this.nomCategoria = nomCategoria;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }
    
    
}
