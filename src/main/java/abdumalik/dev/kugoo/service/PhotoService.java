package abdumalik.dev.kugoo.service;

import abdumalik.dev.kugoo.dto.PhotoDto;
import abdumalik.dev.kugoo.model.Photo;
import abdumalik.dev.kugoo.model.Result;
import abdumalik.dev.kugoo.repository.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PhotoService {

    @Autowired
    PhotoRepo repo;

    public List<Photo> getAll() {
        return repo.findAll();
    }

    public Photo getById(UUID id) {
        return repo.findById(id).get();
    }

    public Optional<Photo> getByName(String name) {
        return repo.findByName(name);
    }

    public Result create(PhotoDto dto) {
        Photo photo = new Photo();
        photo.setName(dto.getName());
        photo.setSize(dto.getSize());
        photo.setByteInfo(dto.getByteInfo());
        repo.save(photo);
        return new Result("Photo successfully created", true);
    }

    public Result update(UUID id, PhotoDto dto) {
        Optional<Photo> byId = repo.findById(id);
        if (byId.isPresent()) {
            Photo photo = byId.get();
            photo.setName(dto.getName());
            photo.setSize(dto.getSize());
            photo.setByteInfo(dto.getByteInfo());
            repo.save(photo);
            return new Result("Photo successfully updated", true);
        }
        return new Result("Photo not found", false);
    }

    public Result delete(UUID id) {
        Optional<Photo> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Photo successfully deleted", true);
        }
        return new Result("Photo not found", false);
    }

}