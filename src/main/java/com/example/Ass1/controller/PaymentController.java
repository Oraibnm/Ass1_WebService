package com.example.Ass1.controller;

import com.example.Ass1.entity.PaymentModel;
import com.example.Ass1.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private PaymentService paymentService;

//    public PaymentController(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    // build create employee REST API
    //@RequestBody annotation allows us to retrieve the request's body and automatically convert it to Java Object
    @PostMapping()
    public ResponseEntity<PaymentModel> savePayment(@RequestBody PaymentModel payment){
        return new ResponseEntity<PaymentModel>(paymentService.savePayment(payment), HttpStatus.CREATED);
    }

    // build get all employees REST API
    @GetMapping
    public List<PaymentModel> getAllPayments(){
        return paymentService.getAllPayments();
    }

    // build get supplier by id REST API
    // http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<PaymentModel> getPaymentById(@PathVariable("id") long employeeId){
        return new ResponseEntity<PaymentModel>(paymentService.getPaymentById(employeeId), HttpStatus.OK);
    }

    // build update employee REST API
    // http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<PaymentModel> updatePayment(@PathVariable("id") long id
            ,@RequestBody PaymentModel payment){
        return new ResponseEntity<PaymentModel>(paymentService.updatePayment(payment, id), HttpStatus.OK);
    }

    // build delete employee REST API
    // http://localhost:8080/api/employees/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePayment(@PathVariable("id") long id){

        // delete employee from DB
        paymentService.deletePayment(id);

        return new ResponseEntity<String>("Supplier deleted successfully!.", HttpStatus.OK);
    }

}
