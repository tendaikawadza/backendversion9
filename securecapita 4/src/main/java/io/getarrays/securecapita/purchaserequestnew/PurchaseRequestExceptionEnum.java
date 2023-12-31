/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.purchaserequestnew;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
/**
 * Kumar.Kunal
 */
@Getter
@RequiredArgsConstructor
public enum PurchaseRequestExceptionEnum {
    
	PURCHASE_REQUEST_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "Purchase Request Not Found!");

    private final HttpStatus status;
    private final String message;
}
