package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(min = 3)
  private String name;

  @NotBlank
  @Size(max = 20)
  private String city;

  @Email
  @NotBlank
  private String email;

  @NotBlank
  @Size(min = 10)
  private String phoneNumber;

  @NotBlank
  private String symptom;
}
