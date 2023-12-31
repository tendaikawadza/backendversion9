/**
 * kunal
 * SpringBootNamedParametreJdbcTemplate
 * com.org.kunal.parametrejdbc.stockitemnew
 */
package io.getarrays.securecapita.stockitemnew;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Kumar.Kunal
 * SpringBootNamedParameterJdbcTemplate
 * 2023
 */
@Service
@Slf4j
public class StocksNewServiceImpl implements StocksNewService {
    private final StocksDao stocksDao;

    @Autowired
    public StocksNewServiceImpl(StocksDao stocksDao) {
        this.stocksDao = stocksDao;
    }

    @Override
    public void saveStock(Stocks stocks) {
        log.info("saveStock service impl ---- '{}'", stocks);
        stocksDao.save(stocks);
    }

    @Override
    public void updateStock(Stocks stocks) {
        stocksDao.update(stocks);
    }

    @Override
    public void deleteStock(int id) {
        stocksDao.delete(id);
    }

    @Override
    public Stocks getStockById(int id) {
        return stocksDao.getById(id);
    }

    @Override
    public List<Stocks> getAllStocks() {
        return stocksDao.getAll();
    }

}
