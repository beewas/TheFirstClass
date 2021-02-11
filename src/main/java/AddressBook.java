import java.util.*;

public class AddressBook {
    private static class Address{
        String street;
        int build, flat;

        public Address (String str, int h, int n) { street = str; build = h; flat = n; }

        public String getStreet() { return street; }
        public int getBuild() { return build; }
        public int getFlat() { return flat; }
        public String getAddress() { return street + " " + build + ", " + flat; }
        public void setAddress(String str, int bld, int flt) { street = str; build = bld; flat = flt; }
    }

    HashMap<String, Address> data = new HashMap<>();

    public void add(String name, String str, int bld, int flt) { data.put(name, new Address(str, bld, flt));}
    public void delete(String name) { data.remove(name);
    }
    public void changeAddress(String name, String str, int bld, int flt) {
        if (data.containsKey(name)) data.get(name).setAddress(str, bld, flt);
        else throw new IllegalArgumentException("There is no " + name + "!");
    }
    public String getAddress(String name) {
        if (data.containsKey(name)) return data.get(name).getAddress();
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