package de.thi.winfo.rmi.objects;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

import static de.thi.winfo.rmi.objects.CustomerInterface.SERVICE_NAME;
import static de.thi.winfo.rmi.objects.CustomerInterface.STANDARD_RMI_PORT;

public class CustomerClient {
    public static final String LOCALHOST = "127.0.0.1";

    private void start() {
        try {
            Registry registry = LocateRegistry.getRegistry(LOCALHOST, STANDARD_RMI_PORT);
            CustomerInterface customerService = (CustomerInterface) registry.lookup(SERVICE_NAME);

            List<Customer> customers = customerService.getCustomersByEmail("someMail@domain.de");
            printCustomers(customers);

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    private void printCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public static void main(String[] args) {
        new CustomerClient().start();
    }
}
