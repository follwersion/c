package a03;

import java.util.Scanner;

public class Ostern {

	Scanner sc = new Scanner(System.in);
	
	public float titel() {
		System.out
				.println("Die Gaußsche Osterformel gilt für beliebige Kalenderjahre nach dem Julianischen und dem Gregorianischen Kalender,\n"
						+ "solange die kirchlichen Regeln für die Festlegung des Osterdatums nicht geändert werden.");
		System.out
				.println("===================================================================================================================");
		System.out.println("");

		return (0);
	}
	
	public float Osternberechnen (){
		
	
		
		System.out.println("Für welches Jahr soll das Osterdatum berechnet werden?");
		int Osterjahr = sc.nextInt();
		


	
	
		
			int a = Osterjahr % 19;
			int b = Osterjahr / 100;
			int c = Osterjahr % 100;
			int d = b / 4;
			int e = b % 4;
			int f = (b + 8) / 25;
			int g = ((b - f) + 1) / 3;
			int h = (((a * 19) + b + 15) - d - g) % 30;
			int i = c / 4;
			int j = c % 4;
			int k = ((((e + i) * 2) + 32) - h - j) % 7;
			int l = ((((k * 2) + h) * 11) + a) / 451;
			int m = ((h + k + 114) - (l * 7)) / 31;
			int n = ((h + k + 114) - (l * 7)) % 31;

			int Monat = m;
			int Tag = n + 1;
			System.out.println("Jahr " + Osterjahr + " Ostern am " + Tag
					+ "." + Monat + "." + Osterjahr
					+ " Gregorianisches Datum");
			if (Osterjahr < 1584){

			int JH = Osterjahr / 100;
			int o = JH / 4;
			int p = JH % 4;
			int TD = (3 * o) + p - 2;
			Tag = Tag - TD;

			if (Tag < 1) {
				Monat = Monat - 1;
				Tag = Tag + 31;
				
			}
			System.out.println("Jahr " + Osterjahr + " Ostern am " + Tag
					+ "." + Monat + "." + Osterjahr
					+ " Julianischen Datum\n");

		
			}
		
		
		return(0);
	
}

	public float Osternschleife() {

		for (int Osterjahr = 354; Osterjahr < 2010 ; Osterjahr++) {
				int a = Osterjahr % 19;
				int b = Osterjahr / 100;
				int c = Osterjahr % 100;
				int d = b / 4;
				int e = b % 4;
				int f = (b + 8) / 25;
				int g = ((b - f) + 1) / 3;
				int h = (((a * 19) + b + 15) - d - g) % 30;
				int i = c / 4;
				int j = c % 4;
				int k = ((((e + i) * 2) + 32) - h - j) % 7;
				int l = ((((k * 2) + h) * 11) + a) / 451;
				int m = ((h + k + 114) - (l * 7)) / 31;
				int n = ((h + k + 114) - (l * 7)) % 31;

				int Monat = m;
				int Tag = n + 1;
				System.out.println("Jahr " + Osterjahr + " Ostern am " + Tag
						+ "." + Monat + "." + Osterjahr
						+ " Gregorianisches Datum");
				
				if (Osterjahr < 1584){

				int JH = Osterjahr / 100;
				int o = JH / 4;
				int p = JH % 4;
				int TD = (3 * o) + p - 2;
				Tag = Tag - TD;

				if (Tag < 1) {
					Monat = Monat - 1;
					Tag = Tag + 31;
					
				}
				System.out.println("Jahr " + Osterjahr + " Ostern am " + Tag
						+ "." + Monat + "." + Osterjahr
						+ " Julianischen Datum\n");

			
			}
		}
	
		
			return 0;
			}}
	
	
	