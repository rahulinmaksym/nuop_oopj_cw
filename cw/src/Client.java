import java.io.Serializable;

public class Client implements IPerson, Serializable {

    private String name;
    private String address;
    private int phoneNumber;
    private long orderId;

    public Client(String name, String address, int phoneNumber, long orderId) {
        setName(name);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setOrderId(orderId);
    }

    @Override
    public void callNumber(int phoneNumber) {
        if(phoneNumber == Administrator.getPhoneNumber()) {
            System.out.println("Calling administrator...\n");
        }
        else {
            System.out.println("Why would you call this number?\n");
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", orderId=" + orderId +
                "}\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
