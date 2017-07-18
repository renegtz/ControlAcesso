/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacesso;
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
            con.close();
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error al consultar datos");
        }  
    }
    
    public void insertar(String nombre, int cantidad, double precio){
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
       // System.out.println("inserte nombre");
        String sql = "insert into inventario (nombre, cantidad, precio) values ('"+nombre+"','"+cantidad+"','"+precio+"')"; 
        try {
                        System.out.println("funciono ('"+nombre+"','"+cantidad+"','"+precio+"')");

            st= con.createStatement();
            st.executeUpdate(sql);
            con.close();
            st.close();
        } catch (Exception e) {
            System.out.println("error "+e);
        }
    }   
    
    public void eliminar(int id){
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
       // System.out.println("inserte nombre");
        String sql = "delete from inventario where idProducto="+id; 
        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if(confirmar ==1){
                System.out.println("Registro eliminado");
            } else{
                System.out.println("Error al eliminar");
            }
            st.close();
            con.close();
                    
        } catch (Exception e) {
            System.out.println("Error "+ e);
        }
   
        
    }
    public void modificar( int id, String nombre, int cantidad, double precio){
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
       // System.out.println("inserte nombre");
        String sql = "update inventario set nombre='"+nombre+"',cantidad='"+cantidad+"',precio='"+precio+"' where idProducto ="+id+""; 
        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if(confirmar ==1){
                System.out.println("Producto Modificado");
            } else{
                System.out.println("Error al modificar producto");
            }
            st.close();
            con.close();
                    
        } catch (Exception e) {
            System.out.println("Error "+ e);
        }
        
    }

    
}
