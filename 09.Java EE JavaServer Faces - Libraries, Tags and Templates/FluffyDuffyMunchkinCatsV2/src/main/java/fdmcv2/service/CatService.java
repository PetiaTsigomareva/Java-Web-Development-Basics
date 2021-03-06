package fdmcv2.service;

import fdmcv2.domain.models.binding.CatBindingModel;
import fdmcv2.domain.models.service.CatServiceModel;

import java.util.List;

public interface CatService {

    boolean saveCat(CatServiceModel catServiceModel);

    List<CatServiceModel> findAllCats();
}
