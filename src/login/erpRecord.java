/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Mithun Kumar
 */
public class erpRecord {
    public static Connection getConnection()
    {
        Connection con=null;
        try
        {
              Class.forName("com.mysql.cj.jdbc.Driver");
            String path="jdbc:mysql://localhost:3306/erp";
            con = DriverManager.getConnection(path,"root","mithun123");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return con;
    }

    static int setAllDetails(String p_name, String p_uname, String p_email, String p_gender, String p_mobile, String p_rg, String p_pass, String p_cpass)
    {
        
        //To change body of generated methods, choose Tools | Templates.
        int i=0;
        try
        {
            Connection con = erpRecord.getConnection();
            String query= "insert into regester (name,username,email,gender,mobile,regester,password,cnfPassword) values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, p_name);
            ps.setString(2, p_uname);
            ps.setString(3, p_email);
            ps.setString(4, p_gender);
            ps.setString(5, p_mobile);
            ps.setString(6, p_rg);
            ps.setString(7, p_pass);
            ps.setString(8, p_cpass);

            
            i = ps.executeUpdate();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }
    //login

 public static int loginCheck(String username,String password)
    {
        int i=0;
        try
        {
            Connection con = erpRecord.getConnection();
            String query="Select * from regester WHERE username=? and password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
               i = rs.getInt(1);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

   

    public static int setAddTeacher(String t_name, String t_email, String t_mobile, String t_course) {
         //To change body of generated methods, choose Tools | Templates.
         int i=0;
        try
        {
            Connection con = erpRecord.getConnection();
            String query= "insert into newteacheradd (teacherName,teacherEmail,teacherMobile,teacherCourse) values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t_name);
            ps.setString(2, t_email);
            ps.setString(3, t_mobile);
            ps.setString(4, t_course);

            
            i = ps.executeUpdate();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
         
    }

  

    public static int setStudentAdmitionDetails(String p_sname, String p_sfname, String p_sdob, String p_sgender, String p_sroll, String p_sAdate, String p_semail, String p_smobile, String p_scourse, String p_scountry, String p_scourseFee, String p_saddress) {
        
        //To change body of generated methods, choose Tools | Templates.

                int i=0;
        try
        {
            Connection con = erpRecord.getConnection();
            String query= "insert into studentadmission (std_name,std_fatherName,std_dob,std_gender,stdRoll,stdAddDate,std_email,std_mobileNumber,std_course,std_cuntry,std_courseFee,std_address) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, p_sname);
            ps.setString(2, p_sfname);
            ps.setString(3, p_sdob);
            ps.setString(4,p_sgender);
            ps.setString(5, p_sroll);
            ps.setString(6, p_sAdate);
            ps.setString(7, p_semail);
            ps.setString(8, p_smobile);
            ps.setString(9, p_scourse);
            ps.setString(10, p_scountry);
            ps.setString(11, p_scourseFee);
            ps.setString(12, p_saddress);


            
            i = ps.executeUpdate();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
         
         
    }

    public static ArrayList<String> stdSearchDetails(String std_id) {
         //To change body of generated methods, choose Tools | Templates.
         
       ArrayList<String> a = new ArrayList<String>();
        try
        {
            Connection con = erpRecord.getConnection();
           String query="Select std_id,stdAddDate,std_name,std_course,std_fatherName,std_gender,std_email,stdRoll,std_dob,std_cuntry,std_mobileNumber,std_address,std_courseFee  from studentadmission WHERE std_id =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, std_id);
           
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
               a.add(rs.getString(1));
                a.add(rs.getString(2));
                a.add(rs.getString(3));
                a.add(rs.getString(4));
                a.add(rs.getString(5));
                a.add(rs.getString(6));
                a.add(rs.getString(7));
                a.add(rs.getString(8));
                a.add(rs.getString(9));
                a.add(rs.getString(10));
                 a.add(rs.getString(11));
                a.add(rs.getString(12));
                 a.add(rs.getString(13));
                 a.add(rs.getString(14));
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return a;
         
    }
    
    //Show student information and update student information
    
    public static ArrayList<String> stdShowDetails(String std_id) {
         //To change body of generated methods, choose Tools | Templates.
         
       ArrayList<String> a = new ArrayList<String>();
        try
        {
            Connection con = erpRecord.getConnection();
           String query="Select std_id,std_name,std_fatherName,std_dob,stdAddDate,std_email,std_mobileNumber,std_address  from studentadmission WHERE std_id =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, std_id);
           
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
               a.add(rs.getString(1));
                a.add(rs.getString(2));
                a.add(rs.getString(3));
                a.add(rs.getString(4));
                a.add(rs.getString(5));
                a.add(rs.getString(6));
                a.add(rs.getString(7));
                a.add(rs.getString(8));
//                a.add(rs.getString(9));
//               a.add(rs.getString(10));
//                a.add(rs.getString(11));
//               a.add(rs.getString(12));
//                a.add(rs.getString(13));
//               a.add(rs.getString(14));
               
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return a;
         
    }
    
    public static ArrayList<String> stdFeeCheck(String std_id) {
         //To change body of generated methods, choose Tools | Templates.
         
       ArrayList<String> a = new ArrayList<String>();
        try
        {
            Connection con = erpRecord.getConnection();
           String query="Select std_name,stdRoll,std_course,std_id,std_courseFee from studentadmission WHERE std_id =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, std_id);
           
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
               a.add(rs.getString(1));
                a.add(rs.getString(2));
                a.add(rs.getString(3));
                a.add(rs.getString(4));
                a.add(rs.getString(5));
                a.add(rs.getString(6));
                a.add(rs.getString(7));
                
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return a;
         
    }
    
    public static ArrayList<String>stdCheckFee(String std_id) {
         //To change body of generated methods, choose Tools | Templates.
         
       ArrayList<String> a = new ArrayList<String>();
        try
        {
            Connection con = erpRecord.getConnection();
           String query="Select std_id,std_name,stdRoll,std_course,std_mobileNumber,std_email,std_courseFee from studentadmission WHERE std_id =?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, std_id);
           
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
               a.add(rs.getString(1));
                a.add(rs.getString(2));
                a.add(rs.getString(3));
                a.add(rs.getString(4));
                a.add(rs.getString(5));
                a.add(rs.getString(6));
                a.add(rs.getString(7));
                a.add(rs.getString(8));
                a.add(rs.getString(9));
                
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return a;
         
    }

    public static int stdDeleteData( String p_roll ) {
        //To change body of generated methods, choose Tools | Templates.
        
         int i=0;
        try
        {
            Connection con = erpRecord.getConnection();
            String query="DELETE   FROM studentadmission WHERE  std_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, p_roll);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
               i = rs.getInt(1);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

    public static int setStudentUpdateDetails(String u_sid,String u_sname, String u_sfname, String u_sdob, String u_sgender, String u_sAdate, String u_scountry, String u_semail, String u_smobile, String u_scourse, String u_scourseFee, String u_scourseduesFee, String u_saddress) 
    {
        int i=0;
        try
        {
            Connection con = erpRecord.getConnection();
            String query= "update studentadmission set std_name='"+u_sname+"',std_fatherName='"+u_sfname+"',std_dob='"+u_sdob+"',std_gender='"+u_sgender+"',stdAddDate='"+u_sAdate+"',std_email='"+u_semail+"',std_mobileNumber='"+u_smobile+"',std_course='"+u_scourse+"',std_cuntry='"+u_scountry+"',std_courseFee='"+u_scourseFee+"',std_courseDuesFee='"+u_scourseduesFee+"',std_address='"+u_saddress+"' where std_id='"+u_sid+"'";
            PreparedStatement ps = con.prepareStatement(query);
//            ps.setString(1, u_sname);
//            ps.setString(2, u_sfname);
//            ps.setString(3, u_sdob);
//            ps.setString(4,u_sgender);
////            
//            ps.setString(5, u_sAdate);
//            ps.setString(6, u_semail);
//            ps.setString(7, u_smobile);
//            ps.setString(8, u_scourse);
//            ps.setString(9, u_scountry);
//            ps.setString(10, u_scourseFee);
//            ps.setString(11, u_scourseduesFee);
//            ps.setString(11, u_saddress);


            
            i=ps.executeUpdate();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

    private static PreparedStatement executeUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static PreparedStatement execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
