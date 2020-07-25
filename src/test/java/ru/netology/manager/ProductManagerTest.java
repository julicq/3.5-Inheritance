package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager = new ProductManager(repository);
    private Book aliceInWonderland = new Book(1, "Alice In Wonderland", 1000, "Lewis Carrol");
    private Book wizardOfOz = new Book(2, "Wizard Of Oz", 1200, "Frank L Baum");
    private Smartphone iPhone11 = new Smartphone(3, "iPhone 11", 85000, "Apple");
    private Smartphone galaxy20 = new Smartphone(4, "Galaxy 20", 68000, "Samsung");

    @BeforeEach
    public void setUp() {
        repository.save(aliceInWonderland);
        repository.save(wizardOfOz);
        repository.save(iPhone11);
        repository.save(galaxy20);
    }

    @Test
    void searchBy() {
        manager.searchBy("alice");

        Product[] expected = new Product[] {aliceInWonderland};
        Product[] actual = repository.findAll();
        assertEquals(expected, actual);

    }
}