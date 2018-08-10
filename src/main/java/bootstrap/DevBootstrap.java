package bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import model.Author;
import model.Book;
import model.Publisher;
import repositories.AuthorRepository;
import repositories.BookRepository;
import repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	
	

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
      initData();
		
	}
	
	private void initData() {
		
		Publisher publisher = new Publisher();
		publisher.setName("foo");
		
		publisherRepository.save(publisher);
		
		Author eric = new Author("Eric", "Jones");
		Book dp= new Book ("Design Patterns", "4325", publisher);
		eric.getBooks().add(dp);
		dp.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(dp);
		
		Author rod = new Author("rod", "Jons");
		Book noEJB = new Book("Developing in NodeJS", "432", publisher);
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
	}

	

}
