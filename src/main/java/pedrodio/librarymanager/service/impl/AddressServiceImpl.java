package pedrodio.librarymanager.service.impl;

import org.springframework.stereotype.Service;
import pedrodio.librarymanager.model.Address;
import pedrodio.librarymanager.repository.AddressRepository;
import pedrodio.librarymanager.service.AddressService;
import pedrodio.librarymanager.service.exception.NotFoundException;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long id, Address address) {
        Address existingAddress = findById(id);
        existingAddress.setStreetName(address.getStreetName());
        existingAddress.setHouseNumber(address.getHouseNumber());
        existingAddress.setComplement(address.getComplement());
        existingAddress.setZipCode(address.getZipCode());
        return addressRepository.save(existingAddress);
    }

    @Override
    public void delete(Long id) {
        Address existingAddress = findById(id);
        addressRepository.delete(existingAddress);
    }
}
