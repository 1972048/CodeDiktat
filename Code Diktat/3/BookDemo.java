import java.util.Scanner;

public class BookDemo {
    public static void main(String[] args) {
        // LOCAL VARIABLES DECLARATION
		// ================================================
		Scanner scanner = new Scanner(System.in);
        BookList booklist;
        Book book;
        String isbn,title,author;
        int c;
		// ALGORITHM
		// ================================================
        booklist = new BookList();
        do {
			System.out.printf("-----------------------------------------------%n                Libary Application%n-----------------------------------------------%n1. Show all books%n2. Add new book%n3. Search book%n4. Exit%n-----------------------------------------------%nChoose: ");
            c=scanner.nextInt();
            if(c==1){
                booklist.showAllBooks();
            }
            else if(c==2){
                System.out.printf("New ISBN: ");
                scanner.nextLine();
                isbn = scanner.nextLine();
                System.out.printf("New Title: ");
                title = scanner.nextLine();
                System.out.printf("New Author: ");
                author = scanner.nextLine();
                book = new Book(isbn,title,author);
                booklist.addBook(book);
            }
            else if(c==3){
                System.out.printf("Search (ISBN): ");
                scanner.nextLine();
                isbn = scanner.nextLine();
                if(booklist.searchBook(isbn)!=null){
                    System.out.printf("ISBN:%s%nTitle:%s%nAuthor:%s%n",booklist.searchBook(isbn).getIsbn(),booklist.searchBook(isbn).getTitle(),booklist.searchBook(isbn).getAuthor());
                }
                else{
                    System.out.printf("Book not found%n");
                }
            }
		} while (c!=4);
    }
}
