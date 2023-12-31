/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.issue;

import io.getarrays.securecapita.purchaserequestnew.PurchaseRequestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author Kumar.Kunal
 *
 */
@Slf4j
public class IssueRowMapper implements RowMapper<io.getarrays.securecapita.issue.IssueEntity> {

	@Override
	public io.getarrays.securecapita.issue.IssueEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		log.info("Entering Row Mapper - /purchase request/{} -> request");

		Long id = resultSet.getLong("id");
		Date issueDate = resultSet.getDate("issue_date");
		String issueTo = resultSet.getString("issue_to");
		int orderNumber = resultSet.getInt("order_number");
		String dispatch = resultSet.getString("dispatch");
		String preparedBy = resultSet.getString("prepared_by");


		int itemNumber = resultSet.getInt("item_number");
		String itemDescription = resultSet.getString("item_description");
		int unitPrice = resultSet.getInt("unit_price");
		int quantity = resultSet.getInt("quantity");
		int estimatedValue = resultSet.getInt("estimated_value");
		String emailAddress = resultSet.getString("email_address");
		String name = resultSet.getString("name");
		String type = resultSet.getString("type");
		byte[] profileImage = resultSet.getBytes("profile_image");

		return IssueEntity.builder()
				.id(id)
				.issuedate(issueDate)
				.issueTo(issueTo)

				.orderNumber(orderNumber)
				.dispatch(dispatch)

				.preparedBY(preparedBy)




				.itemDescription(itemDescription)
				.unitPrice(unitPrice)
				.quantity(quantity)
				.estimatedValue(estimatedValue)
				.emailAddress(emailAddress)
				.name(name)
				.type(type)
				.profileImage(profileImage).build();
	}

}
