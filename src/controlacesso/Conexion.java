/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacesso;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Isabella
 */
public class Conexion {
    String servidor= "localhost:3306";
    String database= "accesoseguro";
    String usuario= "root";
    String password = "1234";
    String url="";
    private static Connection conexion;
    
        
  public Conexion (){
     
      try {
          Class.forName("com.mysql.jdbc.Driver");
          url= "jdbc:mysql://"+servidor+"/"+database;
          conexion =(Connection) DriverManager.getConnection(url,usuario,password);
          System.out.println("Coneción a base de datos"+ url+ "  done!");
          
      } catch (Exception e) {
          System.out.println(e);
      }
      
      }
  public Connection getConnection (){
      return conexion;
  }
//    public static void main(String[] args) {
   //     Conexion c= new Conexion();
 //      }
  }
    

