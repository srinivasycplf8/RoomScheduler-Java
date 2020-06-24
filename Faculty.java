
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acv
 */
public class Faculty
{
    private static Connection connection;
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addFaculty;
    private static PreparedStatement getFacultyList;
    private static ResultSet resultSet;
    
    public static void addFaculty(String name)
    {
        try
        {
            addFaculty = connection.prepareStatement("insert into FACULTY (NAME) values (?)");
            addFaculty.setString(1, name);
            addFaculty.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        
    }
    
    public static ArrayList<String> getFacultyList()
    {
        connection = DBConnection.getConnection();
        ArrayList<String> faculty = new ArrayList<String>();
        try
        {
            getFacultyList = connection.prepareStatement("select NAME from FACULTY order by NAME");
            resultSet = getFacultyList.executeQuery();
            
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
