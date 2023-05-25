package com.csci5308.codeLabeller.Repsoitory;

import com.csci5308.codeLabeller.Models.CodeAnnotations;
import com.csci5308.codeLabeller.Models.DTO.AnnotationResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
/**
 * repository for annotations.
 */
>>>>>>> c88c7e3e5d5ed1f30e3f6dd8d3733a913ad215a2
@Repository
public interface AnnotationsRepository extends CrudRepository<CodeAnnotations, Long> {

}
