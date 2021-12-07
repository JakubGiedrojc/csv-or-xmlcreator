package com.example.invictatask;

import com.example.invictatask.models.Text;
import com.example.invictatask.services.InputProvider;
import com.example.invictatask.services.SentenceCSVConverter;
import com.example.invictatask.services.SentenceXMLConverter;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log
public class StartupRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("executing startup actions...");
        InputProvider inputProvider = new InputProvider();
        log.info("please, provide your text, which would you like to convert to xml");
        Text text = inputProvider.wordsProvidedViaConsole();
        System.out.println(text.getWord().size());
        SentenceXMLConverter sentenceConverter = new SentenceXMLConverter();
        sentenceConverter.saveToXMLFile(text);
        SentenceCSVConverter sentenceCSVConverter = new SentenceCSVConverter();
        sentenceCSVConverter.saveToCSVFile("C:\\Users\\olgak\\appFolder\\invictatask\\src\\main\\resources\\text.csv",text);
        log.info("done");

    }
}
