# LibraryConnect

**LibraryConnect** is a Library Management System designed for both administrators and clients. It provides functionalities to manage books, allow clients to borrow and return books, as well as give ratings and reviews. Administrators can manage book records, update details, and perform various operations like adding, removing, and editing books.

## Features

- **Administrator Features:**
  - Login as an admin user.
  - Add new books to the library.
  - Edit book information.
  - Remove books from the library.
  - View all available books in the library.
  - Find books by ID or Author.

- **Client Features:**
  - Login as a client user.
  - Borrow books from the library.
  - Return borrowed books.
  - Add books to the library (if the client is the author).
  - View all available books in the library.
  - Rate and review borrowed books.

## Technologies Used

- **Java** for the backend logic of the Library Management System.
- **Scanner** for user input.
- **ArrayList** for maintaining the list of books and borrowed books.

## Requirements

- Java 8 or higher.
- A terminal or command line to run the Java application.

## Installation and Setup

1. Clone the repository:

```bash
git clone https://github.com/aeyouseff/LIBRARY-CONNECT.git
```

2. Navigate to the project directory:

```bash
cd LIBRARY-CONNECT
```

3. Compile the Java files:

```bash
javac LMAN.java
```

4. Run the application:

```bash
java LMAN.LMAN
```

## Usage

### Starting the Application

Upon running the application, you'll be prompted with the following options:

1. **Administrator Login**  
   - Username: `Ahmed`
   - Password: `Ahmedpass`

2. **Client Login**  
   - Username: `Islam`
   - Password: `Islampass`

3. **End Session**  
   - Exit the application.

### Administrator Features

Once logged in as an administrator, the following options are available:

- **Add New Book**: Add a new book to the library.
- **Edit Book Information**: Modify details of an existing book.
- **Find a Book**: Search for books by ID or author.
- **Remove Book**: Delete a book from the library.
- **View All Books**: List all the books in the library.
- **End Session**: Log out and return to the main menu.

### Client Features

Once logged in as a client, the following options are available:

- **Check out a Book**: Borrow a book by providing the book ID.
- **Check in a Book**: Return a book that was previously borrowed.
- **Add Book To Library**: Add a book to the library (if the client is the author).
- **List of All Books**: View all the books available in the library.
- **Rate and Review Books**: Rate and review borrowed books.
- **End Session**: Log out and return to the main menu.

### Example Interaction

```
Welcome to LibraryConnect!
1. Administrator
2. Client
0. End Session
Select an option: 1

Enter username: Ahmed
Enter password: Ahmedpass
You're now logged in as an admin. Press Enter to continue.

1. Add New Book
2. Edit Book Information
3. Find a Book
4. Remove Book
5. View All Books
0. End Session
Select an option: 5

List of All Books:
Book ID: 1
Book Name: The Great Gatsby
Author: F. Scott Fitzgerald
Available: Yes
Average Rating: 4.5
Reviews: [Amazing book!]

Book ID: 2
Book Name: To Kill a Mockingbird
Author: Harper Lee
Available: Yes
Average Rating: 4.7
Reviews: [Timeless classic.]
```

## Code Overview

### Main Class - `LMAN`

This is the entry point for the application. It controls the flow of the program, providing the user with a choice to log in as an administrator or client. The main loop continues until the user opts to end the session.

### Admin and Client Login

There are separate login functions for admins and clients, with hardcoded credentials (`Ahmed`/`Ahmedpass` for admin and `Islam`/`Islampass` for client). On successful login, the user is presented with a menu specific to their role (admin or client).

### Book Management

Books are managed using an `ArrayList<Book>` where each book is an instance of the `Book` class. The `Book` class contains:
- `bookId`: Unique identifier for each book.
- `bookName`: The title of the book.
- `bookAuthor`: The author of the book.
- `available`: Boolean flag indicating whether the book is available for borrowing.
- `ratings`: List of ratings given by clients.
- `reviews`: List of reviews submitted by clients.

The system allows adding, updating, deleting, and searching for books. Clients can borrow and return books, and also rate and review them.

### Helper Methods

- `getChoice(Scanner scanner)`: This method ensures that the user input is valid and returns the user's choice.
- `addBook`, `deleteBook`, `updateBook`, `findBook`, `borrowBook`, `returnBook`, etc., are helper methods to handle various actions like adding, editing, deleting, and managing books in the system.
