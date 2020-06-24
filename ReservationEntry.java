/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srini
 */
import java.sql.*;
//import java.util.Calendar;
public class ReservationEntry {
    
    private String Faculty;
    private String Room;
    private Date Date;
    private int Seats;
    private Timestamp currentTimestamp;
    
    
    public ReservationEntry(String Faculty,String Room,Date Date,int Seats,Timestamp currentTimestamp){
        setFaculty(Faculty);
        setRoom(Room);
        setDate(Date);
        setSeats(Seats);
        setTimestamp(currentTimestamp);
    }
    public void setFaculty(String Faculty){
        this.Faculty=Faculty;
    }
    public String getFaculty(){
        return Faculty;
    }
    public void setTimestamp(Timestamp currentTimestamp){
        this.currentTimestamp=currentTimestamp;
    }
    public Timestamp getTimestamp(){
        return currentTimestamp;
    }
    public void setRoom(String Room){
        this.Room=Room;
    }
    public String getRoom(){
        return Room;
    }
    public void setSeats(int Seats){
        this.Seats=Seats;
    }
    public int getSeats(){
        return Seats;
    }
    
    public void setDate(Date Date){
        this.Date=Date;
    }
    public Date getDate(){
        return Date;
    }
    
    
}
