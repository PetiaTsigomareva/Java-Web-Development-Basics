package chushka.service;

import chushka.domain.entities.Product;
import chushka.domain.entities.ProductType;
import chushka.domain.models.service.ProductServiceModel;
import chushka.repository.ProductRepository;
import chushka.util.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveProduct(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel, Product.class);
        product.setProductType(ProductType.valueOf(productServiceModel.getProductType()));

        this.productRepository.save(product);


    }

    @Override
    public List<ProductServiceModel> findAllProduct() {

        return this.productRepository.findAll().stream().map(product -> {
            ProductServiceModel productServiceModel = this.modelMapper.map(product, ProductServiceModel.class);
            productServiceModel.setProductType(product.getProductType().name());
            return productServiceModel;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductServiceModel findProductByName(String name) {
        Product product = this.productRepository.findByName(name);
        ProductServiceModel productServiceModel = this.modelMapper.map(product, ProductServiceModel.class);
        productServiceModel.setProductType(product.getProductType().name());

        return productServiceModel;
    }
}
