package exam.web.beans;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import exam.domain.models.view.DocumentHomeViewModel;
import org.modelmapper.ModelMapper;


import exam.service.DocumentService;

@Named
@RequestScoped
public class DocumentHomeBean extends BaseWebBean {
    private List<DocumentHomeViewModel> documents;
    private DocumentService documentService;


    public DocumentHomeBean() {
        super();
    }

    @Inject
    public DocumentHomeBean(DocumentService documentService, ModelMapper modelMapper) {
        super(modelMapper);
        this.documentService = documentService;
        this.initModels();
    }

    private void initModels() {
        this.documents = this.documentService.getAllUsers().stream().map(u -> this.modelMapper.map(u, DocumentHomeViewModel.class)).collect(Collectors.toList());

        for (DocumentHomeViewModel model : documents) {
            if (model.getTitle().length() > 12) {
                String shortTitle = model.getTitle().substring(0, 13)+"...";
                model.setTitle(shortTitle);
            }
        }


    }

    public List<DocumentHomeViewModel> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentHomeViewModel> documents) {
        this.documents = documents;
    }

    public void print(String documentId) throws IOException {
        redirect("/print/" + documentId);
    }

    public void details(String documentId) throws IOException {
        redirect("/details/" + documentId);
    }


}