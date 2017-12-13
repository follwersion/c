package aufgabe2PRP1;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int k = 20;
		Struktur2 variante = new Struktur2(k);
		
		
		for (int i = 0; i < Math.pow(2, k); i++) {
			System.out.println("Index = " + i);
			System.out.println("Vorgänger" + variante.getVorgänger(i));
			System.out.println("Nachbar" + variante.getNachbarn(i));
			System.out.println("Linker Nachfolger" + variante.getLinkenNachfolger(i));
			System.out.println("Rechter Nachfolger" + variante.getRechtenNachfolger(i));
			
		}
		System.out.println("inorder");
		variante.inorder((int)Math.pow(2, k-1));
		System.out.println();
		System.out.println("preorder");
		variante.preorder((int)Math.pow(2, k-1));
		System.out.println();
		System.out.println("postorder");
		variante.postorder((int)Math.pow(2, k-1));
		
		
	}
}
