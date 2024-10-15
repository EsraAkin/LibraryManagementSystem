import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Kitap ödünç alma işlemi
    public void borrowBook(Book book, List<Book> libraryBooks) {
        if (libraryBooks.contains(book)) {
            borrowedBooks.add(book);
            libraryBooks.remove(book);  // Kitap kütüphaneden kaldırılıyor
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is not available.");
        }
    }

    // Kitap iade etme işlemi
    public void returnBook(Book book, List<Book> libraryBooks) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            libraryBooks.add(book);  // Kitap tekrar kütüphaneye ekleniyor
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println(name + " did not borrow this book.");
        }
    }

    public void showBorrowedBooks() {
        System.out.println(name + " borrowed the following books:");
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }

    public String getName() {
        return name;
    }
}
