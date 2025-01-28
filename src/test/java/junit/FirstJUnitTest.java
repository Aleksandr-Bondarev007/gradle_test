package junit;

import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeAll
     // перед всеми тестами
    static void beforeAll() {
        System.out.println("перед всеми тестами");
    }

    @BeforeEach // перед каждым тестом
    void beforeEach(){
        System.out.println("перед каждым тестом");
    }

    @AfterEach // после каждым тестом
    void afterEach() {
        System.out.println("после каждого теста");

    }

    @Test
    void firstTest(){
        Assertions.assertTrue( 3>2);
        System.out.println("три больше двух");
    }

    @Test
    void secondTest(){
        Assertions.assertTrue( 10>5);
        System.out.println("десять больше пяти");
    }

    @AfterAll
    // перед всеми тестами
    static void afterAll() {
        System.out.println("после всех тестов");
    }
}
