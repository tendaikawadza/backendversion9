/**
 * @author kunal
 * 
 */
package io.getarrays.securecapita.exception;

import io.getarrays.securecapita.purchaserequestnew.PurchaseRequestExceptionEnum;

import java.io.Serial;
/**
 * Kumar.Kunal
 */
public class PurchaseRequestNotFoundException extends RuntimeException {
	
	@Serial
    private static final long serialVersionUID = -7541208107922250009L;

	public PurchaseRequestNotFoundException () {
        super(PurchaseRequestExceptionEnum.PURCHASE_REQUEST_NOT_FOUND_EXCEPTION.getMessage());
    }
}
