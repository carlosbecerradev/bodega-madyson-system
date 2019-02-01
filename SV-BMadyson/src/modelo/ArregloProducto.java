/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bean.Producto;
import bean.Producto;
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
public class ArregloProducto {
    private ArrayList<Producto> lista;

    public ArregloProducto () {
        lista = new ArrayList<Producto>();
        cargar();
    }

    public String adicionar(Producto c) {
        String mensaje;
        Producto x = buscar(c.getCodProd());
        if (x == null) {
            lista.add(c);
            mensaje = "Producto guardado correctamente";
        } else {
            mensaje = "El producto ya existe";
        }
        return mensaje;
    }

    public void eliminar(Producto c) {
        lista.remove(c);
    }

    public Producto obtener(int posicion) {
        return lista.get(posicion);
    }

    public Producto buscar(int codigo) {
        Producto c = null;
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getCodProd() == codigo) {
                c = obtener(i);
                i = lista.size();
            }
        }
        return c;
    }

    public int buscarPosicion(int codigo) {
        int posicion = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getCodProd() == codigo) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public void actualizar(Producto c) {
        lista.set(buscarPosicion(c.getCodProd()), c);
    }

    public int totalCont() {
        return lista.size();
    }

    //Métodos para manipular el archivo de texto
    private void cargar() {
        try {
            File archivo = new File("./archivos/productos.txt");
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./archivos/clientes.txt"), "CP1252"));
                String linea;

                while ((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");

                    int getCodProd = Integer.parseInt(st.nextToken().trim());
                    String getArticulo = st.nextToken().trim();
                    String getMarca = st.nextToken().trim();
                    String getPrecioVenta = st.nextToken().trim();
                    String getStock = st.nextToken().trim();

                    Producto v = new Producto(getCodProd, getArticulo, getMarca, getPrecioVenta, getStock);
                    adicionar(v);
                }
                br.close();
            } else {
                JOptionPane.showMessageDialog(null, "El archivo productos.txt no existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al cargar txt: " + e.toString());
        }

    }

    public void grabar() {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./archivos/productos.txt"), "CP1252"));
            for (int i = 0; i < totalCont(); i++) {
                pw.println(obtener(i).getCodProd() + "," + obtener(i).getArticulo()+ "," +  
                        obtener(i).getMarca()+ "," + obtener(i).getPrecioVenta()+ "," + 
                        obtener(i).getStock());
            }
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al grabar txt: " + e.toString());
        }
    }
}
