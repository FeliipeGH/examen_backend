package com.fgh.examen_backend.services;

import com.fgh.examen_backend.models.SupplierModel;
import com.fgh.examen_backend.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {
    final int MAX_LIST_SIZE_IN_REQUEST = 6;
    @Autowired
    private SupplierRepository supplierRepository;

    public ResponseEntity<?> saveSupplier(SupplierModel supplierModel) {
        if (supplierModel.getSupplierId() == null) {
            if (this.findByName(supplierModel.getSupplierName()) != null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        } else {
            if (existOtherOneWithSameName(supplierModel.getSupplierName(), supplierModel.getSupplierId())) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        this.save(supplierModel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private SupplierModel findByName(String name) {
        return supplierRepository.findBySupplierName(name);
    }

    private boolean existOtherOneWithSameName(String name, Long id) {
        SupplierModel supplierModel = supplierRepository.findBySupplierName(name);
        if (supplierModel == null) return false;
        return !supplierModel.getSupplierId().equals(id);
    }

    public void save(SupplierModel supplierModel) {
        this.supplierRepository.save(supplierModel);
    }

    public ResponseEntity<?> getAllByIndex(int index) {
        List<SupplierModel> supplierModelList = this.supplierRepository.findAll();
        List<SupplierModel> supplierModelListIndexed = getListIndexed(index, supplierModelList);
        return new ResponseEntity<>(supplierModelListIndexed, HttpStatus.OK);
    }

    private List<SupplierModel> getListIndexed(int index, List<SupplierModel> supplierModelList) {
        int fromIndex = index == 0 ? index : MAX_LIST_SIZE_IN_REQUEST * index;
        int topList = fromIndex + MAX_LIST_SIZE_IN_REQUEST;
        if (fromIndex > supplierModelList.size()) {
            return new ArrayList<>();
        }
        if (topList > supplierModelList.size()) {
            return supplierModelList.subList(fromIndex, supplierModelList.size());
        }
        return supplierModelList.subList(fromIndex, topList);
    }

    public ResponseEntity<?> deleteById(Long id) {
        try {
            SupplierModel supplierModel = this.supplierRepository.findById(id).orElse(null);
            if (supplierModel == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            this.supplierRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
