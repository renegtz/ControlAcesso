/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacesso;
import controlacesso.Conexion;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Isabella
 */
public class inventario {
    private static Conexion conexion;
    
    public inventario (){
    }
    
    public void consultar(){
         conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
       // System.out.println("inserte nombre");
        String sql = "select *from inventario";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            
        } catch (Exception e) {
        }
  
        
    }
    
    public void insertar(String nombre, String cantidad, String precio){
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
       // System.out.println("inserte nombre");
        String sql = "insert into inventario (nombre, cantidad, precio) values ('"+nombre+"','"+cantidad+"','"+precio+"')";
  
        
    }
    
    public void eliminar(){
    }
    public void modificar(){
    }
    
    public static void main(String[] args) {
        inventario i = new inventario();
        i.insertar("cafe","20","2");
        
    }
    
}
