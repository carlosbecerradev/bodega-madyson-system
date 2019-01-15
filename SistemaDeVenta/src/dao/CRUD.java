package dao;

import bean.Cliente;
import java.util.ArrayList;

public interface CRUD {

    /* Guarda un registro en la base de datos */
    public void registrar() throws Exception;

    /* Muestra uno o varios registros a través de un parámetro*/
    public String buscar(String filtro) throws Exception;

    /* Extrae un registro y rellena el formulario */
    public void extraer() throws Exception;

    /* Actualiza un registro */
    public void actualizar() throws Exception;

    /* Elimina un registro a partir de su CODIGO*/
    public void eliminar() throws Exception;

    /* Muestra todos los registros en la BD */
    public void listar() throws Exception;

    /* Limpiar campos R */
    public void nuevo() throws Exception;

}
