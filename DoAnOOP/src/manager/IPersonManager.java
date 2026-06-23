package manager;

import model.Person;

public interface IPersonManager {
    void addPerson(Person p);
    void editPerson(String id);
    void deletePerson(String id);
    void searchPerson(String name);
    void displayAll();
}
// Khai bao cac chuc nang quan ly co ban: them, xoa, sua, tim kiem