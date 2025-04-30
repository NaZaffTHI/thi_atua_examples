package de.thi.winfo.rmi.simple;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdditionInterface extends Remote {
    String RMI_HOST = "127.0.0.1";
    int STANDARD_RMI_PORT = 1099;
    String SERVICE_NAME = "AdditionService";

    int add(int a, int b) throws RemoteException;
}
