/**
 * CS50004 CSA 2025Fall
 * Lirui Liu
 * Lab 1
 */

public class Person {
    private String name;
    private String email;
    private String address;

    public Person(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() { return this.name;}
    public String getEmail() { return this.email;}
    public String getAddress() { return this.address;}
}
