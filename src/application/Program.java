package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservations;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			Integer roomNumber = sc.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(sc.next());
			Reservations reservations = new Reservations(roomNumber, checkIn, checkOut);
			System.out.println(reservations);
			
			System.out.println("\nEnter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			reservations.updateDates(checkIn, checkOut);
			System.out.println(reservations);	
		} 
		catch (ParseException e) {
			System.out.println("PE");
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println(e.getLocalizedMessage());
		}
		sc.close();
	}
}
