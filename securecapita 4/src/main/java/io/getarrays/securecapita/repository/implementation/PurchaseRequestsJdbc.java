package io.getarrays.securecapita.repository.implementation;

import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.exception.ApiException;
import io.getarrays.securecapita.purchaserequestnew.PurchaseRequestRowMapper;
import io.getarrays.securecapita.query.PurchaseQuery;
import io.getarrays.securecapita.repository.PurchaseRequestsRepository;
import io.getarrays.securecapita.rowmapper.PurchaseRequisitionRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

import static io.getarrays.securecapita.query.PurchaseQuery.SELECT_PURCHASE_REQUESTS_BY_ID_QUERY;
import static java.util.Map.of;


@Repository
@RequiredArgsConstructor
@Slf4j

public class PurchaseRequestsJdbc implements PurchaseRequestsRepository<PurchaseRequisition> {

    private final NamedParameterJdbcTemplate jdbc;
 //where but department code there, rs is resultSet it must same with column datamase, you can matching with column database

    RowMapper<PurchaseRequisition> rowMapper = (rs, rowNum) -> {
        PurchaseRequisition purchaseRequest = new PurchaseRequisition();
        purchaseRequest.setId(rs.getLong("id"));
        purchaseRequest.setDate(rs.getDate("date"));
        purchaseRequest.setDepartmentCode(rs.getInt("department_code"));
        purchaseRequest.setReceiverEmail(rs.getString("receiver_email"));
        purchaseRequest.setReason(rs.getString("reason"));
        purchaseRequest.setItemNumber(rs.getInt("item_number"));
        purchaseRequest.setItemDescription(rs.getString("item_description"));
        purchaseRequest.setUnitPrice(rs.getInt("unit_price"));
        purchaseRequest.setQuantity(rs.getInt("quantity"));
        purchaseRequest.setEstimatedValue(rs.getInt("estimated_value"));
        purchaseRequest.setSignature(rs.getString("signature"));
        return purchaseRequest;
    };
    //its the same the format must same, an example before  wait i want explain. ab example before departmentCode become department_code it must same with database

    @Override
    public List<PurchaseRequisition> list() {
        try {
            String query = "SELECT * FROM purchaserequisition;";
            List<PurchaseRequisition> purchaseRequests = jdbc.query(query, rowMapper);                        //query(query, new UserRowMapper());
            return purchaseRequests;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred while retrieving the list of purchase request. Please try again.");
        }

    }


    @Override
    public PurchaseRequisition create(PurchaseRequisition purchaseRequests, Long userId) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(purchaseRequests, userId);
        jdbc.update(PurchaseQuery.INSERT_PurchaseRequisition_REQUEST_QUERY, parameters, holder);
        return purchaseRequests;
    }

    private SqlParameterSource getSqlParameterSource(PurchaseRequisition purchaseRequisition, Long userId) {
        return new MapSqlParameterSource()
                .addValue("userId", userId)
                .addValue("id", purchaseRequisition.getId())
                .addValue("date", purchaseRequisition.getDate())
                .addValue("departmentCode", purchaseRequisition.getDepartmentCode())
                .addValue("receiverEmail", purchaseRequisition.getReceiverEmail())
                .addValue("reason", purchaseRequisition.getReason())
                .addValue("itemNumber", purchaseRequisition.getItemNumber())
                .addValue("itemDescription", purchaseRequisition.getItemDescription())
                .addValue("unitPrice", purchaseRequisition.getUnitPrice())
                .addValue("unitPrice", purchaseRequisition.getUnitPrice())
                .addValue("quantity", purchaseRequisition.getQuantity())
                .addValue("estimatedValue", purchaseRequisition.getEstimatedValue())

                .addValue("signature", purchaseRequisition.getSignature());
    }


    @Override
    public PurchaseRequisition get(Long id) {
        try {

            return jdbc.queryForObject(PurchaseQuery.INSERT_PurchaseRequisition_REQUEST_QUERY, of("id", id), rowMapper);

        } catch (EmptyResultDataAccessException exception) {
            throw new ApiException("No PURCHASE REQUESTS found by id: " + id);
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again.");
        }
    }

//    @Override
//    public void update(PurchaseRequests purchaseRequests, Long id) {
//
//    }

//    @Override
//    public void update(PurchaseRequests purchaseRequests, Long id) {
//        try {
//
//            String UPDATE_PURCHASEREQUESTS_BY_PURCHASEREQUEST_ID = "UPDATE PURCHASEREQUEST SET productName=?,Date=?,productCode=? WHERE id = :purchaserequestsId";
//
//            jdbcTemplate.update(UPDATE_PURCHASEREQUESTS_BY_PURCHASEREQUEST_ID, purchaseRequests.getProductName(),purchaseRequests.getDate(),purchaseRequests.getProductCode(),id);
//            return;
//
//        }
//        catch (Exception exception) {
//            log.error(exception.getMessage());
//            throw new ApiException("An error occurred. Please try again.");
//        }
//
//    }


    @Override
    public boolean delete(Long id) {
        try {
            String DELETE_FROM_PURCHASEREQUESTS_BY_PURCHASEREQUEST_ID = "DELETE FROM PURCHASEREQUEST WHERE id = :purchaserequestwId";
            jdbc.update(DELETE_FROM_PURCHASEREQUESTS_BY_PURCHASEREQUEST_ID, Collections.singletonMap("purchaserequestsId", id));
            return true;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again.");
        }

    }

    @Override
    public PurchaseRequisition findOneWithUser(Long id) {
        try {
            return jdbc.queryForObject(SELECT_PURCHASE_REQUESTS_BY_ID_QUERY, of("id", id), new PurchaseRequisitionRowMapper());
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again.");
        }
    }


}
