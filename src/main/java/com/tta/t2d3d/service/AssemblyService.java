package com.tta.t2d3d.service;

import com.tta.t2d3d.dto.AssemblyDto;
import com.tta.t2d3d.dto.ResponseDto;

public interface AssemblyService {

	
	ResponseDto saveAssembly(AssemblyDto data);
	AssemblyDto getById(Long id);

}
