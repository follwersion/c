package a12;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GuiAufgabe1 implements ActionListener {
	/**
	 * @Teamname SingleMalt
	 * 
	 */
	Container content = new Container();
	JTextArea edit0 = new JTextArea();
	JTextArea edit1 = new JTextArea();
	JTextArea edit2 = new JTextArea();
	JTextArea edit3 = new JTextArea();
	JTextArea edit4 = new JTextArea();
	JTextArea edit5 = new JTextArea();
	JTextArea edit6 = new JTextArea();
	JTextArea edit7 = new JTextArea();
	JTextArea edit8 = new JTextArea();
	JTextArea edit9 = new JTextArea();
	JTextArea edit10 = new JTextArea();
	JFrame frame = new JFrame("Aufgabe 12");
	JComboBox box = new JComboBox();
	ObjectCreater obj = new ObjectCreater();
	ArrayList<Kunde> list = new ArrayList<Kunde>();
	
	
	public void aufgabe1(ArrayList<Kunde> kList) {

		list = kList;

		for (int i = 0; i < kList.size(); i++) {
			box.addItem(kList.get(i).getFirmenname());
			box.addActionListener(this);
		}

		content.setLayout(new GridLayout(0, 2, 6, 3));
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content.add(new JLabel("Wählen Sie den Kunden:"));
		content.add(box);
		content.add(new JLabel("Kunden Vorname:"));
		content.add(edit0);
		content.add(new JLabel("Kunden Nachname:"));
		content.add(edit1);
		content.add(new JLabel("Kunden Firmenname :"));
		content.add(edit2);
		content.add(new JLabel("Ort :"));
		content.add(edit3);
		content.add(new JLabel("Postleitzahl :"));
		content.add(edit4);
		content.add(new JLabel("Straße :"));
		content.add(edit5);
		content.add(new JLabel("Hausnummer :"));
		content.add(edit6);
		content.add(new JLabel("Bankname :"));
		content.add(edit7);
		content.add(new JLabel("Kontonummer :"));
		content.add(edit8);
		content.add(new JLabel("Bankleitzahl :"));
		content.add(edit9);
		content.add(new JLabel("Aufträge Anzahl:"));
		content.add(edit10);

		frame.add(content);
		frame.setVisible(true);
		frame.pack();

	}
public ArrayList<Kunde> returnlist(){
	return list;
	
}
	@Override
	public void actionPerformed(ActionEvent e) {

		JComboBox selectedChoice = (JComboBox) e.getSource();
		for (int i = 0; i < list.size(); i++) {
			if (i == selectedChoice.getSelectedIndex()) {
				edit0.setText(list.get(i).getName());
				edit1.setText(list.get(i).getNachname());
				edit2.setText(list.get(i).getFirmenname());
				edit3.setText(list.get(i).getOrt());
				edit4.setText(list.get(i).getPlz());
				edit5.setText(list.get(i).getStreet());
				int tmp = list.get(i).getHausnummer();
				Integer tmpint = new Integer(tmp);
				edit6.setText(tmpint.toString());
				edit7.setText(list.get(i).getBankname());
				int strKonto = list.get(i).getKontonummer();
				Integer tmpKonto = new Integer(strKonto);
				edit8.setText(tmpKonto.toString());
				Integer blz = new Integer(list.get(i).getBlz());
				edit9.setText(blz.toString());
				Integer auftragAnzahl = new Integer(list.get(i).auftragliste
						.size());
				edit10.setText(auftragAnzahl.toString());

			}

		}

	
}}