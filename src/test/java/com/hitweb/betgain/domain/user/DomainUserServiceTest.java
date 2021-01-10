package com.hitweb.betgain.domain.user;

import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.service.DomainUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DomainUserServiceTest {

 /*   @MockBean
    DomainUserService domainUserService;

    @Test
    public void testFindAll() {
        User user = new User();
        user.setLastName("vincenzo");
        List<User> users = new ArrayList<User>();
        users.add(user);
        Mockito.when(domainUserService.findAll()).thenReturn(users);

        Iterable<User> usersDomain = domainUserService.findAll();
         long length = StreamSupport.stream(usersDomain.spliterator(), false).count();
         assertEquals(1, length);

    }*/
}
