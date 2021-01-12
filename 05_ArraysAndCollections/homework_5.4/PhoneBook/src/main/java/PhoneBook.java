import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

    public static final String NAME_CHECK_REGEX = "[A-zА-я|\\s]+";
    public static final String PHONE_CHECK_REGEX = "[7][\\d]{10}";

    private TreeMap<String, String> treeMap = new TreeMap();
    private Set<String> listOfContacts = new TreeSet<>();
    private Set<Map.Entry<String, String>> entries;

    public void addContact(String phone, String name) {
        if (name.matches(NAME_CHECK_REGEX) && phone.matches(PHONE_CHECK_REGEX)){
            treeMap.put(phone, name);
        }
    }

    public String getNameByPhone(String phone) {
        if (treeMap.containsKey(phone)){
            return treeMap.get(phone) + " - " + phone;
        } else {
            return "";
        }
    }

    public Set<String> getPhonesByName(String name) {
        listOfContacts.clear();
        entries = treeMap.entrySet();

        for( Map.Entry<String, String> entry : entries ){
            String nameInBook = entry.getValue();
            if(nameInBook.equals(name)){
                listOfContacts.add(nameInBook + " - " + entry.getKey());
            }
        }

        return listOfContacts;
    }

    public Set<String> getAllContacts() {
        listOfContacts.clear();
        entries = treeMap.entrySet();

        for( Map.Entry<String, String> entry : entries ){
           listOfContacts.add(entry.getValue() + " - " + entry.getKey());
        }

        return listOfContacts;
    }

}