/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.purchaserequestnew;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Kumar.Kunal
 */
public interface PurchaseRequestNewRepository {
	
	List<PurchaseRequestEntity> saveFile(List<MultipartFile> files, List<PurchaseRequestEntity> pEntity) throws IOException;

	int save(PurchaseRequestEntity purchaseRequest);

	int update(PurchaseRequestEntity purchaseRequest);

	Optional<PurchaseRequestEntity> findById(Long id);

	int deleteById(Long id);

	List<PurchaseRequestEntity> findAll();

	Stream<PurchaseRequestEntity> findAll(io.getarrays.securecapita.purchaserequestnew.Page page);
	
}
