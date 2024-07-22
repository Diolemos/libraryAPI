package pedrodio.librarymanager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pedrodio.librarymanager.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    

    
}