package de.thi.winfo.rmi.objects;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CustomerInterface extends Remote {
    int STANDARD_RMI_PORT = 1099;
    String SERVICE_NAME = "CustomerService";

    List<Customer> getCustomersByEmail(String email) throws RemoteException;
}
