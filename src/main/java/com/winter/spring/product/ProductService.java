package com.winter.spring.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
	private ProductDAO productDAO;

	public List<ProductDTO> getList() throws Exception {
		return productDAO.getList();
	}

	public ProductDTO getDetail(int p_code) throws Exception {
		return productDAO.getDetail(p_code);
	}

}
