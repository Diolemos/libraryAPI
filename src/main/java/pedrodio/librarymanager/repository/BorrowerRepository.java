package pedrodio.librarymanager.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import pedrodio.librarymanager.model.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
    List<Borrower> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);

    
}
