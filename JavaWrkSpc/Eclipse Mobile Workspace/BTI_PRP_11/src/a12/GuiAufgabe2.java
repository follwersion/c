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

public class GuiAufgabe2 {
	/**
	 * @Teamname SingleMalt
	 * 
	 */
	JFrame a2 = new JFrame("Aufgabe 2");
	Container content = new Container();
	JComboBox box1 = new JComboBox();

	JComboBox box2 = new JComboBox();
	JComboBox box3 = new JComboBox();
	JTextArea bezeichnung = new JTextArea();
	JTextArea menge = new JTextArea();
	JTextArea preis = new JTextArea();
	JTextArea wert = new JTextArea();
	ArrayList<Kunde> list = new ArrayList<Kunde>();
	boolean vorhanden = false;
	boolean vorhanden2=false;
	int wahlbox1;
	int wahlbox2;
	

	public void aufgabe2gui(ArrayList<Kunde> kList) {
		list = kList;
		for (int i = 0; i < kList.size(); i++) {
			box1.addItem(kList.get(i).getFirmenname());
		}

		ActionListener actionbox1 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JComboBox selectedChoice = (JComboBox) e.getSource();

				wahlbox1 = selectedChoice.getSelectedIndex();

				for (int i = 0; i < list.get(wahlbox1).auftragliste.size(); i++) {

					if (vorhanden == false) {
						box2.addItem(list.get(wahlbox1).auftragliste.get(i)
								.getErteilungsdatum());
					}
					int vergleich = list.get(wahlbox1).auftragliste.size() - 1;

					if (i == vergleich) {
						vorhanden = true;

					}

				}
			}
			

		};

		ActionListener actionbox2 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox selectedChoice = (JComboBox) e.getSource();
				wahlbox2 = selectedChoice.getSelectedIndex();
				
				for (int i =0;i<list.get(wahlbox1).auftragliste.get(wahlbox2).artikelListe.size();i++){
					if (vorhanden2 ==false){
					box3.addItem(list.get(wahlbox1).auftragliste.get(wahlbox2).artikelListe.get(i).getBezeichnung());
				}
				int vergleich = list.get(wahlbox1).auftragliste.get(wahlbox2).artikelListe.size()-1;
				if (i==vergleich){
					vorhanden2 = true;
				}
				
				
				}
				
			}

		};

		ActionListener actionbox3 = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox selectedChoice = (JComboBox) e.getSource();
				int wahlbox3 = selectedChoice.getSelectedIndex();
				
//				for (int i =0;i<list.get(wahlbox1).auftragliste.get(wahlbox2).artikelListe.size();i++){
//					if (vorhanden2 ==false){
					bezeichnung.setText(list.get(wahlbox1).auftragliste.get(wahlbox2).artikelListe.get(wahlbox3).getBezeichnung());
					Integer amenge = new Integer(list.get(wahlbox1).auftragliste.get(wahlbox2).artikelListe.get(wahlbox3).getMenge());
					menge.setText(amenge.toString());
					Float aPreis = new Float(list.get(wahlbox1).auftragliste.get(wahlbox2).artikelListe.get(wahlbox3).getPreis());
					preis.setText(aPreis.toString());
					Float aWert = new Float (list.get(wahlbox1).auftragliste.get(wahlbox2).getSumme());
					wert.setText(aWert.toString());
//				}
				
				
				
				
				
				
				
				// Integer m = new
				// Integer(list.get(0).auftragliste.get(0).artikelListe.get(0).getMenge());
				// menge.setText(m.toString());
				// Float p = new
				// Float(list.get(0).auftragliste.get(0).artikelListe.get(0).getPreis());
				// preis.setText(p.toString());
				// Float w = new
				// Float(list.get(0).auftragliste.get(0).getSumme());
				// wert.setText(w.toString());

			}

		};

		box1.addActionListener(actionbox1);
		box2.addActionListener(actionbox2);
		box3.addActionListener(actionbox3);

		content.setLayout(new GridLayout(0, 2, 6, 3));

		content.add(new JLabel("Wählen Sie den Kunden:"));
		content.add(box1);
		content.add(new JLabel("Wählen Sie einen Auftrag:"));
		content.add(box2);
		content.add(new JLabel("Wählen Sie einen Artikel:"));
		content.add(box3);
		content.add(new JLabel("Artikel Bezeichnung"));
		content.add(bezeichnung);
		content.add(new JLabel("Artikel Menge"));
		content.add(menge);
		content.add(new JLabel("Preis pro Artikel"));
		content.add(preis);
		content.add(new JLabel("Gesamt Preis"));
		content.add(wert);

		a2.add(content);
		a2.setVisible(true);
		a2.pack();

	}

}
