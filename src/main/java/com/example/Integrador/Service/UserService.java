package com.example.Integrador.Service;

import com.example.Integrador.Dto.LoginDTO;
import com.example.Integrador.Dto.UserDTO;
import com.example.Integrador.Dto.UserUpdateDTO;
import com.example.Integrador.Entity.User;
import com.example.Integrador.Message.LoginMessage;
import com.example.Integrador.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    int addUser(UserDTO userDTO);

    LoginMessage LoginUser(LoginDTO loginDTO);

    void updateUser(UserUpdateDTO userUpdateDTO);

    User getUserByEmail(String email);

    @Autowired
    void setUserRepo(UserRepo userRepo);
}
