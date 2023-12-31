/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.purchaserequestnew;

import org.mapstruct.Mapper;



/**
 * @author Kumar.Kunal
 *
 */
@Mapper(componentModel = "spring")
public interface PurchaseRequestMapper {
	
	PurchaseRequestEntity toEntity(PurchaseResponseDto purchaseResponseDto);

	PurchaseResponseDto toDTO(PurchaseRequestEntity purchaseRequestEntity);

}
