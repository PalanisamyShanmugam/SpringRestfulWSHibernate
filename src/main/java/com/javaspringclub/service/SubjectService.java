package com.javaspringclub.service;

import java.util.List;

import com.javaspringclub.entity.Subject;

public interface SubjectService {

	List<Subject> getSubjectById(long subject_id);
	
	public List<Subject> getSubjectInfo();

	public void deleteSubjectById(long subject_id);

}
