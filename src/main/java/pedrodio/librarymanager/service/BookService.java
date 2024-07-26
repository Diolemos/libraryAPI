package pedrodio.librarymanager.service;

import org.springframework.stereotype.Service;

import pedrodio.librarymanager.model.Book;
import java.util.List;


@Service
public interface BookService extends CrudService<Long, Book> {
  public  List<Book> findByTitle(String title);
}
