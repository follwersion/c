package a08;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class List {

	/**
	 * @author Lukas Lukowski Konstantin Dolberg Datum 18.05.09 Aufgabe 8
	 */

	private static File[] tree; 

	public static File[] listRoots(){
		return tree =File.listRoots();
		
	}
	

	public void sort() {
		Arrays.sort(tree);
	}

	public  void showall() {
		

		System.out.println("Date\t\t\t\tFile\t\t\t\tSize");
		System.out
				.println("_________________________________________________________________________");
		for (File f : tree) {
			if (f.canRead() == false) {
				System.out.println("Access Denied: " + f.getName());

			}

			System.out.print(new Date(f.lastModified()) + "\t");

			if (f.isFile()) {
				System.out.print(".");
			}

			{
				System.out.println(f.getName() + "\t\t\t\t" + f.length() / 1024
						+ "kB");

			}

			treeWalk(f);

		}
	}

	private void treeWalk(File file) {
		if (file.isDirectory() && file.canRead()) {
			File[] children = file.listFiles();
			for (int i = 0; i < children.length; i++) {
				treeWalk(children[i]);
			}
		} else {

			System.out.print(new Date(file.lastModified()) + "\t");
			if (file.isFile()) {
				System.out.print(".");
			}
			System.out.print(file.getPath() + "\t");
			System.out.print(file.length() + "byte");
			System.out.print("\n");

		}

	}
}