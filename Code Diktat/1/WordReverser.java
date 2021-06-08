// Deklarasi kelas
public class WordReverser {
	// Deklarasi variable
	String word,reverse;
	// ===========================================================
	// Method
	String reverseWord(String word){
		word=word.trim();
		reverse="";
		char[] temp=word.toCharArray();
		for (int i = temp.length - 1; i >= 0; i--) {
			 reverse += temp[i];
		}
		return reverse;
	}
}