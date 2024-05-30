package com.cursesalura.challengeliterature.main;

import com.cursesalura.challengeliterature.service.APIConsumption;
import com.cursesalura.challengeliterature.service.ConvertData;
import com.cursesalura.challengeliterature.model.Results;
import com.cursesalura.challengeliterature.model.BookData;
import com.cursesalura.challengeliterature.service.IConvertData;

import java.util.*;

public class Principal {
    Scanner scanner = new Scanner(System.in);
    private APIConsumption apiConsumption = new APIConsumption();
    private IConvertData converter = new ConvertData();
    private static final String URL = "https://gutendex.com/books/";

    public void menu() {
        boolean exit = false;
        var option = -1;
        while (!exit) {
            printMenu();
            try {
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1 -> searchBookByTitle();

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

    private Results getDataBooks(String bookTitle) {
        String queryUrl = URL + "?search=" + bookTitle.replace(" ", "+");
        String json = apiConsumption.getData(queryUrl);
        return converter.dataGet(json, Results.class);
    }

    //Book search by title
    private void searchBookByTitle() {
        System.out.println("Enter book name you want to search");
        String bookTitle = scanner.nextLine();
        Results data = getDataBooks(bookTitle);

        //Optional
        Optional<BookData> bookSearch = data.books().stream()
                .filter(b -> b.title().toUpperCase().equalsIgnoreCase(bookTitle.toUpperCase()))
                .findFirst();
        bookSearch.ifPresentOrElse(
                book -> System.out.println("Book found:\n" + book),
                () -> System.out.println("Book not found")
        );
    }
}