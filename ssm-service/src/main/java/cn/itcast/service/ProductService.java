package cn.itcast.service;

import cn.itcast.doamin.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll() throws Exception;
    void save(Product pt);
}
