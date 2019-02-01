/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bean.Empleado;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class ArregloEmpleado {
    private ArrayList<Empleado> lista;

    public ArregloEmpleado () {
        lista = new ArrayList<Empleado>();
        cargar();
    }

    public String adicionar(Empleado c) {
        String mensaje;
        Empleado x = buscar(c.getCodEmp());
        if (x == null) {
            lista.add(c);
            mensaje = "Empleado guardado correctamente";
        } else {
            mensaje = "El empleado ya existe";
        }
        return mensaje;
    }

    public void eliminar(Empleado c) {
        lista.remove(c);
    }

    public Empleado obtener(int posicion) {
        return lista.get(posicion);
    }

    public Empleado buscar(int codigo) {
        Empleado c = null;
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getCodEmp() == codigo) {
                c = obtener(i);
                i = lista.size();
            }
        }
        return c;
    }

    public int buscarPosicion(int codigo) {
        int posicion = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getCodEmp() == codigo) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public void actualizar(Empleado c) {
        lista.set(buscarPosicion(c.getCodEmp()), c);
    }

    public int totalCont() {
        return lista.size();
    }

    //Métodos para manipular el archivo de texto
    private void cargar() {
        try {
            File archivo = new File("./archivos/empleados.txt");
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./archivos/empleados.txt"), "CP1252"));
                String linea;

                while ((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");

                    int cod = Integer.parseInt(st.nextToken().trim());
                    String nombApeEmp = st.nextToken().trim();
                    String cargoEmp = st.nextToken().trim();
                    String dniEmp = st.nextToken().trim();
                    String usuEmp = st.nextToken().trim();
                    String contraEmp = st.nextToken().trim();
                    String genEmp = st.nextToken().trim();
                    int estado = Integer.parseInt(st.nextToken().trim());

                    Empleado v = new Empleado(cod, nombApeEmp, cargoEmp, dniEmp, usuEmp, contraEmp, genEmp, estado);
                    adicionar(v);
                }
                br.close();
            } else {
                JOptionPane.showMessageDialog(null, "El archivo boletas.txt no existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al cargar txt: " + e.toString());
        }

    }

    public void grabar() {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./archivos/empleados.txt"), "CP1252"));
            for (int i = 0; i < totalCont(); i++) {
                pw.println(obtener(i).getCodEmp() + "," + obtener(i).getNombApeEmp()+ "," +  
                        obtener(i).getCargoEmp()+ "," + obtener(i).getDniEmp()+ "," + 
                        obtener(i).getUsuEmp()+ "," + obtener(i).getContraEmp()+ "," + 
                        obtener(i).getGenEmp()+ "," + obtener(i).getEstado());
            }
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al grabar txt: " + e.toString());
        }
    }

}
