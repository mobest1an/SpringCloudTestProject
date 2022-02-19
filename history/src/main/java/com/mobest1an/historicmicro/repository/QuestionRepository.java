package com.mobest1an.historicmicro.repository;

import com.mobest1an.historicmicro.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    
}
