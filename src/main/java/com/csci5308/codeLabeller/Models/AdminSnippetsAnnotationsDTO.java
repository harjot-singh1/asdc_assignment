package com.csci5308.codeLabeller.Models;

import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class AdminSnippetsAnnotationsDTO {

    private Long adminID;
    private String surveyName;
    private String surveyLanguage;

    private List<byte[]> snippets;
    private List<String> annotations;
}
