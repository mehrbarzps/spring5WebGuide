package repositories;

import org.springframework.data.repository.CrudRepository;

import model.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
