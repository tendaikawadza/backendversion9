package io.getarrays.securecapita.controller;

import java.util.List;

import io.getarrays.securecapita.dto.PurchaseRequestVO;
import io.getarrays.securecapita.service.PurchaseRequestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/purchaserequest")
public class PurchaseRequestController {

	private final PurchaseRequestService purchaseRequestService;
	private List<String> processes;

	public PurchaseRequestController(PurchaseRequestService purchaseRequestService) {
		this.purchaseRequestService = purchaseRequestService;

	}

	@PostMapping("/requestprocess")
	public String getPurchaseRequestProcess(@RequestBody PurchaseRequestVO requestVO) {
		String processLabel = null;
		processLabel = this.purchaseRequestService.getPurchaseRequestProcessByName(requestVO.getProcessName());
		return processLabel;
	}

	@GetMapping("/allprocess")
	public List<String> getAllPurchaseProcesses() {
		return this.processes;
	}

	@PostConstruct
	public List<String> initializeProcesses() {
		processes = List.of("INITIATION BY ADMINISTRATION OFFICER",
						
						"APPROVAL BY PRINICIPAL ADMINISTRATION",

				"AUTHORAZATION BY HEAD OF ADMINISTRATION",

				"SUBMISSION TO BOARD OF SURVEY BY HEAD OF ADMISTRATION",

				"COMPLETION"
				);
		return processes;
	}

}
