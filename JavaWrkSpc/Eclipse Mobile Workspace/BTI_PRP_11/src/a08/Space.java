package a08;

import java.io.File;

public class Space {
	

	/**
	 * @author Lukas Lukowski Konstantin Dolberg
	 * Datum 18.05.09
	 * Aufgabe 8
	 */
	
	
	File file = new File("/");
//	File[] file = File.listRoots();

	long freeSpace;
	long totalSpace;
	long usedSpace;
	
	

	public void output() {

		System.out.println("Directory\t\t\tCapacity\tUsed Space\tFree Space");
		System.out.println(file + "\t\t\t\t" + totalSpace + "MB" + "\t\t"
				+ usedSpace + "MB" + "\t\t" + freeSpace + "MB");

	}

	public void freespace() {
		try {
			freeSpace = file.getFreeSpace();
			freeSpace = freeSpace / 1024 / 1024;
		} catch (Exception e) {
			System.err.print("Fehler aufgetreten!");

		}

	}

	public void totalspace() {
		totalSpace = file.getTotalSpace();
		totalSpace = totalSpace / 1024 / 1024;

	}

	public void usedspace() {
		usedSpace = file.getTotalSpace() - file.getFreeSpace();
		usedSpace = usedSpace / 1024 / 1024;

	}

}
