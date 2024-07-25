package pedrodio.librarymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedrodio.librarymanager.model.BookCopy;
import pedrodio.librarymanager.service.BookCopyService;

import java.net.URI;
import java.util.List;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/bookcopies")
public class BookCopyController {

    private final BookCopyService bookCopyService;

    @Autowired
    public BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }

    @GetMapping
    public ResponseEntity<List<BookCopy>> findAll() {
        List<BookCopy> bookCopies = bookCopyService.findAll();
        return ResponseEntity.ok(bookCopies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookCopy> findById(@PathVariable Long id) {
        BookCopy bookCopy = bookCopyService.findById(id);
        return ResponseEntity.ok(bookCopy);
    }

    @PostMapping
    public ResponseEntity<BookCopy> create(@RequestBody BookCopy bookCopy) {
        BookCopy newBookCopy = bookCopyService.create(bookCopy);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(newBookCopy.getId())
            .toUri();
        return ResponseEntity.created(location).body(newBookCopy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookCopy> update(@PathVariable Long id, @RequestBody BookCopy bookCopy) {
        BookCopy updatedBookCopy = bookCopyService.update(id, bookCopy);
        return ResponseEntity.ok(updatedBookCopy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookCopyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
