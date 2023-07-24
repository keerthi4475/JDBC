package com.abc.JDBCDemo;

 

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.Statement;

import java.util.Scanner;

 

public class App

{

    public static void main( String[] args )

    {

        Connection con=null;

        Scanner s=new Scanner(System.in);

        try {

            //1. loading Driver class

        Class.forName("com.mysql.cj.jdbc.Driver");

        

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db2","root","0106");

        if(con!=null) {

            Statement stmt=con.createStatement();

            

            int sid,marks;

            String sname=null,city=null;

            

            //execute()   : all queries  --> boolean

            // executeUpdate() : u,i,d  --> int

            // executeQuery()  : select --> ResultSet

            

            System.out.println("Enter SID : ");

            sid=s.nextInt();

            

            System.out.println("Enter Sname : ");

            sname=s.next();

            

            System.out.println("Enter marks : ");

            marks=s.nextInt();

            

            System.out.println("Enter city : ");

            city=s.next();


            boolean i=stmt.execute("CREATE TABLE Stu(sid INT,sname VARCHAR(20),marks INT,city VARCHAR(20))");
            System.out.println("cfreate success");
            int i1=stmt.executeUpdate("insert into Stu values('"+sid+"','"+sname+"','"+marks+"','"+city+"')");

            if(i1>0) {

                System.out.println("insert success");
 
            }

            else {

                System.out.println("fail");

            }
        }

        else {

            System.out.println("fail");

        }

        }

        catch(Exception e) {

            System.out.println(e);

        }

    }

}