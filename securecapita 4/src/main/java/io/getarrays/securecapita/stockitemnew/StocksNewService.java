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
public interface StocksNewService {

	void saveStock(Stocks stocks);

	void updateStock(Stocks stocks);

	void deleteStock(int id);

	Stocks getStockById(int id);

	List<Stocks> getAllStocks();

}
