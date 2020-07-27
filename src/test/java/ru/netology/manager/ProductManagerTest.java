package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;


class ProductManagerTest {
    private final ProductRepository repository = new ProductRepository();
    private final ProductManager manager = new ProductManager(repository);
    private final Book aliceInWonderland = new Book(1, "Alice In Wonderland", 1000, "Lewis Carrol");
    private final Book wizardOfOz = new Book(2, "Wizard Of Oz", 1200, "Frank L Baum");
    private final Smartphone iPhone11 = new Smartphone(3, "iPhone 11", 85000, "Apple");

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
    public void shouldFindTwoBooks() {
        manager.searchBy("Alice In Wonderland");

        Product[] expected = new Product[] {aliceInWonderland,aliceInWonderland};
        Product[] actual = manager.searchBy("Alice In Wonderland");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindOneSmartphone() {
        manager.searchBy("iPhone 11");

        Product[] expected = new Product[] {};
        Product[] actual = manager.searchBy("iPhone 11");
        assertArrayEquals(expected, actual);

    }

}