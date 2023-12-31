/**
 * kunal
 * SpringBootNamedParametreJdbcTemplate
 * com.org.kunal.parametrejdbc.stockitemnew
 */
package io.getarrays.securecapita.stockitemnew;

import java.util.List;

/**
 * Kumar.Kunal
 * SpringBootNamedParameterJdbcTemplate
 * 2023
 */
public interface StocksDao {

	void save(Stocks stocks);

	void update(Stocks stocks);

	void delete(int id);

	Stocks getById(int id);

	List<Stocks> getAll();

}
