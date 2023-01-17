/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.corejava;
import java.sql.*;  

/**
 *
 * @author Gashw
 */
public class Main {
   public Connection con;
    public static void main(String[] args) {
        System.out.println("hi");
        Allinone();
        System.out.println("callstoredprocedure");
        callstoredprocedure();
        callstoredprocedurewithparameter();
    }
    
    public static void callstoredprocedure()
    {
        System.out.println("connect");
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/ashdatabase","root","root123");  
            //here sonoo is database name, root is username and password  
            CallableStatement statement = con.prepareCall("{  call new_procedure() }");
            boolean hadResults = statement.execute();
            while (hadResults) {
                ResultSet resultSet = statement.getResultSet();
 
                // process result set
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3));                    
                } 
                hadResults = statement.getMoreResults();
            }
 
            statement.close();
            
              
            }catch(Exception e){ System.out.println(e);              
            }  
        
    }
    
    public static void callstoredprocedurewithparameter()
    {
        System.out.println("callstoredprocedurewithparameter");
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/ashdatabase","root","root123");  
            //here sonoo is database name, root is username and password  
            CallableStatement statement = con.prepareCall("{  call new_procedurename(?) }");
            statement.setString(1, "Ashwini");
            boolean hadResults = statement.execute();
            while (hadResults) {
                ResultSet resultSet = statement.getResultSet();
 
                // process result set
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1)+"  "+resultSet.getString(2)+"  "+resultSet.getString(3));                    
                } 
                hadResults = statement.getMoreResults();
            }
 
            statement.close();
            
              
            }catch(Exception e){ System.out.println(e);              
            }  
        
    }
    
    public static void Allinone()
    {
        System.out.println("connect");
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/ashdatabase","root","root123");  
            //here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from employees");  
            while(rs.next())  
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            con.close();  
            }catch(Exception e){ System.out.println(e);              
            }  
        
    }
    
}
