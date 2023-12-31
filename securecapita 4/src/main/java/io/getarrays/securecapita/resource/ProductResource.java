package io.getarrays.securecapita.resource;

import io.getarrays.securecapita.domain.Stock;
import io.getarrays.securecapita.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductResource {

    // Assume ProductService class handles product inventory
    @Autowired
    private StockService stockService;



    @PostMapping("/add")
    public ResponseEntity<Stock> createProduct(@RequestBody Stock stock){

        Stock createProduct =  stockService.createStock(stock);  //createProduct(product);
        return new ResponseEntity<>(createProduct, HttpStatus.OK);
    }

    @GetMapping("/totalQuantity")
    public int getTotalQuantityByProductCode(@RequestParam String productCode) {
        return stockService.getTotalQuantityByProductCode(productCode);
    }
}
