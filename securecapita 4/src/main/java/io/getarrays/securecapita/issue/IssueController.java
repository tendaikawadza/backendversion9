/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.issue;

import io.getarrays.securecapita.issue.Page;
import io.getarrays.securecapita.issue.IssueDto;
import io.getarrays.securecapita.issue.IssueDtoId;
import io.getarrays.securecapita.issue.IssueService;
import io.getarrays.securecapita.issue.IssueResponseDto;
import io.getarrays.securecapita.issue.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Kumar.Kunal
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/issue")
@Slf4j
public class IssueController {

	private final IssueService issueService;

	//@PreAuthorize("hasAnyRole('ADMIN','MANAGER','USER')")
	@PostMapping(value = "/upload", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<List<io.getarrays.securecapita.issue.IssueDto>> uploadFiles(@RequestPart("files") List<MultipartFile> files,
                                                                                                             @RequestPart("issueDto") List<io.getarrays.securecapita.issue.IssueDto> issueDto) throws IOException {
		log.info("POST - /purchase request for Multipart Upload - request -> '{}'", issueDto);

		if (files == null || files.isEmpty() || issueDto == null || issueDto.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}

		List<IssueDto> saved = issueService.saveFile(files, issueDto);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/pagespage")
	public List<io.getarrays.securecapita.issue.IssueResponseDto> findAll(@RequestParam(value = "page", defaultValue = "1") Long page,
                                                                                          @RequestParam(value = "size", defaultValue = "10") Long size) {
		log.info("GET - /purchase request -> finalAll For Pagination Call entered ");
		return issueService.findAll(Page.of(page, size));
	}




//	@GetMapping("/{id}")
//	public io.getarrays.securecapita.issue.IssueResponseDto issueById(@PathVariable Long id) {
//		log.info("GET - /purchase request/{} -> request", id);
//		IssueResponseDto issueByIdResponse = issueService.findById(id);
//		log.info("GET - /purchase request/{} - response -> {} {} " + id + "\n" + issueByIdResponse);
//		return issueByIdResponse;
//	}

	/*
	 * @PostMapping public ResponseDto insert(@RequestBody PurchaseRequestDto
	 * purchaseRequestDto) { log.info("POST - /purchase request - request -> {}" +
	 * purchaseRequestDto); ResponseDto insertResponse =
	 * purchaseRequestService.insert(purchaseRequestDto);
	 * log.info("POST - /purchase request -> response none - created successfully");
	 * return insertResponse; }
	 */

	@PutMapping
	public io.getarrays.securecapita.issue.ResponseDto update(@RequestBody IssueDtoId issueDto) {
		log.info("PUT - /purchase request - request -> {}" + issueDto);
		io.getarrays.securecapita.issue.ResponseDto updatedResponse = issueService.update(issueDto);
		log.info("PUT - /purchase request -> response none - updated successfully");
		return updatedResponse;
	}

	@DeleteMapping("/{id}")
	public io.getarrays.securecapita.issue.ResponseDto delete(@PathVariable Long id) {
		log.info("DELETE - /purchase request/{} -> request", id);
		ResponseDto deleteResponse = issueService.delete(id);
		log.info("DELETE - /purchase request -> response none");
		return deleteResponse;
	}

	/*
	 * @PostMapping public ResponseEntity<AgreementCreationResponse>
	 * createAgreement(@RequestBody String userEmail) { try {
	 * AgreementCreationResponse agreement =
	 * signatureService.createAgreement(userEmail); return
	 * ResponseEntity.ok(agreement); } catch (ApiException e) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); } }
	 */

}
