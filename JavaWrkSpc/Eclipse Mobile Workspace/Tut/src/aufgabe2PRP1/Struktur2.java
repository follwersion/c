package aufgabe2PRP1;

public class Struktur2 {

	int [] array;
	
	public Struktur2(int k) {
		array = new int[(int)Math.pow(2, k)];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}
	
	public int getVorg�nger(int j) {
		if (j == array.length/2) {
			System.out.println("Es gibt keinen Vorg�nger f�r " + j);
			return 0;
		}
		return array[(j-(j&-j))|((j&-j)<<1)];
	}
	
	public int getLinkenNachfolger(int j){
		if( j % 2 == 0){
			return array[j-((j&-j)>>1)];
		}else{
			return 0;
		}
	}
	
	public int getRechtenNachfolger(int j){
		if( j % 2 == 0){
			return array[j+((j&-j)>>1)];
		}else{
			return 0;
		}
	}
	
	public int getNachbarn(int j){
		if (j == array.length/2) {
			System.out.println("Es gibt keinen Nachbarn f�r " + j);
			return 0;
		}
		return array[j^((j&-j) << 1)];
	}
	
	public void inorder(int j){
		if(j == 0)return;
		inorder(getLinkenNachfolger(j));
		visit(j);
		inorder(getRechtenNachfolger(j));		
	}
	
	private void visit(int j) {
		System.out.print(" " + j + " " );
	}
	
	public void preorder(int j){
		if(j == 0)return;
		visit(j);
		preorder(getLinkenNachfolger(j));		
		preorder(getRechtenNachfolger(j));		
	}
	
	public void postorder(int j){
		if(j == 0)return;		
		postorder(getLinkenNachfolger(j));		
		postorder(getRechtenNachfolger(j));
		visit(j);
	}	
}
