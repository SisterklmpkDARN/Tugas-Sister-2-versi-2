package rmi;
import java.rmi.*;
import org.w3c.dom.Document;

public interface CuacaInterface extends Remote {
    public Document getCuaca(String url) throws RemoteException;
//    public Document cekCuacaDunia(String url) throws RemoteException;
//    public String cekCuacaHarian(String url, String Tanggal) throws RemoteException;
//    public String cekCuacaIndo(String url) throws RemoteException;
//    public String cekCuacaJabodetabek(String url, String Daerah) throws RemoteException;
//    public String cekCuacaWisata(String url, String Area) throws RemoteException;

}
