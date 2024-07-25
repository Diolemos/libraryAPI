package pedrodio.librarymanager.service;

import org.springframework.stereotype.Service;
import pedrodio.librarymanager.model.BookCopy;

@Service
public interface BookCopyService extends CrudService<Long, BookCopy> {
  
}
