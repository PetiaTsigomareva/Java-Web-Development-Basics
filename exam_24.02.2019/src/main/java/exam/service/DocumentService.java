package exam.service;

import exam.domain.models.service.DocumentServiceModel;


import java.util.List;

public interface DocumentService {

    String scheduleDocument(DocumentServiceModel documentServiceModel);

    DocumentServiceModel findByID(String id);


    List<DocumentServiceModel> getAllUsers();


    void delete(String id);

    void print(String id);


}
