package bean;

public class Producto {

    private String articulo;
    private String marca;
    private float precioV;
    private int stock;
    private String categoria;

    public Producto(String articulo, String marca, float precioV, int stock, String categoria) {
        this.articulo = articulo;
        this.marca = marca;
        this.precioV = precioV;
        this.stock = stock;
        this.categoria = categoria;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
