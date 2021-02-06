package com.hitweb.betgain.domain.user;

import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.ports.UserRepository;
import com.hitweb.betgain.domain.user.service.DomainUserService;
import com.hitweb.betgain.domain.user.usecases.ValidateAccountUseCase;
import com.hitweb.betgain.domain.user.usecases.payload.request.ValidateAccountRequest;
import com.hitweb.betgain.domain.user.usecases.payload.response.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DomainUserServiceTest {

    @MockBean
    DomainUserService domainUserService;

    @MockBean
    UserRepository userRepository;

    @Test
    public void testFindAll() {

        User user = new User();
        user.setLastname("vincenzo");
        List<User> users = new ArrayList<User>();
        users.add(user);
        Mockito.when(domainUserService.findAll()).thenReturn(users);

        Iterable<User> usersDomain = domainUserService.findAll();
         long length = StreamSupport.stream(usersDomain.spliterator(), false).count();
         assertEquals(1, length);

    }

    @Test
    public void testValidateAccount() {

        ValidateAccountRequest validateAccountRequest = new ValidateAccountRequest();
        validateAccountRequest.setConfirmationCode("ABCDEFG");

        User user = new User();
        user.setLastname("vincenzo");
        user.setUsername("vince");
        user.setPassword("abcee");
        user.setConfirmationCode("ABCDEFG");
        user.setEmail("vincenzo@vincenzo.fr");

        Mockito.when(userRepository.findUser(any(Long.class))).thenReturn(user);

        user.setValidated(true);

        Mockito.when(userRepository.save(user)).thenReturn(user);

        UserResponse userResponse = new ValidateAccountUseCase(userRepository).validate(validateAccountRequest, 53);
        assertEquals("l'utilisateur a bien été validé, il peut désormais faire des retraits", userResponse.getMessage());

    }

}
