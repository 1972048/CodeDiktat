import java.util.Scanner;
public class TimeConverterDemo {
	public static void main(String[] args) {
		// LOCAL VARIABLES DECLARATION
		// ================================================
		TimeConverter tc;
		int n;
		Scanner scanner = new Scanner(System.in);
		// ALGORITHM
		// ================================================
		tc = new TimeConverter(0);
		do{
			System.out.printf("Input time (second, 0 to exit): ");
			n=scanner.nextInt();
			tc.setSecond(n);
			if(n!=0){
			    System.out.println(tc.showTime());
			}
		}
		while(n!=0);
		return;
	}	
}