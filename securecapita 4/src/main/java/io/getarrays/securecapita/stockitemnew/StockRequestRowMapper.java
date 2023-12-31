/**
 * kunal
 * SpringBootNamedParametreJdbcTemplate
 * com.org.kunal.parametrejdbc.stockitemnew
 */
package io.getarrays.securecapita.stockitemnew;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Kumar.Kunal
 * SpringBootNamedParameterJdbcTemplate
 * 2023
 */
@Component
public class StockRequestRowMapper implements RowMapper<StockRequest> {

	@Override
	public StockRequest mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		StockRequest stockRequest = new StockRequest();
		stockRequest.setId(resultSet.getInt("id"));
		stockRequest.setStartDate(resultSet.getDate("start_date").toLocalDate());
		stockRequest.setEndDate(resultSet.getDate("end_date").toLocalDate());
		stockRequest.setStatus(resultSet.getString("status"));
		stockRequest.setDepartmentCode(resultSet.getString("department_code"));
		return stockRequest;
	}
}
