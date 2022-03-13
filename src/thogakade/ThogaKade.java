/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thogakade;

/**
 *
 * @Suraj Lakshitha
 */
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.logging.Level; 
import java.util.logging.Logger;

public class ThogaKade {

    public static void main(String[] args) {
       String SQL="Select * From Customer"; 
       try { 
           Class.forName("com.mysql.cj.jdbc.Driver"); 
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Thogakade", "root", "mysql"); 
           Statement stm = connection.createStatement(); 
           ResultSet rst = stm.executeQuery(SQL); //Retruns ResultSet Object
           while(rst.next()){ 
               String id=rst.getString("id"); 
               String name=rst.getString("name"); 
               String address=rst.getString("Address"); 
               double salary=rst.getDouble("salary"); 
               System.out.println(id+"\t"+name+"\t"+address+"\t"+salary); 
           }
       } catch (ClassNotFoundException ex) { 
           System.out.println("Driver S/W not found"); 
           return; } catch (SQLException ex) { 
               System.out.println(ex.getMessage()); 
           }
    }
    
}
