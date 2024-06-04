package com.cursesalura.challengeliterature.main;

import com.cursesalura.challengeliterature.service.*;
import com.cursesalura.challengeliterature.model.*;
import com.cursesalura.challengeliterature.entity.*;
import com.cursesalura.challengeliterature.repository.*;

import java.util.*;

public class Principal {
    Scanner scanner = new Scanner(System.in);
    private APIConsumption apiConsumption = new APIConsumption();
    private ConvertData convert = new ConvertData();
    private BookRepository repository;
    private final String URL_BASE = "https://gutendex.com/books/";
    private List<Book> books;
    private String nameBook;


    public Principal(BookRepository repository) {
        this.repository = repository;
    }

    public void menu() {
        boolean exit = false;
        var option = -1;
        while (!exit) {
            printMenu();
            try {
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1 -> getBookDataByTitle();
                    case 2 -> listRegisteredBooks();
                    case 0 -> {
                        exit = true;
                        System.out.println("Closing the application...");
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (InputMismatchException e) {  // consume invalid input
                System.out.println("Enter a valid option.");
                scanner.nextLine();
            }
        }
    }

    public static void printMenu() {
        String mainMenu = """
                *******************************************
                          Welcome
                *******************************************                       
                Choose an option:                              
                1 - Search book by title
                2 - List registered books
                3 - List registered authors
                4 - List authors alive in a given year
                5 - List books by language                                   
                0 - Exit
                                
                """;

        System.out.println(mainMenu);
    }

    private String getDataUser() {
        System.out.println("Enter book name you want to search");
        nameBook = scanner.nextLine();
        return nameBook;

    }

    private ResultsDto getDataApi(String titleBook) {
        var json = apiConsumption.getData(URL_BASE + "?search=%20" + titleBook.replace(" ", "+"));
        var data = convert.getData(json, ResultsDto.class);
        return data;

    }

    private Optional<Book> getInfomation(ResultsDto bookData, String titleBook) {
        Optional<Book> books = bookData.results().stream()
                .filter(l -> l.title().toLowerCase().contains(titleBook.toLowerCase()))
                .map(b -> new Book(b.title(), b.languages(), b.downloads(), b.authors()))
                .findFirst();
        return books;
    }


    //Book search by title
    private Optional<Book> getBookDataByTitle() {
        String titleBook = getDataUser();
        ResultsDto dtaBook = getDataApi(titleBook);
        Optional<Book> book = getInfomation(dtaBook, titleBook);
        if (book.isPresent()) {
            var bookSave = book.get();
            repository.save(bookSave);
            System.out.println(bookSave);
        } else {
            System.out.println("Book not found");
        }
        return book;
    }

    private void listRegisteredBooks() {
        books = repository.findAll();
        books.stream().sorted(Comparator.comparing(Book::getTitle)).forEach(System.out::println);
    }

}


