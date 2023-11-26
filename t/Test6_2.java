package t;

import t.pkg10.Books;
import t.pkg11.Admin;
import t.pkg12.User;

import java.util.List;
import java.util.Scanner;

public class Test6_2 {1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();

        while (true) {
            System.out.println("Library Information System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. List Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    int isbn = scanner.nextInt();
                    Books newBook = new Books(title, author, isbn);
                    admin.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter ISBN to search for a book: ");
                    int searchISBN = scanner.nextInt();
                    Books foundBook = admin.searchBook(searchISBN);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    List<Books> booksList = admin.listBooks();
                    if (booksList.isEmpty()) {
                        System.out.println("No books in the library.");
                    } else {
                        System.out.println("List of Books in the Library:");
                        for (Books book : booksList) {
                            System.out.println(book);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

