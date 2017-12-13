package ti1prp_.aufgabe10;
import java.util.*;
public class ShortWordCounter {
	public static void main(String[] args) {
		HashMap<String,Integer> map;
		List<String> keys;
		WordGrabber wg;
		String str;
		try{
            wg = new WordGrabber("C:\\pmars13.txt");
            map = new HashMap<String,Integer>();
            while(wg.hasNext()){
                str = wg.getNext().toLowerCase();
                if(map.get(str) != null) map.put(str, map.get(str).intValue() + 1);
                else map.put(str, 1);
            }
            keys = new ArrayList<String>(map.keySet());
            Collections.sort(keys);
            for(int i = 0; i < keys.size(); i++)
                System.out.printf("[ %s ] : %d\n", keys.get(i), map.get(keys.get(i)));
        }
        catch(Exception e){ System.out.println(e);}
    }
}
