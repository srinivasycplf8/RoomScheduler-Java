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
import java.util.*;
import java.sql.*;

public class RoomQueries {

    //****ADD USERNAME,BLA**********************

    private static Connection connection;

    private static PreparedStatement getAllPossibleRooms;
    private static PreparedStatement addRoom;
    private static PreparedStatement dropRoom;
    private static PreparedStatement getRooms;
    private static ResultSet resultSet;

     public static ArrayList<String>getAllPossibleRooms(int seats) {
        connection = DBConnection.getConnection();
        ArrayList<String> room = new ArrayList<>();
        try {
            getAllPossibleRooms = connection.prepareStatement("select name from ROOMS where seats >= ? order by seats");
            getAllPossibleRooms.setInt(1, seats);
            resultSet = getAllPossibleRooms.executeQuery();
            while (resultSet.next()) {
                room.add(resultSet.getString("NAME"));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return room;
    }
     public static ArrayList<String>getAllRooms() {
        connection = DBConnection.getConnection();
        ArrayList<String> all_rooms = new ArrayList<>();
        try {
            PreparedStatement getAllRooms = connection.prepareStatement("select name from ROOMS");
            resultSet = getAllRooms.executeQuery();
            while (resultSet.next()) {
                all_rooms.add(resultSet.getString("NAME"));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return all_rooms;
    }
    
    public static ArrayList<Integer> getallseats(){
        connection = DBConnection.getConnection();
        ArrayList<Integer> rooms = new ArrayList<Integer>();
        try {
            getRooms = connection.prepareStatement("SELECT SEATS FROM ROOMS");
            resultSet = getRooms.executeQuery();
            while (resultSet.next()) {
                rooms.add(resultSet.getInt("SEATS"));
            }        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return rooms;
        
    }

    public static void addRoom(String RN, int seatTotal) {
        connection = DBConnection.getConnection();
        try {
            addRoom = connection.prepareStatement("insert into ROOMS (NAME,SEATS) values (?,?)");
            addRoom.setString(1, RN);
            addRoom.setInt(2, seatTotal);
            addRoom.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public static void dropRoom(String RN) {
        connection = DBConnection.getConnection();
        try {
            dropRoom = connection.prepareStatement("DELETE FROM ROOMS WHERE NAME=?");
            dropRoom.setString(1,RN);
            dropRoom.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public static String getRoomForSeats(int seats) {

        connection = DBConnection.getConnection();
        String result="";
        try {
            PreparedStatement getRoomForSeats = connection.prepareStatement("SELECT NAME FROM ROOMS WHERE SEATS=?");
            getRoomForSeats.setInt(1, seats);
            ResultSet resultset = getRoomForSeats.executeQuery();
            while (resultset.next()) {
                result=resultset.getString("NAME");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return result;
    }

    public static int getCapacityForRooms(String roomName) {
        int result=0;
        connection = DBConnection.getConnection();
        try{
            PreparedStatement getCapacityForRooms = connection.prepareStatement("SELECT SEATS FROM ROOMS WHERE NAME=?");
            getCapacityForRooms.setString(1, roomName);
            ResultSet resultSet = getCapacityForRooms.executeQuery();
            while (resultSet.next()){
                result = resultSet.getInt("SEATS");
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public static ArrayList<String> getRooms() {
        connection = DBConnection.getConnection();
        ArrayList<String> rooms = new ArrayList<String>();
        try {
            getRooms = connection.prepareStatement("SELECT NAME FROM ROOMS");
            resultSet = getRooms.executeQuery();
            while (resultSet.next()) {
                rooms.add(resultSet.getString("NAME"));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return rooms;
    }

    public static ArrayList<Integer> getSeatsForUn(List<String> unreservedList) {
        connection = DBConnection.getConnection();
        ArrayList<Integer> unseats = new ArrayList<Integer>();
        try {

            for (String i : unreservedList) {
                PreparedStatement getSeatsForUn = connection.prepareStatement("SELECT SEATS FROM ROOMS WHERE NAME=?");
                getSeatsForUn.setString(1, i);
                try (ResultSet resultSet = getSeatsForUn.executeQuery();) {
                    resultSet.next();
                    unseats.add(resultSet.getInt("SEATS"));
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return unseats;

    }

}
