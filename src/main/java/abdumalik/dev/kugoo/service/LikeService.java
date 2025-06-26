package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.LikeDto;
import abdumalik.dev.kugoo.model.Like;
import abdumalik.dev.kugoo.model.Result;
import abdumalik.dev.kugoo.repository.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LikeService {

    @Autowired
    LikeRepo repo;

    public List<Like> getAllLikes() {
        return repo.findAll();
    }

    public Like getLike(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Like> getByLikeCount(Integer likeCount) {
        return repo.findByLikeCount(likeCount);
    }

    public Result create(LikeDto dto) {
        Like like = new Like();
        like.setLikeCount(dto.getLikeCount());
        like.setStatus(dto.getStatus());
        repo.save(like);
        return new Result("Like info created successfully", true);
    }

    public Result update(UUID id, LikeDto dto) {
        Optional<Like> byId = repo.findById(id);
        if (byId.isPresent()) {
            Like like = byId.get();
            like.setLikeCount(dto.getLikeCount());
            like.setStatus(dto.getStatus());
            repo.save(like);
            return new Result("Like info updated successfully", true);
        }
        return new Result("Like info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Like> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Like info deleted successfully", true);
        }
        return new Result("Like info not found", false);
    }

}