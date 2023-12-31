package io.getarrays.securecapita.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class PurchaseRequisition {
    private Long id;
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
