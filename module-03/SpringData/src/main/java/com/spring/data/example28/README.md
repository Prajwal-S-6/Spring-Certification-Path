Implementation of SpringData Repositories

* Spring data Repositories are implemented at runtime by SimpleJpaRepository by default
* Spring will scan for the repositories mentioned in the basePackages of @EnableJpaRepositories
* It will create a bean for repositories in that package
* By default, it will create beans of instance of SimpleJpaRepository


However, we can override this default implementation by 2 ways:
1. Global level - By creating custom base repository implementation by extending SimpleJpaRepository and enabling it in
                    @EnableJpaRepository(repositoryBaseClass = )
2. Dao/Repository level - We can provide custom implementation at single Dao or Repository level
                            By creating separate custom repository interface with custom methods, provide impl for that and use that interface in repository Dao
