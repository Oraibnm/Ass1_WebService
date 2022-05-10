package com.example.Ass1.controller;

import com.example.Ass1.entity.SupplierModel;
import com.example.Ass1.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
//    public String getMassage (){
//        return "Yes App Works !! ";
//    }

private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        super();
        this.supplierService = supplierService;
    }

    // build create employee REST API
    //@RequestBody annotation allows us to retrieve the request's body and automatically convert it to Java Object
    @PostMapping()
    public ResponseEntity<SupplierModel> saveSupplier(@RequestBody SupplierModel supplier){
        return new ResponseEntity<SupplierModel>(supplierService.saveSupplier(supplier), HttpStatus.CREATED);
    }

    // build get all employees REST API
    @GetMapping
    public List<SupplierModel> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    // build get supplier by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<SupplierModel> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<SupplierModel>(supplierService.getSupplierById(employeeId), HttpStatus.OK);
    }

    // build update employee REST API
    // http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<SupplierModel> updateEmployee(@PathVariable("id") long id
            ,@RequestBody SupplierModel employee){
        return new ResponseEntity<SupplierModel>(supplierService.updateSupplier(employee, id), HttpStatus.OK);
    }

    // build delete employee REST API
    // http://localhost:8080/api/employees/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

        // delete employee from DB
        supplierService.deleteSupplier(id);

        return new ResponseEntity<String>("Supplier deleted successfully!.", HttpStatus.OK);
    }

}
