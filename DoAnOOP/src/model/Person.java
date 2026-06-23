package model;

public abstract class Person {

    protected String id;
    protected String name;
    protected String address;
    protected String phone;
    protected String email;
    
    private static int totalPersons = 0;

    public Person() {
        totalPersons++;
    }

    public Person(String id, String name, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        totalPersons++;
    }

    //Getter/Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public static int getTotalPersons() { return totalPersons; }

    // Abstract method
    public abstract void displayInfo();
}