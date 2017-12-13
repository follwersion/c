package part1;

import java.util.ArrayList;

public class Store {
	
	ArrayList<Component> componentList = new ArrayList<Component>();

	public void add(Component c) {
		componentList.add(c);
	}

	public void printAllComponents() {
		for (Component i  : componentList) {
			System.out.println(i);
		}				
	}
	
	public int computeValue() {
		int count = 0;
		for (int i = 0; i <= componentList.size()-1; i++) {
			count += componentList.get(i).price;
		}
		return count;
	}
	
	public void delete(int delNo) throws NonExistingComponentException {
		try {
			componentList.remove(delNo - 1);
		} catch (IndexOutOfBoundsException e) {
			throw new NonExistingComponentException(delNo);
		}
	}
	
	public int numOfComponentsInStore() {
		return componentList.size();
		}

	
	public String toString() {
		return String.format("Store [componentList=%s]", componentList);
	}
}