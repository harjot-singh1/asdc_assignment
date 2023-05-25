package com.csci5308.codeLabeller.Repsoitory;

import com.csci5308.codeLabeller.Models.CodeSurvey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

<<<<<<< HEAD
=======
/**
 * survey respository.
 */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
@Repository
public interface SurveyRepository extends CrudRepository<CodeSurvey, Long> {
    List<CodeSurvey> findAllByUsername(String username);
}
