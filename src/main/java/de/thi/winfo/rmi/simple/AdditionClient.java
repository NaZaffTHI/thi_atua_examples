package de.thi.winfo.rmi.simple;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static de.thi.winfo.rmi.simple.AdditionInterface.*;

public class AdditionClient {

    public static void main(String[] args) {
        new AdditionClient().start();
    }

    private void start() {
        try {
            Registry registry = LocateRegistry.getRegistry(RMI_HOST, STANDARD_RMI_PORT);
            AdditionInterface additionService = (AdditionInterface) registry.lookup(SERVICE_NAME);

            System.out.println("Result from adding 10 and 32 is: " + additionService.add(10, 32));
        } catch (RemoteException | NotBoundException e) {
            System.err.println("An error connecting to the server occurred");
            e.printStackTrace();
        }
    }
}
