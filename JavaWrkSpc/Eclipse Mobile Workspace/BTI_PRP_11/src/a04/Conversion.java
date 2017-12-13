package a04;

public class Conversion {

		public double kelvin2Celsius(double i) {

			return i - 273.15;
			
		}

		public double celsius2Fahrenheit(double i) {

			return i * 1.8 + 32;

		}

		public double fahrenheit2Reaumur(double i) {

			return (i - 32) / 2.25;

		}

		public double reaumur2Kelvin(double i) {

			return i * 1.25 + 273.15;

		}
		
		public double km2m(double i) {

			return i * 1000;

		}
		
		public double m2cm(double i) {

			return i * 100;

		}
		
		public double cm2mm(double i) {

			return i * 10;

		}
		
		public double mm2km(double i) {

			return i / 1000000;

		}
		
		public double t2std(double i) {

			return i * 24;

		}
		
		public double std2min(double i) {

			return i * 60;

		}
		
		public double min2sek(double i) {

			return i * 60;

		}

		public double sek2t(double i) {

			return i / 86.400;

		}
	
}
