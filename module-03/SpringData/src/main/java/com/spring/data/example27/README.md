Naming convention of finder methods in Spring data JPA

find[limit]By[property/properties expressions][comparison][ordering]

* limit - results of the query can be limited using first/top keyword
* Eg: findTop3BySalary, findFirstByHireDate


* property/ properties expressions - results are filtered based on property or property expressions of entity
* multiple properties can be used with And/Or
* Example: findByFirstNameAndLastName, findByLastNameAndSalaryGreaterThan


* comparison - is used for filtering and used after property
* example: findBySalaryBetween, findByLastNameIsNotNull, findByFirstNameEquals, findByFirstNameLike, findByAgeIn(Collection<> age), findByFirstNameNot, findByFirstNameEndingWith etc


* ordering - to order the results, added at the end
* eg: findByLastNameOrderBySalaryAsc, findBySalaryGreaterThanOderByFirstNameDesc