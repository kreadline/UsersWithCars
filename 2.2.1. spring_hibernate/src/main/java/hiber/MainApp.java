package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User one = new User("one", "one", "1@");
      Car oneCar = new Car("vaz", 2);
      oneCar.setUser(one);
      userService.add(one);
      userService.add(oneCar);

      User two = new User("two", "two", "2@");
      Car twoCar = new Car("nevaz", 1);
      twoCar.setUser(two);
      userService.add(two);
      userService.add(twoCar);

      User three = new User("three", "three", "3@");
      Car threeCar = new Car("autovaz", 5);
      threeCar.setUser(three);
      userService.add(three);
      userService.add(threeCar);

      System.out.println(userService.listUsers());

      System.out.println(userService.getUserByCar("nevaz", 1));

      context.close();
   }
}
