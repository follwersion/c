package dolberg_konstantin;

import java.util.ArrayList;

public class Store {
	
	ArrayList<Component> componentList = new ArrayList<Component>();
	
	public boolean add(Component c) {
		componentList.add(c);
		return true;
	}
	
	public void printAllComponents() {
		for (Component c : componentList) {
			System.out.println(c);
		}
	}
	
	public int computeValue() {
		int value = 0;
		for (Component c : componentList) {
			value += c.price;
		}
		return value;		
	}
	
	public void delete(int cnsNo2Delete) throws NonExistingComponentException {
		
		// für die conditions - um zu testen ob cnsNo existiert		
		ArrayList<Integer> cnsTempList = new ArrayList<Integer>();		
		for (Component c : componentList) {
			cnsTempList.add(c.cnsNo);			
		}		
		if ((cnsNo2Delete <= 0 || cnsNo2Delete > componentList.size())) {
			schmeissMeineException("Der Artikel wurde nicht gefunden: ", cnsNo2Delete);
		}
		if (cnsTempList.contains(cnsNo2Delete)) {
			for (Component c : componentList) {
				if (c.cnsNo == cnsNo2Delete) {
					componentList.remove(c);
					System.out.println("\n\n\n***************DELETED:" + c.toString() + "\n\n\n");
					return;
				} 
			}
		} else {
			schmeissMeineException("Der Artikel wurde nicht gefunden: ", cnsNo2Delete);
			}			
	}
	
	public int numOfComponentsInStore() {
		return componentList.size();		
	}

	public String toString() {
		return String.format("Store [componentList=%s]", componentList);
	}
	
	private void schmeissMeineException(String meldung, int cnsNo2Delete) throws NonExistingComponentException {
		throw new NonExistingComponentException(meldung, cnsNo2Delete);
	}
}
