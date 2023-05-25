package com.csci5308.codeLabeller.Service;

<<<<<<< HEAD
import com.csci5308.codeLabeller.Models.Annotator;
import com.csci5308.codeLabeller.Models.CodeSurvey;
import com.csci5308.codeLabeller.Models.DTO.SurveyResponse;
import com.csci5308.codeLabeller.Repsoitory.AnnotatorRepository;
import com.csci5308.codeLabeller.Repsoitory.SurveyRepository;
=======
import com.csci5308.codeLabeller.Models.*;
import com.csci5308.codeLabeller.Models.DTO.AnnotationResponse;
import com.csci5308.codeLabeller.Models.DTO.AnnotatorHighlightTagResponse;
import com.csci5308.codeLabeller.Models.DTO.CodeHighlightResponse;
import com.csci5308.codeLabeller.Models.DTO.SurveyResponse;
import com.csci5308.codeLabeller.Repsoitory.AnnotatorRepository;
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

=======
import java.util.Set;

/**
 * This service helps:
 * get all surveys, be it approved or not approved
 * help tag snippet with annotations
 */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
@Service
public class AnnotatorService {

    @Autowired
    AnnotatorRepository annotatorRepository;
    @Autowired
    SurveyService surveyService;
<<<<<<< HEAD

    public List<SurveyResponse> getAllSurveys() {
        return surveyService.getAllSurveys();// filter from aproved and pending.
    }
=======
    @Autowired
    AnnotationService annotationService;
    @Autowired
    SnippetService snippetService;

    @Autowired
    HighlighterService highlighterService;

    /**
     * This method fetches all surveys.
     * @return: collection of survey DTO.
     */
    public List<SurveyResponse> getAllSurveys() {
        return surveyService.getAllSurveys();// filter from aproved and pending.
    }

    /**
     * This method fetches all approved surveys.
     * @param username:  username
     * @return: collection of survey responses
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public List<SurveyResponse> getAllApprovedSurveys(String username){
        Annotator annotator = annotatorRepository.findById(username).get();
        List<SurveyResponse> surveyResponseList = new ArrayList<>();
        for(CodeSurvey cs: annotator.getApprovedCodeSurvey()){
            surveyResponseList.add(surveyService.makeSurveyResponse(cs));
        }
        return surveyResponseList;
    }

<<<<<<< HEAD
=======
    /**
     * This method fetches all pending surveys
     * @param username:  username
     * @return: collection of survey responses
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public List<SurveyResponse> getAllPendingSurveys(String username) {
        Annotator annotator = annotatorRepository.findById(username).get();
        List<SurveyResponse> surveyResponseList = new ArrayList<>();
        for(CodeSurvey cs: annotator.getPendingApprovalsSurveys()){
            surveyResponseList.add(surveyService.makeSurveyResponse(cs));
        }
        return surveyResponseList;
    }
<<<<<<< HEAD
=======

    /**
     * This method helps tagging snippet with annotations.
     * @param annotatorUsername: annotator username.
     * @param surveyId: survey id
     * @param snippetId: snippet id
     * @param annotatorHighlightTagResponse: annotator highlighted information DTO.
     */
    public void tagSnippetWithAnnotations(String annotatorUsername, Long surveyId, Long snippetId, AnnotatorHighlightTagResponse annotatorHighlightTagResponse) {
        List<AnnotationResponse> annotationResponseList = annotatorHighlightTagResponse.getAnnotationResponseList();
        Set<CodeAnnotations> codeAnnotationsSet = annotationService.getAllCodeAnnotations(annotationResponseList);
        CodeSnippet codeSnippet = snippetService.getCodeSnippet(snippetId);

        Set<CodeAnnotations> snippetTags = codeSnippet.getTags();
        for(CodeAnnotations codeAnnotations: codeAnnotationsSet){
            snippetTags.add(codeAnnotations);
        }
        codeSnippet.setTags(snippetTags);
        Set<CodeHighlights> codeHighlightsSet =  codeSnippet.getHighlightList();
        List<CodeHighlightResponse> chrl = annotatorHighlightTagResponse.getCodeHighlightResponseList();
        Set<CodeHighlights> sch = highlighterService.getAllHighlights(annotatorUsername,codeSnippet, chrl);
        codeHighlightsSet.addAll(sch);
        codeSnippet.setHighlightList(codeHighlightsSet);
        snippetService.updateSnippet(codeSnippet);
    }
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
}
