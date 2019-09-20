package fdmcv2.web.managebeans;

import fdmcv2.domain.models.binding.CatBindingModel;
import fdmcv2.domain.models.service.CatServiceModel;
import fdmcv2.service.CatService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class CatCreationBean {
    private CatBindingModel catBindingModel;
    private CatService catService;
    private ModelMapper modelMapper;

    public CatCreationBean() {
        this.catBindingModel = new CatBindingModel();
    }

    @Inject
    public CatCreationBean(CatService catService, ModelMapper modelMapper) {
        this();
        this.catService = catService;
        this.modelMapper = modelMapper;
    }

    public CatBindingModel getCatBindingModel() {
        return catBindingModel;
    }

    public void setCatBindingModel(CatBindingModel catBindingModel) {
        this.catBindingModel = catBindingModel;
    }

    public void createCat() throws IOException {

        this.catService.saveCat(this.modelMapper.map(this.catBindingModel, CatServiceModel.class));


        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("/");
    }
}
