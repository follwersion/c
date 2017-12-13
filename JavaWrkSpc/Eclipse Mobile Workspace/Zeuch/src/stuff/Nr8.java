package stuff;

import java.util.*;

import stuff.gfd.K;
import stuff.gfd.P;

abstract class A {
	abstract void tu();
}

class P extends A {
	char c = 'c';

	P(char c) {
		this.c = c;
	}

	P() {
		new P('p');
	}

	public void tu() {
		System.out.printf("P.tu->%c\n", c);
	}
}

class K extends P {
	char c = 'c';

	K(char c) {
		this.c = c;
	}

	K() {
		new K('k');
	}

	public void tu() {
		System.out.printf("K.tu->%c\n", c);
	}
}

class E extends K {
	char c = 'c';

	E(char c) {
		this.c = c;
	}

	E() {
		new E('e');
	}

	public void tu() {
		System.out.printf("E.tu->%c\n", c);
	}
}

class G extends E {
	char c = 'c';

	G(char c) {
		this.c = c;
	}

	G() {
		new G('g');
	}

	public void tu() {
		System.out.printf("G.tu->%c\n", c);
	}
}

public class Nr8 {
	static void magic(Queue < ? super E > q) {
		q.add(new E('?'));
	}

	public static void main(String[] args) {
		Queue<K> q = new LinkedList<K>();
		magic(q);
		while (!q.isEmpty()) {
			q.poll().tu();
		}
	}
}