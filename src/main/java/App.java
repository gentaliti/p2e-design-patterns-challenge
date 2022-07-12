import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Product simpleProduct = new Product("1", "Simple Product 1", "Description", "url", List.of("url"), "1",
                "123456", "Nike", 100, BigDecimal.TEN, "123 KG", "white", ProductType.SIMPLE,
                null, null, null);

        Product downloadableProduct = new Product("2", "Downloadable Product 1", "Description", "url", List.of("url"), "1",
                "123456", "Nike", 100, BigDecimal.TEN, "123 KG", "white", ProductType.SIMPLE, null, null, null);

        Product variantChild = new Product("3", "Variant Product 1", "Description", "url", List.of("url"), "1",
                "123456", "Nike", 100, BigDecimal.TEN, "123 KG", "white", ProductType.VARIANT, null, null, "4");

        Product variantParent = new Product("4", "Variant Product 1", "Description", "url", List.of("url"), "1",
                "123456", "Nike", 100, BigDecimal.TEN, "123 KG", "white", ProductType.VARIANT, null, List.of(variantChild), null);


        ProductService productService = new ProductService();
        productService.addProduct(simpleProduct);
        productService.addProduct(downloadableProduct);
        productService.addProduct(variantParent);
    }
}
