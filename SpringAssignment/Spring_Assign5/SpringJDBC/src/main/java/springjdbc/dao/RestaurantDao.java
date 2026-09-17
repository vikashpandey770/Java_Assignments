package springjdbc.dao;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import springjdbc.model.Restaurant;
@Repository
public class RestaurantDao {
 private final JdbcTemplate jdbcTemplate;
 private static final String INSERT="INSERT INTO restaurants (name,cuisine,rating) VALUES (?,?,?)";
 private static final String UPDATE="UPDATE restaurants SET name=?,cuisine=?,rating=? WHERE id=?";
 private static final String DELETE="DELETE FROM restaurants WHERE id=?";
 private static final String SELECT_ALL="SELECT * FROM restaurants";
 private static final String SELECT_BY_ID="SELECT * FROM restaurants WHERE id=?";
 private static final String SELECT_ABOVE_4="SELECT * FROM restaurants WHERE rating > 4.0";
 public RestaurantDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}
 private RowMapper<Restaurant> rowMapper=(rs,rowNum)->{Restaurant r=new Restaurant();r.setId(rs.getInt("id"));r.setName(rs.getString("name"));r.setCuisine(rs.getString("cuisine"));r.setRating(rs.getDouble("rating"));return r;};
 public int insert(Restaurant r){return jdbcTemplate.update(INSERT,r.getName(),r.getCuisine(),r.getRating());}
 public int update(Restaurant r){return jdbcTemplate.update(UPDATE,r.getName(),r.getCuisine(),r.getRating(),r.getId());}
 public int delete(int id){return jdbcTemplate.update(DELETE,id);}
 public List<Restaurant> getAll(){return jdbcTemplate.query(SELECT_ALL,rowMapper);}
 public Restaurant getById(int id){return jdbcTemplate.queryForObject(SELECT_BY_ID,rowMapper,id);}
 public List<Restaurant> getAboveFour(){return jdbcTemplate.query(SELECT_ABOVE_4,rowMapper);}
}
