Unit of work
* The term unit of work means set of tasks that are performing some changes on data.
* Such that all changes needs to be performed or none of the changes needs to be performed.
*In Relational db context the term unit of work means Atomicity(all or none)


* In Context of JPA and hibernate, the term unit of work tracks all changes made to the Data objects which represents entries in db
* ORM will figure out which all changes to be applied to db
* This way the number of db calls are reduced, by aggregating all changes into one call