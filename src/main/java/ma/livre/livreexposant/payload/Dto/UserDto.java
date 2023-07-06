package ma.livre.livreexposant.payload.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int userId;
    private String name;
    private String email;
    private String password;
    private String address;
    private String about;
    private String gender;
    private String phone;
    private Date date;
    private boolean  active;
}
