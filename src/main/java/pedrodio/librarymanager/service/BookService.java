package pedrodio.librarymanager.service;

import org.springframework.stereotype.Service;

import pedrodio.librarymanager.model.Book;



@Service
public interface BookService extends CrudService<Long, Book> {

}