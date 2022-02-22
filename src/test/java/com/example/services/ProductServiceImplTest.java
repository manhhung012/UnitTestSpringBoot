package com.example.services;

import com.example.dao.ProductDao;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
;

class ProductServiceImplTest {

    @Mock
    ProductDao productDao;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    void getAllProduct() {
    }

    @Test
    void getProductById() {
    }

    @Test
    void deleteProduct() {
    }
}