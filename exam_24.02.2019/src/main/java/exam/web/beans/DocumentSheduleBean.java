package exam.web.beans;

import exam.domain.models.binding.DocumentBindingModel;
import exam.domain.models.service.DocumentServiceModel;
import exam.service.DocumentService;
import org.modelmapper.ModelMapper;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class DocumentSheduleBean extends BaseWebBean {

    private DocumentBindingModel documentBindingModel;
    private DocumentService documentService;

    public DocumentSheduleBean() {
        super();
    }

    @Inject
    public DocumentSheduleBean(ModelMapper modelMapper, DocumentService documentService) {
        super(modelMapper);
        this.documentService = documentService;
        this.init();
    }

    private void init() {
        this.documentBindingModel = new DocumentBindingModel();
    }

    public DocumentBindingModel getDocumentBindingModel() {
        return documentBindingModel;
    }

    public void setDocumentBindingModel(DocumentBindingModel documentBindingModel) {
        this.documentBindingModel = documentBindingModel;
    }

    public void schedule() throws IOException {

        DocumentServiceModel documentServiceModel = this.modelMapper.map(documentBindingModel, DocumentServiceModel.class);
        String documentId = this.documentService.scheduleDocument(documentServiceModel);


        if ("ERROR".equals(documentId)) {
            throw new IllegalArgumentException("The document can not be scheduled");
        }
        redirect("/details/" + documentId);

    }


}
