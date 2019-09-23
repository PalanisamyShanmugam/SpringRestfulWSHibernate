package com.javaspringclub.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaspringclub.entity.Book;
import com.javaspringclub.entity.Subject;
import com.javaspringclub.repository.SubjectRepository;
import com.javaspringclub.service.SubjectService;

@Controller
public class SubjectController {
	
private SubjectService subjectService;
	
	public SubjectController() {

	}

	@Autowired
	public SubjectController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	@Autowired
	SubjectRepository subjectRepository;
	
	
	// Search a subject

		@RequestMapping(value = "/searchSubject",method = RequestMethod.POST)
		public ModelAndView searchSubject(ModelAndView model) {
			System.out.println("Begin searchSubject in SubjectController");

			model.setViewName("searchSubject");
			model.addObject("isVisible", false);
			return model;

		}

		@RequestMapping(value = "/getSubjectById",method = RequestMethod.POST)
		public ModelAndView getSubjectById(@RequestParam("subject_id") String subject_id, HttpServletRequest request,
				HttpServletResponse response, ModelAndView model) {
			System.out.println("Begin getSubjectById SubjectController");

			System.out.println("BookId in getSubjectById SubjectController: " + subject_id);

			List<Subject> subjectList = subjectService.getSubjectById(Long.parseLong(subject_id));
			System.out.println("getSubjectById subjectList in SubjectController: " + subjectList);
			System.out.println("getSubjectById subjectList size in SubjectController: " + subjectList.size());

			for (Subject subjectDto : subjectList) {
				Book bookDto = subjectDto.getBook();
				subjectDto.getSubject_id();
				subjectDto.getSubject_title();

				System.out.println("SubjectId in getSubjectById: " + subjectDto.getSubject_id() + "SubjectTitle :"
						+ subjectDto.getSubject_title());
				System.out.println("BookId in getSubjectById:" + bookDto.getBook_id() + "BookTitle: " + bookDto.getBook_title()
						+ "BookPrice: " + bookDto.getPrice());

			}
			// model.addObject("subjectList",subjectList);
			request.setAttribute("subjectList", subjectList);
			model.addObject("isVisible", true);
			model.addObject("subject_id", subject_id);
			model.setViewName("searchSubject");

			return model;

		}
		
		
		
		
		
		// Delete Subject

		@RequestMapping(value = "/deleteSubject",method = RequestMethod.POST)
		public ModelAndView deleteSubject(ModelAndView model) {
			System.out.println("Begin deleteSubject in SubjectController");

			model.setViewName("deleteSubject");
			model.addObject("isVisible", false);
			return model;

		}

		@RequestMapping(value = "/deleteSubjectById",method = RequestMethod.POST)
		public ModelAndView deleteSubjectById(@RequestParam("subject_id") String subject_id, HttpServletRequest request,
				HttpServletResponse response, ModelAndView model) {
			System.out.println("Begin deleteSubjectById SubjectController");

			System.out.println("BookId in deleteSubjectById SubjectController: " + subject_id);

			subjectService.deleteSubjectById(Long.parseLong(subject_id));

			List<Subject> subjectList = subjectService.getSubjectInfo();
			System.out.println("deleteSubjectById subjectList in SubjectController: " + subjectList.size());

			System.out.println("deleteSubjectById subjectList in SubjectController: " + subjectList);
			// model.addObject("subjectList",subjectList);
			request.setAttribute("subjectList", subjectList);
			model.addObject("isVisible", true);
			model.addObject("subject_id", subject_id);
			model.setViewName("deleteSubject");

			return model;

		}
		
		
		
		// Search a subject

				@RequestMapping(value = "/getSubjectByDuration",method = RequestMethod.POST)
				public ModelAndView getSubjectByDuration(ModelAndView model) {
					System.out.println("Begin searchSubject in SubjectController");

					model.setViewName("searchSubjectByDuration");
					model.addObject("isVisible", false);
					return model;

				}

				@RequestMapping(value = "/searchSubjectInfoByDuration",method = RequestMethod.POST)
				public ModelAndView searchSubjectInfoByDuration(@RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date,HttpServletRequest request,
						HttpServletResponse response, ModelAndView model) {
					System.out.println("Begin getSubjectById SubjectController");

					

					List<Subject> subjectList = subjectRepository.getSubjectByDuration(start_date,end_date);
					System.out.println("getSubjectById subjectList in SubjectController: " + subjectList);
					System.out.println("getSubjectById subjectList size in SubjectController: " + subjectList.size());

					for (Subject subjectDto : subjectList) {
						Book bookDto = subjectDto.getBook();
						subjectDto.getSubject_id();
						subjectDto.getSubject_title();

						System.out.println("SubjectId in getSubjectById: " + subjectDto.getSubject_id() + "SubjectTitle :"
								+ subjectDto.getSubject_title());
						System.out.println("BookId in getSubjectById:" + bookDto.getBook_id() + "BookTitle: " + bookDto.getBook_title()
								+ "BookPrice: " + bookDto.getPrice());

					}
					// model.addObject("subjectList",subjectList);
					request.setAttribute("subjectList", subjectList);
					model.addObject("isVisible", true);
					//model.addObject("subject_id", subject_id);
					model.setViewName("searchSubjectByDuration");

					return model;

				}
				


}
