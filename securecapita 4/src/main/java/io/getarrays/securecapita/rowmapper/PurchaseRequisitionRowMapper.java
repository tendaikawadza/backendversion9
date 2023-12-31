package io.getarrays.securecapita.rowmapper;

import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.domain.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseRequisitionRowMapper implements RowMapper<PurchaseRequisition> {
    @Override
    public PurchaseRequisition mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return PurchaseRequisition.builder()
                .id(resultSet.getLong("id"))
                .date(resultSet.getDate("date"))
                .departmentCode(resultSet.getInt("department_code"))
                .reason(resultSet.getString("reason"))
                .itemNumber(resultSet.getInt("item_number"))
                .itemDescription(resultSet.getString("item_description"))
                .unitPrice(resultSet.getInt("unit_price"))
                .quantity(resultSet.getInt("quantity"))
                .estimatedValue(resultSet.getInt("estimated_value"))
                .receiverEmail(resultSet.getString("receiver_email"))
                .signature(resultSet.getString("signature"))
                .build();
    }
}
