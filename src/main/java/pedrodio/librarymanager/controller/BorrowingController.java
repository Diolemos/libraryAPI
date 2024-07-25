package pedrodio.librarymanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedrodio.librarymanager.model.Borrowing;
import pedrodio.librarymanager.service.BorrowingService;

import java.net.URI;
import java.util.List;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping
    public ResponseEntity<List<Borrowing>> findAll() {
        List<Borrowing> borrowings = borrowingService.findAll();
        return ResponseEntity.ok(borrowings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrowing> findById(@PathVariable Long id) {
        Borrowing borrowing = borrowingService.findById(id);
        return ResponseEntity.ok(borrowing);
    }

    @PostMapping
    public ResponseEntity<Borrowing> create(@RequestBody Borrowing borrowing) {
        Borrowing newBorrowing = borrowingService.create(borrowing);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(newBorrowing.getId())
            .toUri();
        return ResponseEntity.created(location).body(newBorrowing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrowing> update(@PathVariable Long id, @RequestBody Borrowing borrowing) {
        Borrowing updatedBorrowing = borrowingService.update(id, borrowing);
        return ResponseEntity.ok(updatedBorrowing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        borrowingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
