///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package client;
//
//import java.io.File;
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.Unmarshaller;
//import java.util.List;
//
//public class XmlUtil {
//
//    public static void saveObjectsToXml(Record newRecord, String fileName) {
//        try {
//            System.out.println("i entered the save  in xmlUti");
//            JAXBContext context = JAXBContext.newInstance(newRecord.getClass());
//            Marshaller marshaller = context.createMarshaller();
//
//            // Convert the list to XML and save to file
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(newRecord, new File(fileName));
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static List<Record> loadObjectsFromXml(String fileName) {
//        try {
//            System.out.print("i entered the retrive  in xmlUti");
//
//            JAXBContext context = JAXBContext.newInstance(Record.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//
//            // Load the list from XML file
//            return (List<Record>) unmarshaller.unmarshal(new File(fileName));
//        } catch (JAXBException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
