# RoomScheduler-Java

Created a Room Scheduler using Java, JavaSwing, and SQL.
 
AddFaculty:
 A faculty member is added to the database. The faculty member is identified by the only one name.

ReserveFacultyDateSeats:

 The faculty member will be assigned a room for the requested Date if there are seats available. The rooms will be assigned in a best-fit manner. The faculty member should be assigned the smallest room that has enough seats for their request. If there are no rooms available or no rooms with enough seats available, the faculty member will be put on the waitlist for that Date. The waiting list must be maintained in the order the faculty members tried to reserve their rooms. 

Status Reservations by Date:
 The Status command by Date will display the faculty members that have rooms reserved on that Date. 

Status Waiting List :

The Status command for the Waitlist will display all the Faculty members waiting for rooms. It will be displayed in Date order and then in the order of when the reservation was requested.

AddRoomSeats:
 Add a new Room to the system. The Room name is a string and Seats is the number of seats in the Room. When a room is added, the waitlist must be searched for any faculty waiting for a room for all Dates that rooms are reserved and reserve the room for them and remove them from the waiting list.

Add Date:
 Add a new Date that rooms can be reserved for the system.

CancelReservationFacultyDate:
 The reservation for that Faculty member and Date must be removed from the Room’sreservationsor the waiting list. If the reservation is removed from a room, the waiting list must be checked to determine if another Faculty member can be booked for that room for that Date, checking the number of seat requirements, of course.

Status Faculty member:
 The Status command for a Faculty member will display the Room and Date for each room the Faculty member has reserved and/or is waitlisted for.

Drop Room:
 The Drop command must remove a room from the application. Any faculty members that had this room reserved for any Date will get another room reserved for that Dateif possible, in priority sequence, and the new reservation reported to the user. If the faculty member can not get a new room reserved, the user is informed that the faculty member could not get a new room reserved and that they have been placed on the waitlist.

