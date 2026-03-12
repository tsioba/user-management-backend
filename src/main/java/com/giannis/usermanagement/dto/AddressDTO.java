package com.giannis.usermanagement.dto;

import com.giannis.usermanagement.model.AddressType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    private AddressType type;
    private String details;
}