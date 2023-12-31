/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.issue;

import io.getarrays.securecapita.issue.Page;
import io.getarrays.securecapita.purchaserequestnew.PurchaseRequestDto;
import io.getarrays.securecapita.purchaserequestnew.PurchaseRequestDtoId;
import io.getarrays.securecapita.purchaserequestnew.PurchaseResponseDto;
import io.getarrays.securecapita.issue.ResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Kumar.Kunal
 */
public interface IssueService {
	
	List<io.getarrays.securecapita.issue.IssueDto> saveFile(List<MultipartFile> files, List<io.getarrays.securecapita.issue.IssueDto> pEntity) throws IOException;
//
	//List<io.getarrays.securecapita.issue.IssueDto> findAll();
	List<IssueResponseDto> findAll(Page page);


//
//	io.getarrays.securecapita.issue.IssueDto findById(Long id);
//
//
 //
ResponseDto update(IssueDtoId issue);

	ResponseDto delete(Long id);


//IssueResponseDto findById(Long id);

}