package com.csci5308.codeLabeller.Service;

import com.csci5308.codeLabeller.Models.CodeAnnotations;
import com.csci5308.codeLabeller.Models.CodeSnippet;
import com.csci5308.codeLabeller.Models.DTO.*;
import com.csci5308.codeLabeller.Models.CodeSurvey;
<<<<<<< HEAD
import com.csci5308.codeLabeller.Repsoitory.AnnotationsRepository;
import com.csci5308.codeLabeller.Repsoitory.SurveyRepository;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.csci5308.codeLabeller.Repsoitory.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

<<<<<<< HEAD
=======
/**
 * this service helps:
 * create surveys
 * fetch all surveys
 * convert surveys to survey DTO and vice-versa.
 * start survey pagination.
 */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
@Service
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    AnnotationService annotationService;
    @Autowired
    SnippetService snippetService;

<<<<<<< HEAD
=======
    /**
     * create surveys
     * @param asaDTO: snippet+annotation DTO
     * @return: survey object.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public CodeSurvey createSurvey(AdminSnippetsAnnotationsDTO asaDTO){
        CodeSurvey survey = new CodeSurvey();
        survey.setUsername(asaDTO.getUsername());
        survey.setSurveyName(asaDTO.getSurveyName());
        survey.setSurveyLanguage(asaDTO.getSurveyLanguage());
<<<<<<< HEAD
=======
        survey.setSurveyThreshold(asaDTO.getSurveyThreshold());
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2

        return surveyRepository.save(survey);
    }

<<<<<<< HEAD
=======
    /**
     * fetch all surveys
     * @return: collection of survey DTO.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public List<SurveyResponse> getAllSurveys() {
        List<CodeSurvey> listCodeSurveys = (List<CodeSurvey>) surveyRepository.findAll();
        List<SurveyResponse> list = new ArrayList<>();
        for(CodeSurvey cs: listCodeSurveys){
            list.add(this.makeSurveyResponse(cs));
        }
        return list;
    }
<<<<<<< HEAD
=======

    /**
     * fetch all survey based on username
     * @param username: username
     * @return: collection of survey DTO.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public List<SurveyResponse> getAllSurveys(String username) {
        List<CodeSurvey> listCodeSurveys = surveyRepository.findAllByUsername(username);
        List<SurveyResponse> list = new ArrayList<>();
        for(CodeSurvey cs: listCodeSurveys){
            list.add(this.makeSurveyResponse(cs));
        }
        return list;
    }

<<<<<<< HEAD
=======
    /**
     * convert survey to survey DTO.
     * @param cs: survey object.
     * @return: survey DTO
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public SurveyResponse makeSurveyResponse(CodeSurvey cs) {
        Set<AnnotationResponse> annotationResponseSet = new HashSet<>();
        for(CodeAnnotations ca: cs.getAnnotationList()){
            AnnotationResponse ar = annotationService.makeAnnotationResponse(ca);
            annotationResponseSet.add(ar);
        }
        Set<SnippetResponse> snippetResponseSet = new HashSet<>();
        for(CodeSnippet codeSnippet: cs.getSnippetList()){
            SnippetResponse snippetResponse = snippetService.makeSnippetResponse(codeSnippet);
            snippetResponseSet.add(snippetResponse);
        }
        SurveyResponse surveyResponse = new SurveyResponse();
        surveyResponse.setSurveyID(cs.getSurveyID());
        surveyResponse.setSurveyName(cs.getSurveyName());
        surveyResponse.setSurveyLanguage(cs.getSurveyLanguage());
<<<<<<< HEAD
=======
        surveyResponse.setSurveyThreshold(cs.getSurveyThreshold());
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
        surveyResponse.setAnnotationResponseSet(annotationResponseSet);
        surveyResponse.setSnippetResponseSet(snippetResponseSet);
        return surveyResponse;
    }

<<<<<<< HEAD
    public SurveyResponse getSurvey(Long surveyID) {
        CodeSurvey survey = surveyRepository.findById(surveyID).get();
        return this.makeSurveyResponse(survey);
    }

=======

    /**
     * fetch survey based on survey id.
     * @param surveyID: survey id
     * @return: survey DTO.
     */
    public SurveyResponse getSurvey(Long surveyID) {
        CodeSurvey survey = getCodeSurvey(surveyID);
        return this.makeSurveyResponse(survey);
    }

    /**
     * fetch survey based on survey id.
     * @param surveyID: survey id
     * @return: survey object
     */
    public CodeSurvey getCodeSurvey(Long surveyID) {
        return surveyRepository.findById(surveyID).get();
    }

    /**
     * start survey pagination
     * @param surveyID: survey id
     * @param page: page number
     * @return: page for survey DTO.
     */
    public Page<StartSurveyResponse> startSurvey(Long surveyID, int page){
        CodeSurvey codeSurvey = surveyRepository.findById(surveyID).get();
        Page<CodeSnippet> codeSnippetPage = snippetService.getSnippetPage(codeSurvey,page);
        Page<StartSurveyResponse> startSurveyResponsePage;
        Set<CodeAnnotations> setCA = codeSurvey.getAnnotationList();
        List<AnnotationResponse> listAnnRes = annotationService.makeListAnnotationResponse(setCA);
        startSurveyResponsePage = codeSnippetPage.map(codeSnippet -> new StartSurveyResponse(codeSnippet.getCodeSnippetId(),codeSnippet.getSnippetText(),listAnnRes));
        return startSurveyResponsePage;
    }
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
}
