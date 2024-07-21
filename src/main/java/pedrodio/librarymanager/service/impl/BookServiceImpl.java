package pedrodio.librarymanager.service.impl;

import java.util.List;

import pedrodio.librarymanager.service.exception.NotFoundException;
import pedrodio.librarymanager.model.Book;
import pedrodio.librarymanager.repository.BookRepository;
import pedrodio.librarymanager.service.BookService;
import java.util.NoSuchElementException;

public class BookServiceImpl implements BookService {
    

private final BookRepository bookRepository;


public BookServiceImpl(BookRepository bookRepository){
    this.bookRepository= bookRepository;
}

@Override
public Book findById(Long id) {
    
    return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
}

@Override
public List<Book> findAll() {
    
    return bookRepository.findAll();
}

@Override
public Book create(Book bookToBeCreated) {

    return bookRepository.save( bookToBeCreated);

}
    

@Override
public void delete(Long id) {
    bookRepository.deleteById(id);
    
}

@Override
public Book update(Long id, Book bookDetails) {
    Book existingBook = bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found with id " + id));

    // Update the fields of the existing book
    existingBook.setTitle(bookDetails.getTitle());
    existingBook.setAuthor(bookDetails.getAuthor());
    existingBook.setReleaseYear(bookDetails.getReleaseYear());
    existingBook.setEdition(bookDetails.getEdition());
    existingBook.setIsBorrowed(bookDetails.getIsBorrowed());

    return bookRepository.save(existingBook);
}






}
