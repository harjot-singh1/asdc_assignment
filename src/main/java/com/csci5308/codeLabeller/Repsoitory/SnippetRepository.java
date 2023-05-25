package com.csci5308.codeLabeller.Repsoitory;

import com.csci5308.codeLabeller.Models.CodeSnippet;
<<<<<<< HEAD
=======
import com.csci5308.codeLabeller.Models.CodeSurvey;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnippetRepository extends CrudRepository<CodeSnippet, Long> {
<<<<<<< HEAD
=======

    Page<CodeSnippet> findBySurvey(CodeSurvey codeSurvey, PageRequest pageRequest, Sort sort);
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
}
