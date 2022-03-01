//package com.example.services;
//
//import com.example.dao.ProductDao;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(SpringExtension.class)
//class ProductServiceImplTest {
//
//    @Mock
//    ProductDao productDao;
//
//    @InjectMocks
//    ProductServiceImpl productService;
//
//    @Test
//    void testGetAllProduct() {
//        List<Product> data = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            data.add(new Product());
//        }
//        when(productDao.findAll()).thenReturn(data);
//
//        List<Product> result = productService.getAllProduct();
//
//        assertEquals(data.size(), result.size());
//
//        verify(productDao).findAll();
//    }
//
//    @Test
//    void testGetProductById() {
//        Product data = new Product();
//
//        when(productDao.findById(any())).thenReturn(Optional.of(data));
//
//        Optional<Product> result = productService.getProductById(any());
//
//        assertEquals(Optional.of(data), result);
//
//        verify(productDao).findById(any());
//    }
//
//    @Test
//    void testDeleteProductSuccessfully() {
//        when(productDao.existsById(any())).thenReturn(false);
//
////        String result = productService.deleteProduct(any()).getBody().getStatus();
//
////        assertEquals("Failed", result);
//
//        verify(productDao).existsById(any());
//    }
//
//    @Test
//    void testDeleteProductWhenCannotFindProduct() {
//        when(productDao.existsById(any())).thenReturn(true);
//
////        String result = productService.deleteProduct(any()).getBody().getStatus();
//
////        assertEquals("OK", result);
//
//        verify(productDao).existsById(any());
//    }
//}