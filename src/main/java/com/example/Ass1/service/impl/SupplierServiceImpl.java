package com.example.Ass1.service.impl;

import com.example.Ass1.entity.SupplierModel;
import com.example.Ass1.exception.ResourceNotFoundException;
import com.example.Ass1.repository.SupplierRepository;
import com.example.Ass1.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    //@Autowired annotation can be  omitted and Spring will use that constructor and inject all necessary dependencies.
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        super();
        this.supplierRepository = supplierRepository;
    }


    @Override
    public SupplierModel saveSupplier(SupplierModel supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<SupplierModel> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public SupplierModel getSupplierById(long id) {
        return supplierRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Supplier", "Id", id));

    }

    @Override
    public SupplierModel updateSupplier(SupplierModel supplier, long id) {
        // we need to check whether Supplier with given id is exist in DB or not
        SupplierModel existingSupplier = supplierRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Supplier", "Id", id));

        existingSupplier.setName(supplier.getName());
        existingSupplier.setAddress(supplier.getAddress());
        existingSupplier.setEmail(supplier.getEmail());
        // save existing supplier to DB
        supplierRepository.save(existingSupplier);
        return existingSupplier;
    }

    @Override
    public void deleteSupplier(long id) {
    // check whether supplier exist in a DB or not
        supplierRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("supplier", "Id", id));
        supplierRepository.deleteById(id);
    }

}
