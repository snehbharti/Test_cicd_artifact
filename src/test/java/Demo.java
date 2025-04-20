import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Demo {

	public static void main(String[] args) {
		String s = "My name is sneh bharti ,I Am foodiE, aa A I have umbrella";
		char[] ch = s.toCharArray();

		HashMap<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < ch.length; i++) {

			if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u') {

				if (hm.containsKey(ch[i])) {
					int count = hm.get(ch[i]);
					hm.put(ch[i], count + 1);
				} else {
					hm.put(ch[i], 1);
				}

			}
			if (ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U') {

				if (hm.containsKey(ch[i])) {
					int count = hm.get(ch[i]);
					hm.put(ch[i], count + 1);
				} else {
					hm.put(ch[i], 1);
				}

			}

		}
		System.out.println(hm);

		ArrayList<Map.Entry<Character, Integer>> al = new ArrayList<>(hm.entrySet());

		al.sort(Map.Entry.comparingByValue());
		System.out.println((al)); // [A=1, E=1, u=1, I=2, o=2, i=3, a=4, e=4] ----->a. Answer in arralist

		LinkedHashMap<Character, Integer> hmFinal = new LinkedHashMap<>();

		for (Entry<Character, Integer> a : al) {
			hmFinal.put(a.getKey(), a.getValue());
		}
		System.out.println(hmFinal);// {A=1, E=1, u=1, I=2, o=2, i=3, a=4, e=4} ------> b. Answer in hashmap

	}

}
