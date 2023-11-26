package t.pkg11;

import t.pkg10.Books;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Books> booksList;

    public Admin() {
        this.booksList = new ArrayList<>();
    }

    public void addBook(Books book) {
        booksList.add(book);
    }

    public Books searchBook(int ISBN) {
        for (Books book : booksList) {
            if (book.getISBN() == ISBN) {
                return book;
            }
        }
        return null;
    }

    public List<Books> listBooks() {
        return booksList;
    }
}