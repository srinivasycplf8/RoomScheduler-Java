/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srini
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Timestamp.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author srini
 */
public class WaitlistQueries {
    private static PreparedStatement getWaitlistByDate;
    private static PreparedStatement getWaitlistByFaculty;
    private static PreparedStatement addWaitlistEntry;
    private static PreparedStatement cancelWaitlistEntry;
    private static PreparedStatement deleteWaitlistEntry;
    private static Connection connection;
    private static ResultSet resultSet;
    
    public static ArrayList<WaitlistEntry> getWaitlistByFaculty(String faculty){
        connection = DBConnection.getConnection();
        ArrayList<WaitlistEntry> waitlistMembers=new ArrayList<WaitlistEntry>();
        try{
            getWaitlistByFaculty=connection.prepareStatement("SELECT FACULTY,DATE,SEATS,TIMESTAMP FROM WAITLIST WHERE FACULTY=? order by FACULTY");
            getWaitlistByFaculty.setString(1,faculty);
            resultSet=getWaitlistByFaculty.executeQuery();
            
            while(resultSet.next()){
                waitlistMembers.add(new WaitlistEntry(
                resultSet.getString("FACULTY"),
                resultSet.getDate("DATE"),
                resultSet.getInt("SEATS"),
                resultSet.getTimestamp("TIMESTAMP")));
                
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return waitlistMembers;
                
    

}
    public static ArrayList<WaitlistEntry> getWaitlistByDate(){
        connection = DBConnection.getConnection();
        ArrayList<WaitlistEntry> waitlist=new ArrayList<>();
        try{
            java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
            getWaitlistByDate=connection.prepareStatement("SELECT * FROM WAITLIST");
            //getWaitlistByDate.setDate(1,date);
            resultSet=getWaitlistByDate.executeQuery();
            while(resultSet.next()){
                waitlist.add(new WaitlistEntry(
                resultSet.getString("FACULTY"),
                resultSet.getDate("DATE"),
                resultSet.getInt("SEATS"),
                resultSet.getTimestamp("TIMESTAMP")));
            }   
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        } 
        return waitlist;   

    }
    public static void addWaitlistEntry(String faculty,Date date,int seats,Timestamp currentTimestamp)
    {
        connection = DBConnection.getConnection();
        currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        
        try
        {
            addWaitlistEntry = connection.prepareStatement("INSERT into WAITLIST(FACULTY,DATE,SEATS,TIMESTAMP) VALUES(?,?,?,?)");
            addWaitlistEntry.setString(1,faculty);
            addWaitlistEntry.setDate(2,date);
            addWaitlistEntry.setInt(3,seats);
            addWaitlistEntry.setTimestamp(4,currentTimestamp);
            addWaitlistEntry.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    public static void cancelWaitlistEntry(String faculty,Date date){
        connection = DBConnection.getConnection();
        try
        {
            cancelWaitlistEntry=connection.prepareStatement("DELETE FROM WAITLIST WHERE FACULTY=? AND DATE=?");
            cancelWaitlistEntry.setString(1,faculty);
            cancelWaitlistEntry.setDate(2,date);
            cancelWaitlistEntry.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        

    }
    public static ArrayList<String> getWaitlistofAllFacultys(){
        connection = DBConnection.getConnection();
        ArrayList<String> faculty = new ArrayList<String>();

        try{
            PreparedStatement getWaitlistofAllFacultys=connection.prepareStatement("SELECT FACULTY FROM WAITLIST");
            resultSet=getWaitlistofAllFacultys.executeQuery();
            while(resultSet.next())
            {
                faculty.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return faculty;
        
    }
    
    

    }

