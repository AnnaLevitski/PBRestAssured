package DTOforOKhttp;

import lombok.*;

//{
//        "token": "string"
//        }
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class AuthResponceDTO {
    private String token;
}
