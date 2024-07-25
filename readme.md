# Library API


## API Description

This API is designed for managing a library system, allowing for comprehensive management of users, books, and their borrowing activities. The API supports adding, deleting, updating, and retrieving users and books.
Additionally, it enables tracking and managing borrowing events, including retrieving the borrowing history for each user.

## Features
- User Management: Add, delete, update, and retrieve user information.
- Book Management: Add, delete, update, and retrieve book information.
- Borrow Management: Track and manage book borrowings, including:
  - Borrowing a book
  - Returning a book
  - Checking which books are currently borrowed
- Borrowing History: Browse through the borrowing history of each user to see past borrowing activities.

---

```mermaid
classDiagram
    class Book {
        +String title
        +String author
        +int releaseYear
        +int edition
        +int availableCopies
        +int totalCopies
        +String info()
    }

    class BookCopy {
        +String id
        +String serialNumber
        +String status
        +String bookId
    }

    class Borrower {
        +String firstName
        +String secondName
        +Address address
        +String primaryPhone
        +String secondaryPhone
        +String email
    }

    class Address {
        +String streetName
        +String houseNumber
        +String complement
        +String zipCode
    }

    class Borrowing {
        +String id
        +String bookCopyId
        +String borrowerId
        +Date borrowDate
        +Date returnDate
    }

    Address <-- Borrower : has an
    Book "1" <-- "0..*" BookCopy : contains
    Borrower "1" <-- "0..*" Borrowing : has
    BookCopy "1" <-- "0..*" Borrowing : borrows
