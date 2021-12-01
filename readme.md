<h2 align="center"> 🎓 MJC school : EPAM Systems<br/>Minsk, Belarus (Минск, Беларусь)<br/>module #3. REST API Advanced</h2>

<h3>🎁 Materials</h3>
<ol>
  <li><a href="https://videoportal.epam.com/video/6Rn164or" rel="nofollow">Spring Boot intro</a></li>
  <li><a href="https://start.spring.io/" rel="nofollow">Spring Boot Init</a></li>
  <li><a href="https://www.moesif.com/blog/technical/api-design/REST-API-Design-Filtering-Sorting-and-Pagination/" rel="nofollow">REST API Design: Filtering, Sorting, and Pagination</a></li>
  <li><a href="https://www.baeldung.com/rest-api-pagination-in-spring/" rel="nofollow">REST Pagination in Spring</a></li>
  <li><a href="https://spring.io/guides/gs/rest-hateoas/" rel="nofollow">HATEOAS with Spring</a></li>
  <li><a href="https://www.educba.com/what-is-orm/" rel="nofollow">What is ORM</a></li>
  <li><a href="https://www.vogella.com/tutorials/JavaPersistenceAPI/article.html" rel="nofollow">Java persistence API</a></li>
  <li><a href="https://docs.spring.io/spring/docs/4.2.x/spring-framework-reference/html/transaction.html" rel="nofollow">Spring transaction management</a></li>
  <li><a href="https://www.baeldung.com/database-auditing-jpa#auditing" rel="nofollow">Auditing with JPA</a></li>
</ol>

<h3>🚀 Task</h3>
<h4>General requirements</h4>
<ol>
  <li>Code should be clean and should not contain any “developer-purpose” constructions.</li>
  <li>App should be designed and written with respect to OOD and SOLID principles.</li>
  <li>Code should contain valuable comments where appropriate.</li>
  <li>Public APIs should be documented (Javadoc).</li>
  <li>Clear layered structure should be used with responsibilities of each application layer defined.</li>
  <li>JSON should be used as a format of client-server communication messages.</li>
  <li>Convenient error/exception handling mechanism should be implemented: all errors should be meaningful and localized on backend side. Example: handle 404 error:
  <br><div class="snippet-clipboard-content position-relative overflow-auto"><pre><code> • HTTP Status: 404
 • response body    
 • {
 • “errorMessage”: “Requested resource not found (id = 55)”,
 • “errorCode”: 40401
 • }
  </code></pre><div class="zeroclipboard-container position-absolute right-0 top-0">
where *errorCode” is your custom code (it can be based on http status and requested resource - certificate or tag)
  </li>
  <li>Abstraction should be used everywhere to avoid code duplication.</li>
  <li>Several configurations should be implemented.</li>
</ol>
    
<h3>Part 1</h3>
Migrate your existing Spring application from a previous module to a Spring Boot application.

<h3>Part 2</h3>
<h4>Business requirements</h4>
This sub-module is an extension of REST API Basics, and it covers such topics as pagination, sorting, filtering and HATEOAS. Please imagine that your application has a lot of data, so when you make a GET request it will return, for instance, 1 million records. This will take much time to process such request and return the result to the consumer of your API. That is exactly what pagination, sorting, and filtering can solve. The other topic is HATEOAS what stands for the phrase "Hypermedia As The Engine Of Application State". When you are viewing a web page, you see data on it and can perform some actions with this data. In REST when you request a resource you get the details of the resource in the response. Along with it you can send the operations that you can perform on the resource. And this is what HATEOAS does.
The system should be extended to expose the following REST APIs:
<ol><br>
 <li>Change single field of gift certificate (e.g. implement the possibility to change only duration of a certificate or only price).</li>
   <li>Add new entity User.
    <ul>
      <li>implement only get operations for user entity.</li>
    </ul>
  </li>
  <li>Make an order on gift certificate for a user (user should have an ability to buy a certificate).</li>
  <li>Get information about user’s orders.</li>
  <li>Get information about user’s order: cost and timestamp of a purchase.
  <ul>
    <li>The order cost should not be changed if the price of the gift certificate is changed.</li>
  </ul>
 </li>
    <li>Get the most widely used tag of a user with the highest cost of all orders.
    <ul>
    <li>Create separate endpoint for this query.</li>
    <li>Demonstrate SQL execution plan for this query (explain).</li>
  </ul>
 </li>
  <li>Search for gift certificates by several tags (“and” condition).</li>
  <li>Pagination should be implemented for all GET endpoints. Please, create a flexible and non-erroneous solution. Handle all exceptional cases.</li>
  <li>Support HATEOAS on REST endpoints.</li>
