package server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.ImplementasiCuaca;

public class RMIServer {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        ImplementasiCuaca ic = new ImplementasiCuaca();
        registry.rebind("rmi",ic);
        System.out.println("server telah berjalan");
    }
}
