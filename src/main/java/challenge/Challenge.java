package challenge;

import java.util.HashMap;
import java.util.Map;

public class Challenge {
	
	private String words;
	private Integer wordCount;
	private int maxValue;
	
	public Challenge(String words, Integer wordCount){
		
		this.words = words;
		this.wordCount = wordCount;
	}
	
	public void startChallenge(){
		
		if(words == null || words.isEmpty() || wordCount == null || wordCount <= 0){
			return;
		}	
		performChallenge();
	}

	private void performChallenge() {
		Map<String, Integer> wordMap = getfrequencyMap();
		
		//create a array hash wordcount -> Integer -> String
		//Sorting a Collection will be O(plogp) where p = no of words. not sure if O(plogp) < O(n)
		//since there is no space constraint only time constraint we create reverse hash
		//We know for sure that O(p) < O(n).
		
		CustomList[] reverseWordMap =  getReverseWordMap(wordMap);
		
		CustomList wordList = new CustomList();
		for(int i = reverseWordMap.length - 1; i > 0; i--){
			CustomList l = reverseWordMap[i];
			if(l != null){
				wordList.addList(l);
				if(wordList.getSize() >= wordCount){
					break;
				}
			}
		}
		
		wordList.printList(wordCount);
	}

	private CustomList[] getReverseWordMap(
			Map<String, Integer> wordMap) {
		CustomList[] reverseMap = new CustomList[maxValue + 1];
		for(String key : wordMap.keySet()){
			 Integer value = wordMap.get(key);
			 CustomList wordList = reverseMap[value];
			 if(wordList != null){
				 wordList.add(key);
				 reverseMap[value] = wordList;
			 } else {
				 wordList = new CustomList();
				 wordList.add(key);
				 reverseMap[value] = wordList;
			 }
		}
		return reverseMap;
	}

	private Map<String, Integer> getfrequencyMap() {
		
		maxValue = 0;
		//assuming words are seperated using space
		//scan the entire String to create the hash map O(n) n-> no of characters
		Map<String,Integer> wordMap =  new HashMap<String,Integer>();
		StringBuilder sb =  new StringBuilder();
		for(int i = 0; i < words.length(); i++){
			if( words.charAt(i) == ' ' && (i+1 < words.length() && words.charAt(i+1) == ' ')){
				continue;
			} else if (words.charAt(i) == ' ' || i == words.length()-1) {
				//we got a word
				
				//special case for last word
				if(i == words.length()-1){
					sb.append(words.charAt(i));
				}
				
				String s = sb.toString();
				if(s.isEmpty()){
					continue;
				}
				if(wordMap.containsKey(s)){
						Integer mapCount = wordMap.get(s);
						if (mapCount + 1 > maxValue){
							maxValue = mapCount + 1;
						}
						wordMap.put(s , mapCount + 1);
				} else {
					if(maxValue == 0){
						maxValue = 1;
					}
					wordMap.put(s , 1);
				}
				//amortized constant time preparing for next set.
				sb.delete(0, sb.length());
			} else {
				sb.append(words.charAt(i));	
			}
		}
		
		return wordMap;
	}



}
