package Assignment3Q1.accolite.Library.Management.service;

import Assignment3Q1.accolite.Library.Management.entity.Book;
import Assignment3Q1.accolite.Library.Management.entity.Genre;
import Assignment3Q1.accolite.Library.Management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Assignment3Q1.accolite.Library.Management.repository.GenreRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> searchBooks(String query) {
        return bookRepository.findByBookNameContaining(query);
    }

    public List<Book> searchBooksByGenre(String query) {
        return bookRepository.findByGenresGenreType(query);
    }

    public List<Book> searchByAuthor(String query){
        return bookRepository.findByAuthorNameContaining(query);
    }

    @Transactional
    public Book addBook(Book book) {
        if (book.getGenres() == null) {
            book.setGenres(new ArrayList<>());
        }
        for (Genre genre : book.getGenres()) {
            Optional<Genre> existingGenre = genreRepository.findById(genre.getId());
            if (existingGenre.isEmpty()) { genreRepository.save(genre);
            }
        }
        return bookRepository.save(book);
    }


    @Transactional
    public Book updateBook(int id, Book updatedBook) {
        Optional<Book> bookOpt = bookRepository.findById(id);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setBookName(updatedBook.getBookName());
            book.setAuthorName(updatedBook.getAuthorName());
            book.setGenres(updatedBook.getGenres());
            book.setRentAmt(updatedBook.getRentAmt());
            return bookRepository.save(book);
        }
        return null;
    }

    @Transactional
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
