/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bean.DetalleDetalleVenta;
import bean.DetalleVenta;
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
public class ArregloDetalleVenta {
    
    private ArrayList<DetalleDetalleVenta> lista;

    public ArregloDetalleVenta () {
        lista = new ArrayList<DetalleDetalleVenta>();
        cargar();
    }

    public String adicionar(DetalleVenta c) {
        String mensaje;
        DetalleVenta x = buscar(c.getCodVenta());
        if (x == null) {
            lista.add(c);
            mensaje = "Boleta guardado correctamente";
        } else {
            mensaje = "La boleta ya existe";
        }
        return mensaje;
    }

    public void eliminar(DetalleVenta c) {
        lista.remove(c);
    }

    public DetalleVenta obtener(int posicion) {
        return lista.get(posicion);
    }

    public DetalleVenta buscar(int codigo) {
        DetalleVenta c = null;
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getCodDetalleVenta() == codigo) {
                c = obtener(i);
                i = lista.size();
            }
        }
        return c;
    }

    public int buscarPosicion(int codigo) {
        int posicion = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getCodDetalleVenta() == codigo) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public void actualizar(DetalleVenta c) {
        lista.set(buscarPosicion(c.getCodDetalleVenta()), c);
    }

    public int totalCont() {
        return lista.size();
    }

    //Métodos para manipular el archivo de texto
    private void cargar() {
        try {
            File archivo = new File("./archivos/ventas.txt");
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./archivos/ventas.txt"), "CP1252"));
                String linea;

                while ((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");

                    int getCodDetalleVenta = Integer.parseInt(st.nextToken().trim());
                    String getFechaDetalleVenta = st.nextToken().trim();
                    String getTotalDetalleVenta = st.nextToken().trim();
                    int getCodEmp1 = Integer.parseInt(st.nextToken().trim());
                    int getCodCli1 = Integer.parseInt(st.nextToken().trim());

                    DetalleVenta v = new DetalleVenta(getCodDetalleVenta, getFechaDetalleVenta, getTotalDetalleVenta, getCodEmp1, getCodCli1);
                    adicionar(v);
                }
                br.close();
            } else {
                JOptionPane.showMessageDialog(null, "El archivo ventas.txt no existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al cargar txt: " + e.toString());
        }

    }

    public void grabar() {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./archivos/ventas.txt"), "CP1252"));
            for (int i = 0; i < totalCont(); i++) {
                pw.println(obtener(i).getCodDetalleVenta() + "," + obtener(i).getFechaDetalleVenta()+ "," +  
                        obtener(i).getTotalDetalleVenta()+ "," + obtener(i).getCodEmp1()+ "," + 
                        obtener(i).getCodCli1());
            }
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al grabar txt: " + e.toString());
        }
    }
}
