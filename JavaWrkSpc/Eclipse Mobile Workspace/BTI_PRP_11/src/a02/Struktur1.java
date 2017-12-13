package a02;

/**
 * 06.04.09
 * Teamname: SingleMalt
 * @author Konstantin Dolberg
 * @author Lukas Lukowski
 */

public class Struktur1 {

	int[] array;

	public Struktur1(int k) {

		array = new int[(int) Math.pow(2, k)];

		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}

	public int getLinkenNachfolger(int j) {
		if (j >= (array.length / 2)) {

			return 0;

		} else {

			return j << 1;
		}

	}

	public int getRechtenNachfolger(int j) {
		if (j >= (array.length / 2)) {

			return 0;

		} else {

			return (j << 1) + 1;
		}
	}

	public int getVorgaenger(int j) {

		if (j == 1) {

			return 0;

		} else {
			return j >> 1;
		}
	}

	public int getNachbar(int j) {

		if (j == 1) {

			return 0;

		} else {

			return j ^ 1;
		}
	}

	public void inorder(int j) {
		if (j == 0)
			return;
		inorder(getLinkenNachfolger(j));
		visit(j);
		inorder(getRechtenNachfolger(j));
	}

	private void visit(int j) {
		System.out.print(" " + j + " ");
	}

	public void preorder(int j) {
		if (j == 0)
			return;
		visit(j);
		preorder(getLinkenNachfolger(j));
		preorder(getRechtenNachfolger(j));
	}

	public void postorder(int j) {
		if (j == 0)
			return;
		postorder(getLinkenNachfolger(j));
		postorder(getRechtenNachfolger(j));
		visit(j);
	}
}
