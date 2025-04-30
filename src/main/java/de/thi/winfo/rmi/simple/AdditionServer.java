package de.thi.winfo.rmi.simple;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AdditionServer implements AdditionInterface {

    public static void main(String[] args) {
        new AdditionServer().start();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    public void start() {
        try {
            AdditionInterface stub = (AdditionInterface) UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.createRegistry(STANDARD_RMI_PORT);
            System.out.println("Registry created: " + registry);

            registry.bind(SERVICE_NAME, stub);
            System.out.println("AdditionServer is ready.");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
