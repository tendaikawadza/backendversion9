/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.issue;

import io.getarrays.securecapita.purchaserequestnew.PurchaseRequestEntity;
import io.getarrays.securecapita.purchaserequestnew.PurchaseResponseDto;
import org.mapstruct.Mapper;



/**
 * @author Kumar.Kunal
 *
 */
@Mapper(componentModel = "spring")
public interface IssueMapper {
	
	io.getarrays.securecapita.issue.IssueEntity  toEntity(io.getarrays.securecapita.issue.IssueResponseDto issueResponseDto);

	IssueResponseDto toDTO(IssueEntity    issueEntity);

}
