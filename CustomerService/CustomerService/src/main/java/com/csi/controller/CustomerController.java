package com.csi.controller;

import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Customer> saveData(@RequestBody Customer customer){
        return ResponseEntity.ok(customerServiceImpl.saveData(customer));
    }

    @GetMapping("/findbycustomerid/{custId}")
    public ResponseEntity<RestTemplateVO> findByCustomerId(@PathVariable int custId){
        return ResponseEntity.ok(customerServiceImpl.findByCustomerId(custId));
    }
}
