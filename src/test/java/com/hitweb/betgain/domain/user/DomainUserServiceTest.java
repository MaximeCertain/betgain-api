package com.hitweb.betgain.domain.user;

import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.service.DomainUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DomainUserServiceTest {
    
    @Test
    public void testFindAll() {
      /*  List<User> users = new ArrayList<User>();
        users.add(user);
        Mockito.when(domainUserService.findAll()).thenReturn(users);

        Iterable<User> usersDomain = domainUserService.findAll();
         long length = StreamSupport.stream(usersDomain.spliterator(), false).count();
         assertEquals(1, length);*/

    }
}
