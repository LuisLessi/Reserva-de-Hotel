package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		
		System.out.print("Check-in date (dd/MM/yy): ");
		Date checkIn =  sdf.parse(sc.next());
		
		System.out.print("Check-out date (dd/MM/yy): ");
		sc.nextLine();
		Date checkOut =  sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
		
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println(reservation.toString());
		
		
		System.out.println("\nEnter data to update the reservation: ");
		
		System.out.print("Check-in date (dd/MM/yy): ");
		checkIn =  sdf.parse(sc.next());
		
		System.out.print("Check-out date (dd/MM/yy): ");
		sc.nextLine();
		checkOut =  sdf.parse(sc.next());
		
		String error = reservation.updateDate(checkIn, checkOut);
		
		if (error == null) {
			System.out.println(reservation.toString());
		} else {
			System.out.println(reservation.updateDate(checkIn, checkOut));
		}
		}
		sc.close();

	}

}
