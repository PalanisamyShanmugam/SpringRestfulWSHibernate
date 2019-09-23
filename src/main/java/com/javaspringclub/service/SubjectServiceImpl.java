package com.javaspringclub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringclub.entity.Subject;
import com.javaspringclub.repository.SubjectRepository;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService{
	
	
	// Implementing Constructor based DI
				private SubjectRepository repository;
				
				public SubjectServiceImpl() {
					
				}
				
				@Autowired
				public SubjectServiceImpl(SubjectRepository repository) {
					super();
					this.repository = repository;
				}

				@Override
				public List<Subject> getSubjectById(long subject_id) {
					List<Subject> subjectList1 = null;
					Optional<Subject> subjectList = repository.findById(subject_id);
					
					if (subjectList.isPresent()) {
						Subject subject1 = subjectList.get();

						subjectList1 = new ArrayList<Subject>();
						subjectList1.add(subject1);

					}
					return subjectList1;
				}
				
				
				
				@Override
				public List<Subject> getSubjectInfo() {
					List<Subject> list = new ArrayList<Subject>();
					repository.findAll().forEach(e -> list.add(e));
					
					for(int i=0;i<list.size();i++){
						Subject subject1 = list.get(i);
						System.out.println("subjectName: "+subject1.getSubject_title());
					}
					
					return list;
				}

				@Override
				public void deleteSubjectById(long subject_id) {
					repository.deleteById(subject_id);
					
				}
				
				

}
