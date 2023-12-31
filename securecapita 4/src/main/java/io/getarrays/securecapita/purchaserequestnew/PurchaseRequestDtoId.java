/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.purchaserequestnew;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Kumar.Kunal
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseRequestDtoId {

	private long id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date purchaseDate;
	
	private  String requestingDepartment;
	private int departmentCode;
	private String requestReason;
	private int itemNumber;
	private String itemDescription;
	private int unitPrice;
	private int quantity;
	private int estimatedValue;
	private String emailAddress;
	
	private String name;
	private String type;
	
	@Column(name = "profileImage", nullable = false, columnDefinition = "BINARY(256)", length = 256)
	@Lob
	private byte[] profileImage;
}
