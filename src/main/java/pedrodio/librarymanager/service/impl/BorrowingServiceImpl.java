package pedrodio.librarymanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pedrodio.librarymanager.model.Borrowing;
import pedrodio.librarymanager.repository.BorrowingRepository;
import pedrodio.librarymanager.service.BorrowingService;
import pedrodio.librarymanager.service.exception.NotFoundException;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    
@Autowired
BorrowingRepository borrowingRepository;
    

     @Override
     public Borrowing create(Borrowing entity) {
          
        return borrowingRepository.save(entity);
     }   

     @Override
     public List<Borrowing> findAll() {
       return  borrowingRepository.findAll(); 
        
     }

     @Override
     public void delete(Long id) {
       borrowingRepository.deleteById(id);         
     }

     @Override
     public Borrowing findById(Long id) {
         // TODO Auto-generated method stub
         return borrowingRepository.findById(id).orElseThrow(()-> new NotFoundException("Could not find Borrowing element with id " + id));
     }

     @Override
     public Borrowing update(Long id, Borrowing entity) {
        Borrowing existingBorrowing = borrowingRepository.findById(entity.getId()).orElseThrow(()->new IllegalArgumentException("Could not find Borrowing with the Id " + id));
        
        existingBorrowing.setBook(entity.getBook());
        existingBorrowing.setBorrowedDate(entity.getBorrowedDate());
        existingBorrowing.setBorrower(entity.getBorrower());
        existingBorrowing.setReturnDate(entity.getReturnDate());
        
        
        return borrowingRepository.save(existingBorrowing);
     }
}
