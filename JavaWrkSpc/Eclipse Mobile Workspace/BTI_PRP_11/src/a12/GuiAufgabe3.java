package a12;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class GuiAufgabe3 {
	/**
	 * @Teamname SingleMalt
	 * 
	 */
	public void guiAufgabe3(ArrayList<Kunde> kList) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Kunden");

		for (int kunde = 0; kunde < kList.size(); kunde++) {
			DefaultMutableTreeNode kunden = new DefaultMutableTreeNode(kList
					.get(kunde).getFirmenname());

			root.add(kunden);

			for (int auftrag = 0; auftrag < kList.get(kunde).auftragliste
					.size(); auftrag++) {

				DefaultMutableTreeNode auftrag1 = new DefaultMutableTreeNode(
						"Auftrag "
								+ kList.get(kunde).auftragliste.get(auftrag)
										.getErteilungsdatum());
				kunden.add(auftrag1);

				for (int i = 0; i < kList.get(kunde).auftragliste.get(auftrag).artikelListe
						.size(); i++) {
					DefaultMutableTreeNode artikel1 = new DefaultMutableTreeNode(
							kList.get(kunde).auftragliste.get(auftrag).artikelListe
									.get(i).getBezeichnung());
					DefaultMutableTreeNode artikel2 = new DefaultMutableTreeNode(
							"Menge:"
									+ kList.get(kunde).auftragliste
											.get(auftrag).artikelListe.get(i)
											.getMenge());
					DefaultMutableTreeNode artikel3 = new DefaultMutableTreeNode(
							"Preis:"
									+ kList.get(kunde).auftragliste
											.get(auftrag).artikelListe.get(i)
											.getPreis());
					DefaultMutableTreeNode sum = new DefaultMutableTreeNode(
							"Preis:"
									+ kList.get(kunde).auftragliste
											.get(auftrag).getSumme());
											
					auftrag1.add(artikel1);
					auftrag1.add(artikel2);
					auftrag1.add(artikel3);
					auftrag1.add(sum);
				}
			}
		}

		JTree tree = new JTree(root);

		frame.add(new JScrollPane(tree));

		frame.pack();
		frame.setVisible(true);

		tree.getSelectionModel().addTreeSelectionListener(
				new TreeSelectionListener() {
					@Override
					public void valueChanged(TreeSelectionEvent e) {
						TreePath path = e.getNewLeadSelectionPath();
						System.out.println(path);
					}
				});

	}
}
