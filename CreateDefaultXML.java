package servercode;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateDefaultXML {

    public void createBirdsXML(String dir1) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Birds");
            doc.appendChild(rootElement);

            // Bird elements
            Element bird = doc.createElement("Bird");
            rootElement.appendChild(bird);

            Element nameBird = doc.createElement("Name");
            bird.appendChild(nameBird);

            Element colorBird = doc.createElement("Color");
            bird.appendChild(colorBird);

            Element heightBird = doc.createElement("Height");
            bird.appendChild(heightBird);

            Element weightBird = doc.createElement("Weight");
            bird.appendChild(weightBird);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Format XML
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(dir1 + "\\birds.xml"));

            // Output to console for testing
            transformer.transform(source, result);

            System.out.println("File birds.xml is created!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void createSightingsXML(String dir2) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("SightingsList");
            doc.appendChild(rootElement);

            // Bird elements
            Element sightings = doc.createElement("Sightings");
            rootElement.appendChild(sightings);

            Element nameBird = doc.createElement("name");
            sightings.appendChild(nameBird);

            Element locationBird = doc.createElement("location");
            sightings.appendChild(locationBird);

            Element dateBird = doc.createElement("date");
            sightings.appendChild(dateBird);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Format XML
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(dir2 + "\\sightings.xml"));

            // Output to console for testing
            transformer.transform(source, result);

            System.out.println("File sightings.xml is created!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void createDefaultXML(String dir) {
        try {

            if (new File(dir).exists()) {
                if (!new File(dir + "\\birds.xml").exists()) {
                    createBirdsXML(dir);
                } else {
                    System.out.println("File birds.xml is existsing!!!");
                }

                if (!new File(dir + "\\sightings.xml").exists()) {
                    createSightingsXML(dir);
                } else {
                    System.out.println("File sightings.xml existsing..");
                }
            } else {
                new File(dir).mkdirs();
                createBirdsXML(dir);
                createSightingsXML(dir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
