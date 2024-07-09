package com.tta.t2d3d.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import com.tta.t2d3d.entity.Assembly;

@Repository
public interface AssemblyDao extends JpaRepository<Assembly,Long>{

	

	

}
