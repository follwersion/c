package dolberg_konstantin.part1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import _untouchable_.Halter_I;
import _untouchable_.KZ_I;
import _untouchable_.MH_I;
import _untouchable_.ZS1_I;

public class ZS implements ZS1_I {
	
	Map<String, MH_I> liste = new TreeMap<String, MH_I>();
	
	public ZS() {
	}

	public void add(MH_I mh) {
		liste.put(mh.getKZ().getKZ(), mh);
	}

	public void clear() {
		liste.clear();
	}

	public Halter_I findHalter(KZ_I kz) {
		Halter_I halter = null;
		for (MH_I mh : liste.values()) {
			if (mh.getKZ().getKZ().equals(kz.getKZ())) {
				halter = mh.getHalter();
			}
		}
		return halter;
	}

	public Map<KZ_I, MH_I> getMAP() {
		Map<KZ_I, MH_I> map = new HashMap<KZ_I, MH_I>();
		for (MH_I mh : liste.values()) {
			map.put(mh.getKZ(), mh);
		}
		return map;
	}

	public int noMH() {
		return liste.size();
	}

	public void printAll() {
		for (MH_I mh : liste.values()) {
			System.out.println(mh);
		}
	}

	public String toString() {
		return String.format("ZS [liste=%s]", liste);
	}	
}