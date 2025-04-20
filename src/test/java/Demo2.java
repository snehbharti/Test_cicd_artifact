import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Demo2 {
	
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

		al.sort(Map.Entry.comparingByKey());
		
		System.out.println((al));
	}

}
