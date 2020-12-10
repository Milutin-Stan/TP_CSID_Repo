package fr.paris8univ.iut.csid.csidwebrepositorybase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class GitRepositoryService {

    private final GitRepositoryRepository gitRepositoryRepository;

    @Autowired
    public GitRepositoryService(GitRepositoryRepository gitRepositoryRepository) {
        this.gitRepositoryRepository = gitRepositoryRepository;
    }


    public List<GitRepository> getRepositories(){
        List<GitRepository> repositoryEntities = gitRepositoryRepository.getRepositories();
        return repositoryEntities;
    }


    public Optional<GitRepository> findOneRepository(String name) throws URISyntaxException {
        Optional<GitRepository> gitrepoopt = gitRepositoryRepository.findOneRepository(name);
        return gitrepoopt.map(x -> new GitRepository(x.getName(), x.getOwner() , x.getForks(), x.getOpen_issues()));
    }

    public void createRepository(GitRepository gitRepository){
        gitRepositoryRepository.createRepository(gitRepository);
    }

    public void putRepository(GitRepository gitRepository, String name){
        gitRepositoryRepository.putRepository(gitRepository, name); }


    public void patchRepository(GitRepository gitRepository, String name) {
        gitRepositoryRepository.patchRepository(gitRepository, name);
    }


    public void deleteRepo(String name){
        gitRepositoryRepository.deleteRepo(name);
    }
}