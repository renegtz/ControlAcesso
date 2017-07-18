
import controlacesso.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isabella
 */
public class gestionUsuarios {
    private static Conexion conexion;
    
    public void consultar(){
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        ResultSet rs;
       // System.out.println("inserte nombre");
        String sql = "select *from usuarios";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);  
            
            
            
            con.close();
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error al consultar tabla de usuarios");
        }  
        
    }
    
    public void registar(String user, String password, int tipo){
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
        String sql = "insert into users (name, password,tipoUsuario) values ('"+user+"','"+password+"','"+tipo+"')"; 
        try {
            st= con.createStatement();
            st.executeUpdate(sql);
            con.close();
            st.close();
        } catch (Exception e) {
        }       
    }
    
    public void modificar(int id, String user, String password, int tipo){
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
       // System.out.println("inserte nombre");
        String sql = "update users set name='"+user+"',password='"+password+"', tipoUsuario'"+tipo+"' where iduser ="+id+""; 
        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if(confirmar ==1){
                System.out.println("Los datos de usuario han sido modificados");
            } else{
                System.out.println("Error modificando usuario");
            }
            st.close();
            con.close();
                    
        } catch (Exception e) {
            System.out.println("Error "+ e);
        }
    
    }
    
    public void eliminar(int id){
        conexion = new Conexion();
        Connection con = conexion.getConnection();
        Statement st;
       // System.out.println("inserte nombre");
        String sql = "delete from users where iduser="+id; 
        try {
            st = con.createStatement();
            int confirmar = st.executeUpdate(sql);
            if(confirmar ==1){
                System.out.println("El usuario ha sido eliminado");
            } else{
                System.out.println("Error tratando de eliminar al usuario");
            }
            st.close();
            con.close();
                    
        } catch (Exception e) {
            System.out.println("Error "+ e);
        }
    
    }
    
    
    
}
