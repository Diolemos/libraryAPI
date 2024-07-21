package pedrodio.librarymanager.service;

import org.springframework.stereotype.Service;

import pedrodio.librarymanager.model.Book;
import pedrodio.librarymanager.repository.BookRepository;


@Service
public interface BookService extends CrudService<Long, Book> {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.BookRepository = bookRepository;
    }

    Book findById(Long id);

    Book create(Book bookToBeCreated);

}