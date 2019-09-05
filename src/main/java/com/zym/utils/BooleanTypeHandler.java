package com.zym.utils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class BooleanTypeHandler implements TypeHandler {

	@Override
	public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
		if (Objects.isNull(parameter)) {
			ps.setInt(i, 0);
		}
		
		Boolean flag = (Boolean)parameter;
		if (flag) {
			ps.setInt(i, 1);
		} else {
			ps.setInt(i, 0);
		}
	}

	@Override
	public Object getResult(ResultSet rs, String columnName) throws SQLException {
		Integer flag = rs.getInt(columnName);
		if (flag == 1) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
