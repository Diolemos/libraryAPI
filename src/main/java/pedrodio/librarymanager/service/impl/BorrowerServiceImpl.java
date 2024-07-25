package pedrodio.librarymanager.service.impl;

import org.springframework.stereotype.Service;
import pedrodio.librarymanager.model.Borrower;
import pedrodio.librarymanager.repository.BorrowerRepository;
import pedrodio.librarymanager.service.BorrowerService;
import pedrodio.librarymanager.service.exception.NotFoundException;

import java.util.List;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    private final BorrowerRepository borrowerRepository;

    
    public BorrowerServiceImpl(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    @Override
    public List<Borrower> findAll() {
        return borrowerRepository.findAll();
    }

    @Override
    public Borrower findById(Long id) {
        return borrowerRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Borrower create(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    @Override
    public Borrower update(Long id, Borrower borrower) {
        Borrower existingBorrower = findById(id);
        existingBorrower.setFirstName(borrower.getFirstName());
        existingBorrower.setSecondName(borrower.getSecondName());
        existingBorrower.setEmail(borrower.getEmail());
        existingBorrower.setAddress(borrower.getAddress());
        existingBorrower.setPrimaryPhone(borrower.getPrimaryPhone());
        existingBorrower.setSecondaryPhone(borrower.getSecondaryPhone());
        return borrowerRepository.save(existingBorrower);
    }

    @Override
    public void delete(Long id) {
        Borrower existingBorrower = findById(id);
        borrowerRepository.delete(existingBorrower);
    }
}
