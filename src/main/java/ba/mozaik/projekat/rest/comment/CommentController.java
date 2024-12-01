package ba.mozaik.projekat.comment;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.nio.channels.NoConnectionPendingException;
import java.util.List;
import java.util.NoSuchElementException;

//baseURL/api/comments
@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommmentRepository commmentRepository;

    @GetMapping(value = "/comments")
    public List<Comment> getAll( ){
        return commmentRepository.findAll();
    }

    @GetMapping("/comments/{id}")
    public Comment getById(@PathVariable Long id){
        System.out.println(id);
        return commmentRepository.findById(id).orElse(new Comment());
    }

    @PostMapping("/comments")
    public Comment addComment(@Validated @RequestBody Comment comment){
        return commmentRepository.save(comment);
    }

    @PutMapping("/comments/{id}")
    public Comment updataComment(@PathVariable Long id,@Validated @RequestBody Comment comment){
        Comment previouslyPersisted = commmentRepository.findById(id).orElseThrow();
        previouslyPersisted.setName(comment.getName());
        previouslyPersisted.setAuthor(comment.getAuthor());
        previouslyPersisted.setCommnet(comment.getCommnet());
       return commmentRepository.save(previouslyPersisted);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id){
        commmentRepository.deleteById(id);
    }
}