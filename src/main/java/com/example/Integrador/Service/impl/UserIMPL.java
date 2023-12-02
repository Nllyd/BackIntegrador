package com.example.Integrador.Service.impl;

import com.example.Integrador.Dto.LoginDTO;
import com.example.Integrador.Dto.UserDTO;
import com.example.Integrador.Dto.UserUpdateDTO;
import com.example.Integrador.Entity.User;
import com.example.Integrador.Message.LoginMessage;
import com.example.Integrador.Message.UserNotFoundException;
import com.example.Integrador.Repo.UserRepo;
import com.example.Integrador.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {

    private UserRepo userRepo;

    @Autowired
    public UserIMPL(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public int addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserid(),
                userDTO.getUsername(),
                userDTO.getUserlastname(),
                userDTO.getEmail(),
                userDTO.getNumber(),
                userDTO.getIdaccount(),
                userDTO.getIdcareer(),
                userDTO.getPassword()
        );

        userRepo.save(user);

        return user.getIdaccount();
    }

    @Override
    public LoginMessage LoginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            boolean isPsdRight = password.matches(password);
            if (isPsdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), password);
                if (user.isPresent()) {
                    return new LoginMessage("Inicio de Sesion Exitoso", true, user.get().getUsername());
                } else {
                    return new LoginMessage("Inicio de Sesion Fallida", false);
                }
            } else {
                return new LoginMessage("Error al ingresar datos", false);
            }
        } else {
            return new LoginMessage("Error al ingresar datos", false);
        }
    }

    @Override
    public void updateUser(UserUpdateDTO userUpdateDTO) {
        if (userUpdateDTO.getEmail() == null || userUpdateDTO.getNewName() == null || userUpdateDTO.getNewPassword() == null) {
            throw new IllegalArgumentException("Se deben proporcionar email, nuevo nombre de usuario y nueva contraseña");
        }

        // Utiliza Optional para obtener el usuario
        Optional<User> optionalUser = userRepo.findOneByEmailAndPassword(userUpdateDTO.getEmail(), userUpdateDTO.getPassword());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (userUpdateDTO.getNewName() != null) {
                user.setUsername(userUpdateDTO.getNewName());
            }
            if (userUpdateDTO.getNewPassword() != null) {
                user.setPassword(userUpdateDTO.getNewPassword());
            }

            // Guarda la actualización en la base de datos
            userRepo.save(user);
        } else {
            throw new UserNotFoundException("Usuario no encontrado");
        }
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
