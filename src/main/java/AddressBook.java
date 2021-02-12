import java.util.*;

public class AddressBook {
    public static class Address{
        private final String street;
        private final int build, flat;

        public Address (String str, int h, int n) { street = str; build = h; flat = n; }

        public String getStreet() { return street; }
        public int getBuild() { return build; }
        public int getFlat() { return flat; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address a = (Address) o;
            return a.street.equals(street) && a.build == build && a.flat == flat;
        }

        @Override
        public int hashCode() { return street.hashCode() + build * 101 + flat * 73; }
    }

    private final HashMap<String, Address> data = new HashMap<>();

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook ab = (AddressBook) o;
        return data.equals(ab.data);
    }

    @Override
    public int hashCode(){ return data.hashCode(); }

    public void add(String name, String str, int bld, int flt) {
        if (data.containsKey(name)) throw new IllegalStateException("There is already " + name + "!");
        else data.put(name, new Address(str, bld, flt));
    }
    public void delete(String name) {
        if (data.containsKey(name)) throw new IllegalArgumentException("There is no " + name + "!");
        else data.remove(name);
    }
    public void changeAddress(String name, String str, int bld, int flt) {
        if (data.containsKey(name)) data.put(name, new Address(str, bld, flt));
        else throw new IllegalArgumentException("There is no " + name + "!");
    }
    public Address getAddress(String name) {
        if (data.containsKey(name)) return data.get(name);
        else throw new IllegalArgumentException("There is no " + name + "!");
    }
    public Set<String> getPeopleByStreet(String str) {
        Set<String> out = new HashSet<>();
        data.forEach((k, v) -> { if (v.getStreet().equals(str)) out.add(k); });
        return out;
    }
    public Set<String> getPeopleByStreetAndBuild(String str, int build){
        Set<String> out = new HashSet<>();
        data.forEach((k, v) -> { if (v.getStreet().equals(str) && v.getBuild() == build) out.add(k); });
        return out;
    }
}