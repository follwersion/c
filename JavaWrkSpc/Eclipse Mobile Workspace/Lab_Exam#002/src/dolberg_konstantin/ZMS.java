package dolberg_konstantin;

import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class ZMS {
	
	Map<String, User> swut;
		
	public ZMS() {
		this.swut = new TreeMap<String, User>();
	}

	public void add(User user) {
		swut.put(user.account, user);
	}
	
	public void del(String acc) throws NonExistingAccountException {	
//			if (swut.remove(acc) == null) {
//				throw new NonExistingAccountException(acc);
		
//			} else {
//			swut.remove(acc);
		
		if (!swut.containsKey(acc)) {
			throw new NonExistingAccountException(acc);
		} else {
			swut.remove(acc);
		}
	}
	
	public int nou() {
		return swut.size();
	}

	public String toString() {
		return String.format("ZMS [swut=\n%s]", swut);
	}
	
	public void printAllUser() {
		for (String s : swut.keySet()) {
			System.out.println(swut.get(s));
		}
	}
	
	public void delPerson(int id) {
		for (int i = 0; i < swut.keySet().size(); i++) {
			if (swut.get(swut.keySet().toArray()[i]).person.id == id) {
				swut.remove(swut.keySet().toArray()[i]);
			}
		}
		
		
//		ArrayList<String> acspeicher = new ArrayList<String>();
//		for(String s : swut.keySet()){
//			if(swut.get(s).person.id==id){
//				acspeicher.add(s);
//			}
//		}
//		for(String temp :acspeicher){
//			swut.remove(temp);
//		}
					
	}
	
	public boolean checkPassword(String account, Password p) throws NonExistingAccountException {
		if (swut.get(account) == null) {
			throw new NonExistingAccountException(account);
		}
		if (swut.get(account).pw.equals(p)) {
		return true;
		} else {
			return false;
		}
	}
	
    public int nop() {   
//    	ArrayList<Person> perSet = new ArrayList<Person>();
//    	for(String a: swut.keySet()){
//    		if(!perSet.contains(swut.get(a).person)){
//    			perSet.add(swut.get(a).person);
//    		}
//    	}
//    	return perSet.size();
    	
        HashSet<Person> temp = new HashSet<Person>();
        for ( String a : swut.keySet() ) {
            temp.add(swut.get(a).person);
        }
        return temp.size();
    }
}