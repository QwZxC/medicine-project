package org.example.medicineproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDto {

    private String hospitalName;
    @Size(min= 10, max=450, message = "Отзыв может содержать от 10 до 450 символов")
    private String content;
    @Size(max = 5)
    @NotBlank
    private Integer rating;
}
