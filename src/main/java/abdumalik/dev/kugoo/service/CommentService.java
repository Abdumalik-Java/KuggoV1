package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.CommentDto;
import abdumalik.dev.kugoo.model.Account;
import abdumalik.dev.kugoo.model.Comment;
import abdumalik.dev.kugoo.model.Like;
import abdumalik.dev.kugoo.model.Result;
import abdumalik.dev.kugoo.repository.AccountRepo;
import abdumalik.dev.kugoo.repository.CommentRepo;
import abdumalik.dev.kugoo.repository.LikeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    CommentRepo repo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    LikeRepo likeRepo;

    public List<Comment> getAll() {
        return repo.findAll();
    }

    public Comment getById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(CommentDto dto) {
        Comment comment = new Comment();

        Optional<Account> byId = accountRepo.findById(dto.getAccountId());
        Account account = byId.get();
        comment.setAccountId(account);

        Optional<Like> byId1 = likeRepo.findById(dto.getLikeId());
        Like like = byId1.get();
        comment.setLikeId(like);

        comment.setReply(dto.getReply());

        repo.save(comment);
        return new Result("Comment info successfully created", true);
    }

    public Result update(UUID id, CommentDto dto) {
        Optional<Comment> byId = repo.findById(id);
        if (byId.isPresent()) {
            Comment comment = byId.get();

            Optional<Account> byId1 = accountRepo.findById(dto.getAccountId());
            Account account = byId1.get();
            comment.setAccountId(account);

            Optional<Like> byId2 = likeRepo.findById(dto.getLikeId());
            Like like = byId2.get();
            comment.setLikeId(like);

            comment.setReply(dto.getReply());

            repo.save(comment);
            return new Result("Comment info successfully updated", true);
        }
        return new Result("Comment info not found", false);
    }

    public Result delete(UUID id) {
        Optional<Comment> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Comment info successfully deleted", true);
        }
        return new Result("Comment info not found", false);
    }

}