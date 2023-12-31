package io.getarrays.securecapita.issue;

import jakarta.persistence.Lob;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class IssueResponseDto {


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
