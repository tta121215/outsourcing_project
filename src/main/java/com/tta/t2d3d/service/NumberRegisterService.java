package com.tta.t2d3d.service;


import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.tta.t2d3d.dto.HeaderDto;
import com.tta.t2d3d.dto.NumberRegiterDto;
import com.tta.t2d3d.dto.ResponseDto;

public interface NumberRegisterService {

	ResponseDto saveNumber(NumberRegiterDto data);

	List<NumberRegiterDto> getAllList(String searchVal, String date, String session);

	List<HeaderDto> getAllHeaderList(String searchVal, String date, String session);

}
