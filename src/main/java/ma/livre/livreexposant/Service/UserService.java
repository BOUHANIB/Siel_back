/*
package ma.livre.livreexposant.Service;


import ma.livre.livreexposant.Exception.ResourceNotFoundException;
import ma.livre.livreexposant.Model.User;
import ma.livre.livreexposant.Repository.UserRepository;
import ma.livre.livreexposant.payload.Dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ModelMapper mapper;



    public UserDto createUser(UserDto userDto) {
        //userDto to User
        User user = this.mapper.map(userDto, User.class);
        //save
        User saveUser = this.userRepo.save(user);
        //user to userDto
        UserDto saveUserDto = this.mapper.map(saveUser, UserDto.class);
        return saveUserDto;
    }

    public UserDto getById(int userId) {
        User findByuserId = this.userRepo.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException( " User not found by this id : " +userId ));
        UserDto userDto = this.mapper.map(findByuserId,UserDto.class);
        return userDto;
    }

    public void deleteUser(int userId){
        User findById = this.userRepo.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException( " User not delete by this id : " +userId ));
        this.userRepo.delete(findById);
    }

    public List<UserDto> findAllUser(){
        List<User> findAll = this.userRepo.findAll();
        //user -> userDto
        List<UserDto> collect = findAll.stream().map(each -> this.mapper.map(each, UserDto.class)).collect(Collectors.toList());
        return collect;
    }

    public UserDto update(UserDto t, int userId) {
        User u=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found by this id"));
        u.setPhone(t.getPhone());
        u.setPassword(t.getPassword());
        u.setName(t.getName());
        u.setGender(t.getGender());
        u.setEmail(t.getEmail());
        u.setDate(t.getDate());
        u.setAddress(t.getAddress());
        u.setActive(t.isActive());
        u.setAbout(t.getAbout());
        User Updateuser=this.userRepo.save(u);
        return this.toDto(Updateuser);
    }

    public UserDto toDto(User u) {
        return this.mapper.map(u,UserDto.class);
    }



}
 */