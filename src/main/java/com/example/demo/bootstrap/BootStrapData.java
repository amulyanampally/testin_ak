package com.example.demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.print("hehehehe");
		Author amulya = new Author("amulya", "nampally");
		Book meetBook = new Book("meet me in another life", "2345");
		amulya.getBooks().add(meetBook);
		meetBook.getAuthors().add(amulya);
		authorRepository.save(amulya);
		bookRepository.save(meetBook);

		Author pandu = new Author("saiprathibha", "nampally");
		Book cppBook = new Book("cpp", "43");
		pandu.getBooks().add(cppBook);
		cppBook.getAuthors().add(pandu);
		authorRepository.save(pandu);
		bookRepository.save(cppBook);

		Publisher publisher = new Publisher();
		publisher.setName("deepthi");
		publisher.setAddress("Hyderabad");
		publisher.getBooks().add(meetBook);
		publisher.getBooks().add(cppBook);
		publisherRepository.save(publisher);

		meetBook.setPublisher(publisher);
		cppBook.setPublisher(publisher);

		System.out.println("no. of books" + bookRepository.count());
		System.out.println("no. of authors" + authorRepository.count());
		System.out.println("no. of books of publishers" + publisherRepository.count());

	}

}
