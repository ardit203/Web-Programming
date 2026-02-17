# Laboratory Exercise 1 - for groups with prefix A
# Specification for the Laboratory Exercise

## 1. Creating a Spring Boot Project
Create a new Spring Boot project with the following characteristics:
- **groupId**: `mk.ukim.finki.wp`
- **artifactId**: `lab`
- **Dependencies**: The same as the project from the lab exercises (see the `<dependency>` tags in `pom.xml`)

---

## 2. Creating the `Model` Classes

Define the package `mk.ukim.finki.wp.lab.model` and create the following classes:

### 2.1 `BookReservation` Class
Create a class `BookReservation` that contains:
- `String bookTitle`
- `String readerName`
- `String readerAddress`
- `Long numberOfCopies`

### 2.2 `Book` Class
Create a class `Book` that contains:
- `String title`
- `String genre`
- `double averageRating`

---

## 3. Creating the `DataHolder` Class
Create a class `DataHolder` in the package `mk.ukim.finki.wp.lab.bootstrap` that contains:
- A static list: `public static List<Book> books = new ArrayList<>();` initialized with **10 values**
- A static list: `public static List<BookReservation> reservations = new ArrayList<>();` (initially empty)

---

## 4. Creating the `Repository` Layer
### 4.1 `BookRepository` Interface
Define the interface `BookRepository` in the package `mk.ukim.finki.wp.lab.repository`:
```java
public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
}
```

### 4.2 `InMemoryBookRepository` Implementation
Create a class `InMemoryBookRepository` that implements the `BookRepository` interface.

**Implementation:**
- `findAll()` - returns the list from `DataHolder.books`
- `searchBooks(String text, Double rating)` - searches through the list of books and returns those whose titles contain the text `text` and have a rating greater than or equal to `rating`.

### 4.3 `BookReservationRepository` Interface
Define the interface `BookReservationRepository` in the package `mk.ukim.finki.wp.lab.repository`:
```java
public interface BookReservationRepository {
    BookReservation save(BookReservation reservation);
}
```

### 4.4 `InMemoryBookReservationRepository` Implementation
Create a class `InMemoryBookReservationRepository` that implements the `BookReservationRepository` interface.

**Implementation:**
- `save(BookReservation reservation)` - adds the reservation to the `DataHolder.reservations` list and returns the saved reservation.

---

## 5. Creating the `Service` Layer
### 5.1 `BookService` Interface
Define the interface `BookService` in the package `mk.ukim.finki.wp.lab.service`:
```java
public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
}
```

### 5.2 `BookReservationService` Interface
Define the interface `BookReservationService` in the package `mk.ukim.finki.wp.lab.service`:
```java
public interface BookReservationService {
    BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies);
}
```

### 5.3 Implementation of Services
Implement the services (create `BookServiceImpl` and `BookReservationServiceImpl` classes).  
`BookService` should depend on `BookRepository`, and `BookReservationService` should depend on `BookReservationRepository`.

---

## 6. Creating the `Web` Layer (`Servlets`)
### 6.1 `BookListServlet`
Create a servlet `BookListServlet` in the package `mk.ukim.finki.lab.web` and map it to the path `/`.  
This servlet should depend on `BookService` and display all the obtained books using the `listAll()` method.  
Allow the user to select one of the books and specify the number of copies to reserve.  

Create one radio button for each book, where the value of the button is the book title, and the displayed text should be in the format:  
`Title: <book_title>, Genre: <book_genre>, Rating: <average_rating>`

Adjust the file `listBooks.html` for the appearance of this page.

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Book Reservation - Welcome and choose a Book</title>
    <style type="text/css">
        body {
            width: 800px;
            margin: auto;
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        form {
            margin-top: 20px;
        }
        .book-option {
            margin: 10px 0;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .book-option:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to our Book Reservation App</h1>
    </header>
    <main>
        <form action="/bookReservation" method="POST">
            <h2>Choose a book:</h2>
            <!-- Display radio buttons for each book,
                 the value should be the book title 
                 and the displayed text should be:
                 Title: <book_title>, Genre: <book_genre>, Rating: <average_rating> -->

            <h2>Enter your information:</h2>
            <label>Your Name:</label>
            <input type="text" name="readerName" required><br/>
            <label>Your Address:</label>
            <input type="text" name="readerAddress" required><br/>

            <h2>Choose number of copies:</h2>
            <input type="number" name="numCopies" min="1" max="10" required><br/>
            <br/>
            <input type="submit" value="Reserve Book">
        </form>
    </main>
</body>
</html>
```

### 6.2 `BookReservationServlet`
When a book is selected, the reservation should be displayed to the user.  
For this purpose, create a servlet `BookReservationServlet` mapped to `/bookReservation`.  
This servlet should depend on `BookReservationService`.

The servlet should:
- Read the data sent from the form (selected book, number of copies, reader’s name and address)
- Obtain the client’s IP address
- Create a reservation by calling the `placeReservation()` method from the service
- Display a confirmation page with the reservation details

In the folder `src/main/resources/templates`, add the file `reservationConfirmation.html` and customize it for the confirmation page.  
Dynamically fill in the table data.

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Book Reservation - Confirmation</title>
    <style type="text/css">
        body {
            width: 800px;
            margin: auto;
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }
        table, td, th {
            border: 1px solid #333;
        }
        th {
            background-color: #4CAF50;
            color: white;
            padding: 12px;
        }
        td {
            padding: 10px;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <section>
        <header>
            <h1>Book Reservation - Confirmation</h1>
        </header>
        <table>
            <tr>
                <th colspan="2">Your Reservation Status</th>
            </tr>
            <tr>
                <td><b>Reader Name</b></td>
                <td><!-- Display reader name from servlet --></td>
            </tr>
            <tr>
                <td><b>Client IP Address</b></td>
                <td><!-- Display IP address from servlet --></td>
            </tr>
            <tr>
                <td><b>Reservation for Book</b></td>
                <td><!-- Display book title from servlet --></td>
            </tr>
            <tr>
                <td><b>Number of copies</b></td>
                <td><!-- Display number of copies from servlet --></td>
            </tr>
        </table>
    </section>
</body>
</html>
```

---

## 7. Implementing Search Functionality
Implement a search feature for books on the home page `listBooks.html`.  
Only books that meet the search conditions should be displayed.  

The search should be performed based on two parameters:
- Books whose titles contain the text entered by the user
- Books with a rating greater than or equal to the value entered by the user
