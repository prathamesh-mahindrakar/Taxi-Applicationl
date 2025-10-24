package com.taxi.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.taxi.dao.ServiceFormCrud;
import com.taxi.model.ServiceForm;

import jakarta.transaction.Transactional;

@Service
public class ServiceFormServiceImpl implements ServiceFormService {

    private ServiceFormCrud serviceFormCrud;

    @Autowired
    public void setServiceFormCrud(ServiceFormCrud serviceFormCrud) {
        this.serviceFormCrud = serviceFormCrud;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ServiceForm addService(ServiceForm serviceform, MultipartFile multipartFile) throws Exception {
        String folderPath = "C:\\Users\\prath\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE1\\TaxiServer\\src\\main\\resources\\static\\myserviceimg";
        File folder = new File(folderPath);
        if (!folder.exists()) folder.mkdirs();

        String fileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        String filePath = folderPath + File.separator + fileName;

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(multipartFile.getBytes());
        }

        // Save relative path to DB
        serviceform.setImage("/myserviceimg/" + fileName);

        // Save to DB
        return serviceFormCrud.save(serviceform);
    }



    @Override
    public List<ServiceForm> reallAllServices() {
        return serviceFormCrud.findAll();
    }
}
