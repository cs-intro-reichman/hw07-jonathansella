

public class HashTagTokenizer {

	public static void main(String[] args) {

		//String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		for (int i = 0; i < dictionary.length; i++) {
			System.out.println(dictionary[i]);
		}
		//breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i = 0; i < 3000; i++) {
			dictionary[i] = in.readString();
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		//Your code here
		for (int i = 0; i < dictionary.length; i++) {
			if (word.equals(dictionary[i])){
				return true;
			}		
		}
		 return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		//Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
	return;
        }
		String lowerCase = hashtag.toLowerCase();
        int N = hashtag.length();
        for (int i = 1; i <= N; i++) {
			if (existInDictionary(lowerCase.substring(0, i), dictionary)) {
				System.out.println(lowerCase.substring(0, i));
				breakHashTag(lowerCase.substring(i), dictionary);
				break;
			}
		
        }
    }

}
