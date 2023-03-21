package com.csci5308.codeLabeller.Controller;

import com.csci5308.codeLabeller.Models.DTO.AnnotationResponse;
import com.csci5308.codeLabeller.Models.DTO.HighlighterResponse;
import com.csci5308.codeLabeller.Models.DTO.SurveyResponse;
import com.csci5308.codeLabeller.Service.AnnotatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@EnableMethodSecurity
@RequestMapping("/annotator/")
public class AnnotatorController {

    @Autowired
    AnnotatorService annotatorService;

    @GetMapping("{annotator_username}/survey/all/")
    @PreAuthorize("hasAuthority('ANNOTATOR')")
    public List<SurveyResponse> getAllSurveys(@PathVariable("annotator_username") String username) {
        username = SecurityContextHolder.getContext().getAuthentication().getName();
        return annotatorService.getAllSurveys();
    }

    @PostMapping("{annotator_username}/survey/{survey_id}/approvalrequest/")
    public void submitSurveyApprovalRequest(){
        //
    }

    @PostMapping("{annotator_username}/survey/{survey_id}/snippet/{snippet_id}/annotationstag/")
    public void tagSnippetWithAnnotations(@PathVariable("annotator_username") String annotatorUsername,
                                                    @PathVariable("survey_id") Long surveyId,
                                                    @PathVariable("snippet_id") Long snippetId,
                                                    @RequestBody List<AnnotationResponse> annotationsTag){
        annotatorUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        annotatorService.tagSnippetWithAnnotations(annotatorUsername, surveyId, snippetId, annotationsTag);
    }

    @GetMapping("{annotator_username}/survey/approved/all/")
    @PreAuthorize("hasAuthority('ANNOTATOR')")
    public List<SurveyResponse> getAllApprovedSurveys(@PathVariable("annotator_username") String username){
        username  = SecurityContextHolder.getContext().getAuthentication().getName();
        return annotatorService.getAllApprovedSurveys(username);
    }

    @GetMapping("{annotator_username}/survey/pending/all/")
    @PreAuthorize("hasAuthority('ANNOTATOR')")
    public List<SurveyResponse> getAllPendingSurveys(@PathVariable("annotator_username") String username){
        username  = SecurityContextHolder.getContext().getAuthentication().getName();
        return annotatorService.getAllPendingSurveys(username);
    }



//    @PostMapping("{annotator_username}/survey/{survey_id}/snippet/{snippet_id}/highlight/")
//    public void highlightSnippetWithAnnotations(@PathVariable("annotator_username") String annotatorUsername,
//                                          @PathVariable("survey_id") Long surveyId,
//                                          @PathVariable("snippet_id") Long snippetId,
//                                          @RequestBody List<HighlighterResponse> highlighterTags){
//        annotatorUsername = SecurityContextHolder.getContext().getAuthentication().getName();
//        annotatorService.tagSnippetWithAnnotations(annotatorUsername, surveyId, snippetId, annotationsTag);
//    }

}
