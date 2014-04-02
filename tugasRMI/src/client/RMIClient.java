package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import rmi.CuacaInterface;

public class RMIClient {
    static int pil=0;
    
    public static void printCuacaDunia(Document xml) {
        xml.getDocumentElement().normalize();
        NodeList nList = xml.getElementsByTagName("Row"), nList2 = xml.getElementsByTagName("Tanggal");
        Element tanggal = (Element) nList2.item(0);
        System.out.println("\n***Perkiraan Cuaca Dunia***");
        System.out.println("Tanggal: " + tanggal.getTextContent());
        System.out.println("");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Kota" + "\t\t: " + eElement.getElementsByTagName("Kota").item(0).getTextContent());
                    System.out.println("Cuaca" + "\t\t: " + eElement.getElementsByTagName("Cuaca").item(0).getTextContent());
                    System.out.println("Suhu Min" + "\t: " + eElement.getElementsByTagName("SuhuMin").item(0).getTextContent());
                    System.out.println("Suhu Max" + "\t: " + eElement.getElementsByTagName("SuhuMax").item(0).getTextContent() + "\n");
                }
            }
    }
    
    public static void printCuacaIndo(Document xml) {
        xml.getDocumentElement().normalize();
        NodeList nList = xml.getElementsByTagName("Row"), nList2 = xml.getElementsByTagName("Tanggal");
        Element tanggal = (Element) nList2.item(0);
        System.out.println("\n***Perkiraan Cuaca Indonesia***");
        System.out.println("Tanggal Mulai\t: " + tanggal.getElementsByTagName("Mulai").item(0).getTextContent());
        System.out.println("Tanggal Sampai\t: " + tanggal.getElementsByTagName("Sampai").item(0).getTextContent());
        System.out.println("");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Kota" + "\t\t: " + eElement.getElementsByTagName("Kota").item(0).getTextContent());
                    System.out.println("Cuaca" + "\t\t: " + eElement.getElementsByTagName("Cuaca").item(0).getTextContent());
                    System.out.println("Suhu Min" + "\t: " + eElement.getElementsByTagName("SuhuMin").item(0).getTextContent());
                    System.out.println("Suhu Max" + "\t: " + eElement.getElementsByTagName("SuhuMax").item(0).getTextContent());
                    System.out.println("Kelembapan Min" + "\t: " + eElement.getElementsByTagName("KelembapanMin").item(0).getTextContent());
                    System.out.println("Kelembapan Max" + "\t: " + eElement.getElementsByTagName("KelembapanMax").item(0).getTextContent() + "\n");
                }
            }
    }
    
    public static void printCuacaJabodetabek(Document xml) {
        xml.getDocumentElement().normalize();
        NodeList nList = xml.getElementsByTagName("Row"), nList2 =  xml.getElementsByTagName("Tanggal");
        Element tanggal = (Element) nList2.item(0);
        System.out.println("\n***Perkiraan Cuaca Jabodetabek***");
        System.out.println("Tanggal: " + tanggal.getTextContent());
        System.out.println("");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Daerah" + "\t: " + eElement.getElementsByTagName("Daerah").item(0).getTextContent());
                    System.out.println("Pagi" + "\t: " + eElement.getElementsByTagName("Pagi").item(0).getTextContent());
                    System.out.println("Siang" + "\t: " + eElement.getElementsByTagName("Siang").item(0).getTextContent());
                    System.out.println("Malam" + "\t: " + eElement.getElementsByTagName("Malam").item(0).getTextContent() + "\n");
                }
            }
    }
    
    public static void printCuacaHarian(Document xml) {
        xml.getDocumentElement().normalize();
        NodeList nList = xml.getElementsByTagName("Row"), nList2 = xml.getElementsByTagName("Date");
        Element tanggal = (Element) nList2.item(0);
        System.out.println("\n***Perkiraan Cuaca Harian***");
        System.out.println("Update\t\t\t: " + tanggal.getElementsByTagName("Update").item(0).getTextContent());
        System.out.println("Jam Update\t\t: " + tanggal.getElementsByTagName("JamUpdate").item(0).getTextContent());
        System.out.println("");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Valid" + "\t\t\t: " + eElement.getElementsByTagName("Valid").item(0).getTextContent());
                    System.out.println("Weather" + "\t\t\t: " + eElement.getElementsByTagName("Weather").item(0).getTextContent());
                    System.out.println("Wind Direction" + "\t\t: " + eElement.getElementsByTagName("WindDirection").item(0).getTextContent());
                    System.out.println("Wind Speed" + "\t\t: " + eElement.getElementsByTagName("WindSpeed").item(0).getTextContent());
                    System.out.println("Temperature" + "\t\t: " + eElement.getElementsByTagName("Temperature").item(0).getTextContent());
                    System.out.println("Humidity" + "\t\t: " + eElement.getElementsByTagName("Humidity").item(0).getTextContent());
                    System.out.println("Sun Rise" + "\t\t: " + eElement.getElementsByTagName("Sunrise").item(0).getTextContent());
                    System.out.println("Sun Set" + "\t\t\t: " + eElement.getElementsByTagName("Sunset").item(0).getTextContent());
                    System.out.println("Moon Rise" + "\t\t: " + eElement.getElementsByTagName("Moonrise").item(0).getTextContent());
                    System.out.println("Moon Set" + "\t\t: " + eElement.getElementsByTagName("Moonset").item(0).getTextContent());
                    System.out.println("Wave Height North Coast" + "\t: " + eElement.getElementsByTagName("WaveHeightNortCoast").item(0).getTextContent());
                    System.out.println("Wave Height South Coast" + "\t: " + eElement.getElementsByTagName("WaveHeightSouthCoast").item(0).getTextContent() + "\n");
                  
                }
            }
    }
    
    public static void printCuacaWisata(Document xml) {
        xml.getDocumentElement().normalize();
        NodeList nList = xml.getElementsByTagName("Row"), nList2 = xml.getElementsByTagName("Date");
        Element tanggal = (Element) nList2.item(0);
        System.out.println("\n***Perkiraan Cuaca Wisata di Bali***");
        System.out.println("Valid Start\t: " + tanggal.getElementsByTagName("ValidStart").item(0).getTextContent());
        System.out.println("Valid Time Start: " + tanggal.getElementsByTagName("ValidTimeStart").item(0).getTextContent());
        System.out.println("Valid End\t: " + tanggal.getElementsByTagName("ValidEnd").item(0).getTextContent());
        System.out.println("Valid Time End\t: " + tanggal.getElementsByTagName("ValidTimeEnd").item(0).getTextContent());
        System.out.println("");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Area" + "\t\t: " + eElement.getElementsByTagName("Area").item(0).getTextContent());
                    System.out.println("Weather" + "\t\t: " + eElement.getElementsByTagName("Weather").item(0).getTextContent());
                    System.out.println("Temperature" + "\t: " + eElement.getElementsByTagName("Temperature").item(0).getTextContent());
                    System.out.println("Humidity" + "\t: " + eElement.getElementsByTagName("Humidity").item(0).getTextContent());
                    System.out.println("Wave Height" + "\t: " + eElement.getElementsByTagName("WaveHeight").item(0).getTextContent() + "\n");
                }
            }
    }
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
         Document xmldata;
         String url="";
         CuacaInterface cInterface = (CuacaInterface) Naming.lookup("rmi://localhost:1099/rmi");
         System.out.println("Client berhasil terkoneksi");
         
         do {
            System.out.println("<<<Menu>>");
            System.out.println("1. Cek cuaca Dunia");
            System.out.println("2. Cek cuaca Indonesia");
            System.out.println("3. Cek cuaca Jabodetabek");
            System.out.println("4. Cek cuaca Harian");
            System.out.println("5. Cek cuaca Wisata");
            System.out.println("6. Exit");
            System.out.print("Masukan pilihan anda: ");
            Scanner sc = new Scanner(System.in);
            pil = sc.nextInt();
    
            switch(pil){
                case 1: 
                        url="http://data.bmkg.go.id/cuaca_dunia_2.xml";
                        xmldata = cInterface.getCuaca(url);
                        printCuacaDunia(xmldata);
                        break;
                case 2: 
                        url="http://data.bmkg.go.id/cuaca_indo_1.xml";
                        xmldata = cInterface.getCuaca(url);
                        printCuacaIndo(xmldata);
                        break;
                case 3: 
                        url="http://data.bmkg.go.id/cuaca_jabodetabek_1.xml";
                        xmldata = cInterface.getCuaca(url);
                        printCuacaJabodetabek(xmldata);
                        break;
                case 4: 
                        url="http://data.bmkg.go.id/cuaca_harian_id.xml";
                        xmldata = cInterface.getCuaca(url);
                        printCuacaHarian(xmldata);
                        break;
                case 5: 
                        url="http://data.bmkg.go.id/cuaca_wisata.xml";
                        xmldata = cInterface.getCuaca(url);
                        printCuacaWisata(xmldata);
                        break;
                case 6: break;
                default: System.out.println("Harap pilih dengan benar: "); break;
            }
          } while(pil!=6);
    }
}
