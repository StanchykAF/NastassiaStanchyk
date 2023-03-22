package com.epam.javacourse.hometask3;

import java.util.Objects;

public class Book {
    private String isbn;
    private String name;
    private Author author;
    private Publisher publisher;
    private int publicationDate;
    boolean paperback;

    public Book(String  isbn, String name, Author author, Publisher publisher, int publicationDate, boolean paperback) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.paperback = paperback;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isPaperback() {
        return paperback;
    }

    public void setPaperback(boolean paperback) {
        this.paperback = paperback;
    }

    @Override
    public String toString() {
        return "Book {" +
                "isbn=" + isbn +
                ", name='" + name + '\'' +
                ", " + author +
                ", " + publisher +
                ", publicationDate='" + publicationDate + '\'' +
                ", paperback=" + paperback +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return paperback == book.paperback && isbn.equals(book.isbn) && name.equals(book.name) &&
                author.equals(book.author) && publisher.equals(book.publisher) &&
                publicationDate == book.publicationDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, name, author, publisher, publicationDate, paperback);
    }
}
