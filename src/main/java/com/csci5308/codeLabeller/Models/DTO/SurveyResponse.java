package com.csci5308.codeLabeller.Models.DTO;

import com.csci5308.codeLabeller.Models.CodeAnnotations;
import lombok.*;

import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class SurveyResponse {
    private Long surveyID;
    private String surveyName;
    private String surveyLanguage;
<<<<<<< HEAD
=======
    private Long surveyThreshold;
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    private Set<AnnotationResponse> annotationResponseSet;
    private Set<SnippetResponse> snippetResponseSet;
}
