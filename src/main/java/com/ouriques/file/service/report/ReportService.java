package com.ouriques.file.service.report;

import com.ouriques.file.common.BusinessConstant;
import com.ouriques.file.common.FileUtils;
import com.ouriques.file.repository.CustomerRepository;
import com.ouriques.file.repository.SaleManRepository;
import com.ouriques.file.repository.SaleRepository;
import com.ouriques.file.service.file.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService implements IReport{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private SaleManRepository saleManRepository;

    @Autowired
    private FileManagerService fileManagerService;

    @Override
    public void build(String fileName) {

        long totalNumberOfCustomers = this.getTotalNumberOfCustomers();
        long totalNumberOfSaleMan = this.getTotalNumberOfSaleMan();

        String data = "Quantidade de clientes no arquivo de entrada: " + Long.toString(totalNumberOfCustomers);
        data += "\n Quantidade de vendedor no arquivo de entrada: " + Long.toString(totalNumberOfSaleMan);

        fileManagerService.store(data, FileUtils.buildDoneFileName(fileName));
    }

    @Override
    public long getTotalNumberOfCustomers() {
        return customerRepository.countAllByType(BusinessConstant.CUSTOMER_ID);
    }

    @Override
    public long getTotalNumberOfSaleMan() {
        return saleManRepository.countAllByType(BusinessConstant.SALES_MAN_ID);
    }
}
