package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.Exceptions;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			
			System.out.print("Check-in date (dd/MM/yy): ");
			Date checkIn =  sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yy): ");
			sc.nextLine();
			Date checkOut =  sdf.parse(sc.next());
			
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation.toString());
			
			
			System.out.println("\nEnter data to update the reservation: ");
			
			System.out.print("Check-in date (dd/MM/yy): ");
			Date checkInUp =  sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yy): ");
			sc.nextLine();
			Date checkOutUp =  sdf.parse(sc.next());
			
			reservation.updateDate(checkInUp, checkOutUp);
			
			
			System.out.println(reservation.toString());
			
			} catch(ParseException e) {
			System.out.println("Invalid data format");
			
			} catch (Exceptions e) {
			
			System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Room number invalid");
				
			} catch (RuntimeException e) {
				System.out.println("unexpected error");
			}
	
		sc.close();

	}

}
