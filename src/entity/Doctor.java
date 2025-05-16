package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 3)
  private String name;

  @NotBlank
  @Size(max = 20)
  @Pattern(regexp = "Delhi|Noida|Faridabad")
  private String city;

  @Email
  @NotBlank
  private String email;

  @NotBlank
  @Size(min = 10)
  private String phoneNumber;

  @NotBlank
  @Pattern(regexp = "Orthopaedic|Gynecology|Dermatology|ENT")
  private String speciality;
}
