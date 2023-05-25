package com.csci5308.codeLabeller.Models.DTO;

import lombok.*;

import java.util.Set;

@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class SnippetResponse {
    private Long snippetID;
    private byte[] snippetText;
    private Set<AnnotationResponse> taggedAnnotations;
<<<<<<< HEAD
=======

    private Set<CodeHighlightResponse> highlightResponses;
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
}
