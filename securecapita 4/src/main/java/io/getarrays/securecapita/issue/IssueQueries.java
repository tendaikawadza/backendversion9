/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.issue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Kumar.Kunal
 *
 */
@Component
public class IssueQueries {

	@Value("${purchase.query.find.all}")
	private String findAll;

	public String getFindAll() {
		return findAll;
	}

	public void setFindAll(String findAll) {
		this.findAll = findAll;
	}

}
