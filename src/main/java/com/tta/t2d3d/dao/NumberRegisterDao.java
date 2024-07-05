package com.tta.t2d3d.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tta.t2d3d.dto.HeaderDto;
import com.tta.t2d3d.dto.NumberRegiterDto;
import com.tta.t2d3d.entity.NumberRegister;

@Repository
public interface NumberRegisterDao extends JpaRepository<NumberRegister,Long>{

	
	@Query("select new com.tta.t2d3d.dto.NumberRegiterDto(d.syskey,d.name,d.phone,d.date,d.session,d.number2d3d,d.amount,d.cashtype) from NumberRegister d where d.recordstatus=1 and d.number2d3d like %:keyword% and d.date=:date and d.session=:session")
	List<NumberRegiterDto> getAllPage( @Param(value="keyword")String keyword,@Param(value="date")String date,@Param(value="session")String session);
	
	@Query("select new com.tta.t2d3d.dto.NumberRegiterDto(d.syskey,d.name,d.phone,d.date,d.session,d.number2d3d,d.amount,d.cashtype) from NumberRegister d where d.recordstatus=1 and d.date=:date and d.session=:session")
	List<NumberRegiterDto> getAllPageWithDate(@Param(value="date")String date,@Param(value="session")String session);


	@Query("select new com.tta.t2d3d.dto.NumberRegiterDto(d.syskey,d.name,d.phone,d.date,d.session,d.number2d3d,d.amount,d.cashtype) from NumberRegister d where d.recordstatus=1")
	List<NumberRegiterDto> getAllPageNoFilter();
	
	@Query("select new com.tta.t2d3d.dto.NumberRegiterDto(d.syskey,d.name,d.phone,d.date,d.session,d.number2d3d,d.amount,d.cashtype) from NumberRegister d where d.recordstatus=1 and d.number2d3d like %:keyword%")
	List<NumberRegiterDto> getAllPageFilter( @Param(value="keyword")String keyword);
	
	@Query("select new com.tta.t2d3d.dto.HeaderDto(d.date,d.session,d.number2d3d,sum(d.amount)) from NumberRegister d where d.recordstatus=1 and d.number2d3d like %:keyword% group by date,session,number2d3d" )
	List<HeaderDto> getHeaderDataSearch(@Param(value="keyword")String keyword);
	
	@Query("select new com.tta.t2d3d.dto.HeaderDto(d.date,d.session,d.number2d3d,sum(d.amount)) from NumberRegister d where d.recordstatus=1 group by date,session,number2d3d" )
	List<HeaderDto> getHeaderData();
	
	@Query("select new com.tta.t2d3d.dto.HeaderDto(d.date,d.session,d.number2d3d,sum(d.amount)) from NumberRegister d where d.recordstatus=1 and d.number2d3d like %:keyword% and d.date=:date and d.session=:session group by date,session,number2d3d")
	List<HeaderDto> getHeaderDataWithDateAndSearch(@Param(value="keyword")String keyword,@Param(value="date")String date,@Param(value="session")String session);
	
	@Query("select new com.tta.t2d3d.dto.HeaderDto(d.date,d.session,d.number2d3d,sum(d.amount)) from NumberRegister d where d.recordstatus=1 and d.date=:date and d.session=:session group by date,session,number2d3d")
	List<HeaderDto> getHeaderDataWithDate(@Param(value="date")String date,@Param(value="session")String session);
	
	
	
	

}
