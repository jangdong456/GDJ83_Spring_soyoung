package com.winter.spring.departments;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 클래스의 객체를 만들어달라는 어노테이션
public class DepartmentService {

	@Autowired
	private DepartmentDAO departmentDAO;

	public List<DepartmentDTO> getList() throws Exception {
		return departmentDAO.getList();
	}

	public DepartmentDTO getDetail(int num) throws Exception {
		return departmentDAO.getDetail(num);
	}

	public int add(DepartmentDTO departmentDTO) throws Exception {
		return departmentDAO.add(departmentDTO);
	}

	public int delete(DepartmentDTO departmentDTO) throws Exception {
		return departmentDAO.delete(departmentDTO);
	}

	public int update(DepartmentDTO departmentDTO) throws Exception {
		return departmentDAO.update(departmentDTO);
	}

	public List<Map<String, Object>> getInfo() throws Exception {
		return departmentDAO.getInfo();
	}

}