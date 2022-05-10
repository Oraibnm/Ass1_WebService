package com.example.Ass1.service.impl;

import com.example.Ass1.entity.PaymentModel;
import com.example.Ass1.exception.ResourceNotFoundException;
import com.example.Ass1.repository.PaymentRepository;
import com.example.Ass1.service.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {


    private PaymentRepository paymentRepository;
    @Override
    public PaymentModel savePayment(PaymentModel payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<PaymentModel> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentModel getPaymentById(long id) {
        return paymentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Payment", "Id", id));

    }

    @Override
    public PaymentModel updatePayment(PaymentModel payment, long id) {
        // we need to check whether Payment with given id is exist in DB or not
        PaymentModel existingPayment = paymentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Payment", "Id", id));

        existingPayment.setType(payment.getType());
        existingPayment.setPhone(payment.getPhone());
        existingPayment.setEmail(payment.getEmail());
        // save existing payment to DB
        paymentRepository.save(existingPayment);
        return existingPayment;
    }

    @Override
    public void deletePayment(long id) {
        paymentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("payment", "Id", id));
        paymentRepository.deleteById(id);
    }
    }

