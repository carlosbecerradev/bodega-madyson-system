/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bean.Cliente;
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
public class ArregloCliente {
    private ArrayList<Cliente> lista;

    public ArregloCliente () {
        lista = new ArrayList<Cliente>();
        cargar();
    }

    public String adicionar(Cliente c) {
        String mensaje;
        Cliente x = buscar(c.getCodCli());
        if (x == null) {
            lista.add(c);
            mensaje = "Cliente guardado correctamente";
        } else {
            mensaje = "El cliente ya existe";
        }
        return mensaje;
    }

    public void eliminar(Cliente c) {
        lista.remove(c);
    }

    public Cliente obtener(int posicion) {
        return lista.get(posicion);
    }

    public Cliente buscar(int codigo) {
        Cliente c = null;
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getCodCli() == codigo) {
                c = obtener(i);
                i = lista.size();
            }
        }
        return c;
    }

    public int buscarPosicion(int codigo) {
        int posicion = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getCodCli() == codigo) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public void actualizar(Cliente c) {
        lista.set(buscarPosicion(c.getCodCli()), c);
    }

    public int totalCont() {
        return lista.size();
    }

    //Métodos para manipular el archivo de texto
    private void cargar() {
        try {
            File archivo = new File("./archivos/clientes.txt");
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./archivos/clientes.txt"), "CP1252"));
                String linea;

                while ((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");

                    int getCodCli = Integer.parseInt(st.nextToken().trim());
                    String getNombApeCli = st.nextToken().trim();
                    String getDniCli = st.nextToken().trim();
                    String getCorreoCli = st.nextToken().trim();
                    String getGenCli = st.nextToken().trim();

                    Cliente v = new Cliente(getCodCli, getNombApeCli, getDniCli, getCorreoCli, getGenCli);
                    adicionar(v);
                }
                br.close();
            } else {
                JOptionPane.showMessageDialog(null, "El archivo clientes.txt no existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al cargar txt: " + e.toString());
        }

    }

    public void grabar() {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./archivos/clientes.txt"), "CP1252"));
            for (int i = 0; i < totalCont(); i++) {
                pw.println(obtener(i).getCodCli() + "," + obtener(i).getNombApeCli()+ "," +  
                        obtener(i).getDniCli()+ "," + obtener(i).getCorreoCli()+ "," + 
                        obtener(i).getGenCli());
            }
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al grabar txt: " + e.toString());
        }
    }
}
