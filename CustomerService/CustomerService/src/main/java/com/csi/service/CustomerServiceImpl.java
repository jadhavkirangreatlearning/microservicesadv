package com.csi.service;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import com.csi.vo.OrderDetail;
import com.csi.vo.Product;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepo customerRepoImpl;
/*
    @Autowired
    private RestTemplate restTemplate;*/

    @Autowired
    private OrderDetailFeignClientService orderDetailFeignClientService;

    @Autowired
    private ProductFeignClientService productFeignClientService;


    public Customer saveData(Customer customer) {

        return customerRepoImpl.save(customer);
    }

    public RestTemplateVO findByCustomerId(int custId) {

        RestTemplateVO restTemplateVO = new RestTemplateVO();

        Customer customer = customerRepoImpl.findByCustId(custId);

        //  Product product = restTemplate.getForObject("http://ProductService/products/findbyproductid/" + customer.getProductId(), Product.class);

        // OrderDetail orderDetail = restTemplate.getForObject("http://OrderService/orderdetails/findbyorderid/" + customer.getOrderId(), OrderDetail.class);

        Product product = productFeignClientService.findByProductId(customer.getProductId());

        OrderDetail orderDetail = orderDetailFeignClientService.findByOrderId(customer.getOrderId());


        restTemplateVO.setCustomer(customer);

        restTemplateVO.setProduct(product);

        restTemplateVO.setOrderDetail(orderDetail);

        return restTemplateVO;
    }
}
