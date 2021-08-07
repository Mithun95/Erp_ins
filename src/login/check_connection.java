/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Mithun Kumar
 */




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mithun Kumar
 */
import java.sql.*;
import java.util.*;
public class check_connection {
    
    public static void main(String[] args)
    {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter name tobe Search : ");
        String name = sc.nextLine();
        
        boolean status = false;
        
        try
        {
        //1. Register Driver class,otherwise ClassNotFoundException occurs
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. Create Connection
        String path="jdbc:mysql://localhost:3306/erp";
        String username="root";
        String password="mithun123";
        
         Connection con = DriverManager.getConnection(path,username,password);
        
       
        //3. Create statement
        Statement st = con.createStatement();
//        //4. Execute Query
        String query = "select * from regester where name ='"+name+"'";
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next())
        {
//       
            status =true;
            break;
            
        }
        
//         System.out.println("Data inserted Successfull..");
        //5. Close Connection
        con.close();
        
        if(status)
        {
            System.out.println("This name is exits");
        }
        else{
            System.out.println("Name is not exits");
        }
        
        }
        catch(Exception e)
        {
            System.out.println(e);
            
        }
        
    }
    
}
