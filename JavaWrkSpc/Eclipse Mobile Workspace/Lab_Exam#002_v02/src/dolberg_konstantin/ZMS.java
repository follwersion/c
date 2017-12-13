package dolberg_konstantin;

import java.util.TreeMap;

public class ZMS {
	
	TreeMap<String, User> swut = new TreeMap<String, User>();	
	
	public void add(User u) {
		swut.put(u.account, u);
	}
	
	public void del(String acc) {
		swut.remove(acc);
	}
	
	public int nou() {
		return swut.size();
	}

	public String toString() {
		return String.format("ZMS [swut=%s]", swut);
	}
	
	public void printAllUser() {
		for (String acc : swut.keySet()) {
			System.out.println(swut.get(acc));
		}
	}

	public boolean checkPassword(String account, Password p) {
		if (swut.get(account).pw.equals(p)) {
		return true;
		} else {
			return false;
		}
	}
//	public boolean checkPassword(String account, Password password) {
//			if (swut.get(account).pw.equals(password)) {
//				return true;
//			}		
//		return false;
//	}

	public Object nop() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delPerson(int id) {
		
	}
}
