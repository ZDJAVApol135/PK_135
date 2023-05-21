package pl.sda.registrationapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.sda.registrationapi.dto.UserDTO;
import pl.sda.registrationapi.service.UsersService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@PreAuthorize("hasRole('ADMIN')")
public class UsersController {

    // HTTP Methods
    // =============================
    // GET -> pobieramy zasoby  200 OK
    // POST -> tworzymy zasoby  201 CREATED
    // PUT -> całościowy update zasobów 201 CREATED
    // PATCH (Łatka) -> częściowy update zasobu 201 CREATED
    // DELETE -> usuwanie zasobów 204 NO_CONTENT
    // HEAD -> pobranie nagłówków
    // OPTIONS -> pobiera opcje, które mogą być wykonane na konkretnym zasobie

    private final UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(usersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usersService.create(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateById(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(usersService.update(id, userDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usersService.deleteById(id);
    }

    @PatchMapping("/{id}/disable")
    @ResponseStatus(HttpStatus.OK)
    public void disableById(@PathVariable Long id) {
        usersService.disable(id);
    }

    @PatchMapping("/{id}/enable")
    @ResponseStatus(HttpStatus.OK)
    public void enableById(@PathVariable Long id) {
        usersService.enable(id);
    }
}
