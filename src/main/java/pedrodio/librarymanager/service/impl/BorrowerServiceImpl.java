package pedrodio.librarymanager.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import pedrodio.librarymanager.model.Borrower;
import pedrodio.librarymanager.repository.BorrowerRepository;
import pedrodio.librarymanager.service.BorrowerService;
import java.lang.IllegalArgumentException;

import pedrodio.librarymanager.service.exception.NotFoundException;

public class BorrowerServiceImpl implements BorrowerService {


    @Autowired
    BorrowerRepository borrowerRepository;


    @Override
    public Borrower create(Borrower entity) {
        
        if(borrowerRepository.existsById(entity.getId())){
            throw new IllegalArgumentException("This borrower already exists");
        }

        return borrowerRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        borrowerRepository.deleteById(id);  
    }

    @Override
    public List<Borrower> findAll() {
        
        return borrowerRepository.findAll() ;
    }

    @Override
    public Borrower findById(Long id) {
        
        return borrowerRepository.findById(id).orElseThrow(() -> new NotFoundException("Borrower not found with id " + id));

    }

    @Override
    public Borrower update(Long id, Borrower entity) {
        Borrower existingBorrower = borrowerRepository.findById(id).orElseThrow(() -> new NotFoundException("Borrower not found with id " + id));

        existingBorrower.setAddress(entity.getAddress());
        existingBorrower.setEmail(entity.getEmail());
        existingBorrower.setFirstName(entity.getFirstName());
        existingBorrower.setSecondName(entity.getSecondName());
        existingBorrower.setPrimaryPhone(entity.getPrimaryPhone());
        existingBorrower.setSecondaryPhone(entity.getSecondaryPhone());

        return borrowerRepository.save(existingBorrower);


        
    }

   

}
