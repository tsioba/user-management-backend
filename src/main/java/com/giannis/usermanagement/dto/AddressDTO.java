package com.giannis.usermanagement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    private String type;
    private String details;
}