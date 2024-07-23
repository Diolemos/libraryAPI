package pedrodio.librarymanager.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import pedrodio.librarymanager.model.Book;
import pedrodio.librarymanager.service.BookService;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/books")
public class BookController {
    
     private final BookService bookService ;

     public BookController(BookService bookService){
        this.bookService = bookService;
     }

     @GetMapping("/{id}")
     public ResponseEntity<Book> findById(@PathVariable Long id){
        
        var book = bookService.findById(id);

        return ResponseEntity.ok(book);
     }

     @PostMapping
public ResponseEntity<Book> create(@RequestBody Book book) {
    var newBook = bookService.create(book);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(newBook.getId())
        .toUri();
    return ResponseEntity.created(location).body(newBook);
}

@PutMapping("/{id}")
public ResponseEntity<Book> update(@PathVariable Long id,  @RequestBody Book book) {
    var updatedBook = bookService.update(id,book);
   
    return ResponseEntity.ok(updatedBook);
}



}
