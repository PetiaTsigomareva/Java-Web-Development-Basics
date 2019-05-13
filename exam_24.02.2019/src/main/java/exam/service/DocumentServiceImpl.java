package exam.service;

import exam.domain.entities.Document;
import exam.domain.models.service.DocumentServiceModel;
import exam.repository.DocumentRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentServiceImpl implements DocumentService {

    private final ModelMapper modelMapper;
    private final DocumentRepository documentRepository;

    @Inject
    public DocumentServiceImpl(ModelMapper modelMapper, DocumentRepository documentRepository) {
        this.modelMapper = modelMapper;
        this.documentRepository = documentRepository;
    }

    @Override
    public String scheduleDocument(DocumentServiceModel documentServiceModel) {
        String result;
        Document document = this.modelMapper.map(documentServiceModel, Document.class);

        if (this.documentRepository.save(document) == null) {
            result = "ERROR";
        } else {
            result = document.getId();
        }

        return result;
    }

    @Override
    public DocumentServiceModel findByID(String id) {
        Document document = this.documentRepository.findById(id);

        if (document == null) {
            return null;
        }

        return this.modelMapper.map(document, DocumentServiceModel.class);

    }


    @Override
    public List<DocumentServiceModel> getAllUsers() {
        List<DocumentServiceModel> alldocuments = this.documentRepository.findAll().stream().map(d -> this.modelMapper.map(d, DocumentServiceModel.class)).collect(Collectors.toList());

        return alldocuments;
    }

    @Override
    public void delete(String id) {
        this.documentRepository.delete(id);


    }

    @Override
    public void print(String id) {
        delete(id);
    }
}
