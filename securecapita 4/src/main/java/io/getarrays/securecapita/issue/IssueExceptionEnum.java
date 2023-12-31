/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.issue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
/**
 * Kumar.Kunal
 */
@Getter
@RequiredArgsConstructor
public enum IssueExceptionEnum {
    
	ISSUE_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "Issue Not Found!");

    private final HttpStatus status;
    private final String message;
}
