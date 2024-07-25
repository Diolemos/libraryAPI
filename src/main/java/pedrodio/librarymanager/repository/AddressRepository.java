package pedrodio.librarymanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pedrodio.librarymanager.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
