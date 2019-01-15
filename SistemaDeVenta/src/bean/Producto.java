package bean;

public class Producto {

    private int CodProducto;
    private String articulo;
    private int CodMarca;
    private float precioV;
    private int stock;
    private int codCategoria;

    public Producto(int CodProducto, String articulo, int CodMarca, float precioV, int stock, int codCategoria) {
        this.CodProducto = CodProducto;
        this.articulo = articulo;
        this.CodMarca = CodMarca;
        this.precioV = precioV;
        this.stock = stock;
        this.codCategoria = codCategoria;
    }

    public int getCodProducto() {
        return CodProducto;
    }

    public void setCodProducto(int CodProducto) {
        this.CodProducto = CodProducto;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCodMarca() {
        return CodMarca;
    }

    public void setCodMarca(int CodMarca) {
        this.CodMarca = CodMarca;
    }

    public float getPrecioV() {
        return precioV;
    }

    public void setPrecioV(float precioV) {
        this.precioV = precioV;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

}
