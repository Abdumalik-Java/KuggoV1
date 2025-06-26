package abdumalik.dev.kugoo.controller;

import abdumalik.dev.kugoo.dto.LikeDto;
import abdumalik.dev.kugoo.model.Like;
import abdumalik.dev.kugoo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    LikeService likeService;

    @GetMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readAll() {
        return new ResponseEntity<>(likeService.getAllLikes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readOne(@PathVariable UUID id) {
        return new ResponseEntity<>(likeService.getLike(id), HttpStatus.OK);
    }

    @GetMapping("/{likeCount}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> readByLikeCount(@PathVariable Integer likeCount) {
        return new ResponseEntity<>(likeService.getByLikeCount(likeCount), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> create(@RequestBody LikeDto likeDto) {
        return new ResponseEntity<>(likeService.create(likeDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> update(@PathVariable UUID id, @RequestBody LikeDto likeDto) {
        return new ResponseEntity<>(likeService.update(id, likeDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('SUPERADMIN','ADMIN','USER')")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        return new ResponseEntity<>(likeService.delete(id), HttpStatus.OK);
    }

}