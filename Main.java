package com.teamtreehouse.lambdas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Exploring the differences between Anonymous Inline Classes
// and Lambdas which are a new feature of Java as of 8(?) 
// Part of a teamtreehouse course on Java Development
//
// 2016
// Adam J. Rock

public class Main {

    public static void usingAnonymousInlineClass() {

        List<Book> books = null;
        books = Books.all();
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });
        
        for (Book book : books) {
            System.out.printf("%s%n", book);
        }

    }

    public static void usingLambdasInLongForm() {

        List<Book> books = Books.all();
        Collections.sort(books, (Book b1, Book b2) -> {
            return b1.getTitle().compareTo(b2.getTitle());
        });

        for (Book book : books) {
            System.out.printf("%s%n", book);
        }

    }


    public static void usingLambdasInShortForm() {

        List<Book> books = Books.all();
        Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));

        //new functional style forEach
        books.forEach(book -> System.out.printf("%s%n", book));
    }

    public static void usingMethodReferences() {

        List<Book> books = Books.all();
        Collections.sort(books, Comparator.comparing(Book::getTitle));

        //new functional style forEach
        books.forEach(System.out::println);
    }

    public static void main(String[] args) {
        usingLambdasInShortForm();
        //usingLambdasInLongForm();
        //usingAnonymousInlineClass();
    }
}
