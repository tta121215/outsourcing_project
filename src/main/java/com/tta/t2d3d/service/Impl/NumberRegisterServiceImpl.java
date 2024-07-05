package com.tta.t2d3d.service.Impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tta.t2d3d.dao.NumberRegisterDao;
import com.tta.t2d3d.dto.HeaderDto;
import com.tta.t2d3d.dto.NumberRegiterDto;
import com.tta.t2d3d.dto.ResponseDto;
import com.tta.t2d3d.entity.NumberRegister;
import com.tta.t2d3d.service.NumberRegisterService;

@Service
public class NumberRegisterServiceImpl implements NumberRegisterService {
	
	@Autowired
	private NumberRegisterDao nrDao;

	@Override
	public ResponseDto saveNumber(NumberRegiterDto data) {
		ResponseDto res=new ResponseDto();
		NumberRegister entity=new NumberRegister();
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String strCreatedDate = dateTime.format(formatter);
		entity.setSyskey(data.getId());
		entity.setCreateddate(strCreatedDate);
		entity.setModifieddate(strCreatedDate);
		entity.setRecordstatus(1);
		entity.setName(data.getName());
		entity.setPhone(data.getPhone());
		entity.setDate(this.yyyyMMddFormat(data.getDate()));
		entity.setSession(data.getSession());
		entity.setNumber2d3d(data.getNumber());
		entity.setAmount(data.getAmount());
		entity.setCashtype(data.getCashtype());
		if(entity.getSyskey()==0) {
			NumberRegister entityres=nrDao.save(entity); 
			if(entityres.getSyskey()>0) {
				res.setStatus_code(200);
				res.setMessage("Successfully Saved.");
			}
		}else {
			NumberRegister entityres=nrDao.save(entity); 
			if(entityres.getSyskey()>0) {
				res.setStatus_code(200);
				res.setMessage("Successfully Updated.");
			}
		}
		
		return res;
	}

	@Override
	public List<NumberRegiterDto> getAllList(String searchVal, String date, String session) {
		List<NumberRegiterDto> rList= null;
		System.out.println(searchVal);
		if(date!=null && date!="") {
			date=yyyyMMddFormat(date);
			if(searchVal.equals("null")) {
				searchVal="";
				rList= nrDao.getAllPageWithDate(date,session);
			}else {
				rList= nrDao.getAllPage(searchVal,date,session);
			}
		}else {
			if(searchVal.equals("null")) {
				 rList= nrDao.getAllPageNoFilter();
			}else {
				 rList= nrDao.getAllPageFilter(searchVal);
			}
		   
		}
		return rList;
	}
	
	
	public String ddMMyyyFormat(String aDate) {
		String l_Date = "";
		if (!aDate.equals("") && aDate != null)
			l_Date = aDate.substring(6) + "-" + aDate.substring(4, 6) + "-" + aDate.substring(0, 4);

		return l_Date;
	}
	
	public String yyyyMMddFormat(String aDate) {
		String l_Date = "";
		if (!aDate.equals("") && aDate != null)
			l_Date = aDate.replaceAll("-", "");

		return l_Date;
	}

	@Override
	public List<HeaderDto> getAllHeaderList(String searchVal, String date, String session) {
		Map<String, Object> res =new HashMap<String, Object>();
		List<HeaderDto> rList= null;
		System.out.println(searchVal);
		if(date!=null && date!="") {
			date=yyyyMMddFormat(date);
			if(searchVal.equals("null")) {
				searchVal="";
				rList= nrDao.getHeaderDataWithDate(date,session);
			}else {
				rList= nrDao.getHeaderDataWithDateAndSearch(searchVal,date,session);
			}
		}else {
			if(searchVal.equals("null")) {
				 rList= nrDao.getHeaderData();
			}else {
				 rList= nrDao.getHeaderDataSearch(searchVal);
			}
		   
		}
		return rList;
	}

}
