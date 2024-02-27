package Entity;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {  // контрустор
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String username;
    private String bio;
}
