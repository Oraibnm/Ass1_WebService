package com.example.Ass1.service;

import com.example.Ass1.entity.SupplierModel;

import java.util.List;

public interface SupplierService {

    SupplierModel saveSupplier(SupplierModel supplier);
    List<SupplierModel> getAllSuppliers();
    SupplierModel getSupplierById(long id);
    SupplierModel updateSupplier(SupplierModel supplier, long id);
    void deleteSupplier(long id);
}
