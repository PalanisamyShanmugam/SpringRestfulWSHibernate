package com.javaspringclub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaspringclub.entity.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>{

	final static String GET_SUBJECT = "SELECT S.SUBJECT_ID,S.SUBJECT_TITLE,S.DURATION_INHOURS,S.BOOK_ID,B.BOOK_TITLE,B.PRICE,B.VOLUME,B.PUBLISH_DATE FROM SUBJECT S "+
                   " INNER JOIN BOOK B "+
                   " ON S.BOOK_ID = B.BOOK_ID "+
				   " AND B.PUBLISH_DATE BETWEEN :start_date AND :end_date ";
	
	@Query(nativeQuery = true, value=GET_SUBJECT)
	List<Subject> getSubjectByDuration(@Param("start_date") String start_date,@Param("end_date") String end_date);

}
