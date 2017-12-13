package a09;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Read {
	
	public float numberOfTokens(String text){
		String token = "";
		Map<String, Integer> counterLetter = new TreeMap<String, Integer>();
		int counterToken = 0;
		int tmp = 0;
		Integer anzahl = 1;
		Pattern p = null;
		Matcher m = null;
		
		for (int i = 0; i < text.length(); i++){
			token = text.charAt(i) + "";
			if (!token.equals("_")){
				if (counterLetter.containsKey(token)){
					tmp = counterLetter.get(token);
					counterLetter.remove(token);
					tmp++;
					counterLetter.put(token, tmp);
				}else{
					counterLetter.put(token, anzahl);
				}
			}
		}		
		for (Map.Entry<String, Integer> element : counterLetter.entrySet()){
			System.out.println(element.getKey() + " : " + element.getValue());
			p = Pattern.compile("\\w");
			m = p.matcher(element.getKey());
			if (m.matches()){
				counterToken += element.getValue();
			}	
		}

		return counterToken;
	}


	public float numberOfWords (String text){
		String [] segmentwords = null;
		List<String> wordlist = new ArrayList<String>();

		segmentwords = text.split(" ");		
		for (String word : segmentwords){			
			wordlist.add(word);
			System.out.println(word);
		}		
		return wordlist.size();	
	}
	
	
	public float average(float anzToken, float anzWords){
		float laenge = 0;
		
		laenge = anzToken / anzWords;
		return laenge;
	}	
}