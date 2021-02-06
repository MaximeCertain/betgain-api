package com.hitweb.betgain.domain.user.usecases;

import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.ports.PasswordEncoderInterface;
import com.hitweb.betgain.domain.user.ports.UserRepository;
import com.hitweb.betgain.domain.user.usecases.payload.request.ProfileRequest;
import com.hitweb.betgain.domain.user.usecases.payload.response.ClientResponse;
import org.springframework.beans.BeanUtils;

public class EditProfileUseCase {
    private final UserRepository userRepository;


    public EditProfileUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ClientResponse edit(ProfileRequest profileRequest) {
        ClientResponse clientResponse = new ClientResponse();
        if (!profileRequest.isSaveBankDetails()) {
            profileRequest.setCardNumber(null);
            profileRequest.setExpirationDate(null);
            profileRequest.setVisualCryptogram(null);
        }
        Client editedClient = new Client();
        BeanUtils.copyProperties(profileRequest, editedClient);

        if (editedClient.getEmail() == null || editedClient.getFirstname() == null || editedClient.getLastname() == null || editedClient.getUsername() == null || new Long(editedClient.getId()) == null || editedClient.getRoles().size() == 0) {
            clientResponse.setMessage("La création est impossible, données manquantes");
            return clientResponse;
        }
        clientResponse.setMessage("Profil du client bien édité");
        Client savedClient = (Client) userRepository.save(editedClient);
        clientResponse.setClient(savedClient);


        return clientResponse;
    }

}
