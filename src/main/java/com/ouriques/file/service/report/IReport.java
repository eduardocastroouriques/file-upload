package com.ouriques.file.service.report;

public interface IReport {

    void build(String fileName);
    long getTotalNumberOfCustomers();
    long getTotalNumberOfSaleMan();

}
