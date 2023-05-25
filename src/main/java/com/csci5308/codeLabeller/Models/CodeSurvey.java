package com.csci5308.codeLabeller.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class CodeSurvey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long surveyID;

    @NonNull
    private String username;
    private String surveyName;
    private String surveyLanguage;

<<<<<<< HEAD
=======
    private Long surveyThreshold;

>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    @ToString.Exclude
    @OneToMany(mappedBy = "survey")
    private Set<CodeSnippet> snippetList;

    @ToString.Exclude
    @OneToMany(mappedBy = "survey")
    private Set<CodeAnnotations> annotationList;

}
