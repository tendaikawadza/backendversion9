package io.getarrays.securecapita.repository;

import io.getarrays.securecapita.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;



    public interface ProductRepository extends JpaRepository<Stock, Long> {


        Stock findByProductCode(String productCode);
    }


