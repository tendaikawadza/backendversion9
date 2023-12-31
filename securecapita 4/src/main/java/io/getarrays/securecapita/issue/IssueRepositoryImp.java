/**
 * @author Kumar.Kunal
 */

package io.getarrays.securecapita.issue;

import io.getarrays.securecapita.issue.Page;
import io.getarrays.securecapita.issue.IssueRowMapper;
import io.getarrays.securecapita.service.implementation.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

/**
 * Kumar.Kunal
 */

@Repository
@RequiredArgsConstructor
@Slf4j

public class IssueRepositoryImp implements IssueRepository {


	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final IssueQueries issueQueries;
	private final RowMapper<IssueEntity> rowMapper;
	private final SimpleJdbcInsert insert;
	private EmailService emailService;

	public IssueRepositoryImp(NamedParameterJdbcTemplate namedParameterJdbcTemplate, IssueQueries issueQueries, RowMapper<IssueEntity> rowMapper, SimpleJdbcInsert insert, EmailService emailService) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.issueQueries = issueQueries;
		this.rowMapper = rowMapper;
		this.insert = insert;
		this.emailService = emailService;
	}

	public IssueRepositoryImp() {
		// Default constructor
		this.namedParameterJdbcTemplate = null;
		this.issueQueries = null;
		this.rowMapper = null;
		this.insert = null;
		this.emailService = null;
	}



	//	@Autowired
