package com.giannis.usermanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String gender;
    private LocalDate birthdate;
    private List<AddressDTO> addresses;
}