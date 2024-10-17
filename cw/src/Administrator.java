import java.util.List;

public class Administrator implements IPerson {

    private String bHName;
    private String adminName;
    private static int phoneNumber;
    private List<Order> orders;
    private List<Client> clients;

    public Administrator(String bHName, String adminName, List<Order> orders, List<Client> clients) {
        setBHName(bHName);
        setAdminName(adminName);
        setOrders(orders);
        setClients(clients);
    }

    public List<Order> getOrdersFromAtoB(int a, int b) {
        return orders;
    }

    public List<Client> getAllClients() {
        return clients;
    }

    public String getMostPopularOrderType() {
        return orders.getFirst().getOrderType();
    }

    public int getAverageMealCount() {
        return orders.size();
    }

    public double getTheBiggestPrice() {
        return orders.getFirst().getPrice();
    }

    public double getTheMostPopularStartingTime() {
        return orders.getFirst().getStartsAt();
    }

    @Override
    public void callNumber(int phoneNumber) {
        System.out.println("Calling a client...\n");
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "bHName='" + bHName + '\'' +
                ", adminName='" + adminName + '\'' +
                ", orders=" + orders +
                ", clients=" + clients +
                "}\n";
    }

    public String getBHName() {
        return bHName;
    }

    public void setBHName(String bHName) {
        this.bHName = bHName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public static int getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(int phoneNumber) {
        Administrator.phoneNumber = phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
