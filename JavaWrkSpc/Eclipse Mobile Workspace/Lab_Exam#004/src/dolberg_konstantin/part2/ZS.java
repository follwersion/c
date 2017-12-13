package dolberg_konstantin.part2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import _untouchable_.Halter_I;
import _untouchable_.KZ_I;
import _untouchable_.MH_I;
import _untouchable_.ZS1_I;
import _untouchable_.ZS2_I;

public class ZS implements ZS2_I {
	
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

	public Set<KZ_I> findKZ(Halter_I h) {
		Set<KZ_I> kzSet = new TreeSet<KZ_I>();
		for (MH_I mh : liste.values()) {
			if (mh.getHalter().equals(h)) {
				kzSet.add(mh.getKZ());
			}
		}
		return kzSet;
	}	
}