
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// Your code goes here
		return str.substring(1);
		
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		String newWord1 = word1.toLowerCase();
		String newWord2 = word2.toLowerCase();
		if (newWord1.length() == 0) {
			return newWord2.length();
		} else if (newWord2.length() == 0) {
			return newWord1.length();
		} else if (newWord1.charAt(0) == newWord2.charAt(0)) {
			return levenshtein(tail(newWord1), tail(newWord2));
		} else {
			int insert = levenshtein(newWord1, tail(newWord2));
			int delete = levenshtein(tail(newWord1), newWord2);
			int replace = levenshtein(tail(newWord1), tail(newWord2));

			return 1 + Math.min(insert, Math.min(delete, replace));
		}

	}

	

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++) {
			dictionary[i] = in.readString();
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		int min = levenshtein(word, dictionary[0]);
		String minLevWord = "";
		for (int i = 1; i < 3000; i++) {
			if (levenshtein(word, dictionary[i]) < min) {
				min = levenshtein(word, dictionary[i]);
				minLevWord = dictionary[i];
			}
		}
		if (min <= threshold) {
			return minLevWord;
		}
		return word;

	}

}
