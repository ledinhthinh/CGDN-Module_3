package data;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();

        products.put(1, new Product(1, "iphone", "10000", "iphone", "apple"));
        products.put(2, new Product(2, "samsung", "20000", "ss", "samsung"));
        products.put(3, new Product(3, "oppo", "30000", "oppo", "oppo"));
        products.put(4, new Product(4, "sony", "40000", "sony", "sony"));
        products.put(5, new Product(5, "realme", "50000", "rme", "xaomi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
