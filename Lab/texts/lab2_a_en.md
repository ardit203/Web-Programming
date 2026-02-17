# Laboratory Exercise 2 - for groups with prefix A
# Specification for the Laboratory Exercise

## 1. Models

In the `Book` class add one more property:
- `private Long id;`
which is unique for each book. Generate the `id` for every book as it was done in the auditory exercise.

Add a class `Author` in the package `mk.ukim.finki.wp.lab.model`. It should store:
- `private Long id;`
- `private String name;`
- `private String surname;`
- `private String country;`
- `private String biography;`

In the `Book` class add a link to the `Author` class as a separate property:
- `private Author author;`

---

## 2. Repository Layer

Create an `AuthorRepository` class in the package `mk.ukim.finki.wp.lab.repository`, and initialize in it a list containing 3 authors.

Within the class, also write the method:
``` java
public List<Author> findAll()
```

which returns all authors that exist in the system.

For each of the books, initialize one of the authors in the author attribute.

---

## 3. Service Layer

Within the package `mk.ukim.finki.wp.lab.service`, create an interface `AuthorService` and a class that implements it, `AuthorServiceImpl` (in the `impl` subpackage).

In this service, define the method:
``` java
public List<Author> findAll()
```

which calls the corresponding method from `AuthorRepository`.

---

## 4. Web Layer - controller and views
Дефинирајте пакет `mk.ukim.finki.wp.lab.web.controller` и во него креирајте ја `BookController` класата.

### 4.1 Listing method

Implement the method:
```java
public String getBooksPage(@RequestParam(required = false) String error, Model model)
```


which should display the view with all books.  
It should respond to the mapping `/books`.  
The view for all books should be `listBooks.html`, showing the author’s first and last name, while keeping the functionality for selecting a book and the number of copies.

Next to each book, add two buttons:
- one for editing the book;
- another for deleting the book.

---

### 4.2 Adding a new book
Implement the method:
```java
public String saveBook(@RequestParam String title,
                       @RequestParam String genre,
                       @RequestParam Double averageRating,
                       @RequestParam Long authorId)

```

which will enable adding a new book and will correspond to the mapping `/books/add`.
On successful addition, it should redirect to the view with all books.

---

### 4.3 Updating a book
Implement the method:
```java
public String editBook(@PathVariable Long bookId,
                       @RequestParam String title,
                       @RequestParam String genre,
                       @RequestParam Double averageRating,
                       @RequestParam Long authorId)

```
which will enable updating books.  
It should correspond to the mapping `/books/edit/{bookId}`, and on successful update redirect to the books list.

---

### 4.4 Deleting a book
Implement the method:
```java
public String deleteBook(@PathVariable Long id)
```

It should correspond to the mapping `/books/delete/{id}`, and on successful deletion it should display the books list again.

Mind the annotations — use `@GetMapping` for forms/pages and `@PostMapping` for create, update, and delete actions.


---

## 5. Connected layers
Create all the necessary methods in the service and repository layers according to the methods in the controllers.

Everything remains in-memory, as in the previous exercise.

---

## 6. Pages (views)

### 6.1 `book-form.html`
Create a page for adding/editing a book.
The form should contain fields for:
- `title`
- `genre`
- `averageRating`
- `authorId` (select list with all authors)

Use the same form for both adding and editing.

---

### 6.2 `listBooks.html`

Display all books (`title`, `genre`, `rating`, `author`).
Next to each book add an `Edit` button and a `Delete` button.
Add a button to Add new book.
Keep the existing reservation form (selecting a book and number of copies).

---

## 7. Additional routes for forms
Implement:
```java
public String getEditBookForm(@PathVariable Long id, Model model)
```

which corresponds to the mapping `/books/book-form/{id}` and displays the `book-form.html` page.
When editing, show the current data for the book.
If the id does not exist — redirect to `/books?error=BookNotFound`.

Implement:
```java
public String getAddBookPage(Model model)
```

which corresponds to the mapping `/books/book-form` and displays the `book-form.html` page.


---

## 8. Reservations (`BookReservationController`)

Replace the `BookReservationServlet` with a controller `BookReservationController`, which will enable:

* creating a new reservation;
* displaying the confirmation page.

The controller should:

* read the data from the form (book, number of copies, name and address);
* obtain the client’s IP address;
* create a reservation via the service;
* display the `reservationConfirmation.html` page with the details.

---

## 9. Verification

When testing, check:

* displaying all books;
* adding, editing, and deleting books;
* the reservation functionality and the confirmation page;
* correct display of authors in the list.













