package com.fgh.examen_backend.services;

import com.fgh.examen_backend.models.InsertionInitialData;
import com.fgh.examen_backend.models.SupplierModel;
import com.fgh.examen_backend.repositories.InsertionInitialDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsertionInitialService {
    @Autowired
    private InsertionInitialDataRepository insertionInitialDataRepository;
    @Autowired
    private SupplierService supplierService;

    public List<InsertionInitialData> findAll() {
        return this.insertionInitialDataRepository.findAll();
    }

    public boolean existData() {
        return this.findAll().size() > 0;
    }

    public void save(InsertionInitialData insertionInitialData) {
        this.insertionInitialDataRepository.save(insertionInitialData);
    }

    public void insertData() {
        try {
            this.insertSuppliers();
            this.save(new InsertionInitialData());
        } catch (Exception e) {
            System.out.println("Error insert main data: " + e);
        }
    }

    private void insertSuppliers() {
        SupplierModel supplierModel = new SupplierModel("Jose Santiago Jimenez Sanches",
                "Sociedad anónima", "Morelos Yautepec la Joya");
        SupplierModel supplierModel2 = new SupplierModel("Alfredo Sanches Sanchez",
                "Sociedad comercial", "Cuernavaca Vicente Guerrero");
        SupplierModel supplierModel3 = new SupplierModel("Maria Martinez",
                "Empresario Individual", "Morelos Jiutepec Tejalpa");
        this.supplierService.save(supplierModel);
        this.supplierService.save(supplierModel2);
        this.supplierService.save(supplierModel3);
    }
}
