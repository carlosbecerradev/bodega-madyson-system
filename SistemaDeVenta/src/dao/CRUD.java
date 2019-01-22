package dao;

public interface CRUD {

    public void registrar() throws Exception;
    public String buscar(String filtro) throws Exception;
    public void extraer() throws Exception;
    public void actualizar() throws Exception;
    public void consultar() throws Exception;
    public void eliminar() throws Exception;
    public void listar() throws Exception;
    public void nuevo() throws Exception;

}
