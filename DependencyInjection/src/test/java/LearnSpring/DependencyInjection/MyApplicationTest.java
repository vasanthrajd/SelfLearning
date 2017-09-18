package LearnSpring.DependencyInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.util.Assert;

import com.springdi.consumer.MyAppAnnotate;
import com.springdi.services.EmailService;
import com.springdi.services.MessageServices;

@Configuration
@ComponentScan(value="com.springdi.consumer")
public class MyApplicationTest {
	private AnnotationConfigApplicationContext context=null;
	
	@Bean
	public MessageServices getMessageServices(){
		return new MessageServices() {
			
			public boolean sendMessage(String message, String recipent) {
				// TODO Auto-generated method stub
				System.out.println(recipent + " has received the following "+message);
				return true;
			}
		};
	}
	
	@Before
	public void setUp(){
		context=new AnnotationConfigApplicationContext(MyApplicationTest.class);	
	}
	
	@After
	public void tearDown(){
		context.close();
	}
	
	@Test
	public void test(){
		MyAppAnnotate app=context.getBean(MyAppAnnotate.class);
		Assert.assertTrue(app.processMessage("Vasanthraj@123.com", "Test Application using JUnit"));
	}
	
	
}
