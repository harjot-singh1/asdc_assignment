package com.csci5308.codeLabeller.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class CodeAnnotations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long annotationID;

    @ManyToOne
    @JoinColumn(name = "SurveyID")
    private CodeSurvey survey;

    private String name;

    @ToString.Exclude
<<<<<<< HEAD
=======
    @OneToMany(mappedBy = "annotation")
    private Set<CodeHighlights> highlightList;

    @ToString.Exclude
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    @ManyToMany
    private Set<CodeSnippet> taggedSnippet;

}
