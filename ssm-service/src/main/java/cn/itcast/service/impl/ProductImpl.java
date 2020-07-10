package cn.itcast.service.impl;

import cn.itcast.dao.ProductDao;
import cn.itcast.doamin.Product;
import cn.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductImpl implements ProductService {
 @Autowired
 private ProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }
    public void save(Product pt){
        productDao.save(pt);
    }
}
