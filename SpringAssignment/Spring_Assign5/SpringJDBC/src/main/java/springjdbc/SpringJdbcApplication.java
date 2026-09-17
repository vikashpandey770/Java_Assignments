package springjdbc;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springjdbc.dao.RestaurantDao;
import springjdbc.model.Restaurant;
@SpringBootApplication
public class SpringJdbcApplication {
 public static void main(String[] args){SpringApplication.run(SpringJdbcApplication.class,args);}
 @Bean CommandLineRunner run(RestaurantDao dao){return args->{
  dao.insert(new Restaurant("Gujarati Food","Gujarati",4.6)); System.out.println("Restaurant Inserted");
  System.out.println("\nAll Restaurants:"); dao.getAll().forEach(System.out::println);
  dao.update(new Restaurant(1,"Updated Restaurant","Indian",4.8)); System.out.println("\nRestaurant Updated");
  System.out.println("\nRestaurant ID 1:"); System.out.println(dao.getById(1));
  dao.delete(3); System.out.println("\nRestaurant Deleted");
  System.out.println("\nRestaurants Rating Above 4.0:"); List<Restaurant> top=dao.getAboveFour(); top.forEach(r->System.out.println("Name: "+r.getName()+" | Cuisine: "+r.getCuisine()));
 };}
}