//	public IssueRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, IssueQueries issueQueries) {
//		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
//		this.rowMapper = new IssueRowMapper();
//		this.issueQueries = issueQueries;
//		this.insert = new SimpleJdbcInsert(namedParameterJdbcTemplate.getJdbcTemplate());
//		this.insert.setTableName("issue");
//		this.insert.usingGeneratedKeyColumns("id");
//	}


	public static final String ISSUE_LIST = "select * from issue";
	public static final String ISSUE_FIND_BY_ID = "select * from issue where id = :id";
	public static final String INSERT_ISSUE = "insert into issue(purchase_date , requesting_department, department_code, request_reason, item_number, "
			+ "item_description, unit_price, quantity, estimated_value, email_address, name, type, profile_image) values (:purchaseDate, :requestingDepartment, "
			+ ":departmentCode, :requestReason, :itemNumber, :itemDescription, :unitPrice, :quantity, :estimatedValue, :emailAddress, :name, :type, :profileImage)";
	public static final String UPDATE_ISSUE = "update issue set requesting_department = :requestingDepartment, department_code = :departmentCode, quantity = :quantity where id = :id";
	public static final String DELETE_ISSUE = "delete from issue where id = :id";

	@Override
	public List<IssueEntity> saveFile(List<MultipartFile> files, List<IssueEntity> pEntity)
			throws IOException {

		log.info("Entering Inside Insert Statement ------ ");

		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			IssueEntity issueEntity = pEntity.get(i);
			if (!file.isEmpty() || !files.isEmpty() || !pEntity.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
					String sql = INSERT_ISSUE;
					KeyHolder keyHolder = new GeneratedKeyHolder();
					MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
					mapSqlParameterSource.addValue("issueDate", issueEntity.getIssuedate());
					mapSqlParameterSource.addValue("issueTo", issueEntity.getIssueTo());
					mapSqlParameterSource.addValue("dispatch", issueEntity.getDispatch());
					mapSqlParameterSource.addValue("orderNumber", issueEntity.getOrderNumber());
					mapSqlParameterSource.addValue("dispatch", issueEntity.getDispatch());

					mapSqlParameterSource.addValue("preparedby", issueEntity.getPreparedBY());

					mapSqlParameterSource.addValue("itemDescription", issueEntity.getItemDescription());
					mapSqlParameterSource.addValue("quantity", issueEntity.getQuantity());
					mapSqlParameterSource.addValue("unitPrice",issueEntity.getUnitPrice());
					mapSqlParameterSource.addValue("estimatedValue", issueEntity.getEstimatedValue());
					mapSqlParameterSource.addValue("emailAddress", issueEntity.getEmailAddress());

//					@DateTimeFormat(pattern = "dd/MM/yyyy")
//					private Date issuedate;
//					private String  issueTo;
//					private int orderNumber;
//					private String dispatch;
//					private String preparedBY;
//					private String itemDescription;
//					private int quantity;
//					private int unitPrice;
//					private int estimatedValue;
//					private String emailAddress;
//					private String name;
//					private String type;

					mapSqlParameterSource.addValue("name", file.getOriginalFilename());
					mapSqlParameterSource.addValue("type", file.getContentType());
					mapSqlParameterSource.addValue("profileImage", bytes);

					namedParameterJdbcTemplate.update(sql, mapSqlParameterSource, keyHolder);
					issueEntity.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
					log.info("Finishing Insert Statement with ID ---  '{}'" , issueEntity.getId());

					String email = issueEntity.getEmailAddress();
					String subject = "Issue Email Verification Sent By jsc Admini";
					String message = "Hello " + issueEntity.getId() + " for Product Name " + issueEntity.getQuantity() + ", "
							+ "\n A Purchase Request Email Verification Was Sent To \n" + issueEntity.getEmailAddress();
					emailService.sendEmail(email, subject, message);

				} catch (DataAccessException e) {
					log.error(
							"Exception for Create saveFile method under PurchaseRequestNewJdbcRepository class '{}' \n '{}'",
							e, e.getMessage());
				}
			}
		}
		return pEntity;
	}

	@Override
	public int save(IssueEntity issueEntity) {
		/*
		 * String email = purchaseRequest.getEmailAddress(); String subject =
		 * "Purchase Request Email Verification Sent By Kumar Kunal"; String message =
		 * "Hello " + purchaseRequest.getId() + " for Product Name " +
		 * purchaseRequest.getItemDescription() + ", " +
		 * "\n A Purchase Request Email Verification Was Sent To \n" +
		 * purchaseRequest.getEmailAddress(); emailService.sendEmail(email, subject,
		 * message);
		 */
		return namedParameterJdbcTemplate.update(INSERT_ISSUE,
				new BeanPropertySqlParameterSource(issueEntity));
	}

	@Override
	public int update(IssueEntity issueEntity) {

		return namedParameterJdbcTemplate.update(UPDATE_ISSUE,
				new BeanPropertySqlParameterSource(issueEntity));
	}

	@Override
	public Optional<IssueEntity> findById(Long id) {
		log.info("Fetching Issue Details from DB with ID = '{}'", id);
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("id", id);
		return namedParameterJdbcTemplate
				.query(ISSUE_FIND_BY_ID, mapSqlParameterSource,
						(rs, row) -> IssueEntity.builder().id(rs.getLong("id"))

								.issuedate(rs.getDate("issue_date"))
								.issueTo(rs.getString("issue_to"))
								.dispatch(rs.getString("dispatch"))
								.preparedBY(rs.getString("prepared_by"))

								.itemDescription(rs.getString("item_description")).unitPrice(rs.getInt("unit_price"))
								.quantity(rs.getInt("quantity")).estimatedValue(rs.getInt("estimated_value"))
								.emailAddress(rs.getString("email_address")).name(rs.getString("name"))
								.type(rs.getString("type")).profileImage(rs.getBytes("profile_image")).build())
				.stream().findFirst();
	}

	@Override
	public int deleteById(Long id) {
		log.info("Purchase Request is deleted with ID = '{}'", id);
		return namedParameterJdbcTemplate.update(DELETE_ISSUE, new MapSqlParameterSource("id", id));
	}

	@Override
	public List<IssueEntity> findAll() {
		log.info("Fetching Purchase Request All Details from DB with ID ");
		return namedParameterJdbcTemplate.query(ISSUE_LIST,
				(rs, row) -> IssueEntity.builder().id(rs.getLong("id"))
						.issuedate(rs.getDate("issue_date"))
						.issueTo(rs.getString("issue_to"))

						.dispatch(rs.getString("dispatch"))

						.itemDescription(rs.getString("item_description"))
						.unitPrice(rs.getInt("unit_price")).quantity(rs.getInt("quantity"))
						.estimatedValue(rs.getInt("estimated_value")).emailAddress(rs.getString("email_address"))
						.name(rs.getString("name")).type(rs.getString("type")).profileImage(rs.getBytes("profile_image"))
						.build());
	}

	@Override
	public Stream<IssueEntity> findAll(Page page) {
		String sql = issueQueries.getFindAll();
		log.info("Fetching Page All Request For Pagination '{}' ", sql);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("limit", page.getLimit());
		paramMap.put("offset", page.getOffset());
		return namedParameterJdbcTemplate.queryForStream(sql, paramMap, rowMapper);
	}




}
