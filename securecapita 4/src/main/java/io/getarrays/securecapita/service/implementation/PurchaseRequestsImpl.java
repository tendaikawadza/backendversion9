package io.getarrays.securecapita.service.implementation;

import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.domain.User;
import io.getarrays.securecapita.dto.PurchaseRequisitionDTO;
import io.getarrays.securecapita.dto.UserDTO;
import io.getarrays.securecapita.dtomapper.PurchaseDTOMapper;
import io.getarrays.securecapita.repository.PurchaseRequestsRepository;
import io.getarrays.securecapita.repository.UserRepository;
import io.getarrays.securecapita.service.PurchaseRequisitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.getarrays.securecapita.dtomapper.UserDTOMapper.fromUser;

@Service
@RequiredArgsConstructor
public class PurchaseRequestsImpl implements PurchaseRequisitionService {
    private final PurchaseRequestsRepository<PurchaseRequisition> purchaseRequestsRepository;
    private final UserRepository<User> userRepository;

    //delete requests
    public boolean deletePurchaseRequest(Long id) {
        return purchaseRequestsRepository.delete(id);
    }

    @Override
    public PurchaseRequisition createPurchaseRequest(PurchaseRequisition purchaseRequests, Long userId) {
        return purchaseRequestsRepository.create(purchaseRequests, userId);
    }

    @Override
    public List<PurchaseRequisition> getAllPurchaseRequests() {
        return purchaseRequestsRepository.list();
    }

    @Override
    public PurchaseRequisition getPurchaseRequestById(Long id) {
        return (PurchaseRequisition) purchaseRequestsRepository.get(id);
    }

    @Override
    public boolean deletePurchaseRequests(Long id) {
        return purchaseRequestsRepository.delete(id);
    }

    @Override
    public PurchaseRequisitionDTO findOneWithUser(Long userId, Long purchaseId) {
        return mapToPurchaseRequisitionDTO(purchaseRequestsRepository.findOneWithUser(purchaseId), userId);
    }

    private PurchaseRequisitionDTO mapToPurchaseRequisitionDTO(PurchaseRequisition purchaseRequisition, Long userId) {
        return PurchaseDTOMapper.fromPurchaseRequisition(purchaseRequisition, userRepository.get(userId));
    }
}
