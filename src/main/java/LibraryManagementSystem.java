import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner input = new Scanner(System.in);

        Admin admin = new Admin("AdminUser");
        User user = new User("Normal User");
        library.addUser(admin);
        library.addUser(user);

        boolean running = true;

        while (running) {
            // Ana menüyü gösterelim
            System.out.println("\nWelcome to the Library System");
            System.out.println("1. Admin: Add a new book");
            System.out.println("2. User: Borrow a book");
            System.out.println("3. User: Return a book");
            System.out.println("4. Show available books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine(); // Satır sonu karakterini temizlemek için

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = input.nextLine();
                    System.out.print("Enter author: ");
                    String author = input.nextLine();
                    System.out.print("Enter year: ");
                    int year = input.nextInt();
                    Book newBook = new Book(title, author, year);
                    admin.addBook(newBook, library.getLibraryBooks());
                    break;

                case 2:
                    // Kullanıcı kitap ödünç alacak
                    library.showAvailableBooks();
                    System.out.print("Enter the title of the book to borrow: ");
                    String borrowTitle = input.nextLine();
                    Book bookToBorrow = findBookByTitle(library.getLibraryBooks(), borrowTitle);
                    if (bookToBorrow != null) {
                        user.borrowBook(bookToBorrow, library.getLibraryBooks());
                    } else {
                        System.out.println("The book is not available.");
                    }
                    break;

                case 3:
                    // Kullanıcı kitap iade edecek
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = input.nextLine();
                    Book bookToReturn = findBookByTitle(user.getBorrowedBooks(), returnTitle);
                    if (bookToReturn != null) {
                        user.returnBook(bookToReturn, library.getLibraryBooks());
                    } else {
                        System.out.println("You don't have this book.");
                    }
                    break;

                case 4:
                    // Kütüphanedeki mevcut kitapları göster
                    library.showAvailableBooks();
                    break;

                case 5:
                    // Programı kapatma seçeneği
                    System.out.println("Exiting the system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    // Kullanıcının girdiği başlığa göre kitabı bulmak için yardımcı metod
    public static Book findBookByTitle(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}