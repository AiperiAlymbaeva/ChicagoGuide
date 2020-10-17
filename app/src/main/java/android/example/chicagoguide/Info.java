package android.example.chicagoguide;

public class Info {

    private String title;
    private String description;
    private String address;



    private String price;
    private String phoneNumber = NOT_PROVIDED;
    private String hours = NOT_PROVIDED;
    private int imageResourceId;

    private static final String NOT_PROVIDED = null;




    public Info(String title, String description, String hours, int imageResourceId, String address) {
        this.title = title;
        this.description = description;
        this.hours = hours;
        this.address = address;

        this.imageResourceId = imageResourceId;
    }

    public Info(String title, String description, String price, String phoneNumber, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHours() {
        return hours;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean hasNumber() {
        return getPhoneNumber() != NOT_PROVIDED;
    }
    public boolean hasHours() {
        return getHours() != NOT_PROVIDED;
    }
    public String getPrice() {
        return price;
    }
}
