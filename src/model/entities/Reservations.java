package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservations {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservations(Integer roomNumber, Date checkIn, Date checkOut) {
		exceptionIfs(checkIn, checkOut);
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCeckOut() {
		return checkIn;
	}

	public Long duration() {
		long time = this.checkOut.getTime() - this.checkIn.getTime();
		return TimeUnit.DAYS.convert(time, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		exceptionIfs(checkIn, checkOut);
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public void exceptionIfs(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.after(checkOut))
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		if(checkIn.before(now))
			throw new DomainException("Error in reservation: Reservation dates must be future dates");
	}

	@Override
	public String toString()  {
		return 	"Reservation: Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut) + ", " + duration() + " nights";
	}
}
