package org.example.medicineproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {

    private String content;
    private UserDto userDto;
    private Integer rating;
}
