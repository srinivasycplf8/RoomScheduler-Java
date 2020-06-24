/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author srini
 */
public class RoomEntry {
    private String RoomName;
    private int Seats;
    
    public RoomEntry(String RoomName,int Seats){
        setRoomName(RoomName);
    }
    
    public void setRoomName(String RoomName){
        this.RoomName=RoomName;
    }
    
    public String getRoomName(){
        return RoomName;
    }
    
    public void setSeats(int Seats){
        this.Seats=Seats;
    }
    public int getSeats(){
        return Seats;
    }
    
}
