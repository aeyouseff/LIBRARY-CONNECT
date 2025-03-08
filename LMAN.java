package LMAN;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static final String AdminUserName = "Ahmed";
    private static final String AdminPass = "Ahmedpass";
    private static final String ClientUserName = "Islam";
    private static final String ClientPass = "Islampass";
    private static List<Book> books = new ArrayList<>();
    private static List<Book> borrowedBooks = new ArrayList<>();
    private static int bookIdCounter = 1;

    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            clearScreen();
            System.out.println("\t\t Embrace the Library Management System!");
            System.out.println("**********************************************************************");
            System.out.println("\t\t Choose one from the following:");
            System.out.println("1. Administrator");
            System.out.println("2. Client");
            System.out.println("0. End Session");
            System.out.print("\nSelect an option: ");

            int choice = getChoice(scanner);

            switch (choice) {
                case 1:
                    adminLogin(scanner);
                    break;
                case 2:
                    userLogin(scanner);
                    break;
                case 0:
                    System.out.println("\t\t Thanks for using the Library Management System. Closing now...");
                    System.out.println("**********************************************************************");
                    return;
                default:
                    System.out.println("\t\t Invalid choice. Press Enter to continue.");
                    System.out.println("**********************************************************************");
                    scanner.nextLine();
            }
        }
    }

  
    
    private static int getChoice(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } else {
                scanner.nextLine();
            }
        }
    }

    
    // ******************* LOGIN *******************
    
    private static void adminLogin(Scanner scanner) {
        clearScreen();
        System.out.println("\t\t Administrator Sign In");
        System.out.println("**********************************************************************");
        System.out.print("Enter username: ");
        String adminUser = scanner.next();
        System.out.print("Enter password: ");
        String adminPassword = scanner.next();

        if (adminUser.equals(AdminUserName) && adminPassword.equals(AdminPass)) {
            scanner.nextLine();
            System.out.println("**********************************************************************");
            System.out.println("\t\t You're now logged in as an admin. Press Enter to continue.");
            System.out.println("**********************************************************************");
            scanner.nextLine();

            while (true) {
                clearScreen();
                System.out.println("1. Add New Book");
                System.out.println("2. Edit Book Information");
                System.out.println("3. Find a Book");
                System.out.println("4. Remove Book");
                System.out.println("5. View All Books");
                System.out.println("0. End Session");
                System.out.print("\nSelect an option: ");

                int innerChoice = getChoice(scanner);

                switch (innerChoice) {
                    case 1:
                        addBook(scanner);
                        break;
                    case 2:
                        updateBook(scanner);
                        break;
                    case 3:
                        findBook(scanner);
                        break;
                    case 4:
                        deleteBook(scanner);
                        break;
                    case 5:
                        listOfAllBooks();
                        break;
                    case 0:
                        System.out.println("**********************************************************************");
                        return;
                    default:
                        System.out.println("**********************************************************************");
                        System.out.println("\t\t Invalid choice. Press Enter to continue.");
                        System.out.println("**********************************************************************");
                        scanner.nextLine();
                }
            }
        } else {
            System.out.println("**********************************************************************");
            System.out.println("\t\t Login failed. Press Enter to continue.");
            System.out.println("**********************************************************************");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    
    
    private static void userLogin(Scanner scanner) {
        clearScreen();
        System.out.println("\t\t Client Sign In");
        System.out.println("**********************************************************************");
        System.out.print("Enter username: ");
        String ClientUser = scanner.next();
        System.out.print("Enter password: ");
        String ClientPassword = scanner.next();

        if (ClientUser.equals(ClientUserName) && ClientPassword.equals(ClientPass)) {
            scanner.nextLine();
            System.out.println("**********************************************************************");
            System.out.println("\t\t You're now logged in as a Client. Press Enter to continue.");
            System.out.println("**********************************************************************");
            scanner.nextLine();
            while (true) {
                clearScreen();
                System.out.println("1. Check out a book");
                System.out.println("2. Check in a book");
                System.out.println("3. Add Book To Library");
                System.out.println("4. List of All Books");
                System.out.println("5. Rate and Review Books");
                System.out.println("0. End Session");
                System.out.print("\nSelect an option: ");

                int innerChoice = getChoice(scanner);

                switch (innerChoice) {
                    case 1:
                        borrowBook(scanner);
                        break;
                    case 2:
                        returnBook(scanner);
                        break;
                    case 3:
                        addBookToLibrary(scanner, ClientUser);
                        break;
                    case 4:
                        listOfAllBooks();
                        break;
                    case 5:
                        rateAndReviewBooks(scanner);
                        break;
                    case 0:
                        System.out.println("**********************************************************************");
                        return;
                    default:
                        System.out.println("**********************************************************************");
                        System.out.println("\t\t Invalid choice. Press Enter to continue.");
                        System.out.println("**********************************************************************");
                        scanner.nextLine();
                }
            }
        } else {
            System.out.println("**********************************************************************");
            System.out.println("\t\t Login failed. Press Enter to continue.");
            System.out.println("**********************************************************************");
            scanner.nextLine();
            scanner.nextLine();
        }
    }

    
    // ******************* CLIENT CLASSES *******************

    private static void borrowBook(Scanner scanner) {
        clearScreen();
        System.out.println("**********************************************************************");
        System.out.println("\t\t Borrow a Book");
        System.out.println("**********************************************************************");

        System.out.print("Enter the book ID to borrow: ");
        int bookId = getChoice(scanner);

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    borrowedBooks.add(book);
                    System.out.println("**********************************************************************");
                    System.out.println("\t\t You have successfully borrowed the book: " + book.getBookName());
                    System.out.println("**********************************************************************");
                    scanner.nextLine();
                } else {
                    System.out.println("**********************************************************************");
                    System.out.println("\t\t The book is currently unavailable.");
                    System.out.println("**********************************************************************");
                    scanner.nextLine();
                }
                return;
            }
        }

        System.out.println("**********************************************************************");
        System.out.println("\t\t Book not found.");
        System.out.println("**********************************************************************");
        scanner.nextLine();
    }

    
    
    private static void returnBook(Scanner scanner) {
        clearScreen();
        System.out.println("**********************************************************************");
        System.out.println("\t\t Return a Book");
        System.out.println("**********************************************************************");

        System.out.print("Enter the book ID to return: ");
        int bookId = getChoice(scanner);

        for (Book book : borrowedBooks) {
            if (book.getBookId() == bookId) {
                book.setAvailable(true);
                borrowedBooks.remove(book);
                System.out.println("**********************************************************************");
                System.out.println("\t\t You have successfully returned the book: " + book.getBookName());
                System.out.println("**********************************************************************");
                scanner.nextLine();
                return;
            }
        }

        System.out.println("**********************************************************************");
        System.out.println("\t\t Book not found in your borrowed books.");
        System.out.println("**********************************************************************");
        scanner.nextLine();
    }

    
    
    private static void addBookToLibrary(Scanner scanner, String authorName) {
        clearScreen();
        System.out.println("**********************************************************************");
        System.out.println("\t\t Add a Book to the Library");
        System.out.println("**********************************************************************");
        System.out.print("Is the book written by you? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("yes")) {
            System.out.print("Enter the book name: ");
            String bookName = scanner.nextLine();

            Book book = new Book(bookIdCounter++, bookName, authorName);
            books.add(book);

            System.out.println("**********************************************************************");
            System.out.println("\t\t Book Added Successfully. \n\t\t Press Enter to continue.");
            System.out.println("**********************************************************************");
            scanner.nextLine();
        } else if (response.equals("no")) {
            System.out.print("Enter the book name: ");
            String bookName = scanner.nextLine();
            System.out.print("Enter the book author: ");
            String bookAuthor = scanner.nextLine();

            Book book = new Book(bookIdCounter++, bookName, bookAuthor);
            books.add(book);

            System.out.println("**********************************************************************");
            System.out.println("\t\t Book Added Successfully. \n\t\t Press Enter to continue.");
            System.out.println("**********************************************************************");
            scanner.nextLine();
        } else {
            System.out.println("Invalid input. Press Enter to continue.");
            System.out.println("**********************************************************************");
            scanner.nextLine();
        }
    }

    
    
    private static void rateAndReviewBooks(Scanner scanner) {
        clearScreen();
        System.out.println("**********************************************************************");
        System.out.println("\t\t Rate and Review a Book");
        System.out.println("**********************************************************************");

        System.out.print("Enter the book ID to rate and review: ");
        int bookId = getChoice(scanner);

        for (Book book : borrowedBooks) {
            if (book.getBookId() == bookId) {
                System.out.print("Enter your rating (1-5): ");
                int rating = getChoice(scanner);
                if (rating >= 1 && rating <= 5) {
                    book.addRating(rating);

                    System.out.print("Enter your review: ");
                    String review = scanner.nextLine();
                    book.addReview(review);

                    System.out.println("**********************************************************************");
                    System.out.println("\t\t Rating and review submitted successfully.");
                    System.out.println("**********************************************************************");
                    scanner.nextLine();
                } else {
                    System.out.println("**********************************************************************");
                    System.out.println("\t\t Invalid rating. Rating should be between 1 and 5.");
                    System.out.println("**********************************************************************");
                    scanner.nextLine();
                }
                return;
            }
        }

        System.out.println("**********************************************************************");
        System.out.println("\t\t Book not found in your borrowed books.");
        System.out.println("**********************************************************************");
        scanner.nextLine();
    }

    
    // ******************* ADMIN CLASSES *******************
    
    private static void addBook(Scanner scanner) {
        clearScreen();
        System.out.println("**********************************************************************");
        System.out.println("\t\t Add a New Book");
        System.out.println("**********************************************************************");
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter book author: ");
        String bookAuthor = scanner.nextLine();

        Book book = new Book(bookIdCounter++, bookName, bookAuthor);
        books.add(book);
        System.out.println("**********************************************************************");
        System.out.println("\t\t Book Added Successfully. \n\t\t Press Enter to continue.");
        System.out.println("**********************************************************************");
        scanner.nextLine();
    }

    
    
    private static void deleteBook(Scanner scanner) {
        clearScreen();
        System.out.println("**********************************************************************");
        System.out.println("\t\t Delete a Book");
        System.out.println("**********************************************************************");
        System.out.print("Enter the id of the book to delete: ");

        int bookId = getChoice(scanner);

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                books.remove(book);
                System.out.println("**********************************************************************");
                System.out.println("\t\t Book deleted successfully.");
                System.out.println("**********************************************************************");
                scanner.nextLine();
                return;
            }
        }
        System.out.println("**********************************************************************");
        System.out.println("\t\t Book not found.");
        System.out.println("**********************************************************************");
        scanner.nextLine();
    }

    
    
    private static void updateBook(Scanner scanner) {
        clearScreen();
        System.out.println("**********************************************************************");
        System.out.println("\t\t Update a Book");
        System.out.println("**********************************************************************");
        System.out.print("Enter the id of the book to update: ");
        int bookId = getChoice(scanner);

        for (Book book : books) {
            if (book.getBookId() == bookId) {
                System.out.print("Enter updated book name: ");
                String updatedName = scanner.nextLine();
                book.setBookName(updatedName);

                System.out.print("Enter updated book author: ");
                String updatedAuthor = scanner.nextLine();
                book.setBookAuthor(updatedAuthor);
                System.out.println("**********************************************************************");
                System.out.println("\t\t Book updated successfully.");
                System.out.println("**********************************************************************");
                scanner.nextLine();
                return;
            }
        }
        System.out.println("**********************************************************************");
        System.out.println("\t\t Book not found.");
        System.out.println("**********************************************************************");
        scanner.nextLine();
    }

    
    
    private static void findBook(Scanner scanner) {
        clearScreen();
        System.out.println("**********************************************************************");
        System.out.println("\t\t Find a Book");
        System.out.println("**********************************************************************");

        System.out.println("Press 1 to Search with Book ID");
        System.out.println("Press 2 to Search with Book's Author Name");
        System.out.print("\t\t Select an option: ");
        int searchOption = getChoice(scanner);

        switch (searchOption) {
            case 1:
                System.out.print("Enter the Book ID to search for: ");
                int bookId = getChoice(scanner);
                boolean found = false;

                for (Book book : books) {
                    if (book.getBookId() == bookId) {
                        System.out.println("**********************************************************************");
                        System.out.println("\t\t Book found:\n" + book);
                        System.out.println("**********************************************************************");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("**********************************************************************");
                    System.out.println("\t\t Book not found.");
                    System.out.println("**********************************************************************");
                }
                break;
            case 2:
                System.out.print("Enter the Author's Name to search for: ");
                String authorName = scanner.nextLine();
                boolean authorFound = false;

                for (Book book : books) {
                    if (book.getBookAuthor().equalsIgnoreCase(authorName)) {
                        System.out.println("**********************************************************************");
                        System.out.println("\t\t Books by the Author " + authorName + ":\n" + book);
                        System.out.println("**********************************************************************");
                        authorFound = true;
                    }
                }

                if (!authorFound) {
                    System.out.println("**********************************************************************");
                    System.out.println("\t\t No books found by the Author " + authorName);
                    System.out.println("**********************************************************************");
                }
                break;
            default:
                System.out.println("\t\t Invalid search option.");
                System.out.println("**********************************************************************");
        }

        scanner.nextLine();
    }

    
    
    private static void listOfAllBooks() {
        clearScreen();
        System.out.println("**********************************************************************");
        System.out.println("\t\t List of All Books");
        System.out.println("**********************************************************************");

        if (books.isEmpty()) {
            System.out.println("\t\t No books in the library.");
            System.out.println("**********************************************************************");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t Press Enter to continue..");
        scanner.nextLine();
    }

    
    // ******************* ******************* *******************
    
    
    private static class Book {
        private int bookId;
        private String bookName;
        private String bookAuthor;
        private boolean available = true;
        private List<Integer> ratings;
        private List<String> reviews;

        public Book(int bookId, String bookName, String bookAuthor) {
            this.bookId = bookId;
            this.bookName = bookName;
            this.bookAuthor = bookAuthor;
            this.ratings = new ArrayList<>();
            this.reviews = new ArrayList<>();
        }

        public int getBookId() {
            return bookId;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }

        public String getBookName() {
            return bookName;
        }

        public String getBookAuthor() {
            return bookAuthor;
        }

        public void setBookAuthor(String bookAuthor) {
            this.bookAuthor = bookAuthor;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        public void addRating(int rating) {
            ratings.add(rating);
        }

        public double getAverageRating() {
            if (ratings.isEmpty()) {
                return 0.0;
            } else {
                int sum = 0;
                for (int rating : ratings) {
                    sum += rating;
                }
                return (double) sum / ratings.size();
            }
        }

        public void addReview(String review) {
            reviews.add(review);
        }

        @Override
        public String toString() {
            return "Book ID: " + bookId +
                    "\nBook Name: " + bookName +
                    "\nAuthor: " + bookAuthor +
                    "\nAvailable: " + (available ? "Yes" : "No") +
                    "\nAverage Rating: " + getAverageRating() +
                    "\nReviews: " + reviews +
                    "\n";
        }
    }

    
    
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            // Handle any exceptions, but they are unlikely in this context
        }
    }
}
