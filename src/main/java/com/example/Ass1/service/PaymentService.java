package com.example.Ass1.service;


import com.example.Ass1.entity.PaymentModel;

import java.util.List;

public interface PaymentService {


    PaymentModel savePayment(PaymentModel payment);
    List<PaymentModel> getAllPayments();
    PaymentModel getPaymentById(long id);
    PaymentModel updatePayment(PaymentModel payment, long id);
    void deletePayment(long id);
}
