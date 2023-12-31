package io.getarrays.securecapita.service;

import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.dto.PurchaseRequisitionDTO;

import java.util.List;

public interface PurchaseRequisitionService {

    PurchaseRequisition createPurchaseRequest(PurchaseRequisition purchaseRequisition, Long userId);

    List<PurchaseRequisition> getAllPurchaseRequests();

    PurchaseRequisition getPurchaseRequestById(Long id);

    boolean deletePurchaseRequests(Long id);

    PurchaseRequisitionDTO findOneWithUser(Long userId, Long purchaseId);
}