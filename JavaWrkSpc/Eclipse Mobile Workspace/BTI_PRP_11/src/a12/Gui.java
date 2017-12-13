package a12;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gui implements ActionListener {
	/**
	 * @Teamname SingleMalt
	 * 
	 */
	JFrame start = new JFrame();
	JButton button1 = new JButton("Aufgabe1");
	JButton button2 = new JButton("Aufgabe2");
	JButton button3 = new JButton("Aufgabe3");
	Container content2 = new Container();
	GuiAufgabe2 obja2 = new GuiAufgabe2();
	GuiAufgabe3 obja3 = new GuiAufgabe3();
	GuiAufgabe1 obja1 = new GuiAufgabe1();
	ObjectCreater creater = new ObjectCreater();
	ArrayList<Kunde> liste = new ArrayList<Kunde>();

	public void guistart(ArrayList<Kunde> kList) {
		liste = kList;

		ActionListener b2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obja2.aufgabe2gui(liste);
			}

		};

		ActionListener b3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				obja3.guiAufgabe3(liste);
			}

		};

		button1.addActionListener(this);
		button2.addActionListener(b2);
		button3.addActionListener(b3);

		content2.setLayout(new GridLayout(0, 2, 6, 3));
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		content2.add(new JLabel("Aufgabe 1"));
		content2.add(button1);
		content2.add(new JLabel("Aufgabe 2"));
		content2.add(button2);
		content2.add(new JLabel("Aufgabe 3"));
		content2.add(button3);
		start.add(content2);
		start.setVisible(true);
		start.pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		obja1.aufgabe1(liste);

	}

}
