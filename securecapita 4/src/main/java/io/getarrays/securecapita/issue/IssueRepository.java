/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.issue;

import io.getarrays.securecapita.purchaserequestnew.PurchaseRequestEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Kumar.Kunal
 */
public interface IssueRepository {
	
	List<io.getarrays.securecapita.issue.IssueEntity> saveFile(List<MultipartFile> files, List<io.getarrays.securecapita.issue.IssueEntity> pEntity) throws IOException;

	int save(io.getarrays.securecapita.issue.IssueEntity issueEntity);

	int update(io.getarrays.securecapita.issue.IssueEntity  issueEntity);

	Optional<io.getarrays.securecapita.issue.IssueEntity> findById(Long id);

	int deleteById(Long id);

	List<io.getarrays.securecapita.issue.IssueEntity> findAll();

	Stream<IssueEntity> findAll(io.getarrays.securecapita.issue.Page page);
	
}
