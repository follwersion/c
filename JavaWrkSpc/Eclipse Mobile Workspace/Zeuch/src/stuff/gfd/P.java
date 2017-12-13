package stuff.gfd;

class P extends K {
	int x = 7;
	P() {
	System.out.println(super.x);
	System.out.println(super.toString());
	System.out.println(((Q)this).x);
	System.out.println(((K)(Q)this).x);
	System.out.println((Q)this);
	}
	public String toString() {return "P";}
	}