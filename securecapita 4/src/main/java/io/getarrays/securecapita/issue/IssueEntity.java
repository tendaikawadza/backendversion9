/**
 * Kumar.Kunal
 * parametrejdbc
 * com.org.kunal.parametrejdbc.purchaserequest
 */
package io.getarrays.securecapita.issue;

import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Kumar.Kunal
 */
@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Table
public class IssueEntity {


    private long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date issuedate;
    private String  issueTo;
    private int orderNumber;
    private String dispatch;
    private String preparedBY;
    private String itemDescription;
    private int quantity;
    private int unitPrice;
    private int estimatedValue;
    private String emailAddress;
    private String name;
    private String type;
    // @Column(name = "profileImage", nullable = false, columnDefinition =
    // "BINARY(256)", length = 256)
    @Lob
    private byte[] profileImage;

}
