/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.*;
/**
 *
 * @author hades
 */
public interface CuacaInterfaces extends Remote {
public String cekCuacaDunia(String url, String Kota) throws RemoteException;
public String cekCuacaHarian(String url, String Tanggal) throws RemoteException;
public String cekCuacaIndo(String url,String Kota) throws RemoteException;
public String cekCuacaJabodetabek(String url, String Daerah) throws RemoteException;
public String cekCuacaWisata(String url, String Area) throws RemoteException;

}
