import java.util.Scanner;
// Deklarasi kelas
public class WordReverserDemo {
	public static void main(String[] args) {
		// Deklarasi variable
		WordReverser wr;	
		String word,x;
		Scanner scanner = new Scanner(System.in);
		// ===========================================================
		// Sintaks 
		System.out.print("Input kalimat (0 untuk keluar): ");
		word = scanner.nextLine();
		wr = new WordReverser();
		while(!word.equals("0")){
			System.out.println(wr.reverseWord(word));
			System.out.print("Input kalimat (0 untuk keluar): ");
			word = scanner.nextLine();
		}
		return;
	}	
}