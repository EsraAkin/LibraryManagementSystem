public class LibraryManagementSystem {
    public static void main(String[] args) {

        // Kütüphane oluştur
        Library library = new Library();

        // Admin ve kullanıcı oluştur
        Admin admin = new Admin("AdminUser");
        User user = new User("Normal User");

        // Kütüphaneye kullanıcı ekle
        library.addUser(admin);
        library.addUser(user);

        // Kitapları oluştur
        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);

        // Admin kitap ekliyor
        admin.addBook(book1, library.getLibraryBooks());
        admin.addBook(book2, library.getLibraryBooks());

        // Kullanıcı kitap ödünç alıyor
        user.borrowBook(book1, library.getLibraryBooks());

        // Kütüphanede kalan kitaplar
        library.showAvailableBooks();

        // Kullanıcı kitabı iade ediyor
        user.returnBook(book1, library.getLibraryBooks());

        // Kütüphanede kalan kitaplar tekrar gösteriliyor
        library.showAvailableBooks();
    }
}