package com.example.Integrador.UserController;


import com.example.Integrador.Dto.LoginDTO;
import com.example.Integrador.Dto.UserDTO;
import com.example.Integrador.Dto.UserUpdateDTO;
import com.example.Integrador.Message.LoginMessage;
import com.example.Integrador.Message.UserNotFoundException;
import com.example.Integrador.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Integrador.Entity.User;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public int saveUser(@RequestBody UserDTO userDTO){
        int id = userService.addUser(userDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginMessage loginMessage = userService.LoginUser(loginDTO);
        if (loginMessage.getMessage().equals("Inicio de Sesion Exitoso")) {

            User user = userService.getUserByEmail(loginDTO.getEmail());
            loginMessage.setUsername(user.getUsername());

        }
        return ResponseEntity.ok(loginMessage);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
        try {
            userService.updateUser(userUpdateDTO);
            return ResponseEntity.ok("Usuario actualizado con éxito");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el usuario");
        }
    }
}
