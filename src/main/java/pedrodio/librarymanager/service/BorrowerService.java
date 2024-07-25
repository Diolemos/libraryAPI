package pedrodio.librarymanager.service;

import org.springframework.stereotype.Service;
import pedrodio.librarymanager.model.Borrower;

@Service
public interface BorrowerService extends CrudService<Long, Borrower> {
    // Additional methods specific to Borrower if needed
}
