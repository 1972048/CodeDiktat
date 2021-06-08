// Theovanno Tjahyamulia - 1972048
// class no2
public class Book {
    
    private String isbn;
    private String title;
    private String author;

    public Book() {
    }

    public Book(String isbn, String title, String author){
        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
    }

    public String getIsbn(){
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn=isbn;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title) {
        this.title=title;
    }
    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author) {
        this.author=author;
    }



    
}
