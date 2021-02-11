import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    @Test
    void add() {
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        assertEquals("Avenue 5, 32", ab.getAddress("John"));
    }

    @Test
    void delete() {
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        assertEquals("Avenue 5, 32", ab.getAddress("John"));
        ab.delete("John");
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> ab.getAddress("John"));
        assertNotNull(thr.getMessage());
    }

    @Test
    void changeAddress() {
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        ab.changeAddress("John", "Laguna", 12, 3);
        assertEquals("Laguna 12, 3", ab.getAddress("John"));
    }

    @Test
    void getAddress() {
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        assertEquals("Avenue 5, 32", ab.getAddress("John"));
    }

    @Test
    void getPeopleByStreet() {
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        ab.add("Loki", "Avenue", 3, 42);
        ab.add("Zeus", "Laguna", 2, 12);
        HashSet<String> al = new HashSet<>();
        al.add("John");
        al.add("Loki");
        assertEquals(al, ab.getPeopleByStreet("Avenue"));
    }

    @Test
    void getPeopleByStreetAndBuild(){
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        ab.add("Loki", "Avenue", 3, 42);
        ab.add("Thor", "Avenue", 3, 41);
        ab.add("Zeus", "Laguna", 2, 12);
        HashSet<String> al = new HashSet<>();
        al.add("Thor");
        al.add("Loki");
        assertEquals(al, ab.getPeopleByStreetAndBuild("Avenue", 3));
    }
}