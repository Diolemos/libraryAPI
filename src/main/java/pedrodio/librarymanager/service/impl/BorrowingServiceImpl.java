package pedrodio.librarymanager.service.impl;

import org.springframework.stereotype.Service;
import pedrodio.librarymanager.model.Borrowing;
import pedrodio.librarymanager.repository.BorrowingRepository;
import pedrodio.librarymanager.service.BorrowingService;
import pedrodio.librarymanager.service.exception.NotFoundException;

import java.util.List;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    private final BorrowingRepository borrowingRepository;

    public BorrowingServiceImpl(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    @Override
    public List<Borrowing> findAll() {
        return borrowingRepository.findAll();
    }

    @Override
    public Borrowing findById(Long id) {
        return borrowingRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Borrowing create(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    @Override
    public Borrowing update(Long id, Borrowing borrowing) {
        Borrowing existingBorrowing = findById(id);
        existingBorrowing.setBorrower(borrowing.getBorrower());
        existingBorrowing.setBook(borrowing.getBook());
        existingBorrowing.setBorrowedDate(borrowing.getBorrowedDate());
        existingBorrowing.setReturnDate(borrowing.getReturnDate());
        return borrowingRepository.save(existingBorrowing);
    }

    @Override
    public void delete(Long id) {
        Borrowing existingBorrowing = findById(id);
        borrowingRepository.delete(existingBorrowing);
    }
}
