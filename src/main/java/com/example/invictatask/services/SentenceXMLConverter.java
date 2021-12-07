package com.example.invictatask.services;

import com.example.invictatask.models.Sentence;
import com.example.invictatask.models.Text;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

@Service
@Log
public class SentenceXMLConverter {

    public void saveToXMLFile(Text text) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder =dbFactory.newDocumentBuilder();

            Document doc = documentBuilder.newDocument();
            Element rootElement = doc.createElement("text");
            doc.appendChild(rootElement);
            //this should be in so,me kind of loop


            for (Sentence se : text.getWord()){
                Element sentence = doc.createElement("sentence");
                rootElement.appendChild(sentence);

                for (String s : se.getWords()){
                    Element word = doc.createElement("word");
                    word.appendChild(doc.createTextNode(s));
                    sentence.appendChild(word);
                }


            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\olgak\\appFolder\\invictatask\\src\\main\\resources\\text.xml"));
            transformer.transform(source, result);
            log.info("done");
        } catch (ParserConfigurationException pce){
            pce.printStackTrace();
        } catch (TransformerException tfe){
            tfe.printStackTrace();
        }


    }


}