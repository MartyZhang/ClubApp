package martin.hksn.com.hksnapp2015.sponsors;

/**
 * Created by yanqzhang on 8/20/15.
 */
public class Sponsor {
    private int name;
    private int description;
    private int address;
    private int phone_number;
    private int hours;
    private int discount;
    private int imageResource;

    public Sponsor(int name, int description, int address, int phone_number, int hours, int discount, int imageResource) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone_number = phone_number;
        this.hours = hours;
        this.discount = discount;
        this.imageResource = imageResource;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

}
