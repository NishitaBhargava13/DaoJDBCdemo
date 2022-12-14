package dao;

import java.util.List;
import entity.Product;

public interface ProductDAO {
	public int delete(int pid);
	public List<Product> findAll();
	public Product findById(int pid);
	public Product findByName(String name);
	public int update(Product pObj);
	public int insert(Product Obj);
	
}
