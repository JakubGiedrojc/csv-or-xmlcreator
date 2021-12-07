package com.example.invictatask.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sentence {
    private List<String> words;
}
