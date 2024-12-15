package Assignment3Q1.accolite.Library.Management.service;

import Assignment3Q1.accolite.Library.Management.entity.Genre;
import Assignment3Q1.accolite.Library.Management.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre getGenreById(int id) {
        return genreRepository.findById(id).orElse(null);
    }

    public Genre addGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(int id, Genre updatedGenre) {
        Optional<Genre> genreOpt = genreRepository.findById(id);
        if (genreOpt.isPresent()) {
            Genre genre = genreOpt.get();
            genre.setGenreType(updatedGenre.getGenreType());
            genre.setBooks(updatedGenre.getBooks());
            return genreRepository.save(genre);
        }
        return null;
    }

    public void deleteGenre(int id) {
        genreRepository.deleteById(id);
    }
}
