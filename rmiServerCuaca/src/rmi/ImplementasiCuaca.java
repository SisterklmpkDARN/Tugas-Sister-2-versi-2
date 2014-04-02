/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.*;
import java.net.*;


/**
 *
 * @author hades
 */
public class ImplementasiCuaca extends UnicastRemoteObject implements CuacaInterfaces {
    int nama;
    private String Cuaca;
    private BufferedWriter buff;
    
    public ImplementasiCuaca(int i) throws RemoteException{
        this.nama = i;
    }

    public int getNamaClient(){
        return this.nama;
    }
    @Override
    public String cekCuacaDunia(String url, String Kota) throws RemoteException {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            System.out.println("Client meminta info cuaca dunia di kota " + Kota);
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Row");
            
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //System.out.println("Kota" + "\t\t: " + eElement.getElementsByTagName("Kota").item(0).getTextContent());
                    //System.out.println("Cuaca" + "\t\t: " + eElement.getElementsByTagName("Cuaca").item(0).getTextContent());
                    //System.out.println("Suhu Min" + "\t: " + eElement.getElementsByTagName("SuhuMin").item(0).getTextContent());
                    //System.out.println("Suhu Max" + "\t: " + eElement.getElementsByTagName("SuhuMax").item(0).getTextContent());
                    if(eElement.getElementsByTagName("Kota").item(0).getTextContent().equalsIgnoreCase(Kota))
                    {   
                        setCuaca(eElement.getElementsByTagName("Cuaca").item(0).getTextContent());
                    }
                }
            }
       } 
       catch (Exception e) {
           e.printStackTrace();
       }
       return ("Cuaca: "+getCuaca());
    }

    @Override
    public String cekCuacaHarian(String url, String Tanggal) throws RemoteException {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            System.out.println("Client meminta info cuaca harian pada tanggal " + Tanggal);
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Row");
            
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName());
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
                    System.out.println("Wave Height South Coast" + "\t: " + eElement.getElementsByTagName("WaveHeightSouthCoast").item(0).getTextContent());
                    
                    if(eElement.getElementsByTagName("Valid").item(0).getTextContent().equalsIgnoreCase(Tanggal))
                    {   
                        setCuaca(eElement.getElementsByTagName("Weather").item(0).getTextContent());
                        
                    }
                }
            }
       } 
       catch (Exception e) {
           e.printStackTrace();
       }
       return ("Cuaca: "+getCuaca());
    }

    @Override
    public String cekCuacaIndo(String url,String Kota) throws RemoteException {
       try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            System.out.println("Client meminta info cuaca indonesia di kota " + Kota);
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Row");
            
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //System.out.println("Kota" + "\t\t: " + eElement.getElementsByTagName("Kota").item(0).getTextContent());
                    //System.out.println("Cuaca" + "\t\t: " + eElement.getElementsByTagName("Cuaca").item(0).getTextContent());
                    //System.out.println("Suhu Min" + "\t: " + eElement.getElementsByTagName("SuhuMin").item(0).getTextContent());
                    //System.out.println("Suhu Max" + "\t: " + eElement.getElementsByTagName("SuhuMax").item(0).getTextContent());
                    //System.out.println("Kelembapan Min" + "\t: " + eElement.getElementsByTagName("KelembapanMax").item(0).getTextContent());
                    //System.out.println("Kelembapan Max" + "\t: " + eElement.getElementsByTagName("SuhuMax").item(0).getTextContent());
                    if(eElement.getElementsByTagName("Kota").item(0).getTextContent().equalsIgnoreCase(Kota))
                    {   
                        setCuaca(eElement.getElementsByTagName("Cuaca").item(0).getTextContent());
                    }
                }
            }
       } 
       catch (Exception e) {
           e.printStackTrace();
       }
       return ("Cuaca: "+getCuaca());
    }

    @Override
    public String cekCuacaJabodetabek(String url, String Daerah) throws RemoteException {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            System.out.println("Client meminta info cuaca Jabodetabek di daerah " + Daerah);
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Row");
            
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Daerah" + "\t\t: " + eElement.getElementsByTagName("Daerah").item(0).getTextContent());
                    System.out.println("Pagi" + "\t\t: " + eElement.getElementsByTagName("Pagi").item(0).getTextContent());
                    System.out.println("Siang" + "\t\t: " + eElement.getElementsByTagName("Siang").item(0).getTextContent());
                    System.out.println("Malam" + "\t\t: " + eElement.getElementsByTagName("Malam").item(0).getTextContent());
                    if(eElement.getElementsByTagName("Daerah").item(0).getTextContent().equalsIgnoreCase(Daerah))
                    {   
                        setCuaca(eElement.getElementsByTagName("Pagi").item(0).getTextContent());
                        
                    }
                }
            }
       } 
       catch (Exception e) {
           e.printStackTrace();
       }
       return ("Cuaca pagi hari: "+getCuaca());
    }

    @Override
    public String cekCuacaWisata(String url, String Area) throws RemoteException {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();
            System.out.println("Client meminta info cuaca wisata di Bali di area " + Area);
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Row");
            
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Area" + "\t\t: " + eElement.getElementsByTagName("Area").item(0).getTextContent());
                    System.out.println("Weather" + "\t\t: " + eElement.getElementsByTagName("Weather").item(0).getTextContent());
                    System.out.println("Temperature" + "\t: " + eElement.getElementsByTagName("Temperature").item(0).getTextContent());
                    System.out.println("Humidity" + "\t: " + eElement.getElementsByTagName("Humidity").item(0).getTextContent());
                    System.out.println("Wave Height" + "\t: " + eElement.getElementsByTagName("WaveHeight").item(0).getTextContent());
                     
                    if(eElement.getElementsByTagName("Area").item(0).getTextContent().equalsIgnoreCase(Area))
                    {   
                        setCuaca(eElement.getElementsByTagName("Weather").item(0).getTextContent());
                        
                    }
                }
            }
       } 
       catch (Exception e) {
           e.printStackTrace();
       }
       return ("Cuaca: "+getCuaca());
    }

    /**
     * @return the City
     */
   

    /**
     * @return the Cuaca
     */
    public String getCuaca() {
        return Cuaca;
    }

    /**
     * @param Cuaca the Cuaca to set
     */
    public void setCuaca(String Cuaca) {
        this.Cuaca = Cuaca;
    }
    
    
}
