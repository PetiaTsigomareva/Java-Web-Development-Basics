package exam.web.beans;

import exam.domain.models.service.DocumentServiceModel;
import exam.domain.models.view.DocumentPrintViewModel;
import exam.service.DocumentService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;


@Named
@RequestScoped
public class DocumentPrintBean extends BaseWebBean {
    private DocumentService documentService;
    private DocumentPrintViewModel documentPrintViewModel;


    public DocumentPrintBean() {
        super();
    }

    @Inject
    public DocumentPrintBean(ModelMapper modelMapper, DocumentService documentService) {
        super(modelMapper);
        this.documentService = documentService;
        this.init();
    }

    private void init() {
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        this.documentPrintViewModel = new DocumentPrintViewModel();
        DocumentServiceModel documentServiceModel = this.documentService.findByID(id);

        if (documentServiceModel == null) {
            throw new IllegalArgumentException("The document does not exist");
        }

        this.documentPrintViewModel = this.modelMapper.map(documentServiceModel, DocumentPrintViewModel.class);


    }

    public DocumentPrintViewModel getDocumentPrintViewModel() {
        return documentPrintViewModel;
    }

    public void setDocumentPrintViewModel(DocumentPrintViewModel documentPrintViewModel) {
        this.documentPrintViewModel = documentPrintViewModel;
    }

    public void print() throws IOException {

        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");

        this.documentService.print(id);

        redirect("/home");

    }
}
