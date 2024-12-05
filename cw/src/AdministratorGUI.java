import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.List;

public class AdministratorGUI {
    private JFrame frame;

    private JTextField bHNameField;
    private JTextField adminNameField;

    private JTextField clientNameField;
    private JTextField clientAddressField;
    private JTextField clientPhoneNumberField;
    private JTextField clientsOrderIdField;

    private JTextField orderAddressField;
    private JTextField orderTypeField;
    private JTextField orderGuestNumberField;
    private JTextField orderDateField;
    private JTextField orderStartsAtField;
    private JTextField orderMealNumberField;
    private JTextField orderPriceField;
    private JTextField orderIdField;

    private JButton saveAdminButton;
    private JButton loadAdminButton;
    private JButton addClientButton;
    private JButton addOrderButton;

    private JLabel adminLabel;
    private JLabel ordersLabel;
    private JLabel clientsLabel;

    private JTextField aField;
    private JTextField bField;
    private JButton aToBButton;
    private JLabel aToBLabel;

    private JButton allClientsButton;
    private JLabel allClientsLabel;

    private JButton mostPopularOrderTypeButton;
    private JLabel mostPopularOrderTypeLabel;

    private JButton averageMealCountButton;
    private JLabel averageMealCountLabel;

    private JButton biggestPriceButton;
    private JLabel biggestPriceLabel;

    private JButton mostPopularStartingTimeButton;
    private JLabel mostPopularStartingTimeLabel;

