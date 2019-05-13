package exam.web.beans;

import exam.domain.models.service.DocumentServiceModel;
import exam.domain.models.view.DocumentDetailsViewModel;
import exam.service.DocumentService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class DocumentDetailsBean extends BaseWebBean {
    private DocumentService documentService;
    private DocumentDetailsViewModel documentDetailsViewModel;

    public DocumentDetailsBean() {
        super();
    }

    @Inject
    public DocumentDetailsBean(ModelMapper modelMapper, DocumentService documentService) {
        super(modelMapper);
        this.documentService = documentService;
        this.init();
    }

    private void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().\().get("id");
        this.documentDetailsViewModel = new DocumentDetailsViewModel();
        DocumentServiceModel documentServiceModel = this.documentService.findByID(id);

        if (documentServiceModel == null) {
            throw new IllegalArgumentException("The document does not exist");
        }
        this.documentDetailsViewModel = this.modelMapper.map(documentServiceModel, DocumentDetailsViewModel.class);


    }

    public DocumentDetailsViewModel getDocumentDetailsViewModel() {
        return documentDetailsViewModel;
    }

    public void setDocumentDetailsViewModel(DocumentDetailsViewModel documentDetailsViewModel) {
        this.documentDetailsViewModel = documentDetailsViewModel;
    }
}
