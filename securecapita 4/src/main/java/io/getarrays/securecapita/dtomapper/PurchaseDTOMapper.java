package io.getarrays.securecapita.dtomapper;

import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.domain.User;
import io.getarrays.securecapita.dto.PurchaseRequisitionDTO;
import org.springframework.beans.BeanUtils;

public class PurchaseDTOMapper {
    public static PurchaseRequisitionDTO fromPurchaseRequisition(PurchaseRequisition purchaseRequisition, User user) {
        PurchaseRequisitionDTO purchaseRequisitionDTO = new PurchaseRequisitionDTO();
        BeanUtils.copyProperties(purchaseRequisition, purchaseRequisitionDTO);
        purchaseRequisitionDTO.setDepartment(user.getDepartment());
        purchaseRequisitionDTO.setFullName(user.getFirstName() + " " + user.getLastName());
        return purchaseRequisitionDTO;
    }
}
