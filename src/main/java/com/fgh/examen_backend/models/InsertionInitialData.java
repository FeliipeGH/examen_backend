package com.fgh.examen_backend.models;

import javax.persistence.*;

@Entity
public class InsertionInitialData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insertionId", nullable = false)
    private Long insertionId;

    public void setInsertionId(Long insertionId) {
        this.insertionId = insertionId;
    }

    @Override
    public String toString() {
        return "InsertionInitialData{" +
                "insertionId=" + insertionId +
                '}';
    }
}
