package com.example.invictatask.services;

import com.example.invictatask.models.Text;
import com.example.invictatask.models.Sentence;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InputProvider {

    public Text wordsProvidedViaConsole(){
        Scanner sc = new Scanner(System.in);
        Text sentence = new Text();
        List<Sentence> words = new ArrayList<>();
        String bigString = sc.nextLine();
        String [] sentences = bigString.split("\\.");
        for (int i = 0; i < sentences.length; i++) {
            System.out.println(sentences[i]);

        }
        for (int i = 0; i < sentences.length; i++) {
            String[] array = sentences[i].split(" ");
            List<String> strings = new ArrayList<>();
            for (String s : array){
                System.out.println(s);
                strings.add(s);
            }
            Collections.sort(strings);
            Sentence word = new Sentence(strings);
            words.add(word);
        }
        sentence.setWord(words);
        return sentence;
    }
}
