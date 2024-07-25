package pedrodio.librarymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pedrodio.librarymanager.model.Address;
import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
