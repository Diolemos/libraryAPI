package pedrodio.librarymanager.service;

import org.springframework.stereotype.Service;
import pedrodio.librarymanager.model.Borrower;
import java.util.List;
@Service
public interface BorrowerService extends CrudService<Long, Borrower> {
    List<Borrower> findByName(String name);
}
