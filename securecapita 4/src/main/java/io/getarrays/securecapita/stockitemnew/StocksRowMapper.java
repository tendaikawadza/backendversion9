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
import java.util.ArrayList;

/**
 * Kumar.Kunal
 * SpringBootNamedParameterJdbcTemplate
 * 2023
 */
@Component
public class StocksRowMapper implements RowMapper<Stocks> {

	@Override
	public Stocks mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Stocks stocks = new Stocks();
		stocks.setId(resultSet.getInt("id"));
		stocks.setUsername(resultSet.getString("username"));
		stocks.setPassword(resultSet.getString("password"));
		stocks.setDepartmentRequesting(resultSet.getString("department_requesting"));
		stocks.setStockRequestDate(resultSet.getDate("stock_request_date"));
		stocks.setDepartmentCode(resultSet.getString("department_code"));
		stocks.setPurposeOfIssue(resultSet.getString("purpose_of_issue"));
		stocks.setStockDate(resultSet.getDate("stock_date"));
		stocks.setItemNo(resultSet.getInt("item_no"));
		stocks.setItemReferenceNo(resultSet.getString("item_reference_no"));
		stocks.setItemDescription(resultSet.getString("item_description"));
		stocks.setDateOfPreviousIssue(resultSet.getDate("date_of_previous_issue"));
		stocks.setPreviousIssueQuantity(resultSet.getInt("previous_issue_quantity"));
		stocks.setQuantityRequested(resultSet.getInt("quantity_requested"));
		stocks.setDepartmentInitiatedBy(resultSet.getString("department_initiated_by"));
		stocks.setDepartmentAuthorisedBy(resultSet.getString("department_authorised_by"));
		stocks.setDepartmentConfirmedBy(resultSet.getString("department_confirmed_by"));
		stocks.setDepartmentReceivedBy(resultSet.getString("department_received_by"));
		stocks.setDesignatedPersonApprovalName(resultSet.getString("designated_person_approval_name"));
		stocks.setSignature(resultSet.getString("signature"));
		stocks.setDateOfConfirmation(resultSet.getDate("date_of_confirmation"));
		stocks.setRole(resultSet.getString("role"));

		stocks.setStockRequests(new ArrayList<>());
		
		return stocks;
	}
}
