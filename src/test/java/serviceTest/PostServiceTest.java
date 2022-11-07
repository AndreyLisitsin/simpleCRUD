package serviceTest;

import com.lisitsin.models.Post;
import com.lisitsin.repositories.PostRepository;
import com.lisitsin.services.PostService;
import com.lisitsin.services.impl.PostServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.BDDMockito.given;

public class PostServiceTest {
    @Mock
    PostRepository repository;

    PostService postService;

    public PostServiceTest(){
        MockitoAnnotations.openMocks(this);
        postService = new PostServiceImpl(repository);
    }

    @Test
    void getPostById(){

        Date created = new Date();
        Date updated  = new Date();

        given(repository.getById(1L)).willReturn(new Post(1L, "test content", created, updated, Collections.emptyList()));
        Post post = postService.getById(1L);
        Assertions.assertEquals(new Post(1L, "test content", created, updated, Collections.emptyList()), post);
    }

    @Test
    void getAllPosts(){

        Date created = new Date();
        Date updated  = new Date();

        Post firstPost = new Post(1L, "first content", created, updated, Collections.emptyList());
        Post secondPost = new Post(2L, "second content", created, updated, Collections.emptyList());

        given(repository.getAll()).willReturn(List.of(firstPost, secondPost));

        List<Post> posts = postService.getAll();
        Assertions.assertEquals(List.of(firstPost, secondPost), posts);
    }

    @Test
    void saveOrUpdatePost(){

        Date created = new Date();
        Date updated  = new Date();

        Post firstPost = new Post(1L, "first content", created, updated, Collections.emptyList());

        given(repository.save(firstPost)).willReturn(firstPost);

        Post post = postService.save(firstPost);

        Assertions.assertEquals(firstPost, post);
    }

    @Test
    void deletePost(){

        Date created = new Date();
        Date updated  = new Date();

        Post firstPost = new Post(1L, "first content", created, updated, Collections.emptyList());
        Post secondPost = new Post(2L, "second content", created, updated, Collections.emptyList());

        List<Post> oldList = new ArrayList<>(List.of(firstPost, secondPost));
        List<Post> newList = new ArrayList<>(List.of(firstPost));

    // не придумал, как работать с войд методами

    }
}
