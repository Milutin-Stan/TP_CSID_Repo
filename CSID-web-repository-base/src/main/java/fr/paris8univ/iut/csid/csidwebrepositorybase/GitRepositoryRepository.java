package fr.paris8univ.iut.csid.csidwebrepositorybase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class GitRepositoryRepository {

    private final GitRepositoryDao gitRepositoryDao;
    private final GithubRepositoryDao githubRepositoryDao;

    @Autowired
    public GitRepositoryRepository(GitRepositoryDao gitRepositoryDao,GithubRepositoryDao githubRepositoryDao) {
        this.gitRepositoryDao = gitRepositoryDao;
        this.githubRepositoryDao = githubRepositoryDao;
    }

    public List<GitRepository> getRepositories(){
        List<GitRepositoryEntity> repositoryEntities = gitRepositoryDao.findAll();
        List<GitRepository> newRepository = repositoryEntities.stream()
                .map(x -> new GitRepository(x.getName(), x.getOwner() , x.getForks(), x.getOpen_issues()))
                .collect(Collectors.toList());
        return newRepository;
    }

    public Optional<GitRepository> findOneRepository(String name) throws URISyntaxException {
        GitRepositoryEntity gitrepoopt = gitRepositoryDao.findById(name).get();
        GitRepository gitRepository = new GitRepository(gitrepoopt.getName(), gitrepoopt.getOwner(), gitrepoopt.getForks(), gitrepoopt.getOpen_issues());

            GithubRepositoryDto githubRepositoryDto = githubRepositoryDao.getGitJson(gitRepository.getName(), gitRepository.getOwner());
            gitRepository.setForks(githubRepositoryDto.getForks());
            gitRepository.setOpen_issues(githubRepositoryDto.getOpen_issues());
            patchRepository(gitRepository, name);

        return Optional.of(gitRepository);
    }

    public void createRepository(GitRepository gitRepository){
        gitRepositoryDao.save(new GitRepositoryEntity(gitRepository.getName(),gitRepository.getOwner(),gitRepository.getForks(),gitRepository.getOpen_issues()));
    }

    public void putRepository(GitRepository gitRepository, String name){

        Optional<GitRepositoryEntity> repositoryEntity = gitRepositoryDao.findById(name);

        if(repositoryEntity.isEmpty()) {
            createRepository(gitRepository);
        }
        else {
            GitRepositoryEntity newRepository = repositoryEntity.get();
            newRepository.setOwner(gitRepository.getOwner());
            newRepository.setForks(gitRepository.getForks());
            newRepository.setOpen_issues(gitRepository.getOpen_issues());
            gitRepositoryDao.save(newRepository);
        }
    }

    public void patchRepository(GitRepository gitRepository, String name){

        GitRepositoryEntity patchedRepository = gitRepositoryDao.findById(name).get();

                if(gitRepository.getOwner() != null)
                    patchedRepository.setOwner(gitRepository.getOwner());

                if(gitRepository.getForks() != 0)
                    patchedRepository.setForks(gitRepository.getForks());

                if(gitRepository.getOpen_issues() != 0 )
                    patchedRepository.setOpen_issues(gitRepository.getOpen_issues());

            gitRepositoryDao.save(patchedRepository);

        }

    public void deleteRepo(String name){
        gitRepositoryDao.deleteById(name);
    }
}
