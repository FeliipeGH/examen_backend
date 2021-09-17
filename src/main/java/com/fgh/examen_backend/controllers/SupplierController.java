package com.fgh.examen_backend.controllers;

import com.fgh.examen_backend.models.SupplierModel;
import com.fgh.examen_backend.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplierController")
@CrossOrigin(origins = "*")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping(value = "/saveSupplier")
    @CrossOrigin(origins = "*", methods = {RequestMethod.POST})
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody SupplierModel supplierModel) {
        return this.supplierService.saveSupplier(supplierModel);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteSupplierById/{supplierId}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.DELETE})
    public ResponseEntity<?> delete(@PathVariable("supplierId") Long supplierId) {
        return this.supplierService.deleteById(supplierId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getSupplierList/{index}")
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    public ResponseEntity<?> getSupplierList(@PathVariable("index") int index) {
        return this.supplierService.getAllByIndex(index);
    }
}
