/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.purchaserequestnew;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Kumar.Kunal
 */
public interface PurchaseRequestNewService {
	
	List<PurchaseRequestDto> saveFile(List<MultipartFile> files, List<PurchaseRequestDto> pEntity) throws IOException;

	List<PurchaseResponseDto> findAll();

	PurchaseResponseDto findById(Long id);

	ResponseDto insert(PurchaseRequestDto purchaseRequest);

	ResponseDto update(PurchaseRequestDtoId purchaseRequest);

	ResponseDto delete(Long id);

	List<PurchaseResponseDto> findAll(Page page);

}