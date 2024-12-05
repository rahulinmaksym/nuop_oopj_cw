import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Administrator implements IPerson, Serializable {

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
        phoneNumber = 4201488;
    }

    public Administrator(String bHName, String adminName) {
        setBHName(bHName);
        setAdminName(adminName);
        setOrders(new ArrayList<>());
        setClients(new ArrayList<>());
        phoneNumber = 4201488;
    }

    public List<Order> getOrdersFromAtoB(int a, int b) {
        List<Order> result = new ArrayList<>();
        for (int i = a-1; i <= b-1; i++) {
            result.add(orders.get(i));
        }
        return result;
    }

    public List<Client> getAllClients() {
        return clients;
    }

    public String getMostPopularOrderType() {

        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (Order order : orders) {
            frequencyMap.put(order.getOrderType(), frequencyMap.getOrDefault(order.getOrderType(), 0) + 1);
        }

        String mostFrequentType = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentType = entry.getKey();
            }
        }

        return mostFrequentType;
    }

    public int getAverageMealCount() {
        int averageMealCount = 0;
        for (Order order : orders) {
            averageMealCount += order.getMealNumber();
        }
        return Math.round((float) averageMealCount / orders.size());
    }

    public double getTheBiggestPrice() {

        double maxValue = orders.getFirst().getPrice();

        for (Order order : orders) {
            if (order.getPrice() > maxValue) {
                maxValue = order.getPrice();
            }
        }

        return maxValue;
    }

    public double getTheMostPopularStartingTime() {

        HashMap<Double, Integer> frequencyMap = new HashMap<>();

        for (Order order : orders) {
            frequencyMap.put(order.getStartsAt(), frequencyMap.getOrDefault(order.getStartsAt(), 0) + 1);
        }

        Double mostFrequentPrice = 0.0;
        int maxCount = 0;

        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentPrice = entry.getKey();
            }
        }

        return mostFrequentPrice;
    }

    @Override
    public void callNumber(int phoneNumber) {
        System.out.println("Calling " + phoneNumber);
    }

    @Override
    public String toString() {
        return "Banquette hall name: " + bHName + ", \n" +
                "Admin name: " + adminName + ", \n";
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
