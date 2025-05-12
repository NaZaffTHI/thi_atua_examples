package de.thi.winfo.rmi.objects;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CustomerServer implements CustomerInterface {

    private void start() {
        try {
            CustomerInterface stub = (CustomerInterface) UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.createRegistry(STANDARD_RMI_PORT);
            System.out.println("Registry created: " + registry);

            registry.bind(SERVICE_NAME, stub);
            System.out.println("Customer Service is ready.");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getCustomersByEmail(String email) throws RemoteException {
        // Usually you have some code here to find customers with the mail in your database.
        // Since finding entries in databases is not relevant here, we just return the same two people every time.
        Customer aCustomerWithTheGivenMail = new Customer(
                42L, email, "Zaphod", "Beeblebrox"
        );
        Customer anotherCustomerWithTheGivenMail = new Customer(
                4711L, email, "Ada", "Lovelace"
        );
        return List.of(aCustomerWithTheGivenMail, anotherCustomerWithTheGivenMail);
    }

    public static void main(String[] args) {
        new CustomerServer().start();
    }
}
