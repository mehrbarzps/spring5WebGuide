package repositories;

import org.springframework.data.repository.CrudRepository;

import model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
