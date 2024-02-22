package entity;

import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String username;
    private String password;
    private String bio;
}
