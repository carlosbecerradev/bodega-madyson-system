package modelo;

import bean.Cliente;
import dao.Conexion;
import dao.DaoClienteImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModeloCliente extends Conexion implements DaoClienteImpl {

    @Override
    public void registrar(Cliente cli) throws Exception {
        try{
            this.conectarBD();
            PreparedStatement ps = this.conexion.prepareStatement("insert into Cliente values (?,?,?,?)");
            ps.setString(1, cli.getNombCli());
            ps.setString(2, cli.getDniCli());
            ps.setString(3, cli.getRucCli());
            ps.setString(4, cli.getGeneroCli());
            ps.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al registrar" + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void actualizar(Cliente cli) throws Exception {
        try{
            this.conectarBD();
            PreparedStatement ps = this.conexion.prepareStatement("update Cliente set nombApeCli = ? , dniCli = ?, rucCli = ? ,"
                    + " genCli = ? where codCli = ?");
            ps.setString(1, cli.getNombCli());
            ps.setString(2, cli.getDniCli());
            ps.setString(3, cli.getRucCli());
            ps.setString(4, cli.getGeneroCli());
            ps.setInt(5, cli.getCodCli());
            ps.executeUpdate();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar" + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void eliminar(Cliente cli) throws Exception {
        try {
            this.conectarBD();
            PreparedStatement ps = this.conexion.prepareStatement("delete from Cliente where id = ?");
            ps.setInt(1, cli.getCodCli());
            ps.executeUpdate();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public ArrayList listar() throws Exception {
        ArrayList<Cliente> lista = null;
        try {
            this.conectarBD();
            PreparedStatement ps = this.conexion.prepareStatement("delete from Cliente where id = ?");
            
            lista = new ArrayList();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setCodCli(rs.getInt(0));
                cli.setNombCli(rs.getString(1));
                cli.setDniCli(rs.getString(2));
                cli.setRucCli(rs.getString(3));
                cli.setGeneroCli(rs.getString(4));
                lista.add(cli);
            }
            ps.close();
            rs.close();
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e);
        } finally {
            this.desconectarBD();
        }
        return lista;
    }

   
    

   
}
