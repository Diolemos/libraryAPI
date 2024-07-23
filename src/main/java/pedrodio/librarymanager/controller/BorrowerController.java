package pedrodio.librarymanager.controller;

import java.net.URI;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pedrodio.librarymanager.model.Borrower;
import pedrodio.librarymanager.service.BorrowerService;

@RestController
public class BorrowerController {
   private final BorrowerService borrowerService;

   public BorrowerController(BorrowerService borrowerService){
    this.borrowerService = borrowerService;
   }





    @GetMapping("/{id}")
    public ResponseEntity<Borrower>findById(@PathVariable Long id){
       Borrower borrower = borrowerService.findById(id);
       return ResponseEntity.ok(borrower);
    }
    
    
    @PostMapping
    public ResponseEntity<Borrower> create(@RequestBody Borrower borrower){
        var newBorrower = borrower;
         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(newBorrower.getId())
        .toUri();
        return ResponseEntity.created(location).body(newBorrower);
    }






}
