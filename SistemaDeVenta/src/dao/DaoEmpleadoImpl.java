package dao;

import bean.Empleado;
import java.util.ArrayList;

public interface DaoEmpleadoImpl {
    
    public void registrar(Empleado obj) throws Exception;
    public void actualizar(Empleado obj) throws Exception;
    public void eliminar(Empleado obj) throws Exception;
    public ArrayList listar() throws Exception;
    
}
