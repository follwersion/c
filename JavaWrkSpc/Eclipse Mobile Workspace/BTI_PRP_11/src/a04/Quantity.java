package a04;

public class Quantity {

	public String degree(String initial, String target, double value) {

		int tempInitial = (initial.equals("k")) ? 0
				: ((initial.equals("c") ? 1 : ((initial.equals("f") ? 2
						: ((initial.equals("r") ? 3 : 0))))));
		int tempTarget = (target.equals("k")) ? 0 : ((target.equals("c") ? 1
				: ((target.equals("f") ? 2 : ((target.equals("r") ? 3 : 0))))));

		int j = tempInitial;

		while (j != tempTarget) {

			double[] convertArr = { new Conversion().kelvin2Celsius(value),
					new Conversion().celsius2Fahrenheit(value),
					new Conversion().fahrenheit2Reaumur(value),
					new Conversion().reaumur2Kelvin(value) };

			value = convertArr[j];

			j = (j == 3) ? -1 : j;

			j++;
		}

		if (target.equals("k")) {
			target = "Kelvin";
		} else if (target.equals("c")) {
			target = "Celsius";
		} else if (target.equals("f")) {
			target = "Fahrenheit";
		} else if (target.equals("r")) {
			target = "Reaumur";
		}

		return value + "° " + target;
	}

	public String distance(String initial, String target, double value) {

		int tempInitial = (initial.equals("km")) ? 0
				: ((initial.equals("m") ? 1 : ((initial.equals("cm") ? 2
						: ((initial.equals("mm") ? 3 : 0))))));
		int tempTarget = (target.equals("km")) ? 0
				: ((target.equals("m") ? 1 : ((target.equals("cm") ? 2
						: ((target.equals("mm") ? 3 : 0))))));

		int j = tempInitial;

		while (j != tempTarget) {

			double[] convertArr = { new Conversion().km2m(value),
					new Conversion().m2cm(value),
					new Conversion().cm2mm(value),
					new Conversion().mm2km(value) };

			value = convertArr[j];

			j = (j == 3) ? -1 : j;

			j++;

		}

		if (target.equals("km")) {
			target = "Kilometer";
		} else if (target.equals("m")) {
			target = "Meter";
		} else if (target.equals("cm")) {
			target = "Zentimeter";
		} else if (target.equals("mm")) {
			target = "Millimeter";
		}

		return value + " " + target;

	}
	
	public String volume(String initial, String target, double value) {

		int tempInitial = (initial.equals("kl")) ? 0
				: ((initial.equals("l") ? 1 : ((initial.equals("cl") ? 2
						: ((initial.equals("ml") ? 3 : 0))))));
		int tempTarget = (target.equals("kl")) ? 0
				: ((target.equals("l") ? 1 : ((target.equals("cl") ? 2
						: ((target.equals("ml") ? 3 : 0))))));

		int j = tempInitial;

		while (j != tempTarget) {

			double[] convertArr = { new Conversion().km2m(value),
					new Conversion().m2cm(value),
					new Conversion().cm2mm(value),
					new Conversion().mm2km(value) };

			value = convertArr[j];

			j = (j == 3) ? -1 : j;

			j++;

		}

		if (target.equals("kl")) {
			target = "Kiloliter";
		} else if (target.equals("l")) {
			target = "Liter";
		} else if (target.equals("cl")) {
			target = "Zentiliter";
		} else if (target.equals("ml")) {
			target = "Milliliter";
		}

		return value + " " + target;

	}

	public String mass(String initial, String target, double value) {

		int tempInitial = (initial.equals("kg")) ? 0
				: ((initial.equals("g") ? 1 : ((initial.equals("cg") ? 2
						: ((initial.equals("mg") ? 3 : 0))))));
		int tempTarget = (target.equals("kg")) ? 0
				: ((target.equals("g") ? 1 : ((target.equals("cg") ? 2
						: ((target.equals("mg") ? 3 : 0))))));

		int j = tempInitial;

		while (j != tempTarget) {

			double[] convertArr = { new Conversion().km2m(value),
					new Conversion().m2cm(value),
					new Conversion().cm2mm(value),
					new Conversion().mm2km(value) };

			value = convertArr[j];

			j = (j == 3) ? -1 : j;

			j++;

		}

		if (target.equals("kg")) {
			target = "Kilogramm";
		} else if (target.equals("g")) {
			target = "Gramm";
		} else if (target.equals("cg")) {
			target = "Zentigramm";
		} else if (target.equals("mg")) {
			target = "Milligramm";
		}

		return value + " " + target;

	}
	
	public String time(String initial, String target, double value) {

		int tempInitial = (initial.equals("t")) ? 0
				: ((initial.equals("std") ? 1 : ((initial.equals("min") ? 2
						: ((initial.equals("sek") ? 3 : 0))))));
		int tempTarget = (target.equals("t")) ? 0
				: ((target.equals("std") ? 1 : ((target.equals("min") ? 2
						: ((target.equals("sek") ? 3 : 0))))));

		int j = tempInitial;

		while (j != tempTarget) {

			double[] convertArr = { new Conversion().t2std(value),
					new Conversion().std2min(value),
					new Conversion().min2sek(value),
					new Conversion().sek2t(value) };

			value = convertArr[j];

			j = (j == 3) ? -1 : j;

			j++;

		}

		if (target.equals("t")) {
			target = "Tag(e)";
		} else if (target.equals("std")) {
			target = "Stunde(n)";
		} else if (target.equals("min")) {
			target = "Minute(n)";
		} else if (target.equals("sek")) {
			target = "Sekunde(n)";
		}

		return value + " " + target;

	}
	
}
