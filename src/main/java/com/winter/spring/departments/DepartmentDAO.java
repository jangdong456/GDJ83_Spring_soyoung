package com.winter.spring.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.winter.spring.util.DBConnection;

@Repository
public class DepartmentDAO {

	// (DAO는 얘 없으면 사용 못하니까 의존성 있음, 그니까 의존성 추가해주어야 함) DI, IOC(스프링 프레임워크한테 해달라고 하는 것)
	@Autowired // 주입하는 메서드
	private DBConnection dbConnection;

	public void getList() throws Exception {
		Connection con = dbConnection.getConnection();
		System.out.println(con);

		// SQL(Query)작성
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID ASC"; // 자바에서는 쿼리문 마지막에 세미콜론 안붙임

		// 작성한 쿼리문 미리 전송(미리 서버로 보내서 준비시킴)
		PreparedStatement st = con.prepareStatement(sql);

		// ? 값 세팅 과정은 지금은 건너뜀
		// 최종 전송 및 결과를 처리하는 단계
		ResultSet rs = st.executeQuery(); // st.exe가 최종 전송이고 그 결과물을 resueltset에 받겠다는 의미

		while (rs.next()) { // 한개씩 읽으면서 꺼내줌
			int id = rs.getInt("DEPARTMENT_ID");
			String name = rs.getString("DEPARTMENT_NAME");
			System.out.println(id + ":" + name);

		}

		// 연결한 자원 해제
		rs.close();
		st.close();
		con.close();

	}

}