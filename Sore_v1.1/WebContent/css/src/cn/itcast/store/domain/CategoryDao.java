package cn.itcast.store.domain;
import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {
public List<Category> getAllCats() throws SQLException ;
}
