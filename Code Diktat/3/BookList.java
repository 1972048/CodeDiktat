import java.util.ArrayList;
import java.util.List;

public class BookList {
 
    protected List<Book> books;

    public BookList(){
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
    
    public Book searchBook(String isbn){
        for(int i=0;i<books.size();i++){
            if(((Book) books.get(i)).getIsbn().equals(isbn)){
                return ((Book) books.get(i));
            }
        }
        return null;
    }

    public void showAllBooks() {
        if(books.size()==0){
            System.out.printf("No books to show%n");
        }
        else{
            System.out.printf("|%-20s|%-50s|%-20s|%n","ISBN","Title","Author");
            for(int i=0;i<books.size();i++){
                System.out.printf("|%-20s|%-50s|%-20s|%n",books.get(i).getIsbn(),books.get(i).getTitle(),books.get(i).getAuthor());
            }
        }
    }    
}