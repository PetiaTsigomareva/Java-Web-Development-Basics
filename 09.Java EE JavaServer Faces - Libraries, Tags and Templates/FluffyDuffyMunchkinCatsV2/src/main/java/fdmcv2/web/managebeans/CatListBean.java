package fdmcv2.web.managebeans;

import fdmcv2.domain.models.views.CatViewModel;
import fdmcv2.service.CatService;
import org.modelmapper.ModelMapper;


//import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class CatListBean {
    private List<CatViewModel> cats;
    private CatService catService;
    private ModelMapper modelMapper;

    public CatListBean() {
    }

    @Inject
    public CatListBean(CatService catService, ModelMapper modelMapper) {
        this.catService = catService;
        this.modelMapper = modelMapper;
        this.cats = this.catService.findAllCats().stream().map(c -> this.modelMapper.map(c, CatViewModel.class)).collect(Collectors.toList());
        this.cats.sort(sortByName);


    }

    public List<CatViewModel> getCats() {
        return cats;
    }

    public void setCats(List<CatViewModel> cats) {
        this.cats = cats;
    }

    private Comparator<CatViewModel> sortByName = (CatViewModel c1, CatViewModel c2) -> c1.getName().compareTo(c2.getName());
    private Comparator<CatViewModel> sortByPriceDes = (CatViewModel c1, CatViewModel c2) -> c2.getPrice().compareTo(c1.getPrice());
    private Comparator<CatViewModel> sortByPriceAcs = (CatViewModel c1, CatViewModel c2) -> c2.getPrice().compareTo(c1.getPrice());







}
