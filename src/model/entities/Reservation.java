package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.Exceptions;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		if (!checkout.after(checkin)) {
			throw new Exceptions("Error in reservation: Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}


	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDate(Date checkIn, Date checkOut)  {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new Exceptions("Error in reservation: Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new Exceptions("Error in reservation: Check-out date must be after check-in date");
		}
		this.checkin = checkIn;
		this.checkout = checkOut;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Reservation: Room "+ roomNumber+", CheckIn: "+ sdf.format(this.checkin)+", checkOut: "+ sdf.format(this.checkout)
				+", "+ duration()+" nights";
	}
	
}
