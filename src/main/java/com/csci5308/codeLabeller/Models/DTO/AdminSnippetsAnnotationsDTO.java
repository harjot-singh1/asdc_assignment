package com.csci5308.codeLabeller.Models.DTO;

import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class AdminSnippetsAnnotationsDTO {
    private String username;
    private String surveyName;
    private String surveyLanguage;
<<<<<<< HEAD
=======
    private Long surveyThreshold = (long)0;
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2

    private List<byte[]> snippets;
    private List<String> annotations;
}
