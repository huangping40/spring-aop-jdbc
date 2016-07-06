import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ping.spring.controller.UserController;

public class App {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		UserController userController = (UserController) ac
				.getBean("userController");
		for (int i = 0; i < 1; i++) {
			userController.addUser();
		}
	}

}