</ol>

<h4>Application requirements</h4>
<ol>
  <li>JDK version: 8. Use Streams, java.time.*, an etc. where it is appropriate. (the JDK version can be increased in agreement with the mentor/group coordinator/run coordinator)  </li>
  <li>Application packages root: com.epam.esm.</li>
  <li>Java Code Convention is mandatory (exception: margin size –120 characters).</li>
  <li>Apache Maven/Gradle, latest version. Multi-module project.</li>
  <li>Spring Framework, the latest version.</li>
  <li>Database: PostgreSQL/MySQL, latest version.</li>
  <li>Testing: JUnit, the latest version, Mockito.</li>
  <li>Service layer should be covered with unit tests not less than 80%.</li>
</ol>

<h3>Part 3</h3>
This sub-module covers following topics:
<ol>
<li>ORM</li>
<li>JPA &amp; Hibernate</li>
<li>Transactions
ORM stands for Object Relational Mapping. It’s a bit of an abstract concept – but basically it’s a technique that allows us to query and change data from the database in an object oriented way. ORMs provide a high-level abstraction upon a relational database that allows a developer to write Java code instead of SQL to create, read, update and delete data and schemas in their database. Developers can use the programming language they are comfortable with to work with a database instead of writing SQL statements or stored procedures. A JPA (Java Persistence API) is a specification of Java which is used to access, manage, and persist data between Java object and relational database. It is considered as a standard approach for Object Relational Mapping. JPA can be seen as a bridge between object-oriented domain models and relational database systems. Being a specification, JPA doesn't perform any operation by itself. Thus, it requires implementation. So, ORM tools like Hibernate, TopLink, and iBatis implements JPA specifications for data persistence. A transaction usually means a sequence of information exchange and related work (such as database updating) that is treated as a unit for the purposes of satisfying a request and for ensuring database integrity. For a transaction to be completed and database changes to made permanent, a transaction has to be completed in its entirety.</li>
</ol>

<h4>Application requirements</h4>
<ol>
  <li>Hibernate should be used as a JPA implementation for data access.</li>
  <li>Spring Transaction should be used in all necessary areas of the application.</li>
  <li>Audit data should be populated using JPA features (an example can be found in materials).</li>
</ol>

<h4>Application restrictions</h4>
<ol>
  <li>Hibernate specific features.</li>
  <li>Spring Data</li>
</ol>

<h3>📚 Extra Materials</h3>
<ol>
  <li><a href="https://spring.io/projects/spring-boot/" rel="nofollow">Spring Boot reference</a></li>
  <li><a href="https://spring.io/guides/gs/rest-service/" rel="nofollow">Spring Boot tutorial</a></li>
  <li><a href="https://habr.com/ru/post/257223/" rel="nofollow">Spring Boot</a></li>
  <li><a href="https://habr.com/ru/post/483328/" rel="nofollow">What is HATEOAS?</a></li>
  <li><a href="https://martinfowler.com/articles/richardsonMaturityModel.html" rel="nofollow">Richardson Maturity Model</a></li>
  <li><a href="https://youtu.be/bkDUIIho70o" rel="nofollow">ORM или SQL</a></li>
  <li><a href="https://www.educba.com/java-persistence-api/" rel="nofollow">JPA</a></li>
  <li><a href="https://www.javatpoint.com/jpa-vs-hibernate" rel="nofollow">JPA vs Hibernate</a></li>
  <li><a href="https://www.geeksforgeeks.org/acid-properties-in-dbms/" rel="nofollow">ACID Properties of transactions</a></li>
  <li><a href="https://www.geeksforgeeks.org/transaction-isolation-levels-dbms/" rel="nofollow">Transaction Isolation Levels</a></li>
</ol>
