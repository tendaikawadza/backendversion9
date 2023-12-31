package io.getarrays.securecapita.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRequisitionDTO {
    private Long id;
    private String fullName;
    private String department;
    private Date date;
    private int departmentCode;
    private String reason;
    private int itemNumber;
    private String itemDescription;
    private int unitPrice;
    private int quantity;
    private int estimatedValue;
    private String receiverEmail;
    private String signature;

}
