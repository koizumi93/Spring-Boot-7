package com.example.names;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter

public class CreateForm {
    @NotBlank(message="名前は必須です")
    @Size(max=20,message="名前は20文字以下で入力してください")
    private String name;
    
    @NotNull(message = "入力してください")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "過去の日付を入力してください")
    private LocalDate dateOfBirth;
    
}
