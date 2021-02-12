import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    @Test
    void add() {
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        assertEquals(new AddressBook.Address("Avenue", 5, 32), ab.getAddress("John"));
    }

    @Test
    void delete() {
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        assertEquals(new AddressBook.Address("Avenue", 5, 32), ab.getAddress("John"));
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> ab.delete("John"));
        assertNotNull(thr.getMessage());
    }

    @Test
    void changeAddress() {
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        ab.changeAddress("John", "Laguna", 12, 3);
        assertEquals(new AddressBook.Address("Laguna", 12, 3), ab.getAddress("John"));
    }

    @Test
    void getAddress() {
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        assertEquals(new AddressBook.Address("Avenue", 5, 32), ab.getAddress("John"));
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

    @Test
    void equalsTest(){
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        ab.add("Loki", "Avenue", 3, 42);
        AddressBook ad = new AddressBook();
        ad.add("John", "Avenue", 5, 32);
        ad.add("Loki", "Avenue", 3, 42);
        assertEquals(ad, ab);
    }

    @Test
    void hashCodeTest(){
        AddressBook ab = new AddressBook();
        ab.add("John", "Avenue", 5, 32);
        ab.add("Loki", "Avenue", 3, 42);
        AddressBook ad = new AddressBook();
        ad.add("John", "Avenue", 5, 32);
        ad.add("Loki", "Avenue", 3, 42);
        assertEquals(ad.hashCode(), ab.hashCode());
    }
}