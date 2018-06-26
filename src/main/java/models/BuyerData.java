package models;

import java.util.Random;

public class BuyerData {
    private String name;
    private String surname;
    private String email;
    private String address = "Test Address";
    private String city = "TestCity";
//    private String post = String.valueOf(System.currentTimeMillis());
    private int post = gen();
    private long phone = System.currentTimeMillis();

    public BuyerData(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getPost() {
        return post;
    }

    public long getPhone() {
        return phone;
    }

    public int gen() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

    public static BuyerData generate() {
        return new BuyerData(
                "FirstName",
                "LastName",
                "email" + System.currentTimeMillis() + "@mail.com");
    }

}