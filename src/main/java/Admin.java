import java.util.List;

public class Admin extends User {
    public Admin(String name) {
        super(name);  // User class'ının constructor'ını çağırıyoruz
        }

    //Kütüphaneye kitap ekleme metodu

    public void addBook(Book book, List<Book> libraryBooks){
        libraryBooks.add(book);
        System.out.println(book.getTitle() + " added to the library by " + getName());

    }


}
