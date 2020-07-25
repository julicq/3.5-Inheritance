package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;


class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book aliceInWonderland = new Book(1, "Alice In Wonderland", 1000, "Lewis Carrol");
    private Book wizardOfOz = new Book(2, "Wizard Of Oz", 1200, "Frank L Baum");
    private Smartphone iPhone11 = new Smartphone(3, "iPhone 11", 85000, "Apple");
    private Smartphone galaxy20 = new Smartphone(4, "Galaxy 20", 68000, "Samsung");

    @BeforeEach
    public void setUp() {
        manager.add(aliceInWonderland);
        manager.add(aliceInWonderland);
        manager.add(iPhone11);
    }


    @Test
    public void shouldSaveOneItem() {
        manager.add(wizardOfOz);

        Product[] expected = new Product[]{aliceInWonderland,aliceInWonderland,iPhone11,wizardOfOz};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneBook() {
        manager.searchBy("alice");

        Product[] expected = new Product[] {aliceInWonderland};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindOneSmartphone() {
        manager.searchBy("iPhone11");

        Product[] expected = new Product[] {iPhone11};
        Product[] actual = manager.searchBy("iPhone11");
        assertArrayEquals(expected, actual);

    }
}