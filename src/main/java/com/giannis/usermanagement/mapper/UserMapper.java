package com.giannis.usermanagement.mapper;

import com.giannis.usermanagement.dto.AddressDTO;
import com.giannis.usermanagement.dto.UserDTO;
import com.giannis.usermanagement.model.Address;
import com.giannis.usermanagement.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setGender(user.getGender());
        dto.setBirthdate(user.getBirthdate());

        if (user.getAddresses() != null) {
            List<AddressDTO> addressDTOs = new ArrayList<>();
            for (Address address : user.getAddresses()) {
                AddressDTO addressDTO = new AddressDTO();
                addressDTO.setId(address.getId());
                addressDTO.setType(address.getType());
                addressDTO.setDetails(address.getDetails());
                addressDTOs.add(addressDTO);
            }
            dto.setAddresses(addressDTOs);
        }

        return dto;
    }

    public User toEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setGender(dto.getGender());
        user.setBirthdate(dto.getBirthdate());

        if (dto.getAddresses() != null) {
            List<Address> addresses = new ArrayList<>();
            for (AddressDTO addressDTO : dto.getAddresses()) {
                Address address = new Address();
                address.setId(addressDTO.getId());
                address.setType(addressDTO.getType());
                address.setDetails(addressDTO.getDetails());
                address.setUser(user);
                addresses.add(address);
            }
            user.setAddresses(addresses);
        }

        return user;
    }

    public void updateEntityFromDTO(UserDTO dto, User existingUser) {
        if (dto == null) {
            return;
        }

        existingUser.setName(dto.getName());
        existingUser.setSurname(dto.getSurname());
        existingUser.setGender(dto.getGender());
        existingUser.setBirthdate(dto.getBirthdate());

        if (dto.getAddresses() != null) {
            existingUser.getAddresses().clear();
            for (AddressDTO addressDTO : dto.getAddresses()) {
                Address address = new Address();
                address.setId(addressDTO.getId());
                address.setType(addressDTO.getType());
                address.setDetails(addressDTO.getDetails());
                address.setUser(existingUser);
                existingUser.getAddresses().add(address);
            }
        }
    }
}