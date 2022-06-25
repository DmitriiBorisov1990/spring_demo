package java.com.borisov.dao;

import com.borisov.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private ApplicationContext context;

    @Value("postgres")
    private String userName;

    @Value("5")
    private Integer number;

    @Value("#{'${test.numbers}'.split(',')}")
    private List<Long> numbers;

    @Value("classpath:application.properties")
    private Resource resource;

    @Test
    public void setEmployeeDaoNotNull(){
        assertNotNull(employeeDao);
    }
}