package com.tta.t2d3d.controller;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tta.t2d3d.dto.AssemblyDto;

import com.tta.t2d3d.dto.ResponseDto;
import com.tta.t2d3d.service.AssemblyService;


@RestController
@CrossOrigin
@RequestMapping("assembly")
public class AssemblyController {
	
	@Autowired
	private AssemblyService assemblyService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveAssembly(@RequestBody AssemblyDto data){
		if(data != null){
				ResponseDto result = assemblyService.saveAssembly(data);
				return ResponseEntity.accepted().body(result);
			}
		else{
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/assembly")
	public ResponseEntity<?> getById(@RequestParam("id") Long id) {
		AssemblyDto result = null;
		if(id != null) {
			result = assemblyService.getById(id);
		}
		return ResponseEntity.accepted().body(result);
		

		
	}
	
//	@GetMapping("")
//	public ResponseEntity<?> getNumber(@RequestParam String searchVal,@RequestParam String date,@RequestParam String session){
//		 List<NumberRegiterDto> result = nrservice.getAllList(searchVal,date,session);
//				return ResponseEntity.accepted().body(result);
//		
//	}
//	
//	@GetMapping("/header")
//	public ResponseEntity<?> getNumberHeader(@RequestParam String searchVal,@RequestParam String date,@RequestParam String session){
//		 List<HeaderDto> result = nrservice.getAllHeaderList(searchVal,date,session);
//				return ResponseEntity.accepted().body(result);
//		
//	}

}
