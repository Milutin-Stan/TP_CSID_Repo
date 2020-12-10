package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("repositories")
public class RepositoryController {

    private final GitRepositoryService repositoryService;

    @Autowired
    public RepositoryController(GitRepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @GetMapping
    public List<GitRepository> getRepositories(){
        return repositoryService.getRepositories();
    }

    @GetMapping("/{name}")
    public ResponseEntity<GitRepository> findOneRepository(@PathVariable String name) throws URISyntaxException {
        return repositoryService.findOneRepository(name)
                .map(x->ResponseEntity.ok(x))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GitRepository> createRepo(@RequestBody GitRepository gitRepository) throws URISyntaxException {
            repositoryService.createRepository(gitRepository);
        return ResponseEntity.created(new URI("repositories/created")).build();
    }

    @PutMapping("/{name}")
    public ResponseEntity<Object> putRequest(@PathVariable String name, @RequestBody GitRepository gitRepository){
        repositoryService.putRepository(gitRepository,name);
        return ResponseEntity.noContent().build();

    }

    @PatchMapping("/{name}")
    public ResponseEntity<Object> patchRepository(@PathVariable String name,@RequestBody GitRepository gitRepository) {
        repositoryService.patchRepository(gitRepository,name);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Object> deleteRepository(@PathVariable String name){
        repositoryService.deleteRepo(name);
        return ResponseEntity.noContent().build();
    }

}
