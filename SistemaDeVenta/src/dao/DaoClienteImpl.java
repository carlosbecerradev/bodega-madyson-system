package dao;

import bean.Cliente;
import java.util.ArrayList;

public interface DaoClienteImpl {
    
    public void registrar(Cliente cli) throws Exception;
    public void actualizar(Cliente cli) throws Exception;
    public void eliminar(Cliente cli) throws Exception;
    public ArrayList listar() throws Exception;
    
}
