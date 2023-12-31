package io.getarrays.securecapita.service.impl;

import io.getarrays.securecapita.enumeration.PurchaseRequest;
import io.getarrays.securecapita.service.PurchaseRequestService;
import org.springframework.stereotype.Service;



@Service
public class PurchaseRequestServiceImpl implements PurchaseRequestService {

	@Override
	public String getPurchaseRequestProcessByName(String processName) {
		String processLabel = null;
		PurchaseRequest purchaseRequest = PurchaseRequest.getPurchaseRequestValueByName(processName);
		processLabel =  null != purchaseRequest ? purchaseRequest.getDescription() : "No Process's Name Found in the System";	
		return processLabel;
	}
}
