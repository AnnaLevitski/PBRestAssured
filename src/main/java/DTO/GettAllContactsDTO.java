package DTO;

import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class GettAllContactsDTO {
    private List<ContactDTO> contacts;
}
