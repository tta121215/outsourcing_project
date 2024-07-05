package com.tta.t2d3d.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tta.t2d3d.dto.HeaderDto;
import com.tta.t2d3d.dto.NumberRegiterDto;
import com.tta.t2d3d.dto.ResponseDto;
import com.tta.t2d3d.service.NumberRegisterService;

@RestController
@CrossOrigin
@RequestMapping("number")
public class NumberRegister {
	
	@Autowired
	private NumberRegisterService nrservice;
	
	@PostMapping("")
	public ResponseEntity<?> saveNumber(@RequestBody NumberRegiterDto data){
		if(data != null){
				ResponseDto result = nrservice.saveNumber(data);
				return ResponseEntity.accepted().body(result);
			}
		else{
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("")
	public ResponseEntity<?> getNumber(@RequestParam String searchVal,@RequestParam String date,@RequestParam String session){
		 List<NumberRegiterDto> result = nrservice.getAllList(searchVal,date,session);
				return ResponseEntity.accepted().body(result);
		
	}
	
	@GetMapping("/header")
	public ResponseEntity<?> getNumberHeader(@RequestParam String searchVal,@RequestParam String date,@RequestParam String session){
		 List<HeaderDto> result = nrservice.getAllHeaderList(searchVal,date,session);
				return ResponseEntity.accepted().body(result);
		
	}

}
