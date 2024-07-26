package pedrodio.librarymanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedrodio.librarymanager.model.Borrower;
import pedrodio.librarymanager.service.BorrowerService;

import java.net.URI;
import java.util.List;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/borrowers")
public class BorrowerController {

    private final BorrowerService borrowerService;

    
    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @GetMapping
    public ResponseEntity<List<Borrower>> findAll() {
        List<Borrower> borrowers = borrowerService.findAll();
        return ResponseEntity.ok(borrowers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrower> findById(@PathVariable Long id) {
        Borrower borrower = borrowerService.findById(id);
        return ResponseEntity.ok(borrower);
    }

    @PostMapping
    public ResponseEntity<Borrower> create(@RequestBody Borrower borrower) {
        Borrower newBorrower = borrowerService.create(borrower);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(newBorrower.getId())
            .toUri();
        return ResponseEntity.created(location).body(newBorrower);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrower> update(@PathVariable Long id, @RequestBody Borrower borrower) {
        Borrower updatedBorrower = borrowerService.update(id, borrower);
        return ResponseEntity.ok(updatedBorrower);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        borrowerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Borrower>> findByName(@RequestParam String name) {
        List<Borrower> borrowers = borrowerService.findByName(name);
        return ResponseEntity.ok(borrowers);
    }
}
