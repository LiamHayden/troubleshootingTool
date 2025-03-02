package com.datapac.troubleshootingTool.Question;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
//	@Query("SELECT p FROM Question p JOIN p.problems c WHERE c.id = :problemId")
	String findQuestionById(@Param("problemId") Long id);
	
}
