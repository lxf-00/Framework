import com.springlearning.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        // 1 获取核心容器Ioc
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2. 获取对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        // 3. 调用方法
        as.saveAccount();
    }
}
