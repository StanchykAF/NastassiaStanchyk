package com.epam.javacourse.hometask3;

public class Library {

    public static void main(String[] args) {
        Author[] authors = {
                new Author(1, "Andrzej", "Sapkowski"),
                new Author(2, "Андрусь", "Горват"),
                new Author(3, "Ozturk", "Kayikci"),
                new Author(4, "Александр", "Панчин")
        };
        Publisher[] publishers = {
                new Publisher(1, "Supernowa", "Warszawa"),
                new Publisher(2, "Медысонт", "Минск"),
                new Publisher(3, "Yuksek Isler", "Istanbul"),
                new Publisher(4, "АСТ", "Москва")
        };
        Book[] books = {
                new Book("978-83-7578-063-5",
                        "Wiedzmin. Ostatnie zyczenie",
                        authors[0],
                        publishers[0],
                        2014,
                        true),
                new Book("978-83-7578-064-2",
                        "Wiedzmin. Miecz przeznaczenia",
                        authors[0],
                        publishers[0],
                        2014,
                        true),
                new Book("978-985-7261-49-9",
                        "Радзива Прудок",
                        authors[1],
                        publishers[1],
                        2021,
                        true),
                new Book("978-605-85769-1-9",
                        "A rock climbing guide to Antalya",
                        authors[2],
                        publishers[2],
                        2018,
                        true),
                new Book("978-5-17-982690-3",
                        "Защита от темных искусств",
                        authors[3],
                        publishers[3],
                        2018,
                        false)
        };
        filter(books, false);
    }

    public static void filter(Book[] books, int publicationDate) {
        for (Book book : books) {
            if(book.getPublicationDate() == publicationDate) {
                System.out.println(book);
            }
        }
    }

    public static void filter(Book[] books, String isbnOrName) {
        for (Book book : books) {
            if((book.getIsbn().equals(isbnOrName)) || (book.getName().equals(isbnOrName))) {
                System.out.println(book);
            }
        }
    }

    public static void filter(Book[] books, Author author) {
        for (Book book : books) {
            if(book.getAuthor().equals(author)) {
                System.out.println(book);
            }
        }
    }

    public static void filter(Book[] books, Publisher publisher) {
        for (Book book : books) {
            if(book.getPublisher().equals(publisher)) {
                System.out.println(book);
            }
        }
    }

    public static void filter(Book[] books, boolean paperback) {
        for (Book book : books) {
            if((book.isPaperback() && paperback) || (!book.isPaperback() && !paperback)) {
                System.out.println(book);
            }
        }
    }
}
