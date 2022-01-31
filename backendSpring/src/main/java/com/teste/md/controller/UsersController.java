package com.teste.md.controller;

import com.google.gson.Gson;
import com.teste.md.Models.DTO.PageResponse;
import com.teste.md.Models.Users;
import com.teste.md.Models.DTO.requests.UserRequest;
import com.teste.md.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;


    @PostMapping(path = "/save")
    @ApiOperation(value = "Salvar usuario")
    public ResponseEntity<Users> loadFile(
            @ApiParam(value = "Dados do usuario a ser salvo")
            @Valid @RequestBody UserRequest userRequest) throws IOException {
        return ResponseEntity.ok().body(this.userService.createUsers(userRequest));
    }


    @GetMapping(path = "visualizar/page/{page}/size/{size}")
    @ResponseBody
    @ApiOperation(value = "Lista usuários por página quantidade")
    public Page<Users> listUsersByPageWithSize(
            @ApiParam(value = "Página que deseja visualizar iniciando em 0", example = "0")
            @PathVariable(value="page")
                    int page,
            @ApiParam(value = "Quantidade de usuários a serem listados por página", example = "10")
            @PathVariable(value="size")
                    int size){

        Pageable pages = PageRequest.of(page, size);
        return this.userService.listUsersByPage(pages);

    }

    @GetMapping("/check")
    @ResponseBody
    public ResponseEntity<String> check(){
        Gson gson = new Gson();
        return ResponseEntity.ok().body(gson.toJson("OK"));
    }
}
