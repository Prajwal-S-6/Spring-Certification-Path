Implementation of SpringData Repositories

* Spring data Repositories are implemented at runtime by SimpleJpaRepository by default
* Spring will scan for the repositories mentioned in the basePackages of @EnableJpaRepositories
* It will create a bean for repositories in that package
* By default, it will create beans of instance of SimpleJpaRepository


However, we can override this default implementation by 2 ways:
1. Global level - By creating custom base repository implementation by extending SimpleJpaRepository and enabling it in
                    @EnableJpaRepository(repositoryBaseClass = )
