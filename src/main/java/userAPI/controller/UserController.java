package userAPI.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userAPI.dto.UserDto;
import userAPI.entity.User;
import userAPI.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable long id){
        User user= userRepository.findUserById(id);
        if(user != null){
            UserDto userDto= new UserDto();
            BeanUtils.copyProperties(user,userDto);
            return ResponseEntity.ok(userDto);
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping("/")
    public ResponseEntity<UserDto> add (@RequestBody User user){
        if (!user.getPassword().equals(user.getConfirmPassword())){
            return  ResponseEntity.badRequest().build();
        }
        userRepository.save(user);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return ResponseEntity.ok(userDto);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update (@RequestBody User user,@PathVariable long id){

        User u= userRepository.findById(id).orElseThrow(null);
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());

        u=userRepository.save(u);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(u, userDto);
        return ResponseEntity.ok(userDto);


    }



}
