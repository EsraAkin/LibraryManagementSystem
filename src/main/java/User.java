import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks;

    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book, List<Book> libraryBooks) {
        if (libraryBooks.contains(book)) {
            borrowedBooks.add(book);
            libraryBooks.remove(book);
            System.out.println(name + " borrowed " + book.getTitle());
        } else {
            System.out.println("This book is not available.");
        }
    }

    public void returnBook(Book book, List<Book> libraryBooks) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            libraryBooks.add(book);
            System.out.println(name + " returned " + book.getTitle());
        } else {
            System.out.println(name + " does not have this book.");
        }
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getName() {
        return name;
    }
}
