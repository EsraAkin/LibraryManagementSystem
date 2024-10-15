import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> libraryBooks;
    private List<User> users;

    public Library() {
        libraryBooks = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println(user.getName() + " added to the library system.");
    }

    public void showAvailableBooks() {
        if (libraryBooks.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Available books in the library:");
            for (Book book : libraryBooks) {
                System.out.println(book);
            }
        }
    }

    public List<Book> getLibraryBooks() {
        return libraryBooks;
    }

    public List<User> getUsers() {
        return users;
    }
}