    public AdministratorGUI() {
        frame = new JFrame("Banquette Hall");
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2));

        bHNameField = new JTextField(20);
        adminNameField = new JTextField(20);
        clientNameField = new JTextField(20);
        clientAddressField = new JTextField(20);
        clientPhoneNumberField = new JTextField(20);
        clientsOrderIdField = new JTextField(20);
        orderAddressField = new JTextField(20);
        orderTypeField = new JTextField(20);
        orderGuestNumberField = new JTextField(20);
        orderDateField = new JTextField(20);
        orderStartsAtField = new JTextField(20);
        orderMealNumberField = new JTextField(20);
        orderPriceField = new JTextField(20);
        orderIdField = new JTextField(20);

        saveAdminButton = new JButton("New admin");
        loadAdminButton = new JButton("Load admin");
        addClientButton = new JButton("Add client");
        addOrderButton = new JButton("Add order");

        adminLabel = new JLabel();
        ordersLabel = new JLabel();
        clientsLabel = new JLabel();

        aField = new JTextField(20);
        bField = new JTextField(20);
        aToBButton = new JButton("Get orders from a to b");
        aToBLabel = new JLabel();

        allClientsButton = new JButton("Get all clients");
        allClientsLabel = new JLabel();

        mostPopularOrderTypeButton = new JButton("Get most popular order type");
        mostPopularOrderTypeLabel = new JLabel();

        averageMealCountButton = new JButton("Get average meal count");
        averageMealCountLabel = new JLabel();

        biggestPriceButton = new JButton("Get biggest price");
        biggestPriceLabel = new JLabel();

        mostPopularStartingTimeButton = new JButton("Get most popular start time");
        mostPopularStartingTimeLabel = new JLabel();

        frame.add(new JLabel("Banquette hall name:"));
        frame.add(bHNameField);
        frame.add(new JLabel("Admin name:"));
        frame.add(adminNameField);
        frame.add(new JLabel("Client name:"));
        frame.add(clientNameField);
        frame.add(new JLabel("Client address:"));
        frame.add(clientAddressField);
        frame.add(new JLabel("Client phone number:"));
        frame.add(clientPhoneNumberField);
        frame.add(new JLabel("Client order id:"));
        frame.add(clientsOrderIdField);
        frame.add(new JLabel("Order address:"));
        frame.add(orderAddressField);
        frame.add(new JLabel("Order type:"));
        frame.add(orderTypeField);
        frame.add(new JLabel("Order guest number:"));
        frame.add(orderGuestNumberField);
        frame.add(new JLabel("Order date:"));
        frame.add(orderDateField);
        frame.add(new JLabel("Order starts at:"));
        frame.add(orderStartsAtField);
        frame.add(new JLabel("Order meal number:"));
        frame.add(orderMealNumberField);
        frame.add(new JLabel("Order price:"));
        frame.add(orderPriceField);
        frame.add(new JLabel("Order id:"));
        frame.add(orderIdField);

        frame.add(saveAdminButton);
        frame.add(loadAdminButton);
        frame.add(addClientButton);
        frame.add(addOrderButton);

        frame.add(adminLabel);
        frame.add(ordersLabel);
        frame.add(clientsLabel);
        frame.add(new Label("meow"));

        frame.add(aField);
        frame.add(bField);
        frame.add(aToBButton);
        frame.add(aToBLabel);

        frame.add(allClientsButton);
        frame.add(allClientsLabel);

        frame.add(mostPopularOrderTypeButton);
        frame.add(mostPopularOrderTypeLabel);

        frame.add(averageMealCountButton);
        frame.add(averageMealCountLabel);

        frame.add(biggestPriceButton);
        frame.add(biggestPriceLabel);

        frame.add(mostPopularStartingTimeButton);
        frame.add(mostPopularStartingTimeLabel);

        saveAdminButton.addActionListener(_ -> saveAdmin());
        loadAdminButton.addActionListener(_ -> loadAdmin());
        addClientButton.addActionListener(_ -> addClient());
        addOrderButton.addActionListener(_ -> addOrder());

        aToBButton.addActionListener(_ -> getOrdersFromAtoB());

        allClientsButton.addActionListener(_ -> getAllClients());

        mostPopularOrderTypeButton.addActionListener(_ -> getMostPopularOrderType());

        averageMealCountButton.addActionListener(_ -> getAverageMealCount());

        biggestPriceButton.addActionListener(_ -> getTheBiggestPrice());

        mostPopularStartingTimeButton.addActionListener(_ -> getTheMostPopularStartingTime());

        frame.setVisible(true);
    }

    private void getTheMostPopularStartingTime() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("administrator.dat"))) {
            Administrator admin = (Administrator) in.readObject();
            mostPopularStartingTimeLabel.setText("" + admin.getTheMostPopularStartingTime());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error loading administrator: " + e.getMessage());
        }
    }

    private void getTheBiggestPrice() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("administrator.dat"))) {
            Administrator admin = (Administrator) in.readObject();
            biggestPriceLabel.setText("" + admin.getTheBiggestPrice());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error loading administrator: " + e.getMessage());
        }
    }

    private void getAverageMealCount() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("administrator.dat"))) {
            Administrator admin = (Administrator) in.readObject();
            averageMealCountLabel.setText("" + admin.getAverageMealCount());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error loading administrator: " + e.getMessage());
        }
    }

    private void getMostPopularOrderType() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("administrator.dat"))) {
            Administrator admin = (Administrator) in.readObject();
            mostPopularOrderTypeLabel.setText(admin.getMostPopularOrderType());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error loading administrator: " + e.getMessage());
        }
    }

    private void getAllClients() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("administrator.dat"))) {
            Administrator admin = (Administrator) in.readObject();
            List<Client> clients = admin.getAllClients();
            allClientsLabel.setText(clients.toString());
            JOptionPane.showMessageDialog(frame, clients.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error loading administrator: " + e.getMessage());
        }
    }

    private void getOrdersFromAtoB() {

        if(aField.getText().isEmpty() || bField.getText().isEmpty()) {
            throw new IllegalArgumentException("Please, enter valid data.");
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("administrator.dat"))) {
            Administrator admin = (Administrator) in.readObject();
            List<Order> orders = admin.getOrdersFromAtoB(
                    Integer.parseInt(aField.getText()),
                    Integer.parseInt(bField.getText())
            );
            aToBLabel.setText(orders.toString());
            JOptionPane.showMessageDialog(frame, orders.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error loading administrator: " + e.getMessage());
        }
    }

    private void saveAdmin() {

        if(bHNameField.getText().isEmpty() || adminNameField.getText().isEmpty()) {
            throw new IllegalArgumentException("Please, enter valid data.");
        }

        Administrator admin = new Administrator(bHNameField.getText(), adminNameField.getText());

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("administrator.dat"))) {
            out.writeObject(admin);
            JOptionPane.showMessageDialog(frame, "Administrator saved successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error saving administrator: " + e.getMessage());
        }
    }

    private void loadAdmin() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("administrator.dat"))) {
            Administrator admin = (Administrator) in.readObject();
            adminLabel.setText("Admin: " + admin.toString());
            ordersLabel.setText("Orders: " + admin.getOrders().toString());
            clientsLabel.setText("Clients: " + admin.getClients().toString());
            JOptionPane.showMessageDialog(frame, admin + " " + admin.getOrders().toString() + " " + admin.getClients().toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error loading administrator: " + e.getMessage());
        }
    }

    private void addClient() {

        if(clientNameField.getText().isEmpty() || clientAddressField.getText().isEmpty() ||
        clientPhoneNumberField.getText().isEmpty() || clientsOrderIdField.getText().isEmpty()) {
            throw new IllegalArgumentException("Please, enter valid data.");
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("administrator.dat"))) {
            Administrator admin = (Administrator) in.readObject();
            Client client = new Client(clientNameField.getText(), clientAddressField.getText(),
                    Integer.parseInt(clientPhoneNumberField.getText()), Long.parseLong(clientsOrderIdField.getText()));
            List<Client> clientList = admin.getClients();
            clientList.add(client);
            admin.setClients(clientList);
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("administrator.dat"))) {
                out.writeObject(admin);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error saving administrator: " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error loading administrator: " + e.getMessage());
        }
    }

    private void addOrder() {

        if(orderAddressField.getText().isEmpty() || orderTypeField.getText().isEmpty()
                || orderGuestNumberField.getText().isEmpty() || orderDateField.getText().isEmpty()
                || orderStartsAtField.getText().isEmpty() || orderMealNumberField.getText().isEmpty()
                || orderPriceField.getText().isEmpty() || orderIdField.getText().isEmpty()) {
            throw new IllegalArgumentException("Please, enter valid data.");
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("administrator.dat"))) {
            Administrator admin = (Administrator) in.readObject();
            Order order = new Order(
                    orderAddressField.getText(), orderTypeField.getText(), Integer.parseInt(orderGuestNumberField.getText()),
                    orderDateField.getText(), Double.parseDouble(orderStartsAtField.getText()),
                    Integer.parseInt(orderMealNumberField.getText()), Double.parseDouble(orderPriceField.getText()),
                    Long.parseLong(orderIdField.getText())
            );
            List<Order> orderList = admin.getOrders();
            orderList.add(order);
            admin.setOrders(orderList);
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("administrator.dat"))) {
                out.writeObject(admin);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error saving administrator: " + e.getMessage());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error loading administrator: " + e.getMessage());
        }
    }
}
