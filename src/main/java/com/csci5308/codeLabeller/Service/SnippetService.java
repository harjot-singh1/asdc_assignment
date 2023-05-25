package com.csci5308.codeLabeller.Service;

<<<<<<< HEAD
import com.csci5308.codeLabeller.Models.CodeAnnotations;
import com.csci5308.codeLabeller.Models.DTO.AdminSnippetsAnnotationsDTO;
import com.csci5308.codeLabeller.Models.CodeSnippet;
import com.csci5308.codeLabeller.Models.CodeSurvey;
import com.csci5308.codeLabeller.Models.DTO.AnnotationResponse;
import com.csci5308.codeLabeller.Models.DTO.SnippetResponse;
import com.csci5308.codeLabeller.Repsoitory.SnippetRepository;
import com.csci5308.codeLabeller.Repsoitory.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.csci5308.codeLabeller.Enums.MiscEnums;
import com.csci5308.codeLabeller.Models.CodeAnnotations;
import com.csci5308.codeLabeller.Models.CodeHighlights;
import com.csci5308.codeLabeller.Models.DTO.*;
import com.csci5308.codeLabeller.Models.CodeSnippet;
import com.csci5308.codeLabeller.Models.CodeSurvey;
import com.csci5308.codeLabeller.Repsoitory.SnippetRepository;
import com.csci5308.codeLabeller.Repsoitory.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

<<<<<<< HEAD
=======
/**
 * This service helps to:
 * lets annotator starts the pagination for snippets.
 * create snippets.
 * fetch snippet
 * convert all snippet to snippet DTO.
 */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
@Service
public class SnippetService {

    @Autowired
    SnippetRepository snippetRepository;
    @Autowired
    AnnotationService annotationService;
    @Autowired
    SurveyRepository surveyRepository;

<<<<<<< HEAD
=======
    @Autowired
    HighlighterService highlighterService;

    /**
     * helps annotator start the pagination for snippet for the requested survey.
     * @param username: username
     * @param surveyId: survey id.
     * @param snippetId: snippet id.
     * @param page: page number
     * @return: page of collection of highlight response.
     */
    public Page<List<CodeHighlightResponse>> startSnippetHighlightsPaginationByAnnotator(String username, Long surveyId, Long snippetId, int page){
        CodeSnippet codeSnippet = snippetRepository.findById(snippetId).get();
        return highlighterService.getHighlightsSetPage(codeSnippet,page);

    }

    /**
     * helps create snippet.
     * @param asaDTO: snippet + annotation DTO.
     * @param survey: survey for which data is being saved.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public void createSnippets(AdminSnippetsAnnotationsDTO asaDTO, CodeSurvey survey) {
        List<byte[]> snippets = asaDTO.getSnippets();
        List<CodeSnippet> codeSnippetList = new ArrayList<>();
        for(byte[] data: snippets){
            CodeSnippet codeSnippet = new CodeSnippet();
            codeSnippet.setSnippetText(data);
            codeSnippet.setSurvey(survey);
            codeSnippetList.add(codeSnippet);
        }
        snippetRepository.saveAll(codeSnippetList);
    }
<<<<<<< HEAD
=======

    /**
     * convert snippet to its DTO
     * @param codeSnippet: snippet object
     * @return: snippet DTO.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public SnippetResponse makeSnippetResponse(CodeSnippet codeSnippet) {
        SnippetResponse snippetResponse = new SnippetResponse();
        snippetResponse.setSnippetID(codeSnippet.getCodeSnippetId());
        snippetResponse.setSnippetText(codeSnippet.getSnippetText());
        Set<AnnotationResponse> annotationResponseList = new HashSet<>();
        for(CodeAnnotations codeAnnotations: codeSnippet.getTags()){
            annotationResponseList.add(annotationService.makeAnnotationResponse(codeAnnotations));
        }
        snippetResponse.setTaggedAnnotations(annotationResponseList);
<<<<<<< HEAD
        return snippetResponse;
    }

=======
        Set<CodeHighlights> setCh = codeSnippet.getHighlightList();
        Set<CodeHighlightResponse> highlightResponseList;
        highlightResponseList = highlighterService.makeAllHighlightResponse(setCh);
        snippetResponse.setHighlightResponses(highlightResponseList);
        return snippetResponse;
    }

    /**
     * fetches all snippet for username and a particular survey.
     * @param username: username
     * @param surveyId: survey id.
     * @return: collection of snippet dto.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public List<SnippetResponse> getAllSnippets(String username, Long surveyId) {
        CodeSurvey codeSurvey =  surveyRepository.findById(surveyId).get();
        List<SnippetResponse> snippetResponseList = new ArrayList<>();

        for(CodeSnippet cs: codeSurvey.getSnippetList()){
            snippetResponseList.add(this.makeSnippetResponse(cs));
        }
        return snippetResponseList;
    }

<<<<<<< HEAD
=======
    /**
     * fetch a snippet.
     * @param username: username
     * @param surveyId: survey id
     * @param id: snippet Id.
     * @return: snippet DTO.
     */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
    public SnippetResponse getSnippet(String username, Long surveyId, Long id) {
        CodeSnippet codeSnippet = snippetRepository.findById(id).get();
        return this.makeSnippetResponse(codeSnippet);
    }
<<<<<<< HEAD
=======

    /**
     * ftech tagged annotations for snippet.
     * @param username:
     * @param surveyId
     * @param id
     * @return
     */
    public List<AnnotationResponse> getSnippetTaggedAnnotations(String username, Long surveyId, Long id) {
        CodeSnippet codeSnippet = snippetRepository.findById(id).get();
        return this.annotationService.makeListAnnotationResponse(codeSnippet.getTags());
    }

    /**
     * get code snippet
     * @param snippetId: sniippet id
     * @return: snippet object.
     */
    public CodeSnippet getCodeSnippet(Long snippetId){
        return snippetRepository.findById(snippetId).get();
    }

    /**
     * update snippet based on id.
     * @param codeSnippet: snippet object.
     */
    public void updateSnippet(CodeSnippet codeSnippet) {
        snippetRepository.save(codeSnippet);
    }

    /**
     * fetches page for snippet object.
     * @param codeSurvey: survey object
     * @param page: page number
     * @return: page of snippet object.
     */
    public Page<CodeSnippet> getSnippetPage(CodeSurvey codeSurvey, int page) {
        Sort sort = Sort.by(Sort.Direction.ASC, "codeSnippetId");
        return snippetRepository.findBySurvey(codeSurvey, PageRequest.of(page, MiscEnums.NumberOfPages.getValue()), sort);
    }
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
}
