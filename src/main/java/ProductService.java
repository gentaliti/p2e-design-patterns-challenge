import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> productDatabase;

    public ProductService() {
        productDatabase = new ArrayList<>();
    }

    public void addProduct(Product product) {
        System.out.printf("Adding product: %s%n", product);
        switch (product.getProductType()) {
            case SIMPLE:
                validateSimpleProduct(product);
                productDatabase.add(product);
                System.out.printf("Product of type %s added successfully %n", product.getProductType());
                break;
            case DOWNLOADABLE:
                validateDownloadableProduct(product);
                String downloadUrl = uploadProductToExternalBucketStorage(product);
                product.setDownloadUrl(downloadUrl);
                productDatabase.add(product);
                System.out.printf("Product of type %s added successfully %n", product.getProductType());
                break;
            case VARIANT:
                validateVariableProduct(product);
                product.getVariants().forEach(variant -> {
                    variant.setProductType(ProductType.SIMPLE);
                    variant.setParentId(product.getParentId());
                    productDatabase.add(variant);
                });
                productDatabase.add(product);
                System.out.printf("Product of type %s added successfully %n", product.getProductType());
                break;
        }
    }

    private String uploadProductToExternalBucketStorage(Product product) {
        // upload to s3 simulation
        return "i-am-a-download-url";
    }

    private void validateVariableProduct(Product product) {
        if ("blue".equals(product.getColor())) {
            throw new IllegalArgumentException("Variable product cannot be green");
        }
        if (product.getVariants() == null) {
            throw new IllegalArgumentException("Variable product must have variants");
        }
    }

    private void validateDownloadableProduct(Product product) {
        if ("red".equals(product.getColor())) {
            throw new IllegalArgumentException("Downloadable product cannot be green");
        }
    }

    private void validateSimpleProduct(Product product) {
        if ("red".equals(product.getColor())) {
            throw new IllegalArgumentException("Product cannot be red");
        }
    }
}
