import java.io.Serializable;

public class Order implements Serializable {

    private String address;
    private String orderType;
    private int guestNumber;
    private String date;
    private double startsAt;
    private int mealNumber;
    private double price;
    private long id;

    public Order(String address, String orderType, int guestNumber, String date, double startsAt, int mealNumber, double price, long id) {
        setAddress(address);
        setOrderType(orderType);
        setGuestNumber(guestNumber);
        setDate(date);
        setStartsAt(startsAt);
        setMealNumber(mealNumber);
        setPrice(price);
        setId(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "address='" + address + '\'' +
                ", orderType='" + orderType + '\'' +
                ", guestNumber=" + guestNumber +
                ", date='" + date + '\'' +
                ", startsAt=" + startsAt +
                ", mealNumber=" + mealNumber +
                ", price=" + price +
                ", id=" + id +
                "}\n";
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public int getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(int guestNumber) {
        if(guestNumber > 0 && guestNumber < 100) {
            this.guestNumber = guestNumber;
        }
        else {
            System.out.println("Invalid guest number\n");
            this.guestNumber = 1;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(double startsAt) {
        this.startsAt = startsAt;
    }

    public int getMealNumber() {
        return mealNumber;
    }

    public void setMealNumber(int mealNumber) {
        if(mealNumber > 0 && mealNumber < 100) {
            this.mealNumber = mealNumber;
        }
        else {
            System.out.println("Invalid meal number\n");
            this.mealNumber = 1;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0) {
            this.price = price;
        }
        else {
            System.out.println("Invalid price\n");
            this.price = 1;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
