package csd230.s26.lab1.repositories;

import com.github.javafaker.Faker;
import csd230.s26.lab1.entities.BookEntity;
import csd230.s26.lab1.entities.DigitalGameEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class ProductRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private DigitalGameRepository digitalGameRepository;

    @Test
    void testSaveAndRetrieveBook() {
        Faker faker = new Faker();

        // 1. Create a fake book
        BookEntity book = new BookEntity(
                faker.book().author(),
                faker.book().title(),
                29.99,
                10
        );

        // 2. Save to database
        bookRepository.save(book);
        Long savedId = book.getId();
        assertNotNull(savedId, "ID should be generated upon saving");

        // 3. Retrieve and Verify
        BookEntity foundBook = bookRepository.findById(savedId).orElseThrow();
        assertEquals(book.getTitle(), foundBook.getTitle());
        assertEquals(book.getAuthor(), foundBook.getAuthor());

        System.out.println("Successfully verified book: " + foundBook.getTitle());
    }

    /**
     * Requirement 1: CRUD Test
     */
    @Test
    public void testSaveAndDeleteDigitalGame() {
        // Arrange
        DigitalGameEntity game = new DigitalGameEntity("Cyberpunk 2077", "RPG", "PC", 59.99, 70.0, "2.1");

        // Act - Save
        DigitalGameEntity savedGame = digitalGameRepository.save(game);
        assertNotNull(savedGame.getId(), "Entity should have an assigned ID after saving.");

        // Act - Delete
        digitalGameRepository.delete(savedGame);
        Optional<DigitalGameEntity> deletedGame = digitalGameRepository.findById(savedGame.getId());

        // Assert
        assertTrue(deletedGame.isEmpty(), "Entity should be successfully deleted from the database.");
    }

    /**
     * Requirement 2: Derived Query Test
     */
    @Test
    public void testDerivedQueryFindByTitle() {
        // Arrange
        DigitalGameEntity game1 = new DigitalGameEntity("Hades", "Roguelike", "Switch", 24.99, 15.0, "1.0");
        DigitalGameEntity game2 = new DigitalGameEntity("Elden Ring", "Action RPG", "PC", 59.99, 60.0, "1.12");
        digitalGameRepository.save(game1);
        digitalGameRepository.save(game2);

        // Act
        List<DigitalGameEntity> results = digitalGameRepository.findByTitle("Hades");

        // Assert
        assertEquals(1, results.size(), "Should find exactly one game with the title 'Hades'.");
        assertEquals("Roguelike", results.get(0).getGenre(), "The found game genre should match.");
    }

    /**
     * Requirement 3: Niche Test
     */
    @Test
    public void testNicheEntityFieldsSaveAndRetrieve() {
        // Arrange
        double expectedStorage = 105.5;
        String expectedVersion = "v1.0.4a";
        DigitalGameEntity digitalGame = new DigitalGameEntity("Baldur's Gate 3", "RPG", "PS5", 69.99, expectedStorage, expectedVersion);

        // Act
        DigitalGameEntity savedGame = digitalGameRepository.save(digitalGame);
        Optional<DigitalGameEntity> retrievedGameOpt = digitalGameRepository.findById(savedGame.getId());

        // Assert
        assertTrue(retrievedGameOpt.isPresent(), "Game should be present in database.");
        DigitalGameEntity retrievedGame = retrievedGameOpt.get();

        assertEquals(expectedStorage, retrievedGame.getStorageSizeGb(), 0.001, "Storage size should match.");
        assertEquals(expectedVersion, retrievedGame.getVersion(), "Version string should match.");
    }
}