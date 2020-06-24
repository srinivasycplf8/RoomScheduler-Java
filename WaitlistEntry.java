/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srini
 */
import java.util.Calendar;
import java.sql.*;



/**
 *
 * @author srini
 */
public class WaitlistEntry {
    private String Faculty;
    private Date Date;
    private int Seats;
    private Timestamp currentTimestamp;




        
    public WaitlistEntry(String Faculty,Date Date,int Seats,Timestamp currentTimestamp){
        setFaculty(Faculty);
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
    public void setDate(Date Date){
        this.Date=Date;
    }
    public Date getDate(){
        return Date;
    }
    public void setSeats(int Seats){
        this.Seats=Seats;
    }
    public int getSeats(){
        return Seats;
    }
   
    
}
    
    
}