package pedrodio.librarymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pedrodio.librarymanager.model.BookCopy;

public interface CopyRepository extends JpaRepository<BookCopy, Long>  {
    
}
