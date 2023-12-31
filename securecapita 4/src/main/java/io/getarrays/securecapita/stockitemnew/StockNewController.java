/**
 * kunal
 * SpringBootNamedParametreJdbcTemplate
 * com.org.kunal.parametrejdbc.stockitemnew
 */
package io.getarrays.securecapita.stockitemnew;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Kumar.Kunal
 * SpringBootNamedParameterJdbcTemplate
 * 2023
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/item")
@Slf4j
public class StockNewController {

    private StocksNewService stocksNewService;

    @Autowired
    public StockNewController(StocksNewService stocksNewService) {
        this.stocksNewService = stocksNewService;
    }

    @PostMapping(value = "/stocks", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveStock(@RequestBody Stocks stocks) {
        if (stocks != null) {
            log.info("saveStock controller ---- '{}'", stocks);
            stocksNewService.saveStock(stocks);
        }else {
            log.error("Invalid request: stocks object is null");
        }
    }

    //here on create its not null, the null from loop stock

    @PutMapping(value = "/stocks/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateStock(@PathVariable int id, @RequestBody Stocks stocks) {
        stocks.setId(id);
        stocksNewService.updateStock(stocks);
    }

    @DeleteMapping("/stocks/{id}")
    public void deleteStock(@PathVariable int id) {
        stocksNewService.deleteStock(id);
    }

    @GetMapping("/stocks/{id}")
    public Stocks getStockById(@PathVariable int id) {
        return stocksNewService.getStockById(id);
    }

    @GetMapping("/stocks")
    public List<Stocks> getAllStocks() {
        return stocksNewService.getAllStocks();
    }

}
