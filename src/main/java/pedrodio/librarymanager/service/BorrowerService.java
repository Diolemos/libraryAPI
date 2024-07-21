package pedrodio.librarymanager.service;


import org.springframework.stereotype.Service;

import pedrodio.librarymanager.model.Borrower;

@Service
public interface BorrowerService extends CrudService<Long, Borrower> {
    
    Borrower findById(Long id);

    Borrower createBorrower(Borrower borrowerToBeCreated);



}