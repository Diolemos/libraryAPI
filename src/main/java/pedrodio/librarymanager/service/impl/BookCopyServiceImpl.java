package pedrodio.librarymanager.service.impl;

import org.springframework.stereotype.Service;
import pedrodio.librarymanager.model.BookCopy;
import pedrodio.librarymanager.repository.BookCopyRepository;
import pedrodio.librarymanager.service.BookCopyService;
import pedrodio.librarymanager.service.exception.NotFoundException;

import java.util.List;

@Service
public class BookCopyServiceImpl implements BookCopyService {

    private final BookCopyRepository bookCopyRepository;

    public BookCopyServiceImpl(BookCopyRepository bookCopyRepository) {
        this.bookCopyRepository = bookCopyRepository;
    }

    @Override
    public List<BookCopy> findAll() {
        return bookCopyRepository.findAll();
    }

    @Override
    public BookCopy findById(Long id) {
        return bookCopyRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public BookCopy create(BookCopy bookCopy) {
        return bookCopyRepository.save(bookCopy);
    }

    @Override
    public BookCopy update(Long id, BookCopy bookCopy) {
        BookCopy existingBookCopy = findById(id);
        existingBookCopy.setSerialNumber(bookCopy.getSerialNumber());
        existingBookCopy.setIsBorrowed(bookCopy.getIsBorrowed());
        existingBookCopy.setCondition(bookCopy.getCondition());
        existingBookCopy.setBook(bookCopy.getBook());
        return bookCopyRepository.save(existingBookCopy);
    }

    @Override
    public void delete(Long id) {
        BookCopy existingBookCopy = findById(id);
        bookCopyRepository.delete(existingBookCopy);
    }
}
