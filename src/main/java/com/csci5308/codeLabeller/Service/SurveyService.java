package com.csci5308.codeLabeller.Service;

import com.csci5308.codeLabeller.Models.CodeAnnotations;
import com.csci5308.codeLabeller.Models.CodeSnippet;
import com.csci5308.codeLabeller.Models.DTO.*;
import com.csci5308.codeLabeller.Models.CodeSurvey;
import com.csci5308.codeLabeller.Repsoitory.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;
    @Autowired
    AnnotationService annotationService;
    @Autowired
    SnippetService snippetService;

    public CodeSurvey createSurvey(AdminSnippetsAnnotationsDTO asaDTO){
        CodeSurvey survey = new CodeSurvey();
        survey.setUsername(asaDTO.getUsername());
        survey.setSurveyName(asaDTO.getSurveyName());
        survey.setSurveyLanguage(asaDTO.getSurveyLanguage());
        survey.setSurveyThreshold(asaDTO.getSurveyThreshold());

        return surveyRepository.save(survey);
    }

    public List<SurveyResponse> getAllSurveys() {
        List<CodeSurvey> listCodeSurveys = (List<CodeSurvey>) surveyRepository.findAll();
        List<SurveyResponse> list = new ArrayList<>();
        for(CodeSurvey cs: listCodeSurveys){
            list.add(this.makeSurveyResponse(cs));
        }
        return list;
    }
    public List<SurveyResponse> getAllSurveys(String username) {
        List<CodeSurvey> listCodeSurveys = surveyRepository.findAllByUsername(username);
        List<SurveyResponse> list = new ArrayList<>();
        for(CodeSurvey cs: listCodeSurveys){
            list.add(this.makeSurveyResponse(cs));
        }
        return list;
    }

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
        surveyResponse.setSurveyThreshold(cs.getSurveyThreshold());
        surveyResponse.setAnnotationResponseSet(annotationResponseSet);
        surveyResponse.setSnippetResponseSet(snippetResponseSet);
        return surveyResponse;
    }


    public SurveyResponse getSurvey(Long surveyID) {
        CodeSurvey survey = getCodeSurvey(surveyID);
        return this.makeSurveyResponse(survey);
    }

    public CodeSurvey getCodeSurvey(Long surveyID) {
        return surveyRepository.findById(surveyID).get();
    }

    public Page<StartSurveyResponse> startSurvey(Long surveyID, int page){
        CodeSurvey codeSurvey = surveyRepository.findById(surveyID).get();
        Page<CodeSnippet> codeSnippetPage = snippetService.getSnippetPage(codeSurvey,page);
        Page<StartSurveyResponse> startSurveyResponsePage;
        Set<CodeAnnotations> setCA = codeSurvey.getAnnotationList();
        List<AnnotationResponse> listAnnRes = annotationService.makeListAnnotationResponse(setCA);
        startSurveyResponsePage = codeSnippetPage.map(codeSnippet -> new StartSurveyResponse(codeSnippet.getCodeSnippetId(),codeSnippet.getSnippetText(),listAnnRes));
        return startSurveyResponsePage;
    }
}
