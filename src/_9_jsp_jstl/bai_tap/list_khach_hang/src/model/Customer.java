package model;

public class Customer {
    private String name;
    private String age;
    private String address;
    private String image;

    public Customer(String name, String age, String address, String image) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.image = image;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
