package com.example.invictatask.services;

import com.example.invictatask.models.Sentence;
import com.example.invictatask.models.Text;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Service
@Log
public class SentenceCSVConverter {
    public void saveToCSVFile(String name, Text text){
        FileWriter writer = null;
        int columnNumber = 0;
        int rowNumber = text.getWord().size();
        for (Sentence se : text.getWord()){
            if (columnNumber < se.getWords().size()){
                columnNumber = se.getWords().size();
            }
        }

        try {
            writer=new FileWriter(name);
            for (int i = 0; i < columnNumber; i++) {
                writer.append(',');
                writer.append("word "+i);
            }
            writer.append('\n');

            for (Sentence sentence : text.getWord()){
                int i = 1;
                writer.append("sentence "+1);
                i++;
                for (String s : sentence.getWords()){
                    writer.append(',');
                    writer.append(s);
                }
                writer.append('\n');
            }
            log.info("CSV File is created ");

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
