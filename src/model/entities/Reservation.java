package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
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
	
	public String updateDate(Date checkIn, Date checkOut) {
		if (this.checkin.after(checkIn) || this.checkout.after(checkOut)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		if (checkOut.before(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date";
		}
		this.checkin = checkIn;
		this.checkout = checkOut;
		return null;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "Reservation: Room "+ roomNumber+", CheckIn: "+ sdf.format(this.checkin)+", checkOut: "+ sdf.format(this.checkout)
				+", "+ duration()+" nights";
	}
	
}
