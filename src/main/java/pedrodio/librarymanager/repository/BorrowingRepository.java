package pedrodio.librarymanager.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import pedrodio.librarymanager.model.Borrowing;


public interface BorrowingRepository extends JpaRepository<Borrowing,Long> {
    
}
