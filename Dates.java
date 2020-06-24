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
import java.util.ArrayList;
import java.sql.*;
public class Dates {
        private static Connection connection;
        private static ArrayList<Date> dates = new ArrayList<Date>();
        private static PreparedStatement addDate;
        private static PreparedStatement getAllDates;
        private static ResultSet resultSet;
        
        public static void addDate(Date date){

            connection = DBConnection.getConnection();
            
            try{
                //Date day = Date.valueOf(bookDaysCombo.getSelectedItem().toString());
                //java.util.Date date=new java.util.Date();
                //java.sql.Date sqlDate=new java.sql.Date(date.getTime());
                addDate = connection.prepareStatement("insert into DATE(DATE) values (?)");
                addDate.setDate(1,date);
                addDate.executeUpdate();

            }
            catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
        public static ArrayList<Date> getAllDates(){
            connection = DBConnection.getConnection();
            ArrayList<Date> dates = new ArrayList<Date>();
        try
        {
            getAllDates = connection.prepareStatement("select DATE from DATE order by DATE");
            resultSet = getAllDates.executeQuery();
            
            while(resultSet.next())
            {
                dates.add(resultSet.getDate(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return dates; 
            
        }
 

}
