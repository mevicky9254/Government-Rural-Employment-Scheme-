package com.mgnrega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mgnrega.exception.GMPException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.UserException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.Project;
import com.mgnrega.model.Worker;
import com.mgnrega.service.BDOService;

@CrossOrigin(origins="*")
@RestController
public class BDOController {


	
	@Autowired
	public BDOService BdoService;
	
	
	@PostMapping("BDO/createProject")
	public ResponseEntity<Project> createProject(@RequestBody Project project, @RequestParam("SessionKey") String key) throws ProjectException, UserException{
		
	Project pro=	BdoService.createProject(project,key);
		
		return new ResponseEntity<>(pro,HttpStatus.CREATED);
		
		
	}
	
	
	@GetMapping("BDO/projectList")
	public ResponseEntity<List<Project>> viewListOfProjects(@RequestParam("SessionKey") String key) throws ProjectException, UserException{
		
		return new ResponseEntity<>(BdoService.viewListOfProjects(key),HttpStatus.OK);
		
	}
	
	
	@PostMapping("BDO/createGMP")
	public ResponseEntity<GramPanchayatMember> createGMP(@RequestBody GramPanchayatMember GMP, @RequestParam("SessionKey") String key) throws GMPException, UserException {
		
		return new ResponseEntity<>(BdoService.createGMP(GMP, key),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("BDO/gmpList")
	public ResponseEntity<List<GramPanchayatMember>> viewListOfGMPs(@RequestParam("SessionKey") String key) throws GMPException, UserException{
		
		return new ResponseEntity<>(BdoService.viewListOfGMPS(key),HttpStatus.OK);
		
	}
	
	
	@PostMapping("BDO/allocateProject")
	public ResponseEntity<GramPanchayatMember> allocateProjectToGMP(@RequestParam("GMP_Id")Integer gmpId,
			                                                        @RequestParam("Project_Id")Integer projectId,
			                                                        @RequestParam("SessionKey") String key) throws GMPException, ProjectException, UserException{
		
		return new ResponseEntity<>(BdoService.allocateProjectToGMP(gmpId, projectId,key),HttpStatus.OK);
		
	}
	
	
	@GetMapping("BDO/workerList")
	public ResponseEntity<List<Worker>> viewListOfWorker(@RequestParam("SessionKey") String key) throws WorkerException, UserException{
		
		return new ResponseEntity<>(BdoService.viewListWorkers(key),HttpStatus.OK);
		
	}
	
	
	
	@DeleteMapping("BDO/GramPanchayatMember")
	public ResponseEntity<GramPanchayatMember> deleteGMP(@RequestParam("GMP_Id")Integer gmpId, @RequestParam("SessionKey") String key) throws  GMPException, UserException{
		
		return new ResponseEntity<>(BdoService.deleteGMP(gmpId, key),HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("BDO/project")
	public ResponseEntity<Project> deleteProject(@RequestParam("Project_Id")Integer projectId,@RequestParam("SessionKey") String key) throws  ProjectException, UserException{
		
		return new ResponseEntity<>(BdoService.deleteProject(projectId,key),HttpStatus.OK);
		
	}
	
	
}
