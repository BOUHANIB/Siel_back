/*
package ma.livre.livreexposant.Controller;


import ma.livre.livreexposant.payload.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        Date date = new Date();
        userDto.setDate(date);
        UserDto createUser = this.userService.createUser(userDto);
        return new ResponseEntity<UserDto>(createUser, HttpStatus.CREATED);
    }

    @GetMapping("/findById/{userId}")
    public ResponseEntity<UserDto> findUserById(@PathVariable int userId) {
        UserDto byId = this.userService.getById(userId);
        return new ResponseEntity<UserDto>(byId, HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteuser/{userId}")
    void deleteUser(@PathVariable int userId) {
        this.userService.deleteUser(userId);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<UserDto>> findAllUser() {
        List<UserDto> findAllUser = this.userService.findAllUser();
        return new ResponseEntity<List<UserDto>>(findAllUser, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable int userId, @RequestBody UserDto userDto) {
        Date date = new Date();
        userDto.setDate(date);
        UserDto updatedUser = userService.update(userDto, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
 */