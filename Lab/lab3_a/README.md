<div>
    <div role="main">
 <h1>Laboratory Exercise 3 – for groups with prefix A</h1>
        <div class="box py-3 generalbox center clearfix">
            <div class="no-overflow">
                <h3>The solution prepared at home must use PostgreSQL, but the presentation at the faculty must be done exclusively with H2!</h3>
                <ol>
                    <li>
                        Continue working on the solution from the previous laboratory exercise, where you worked on a book management system, and implement data persistence using Spring Data JPA and Hibernate.
                    </li>
                </ol>
                <hr>
                <ol start="2">
                    <li>
                        <p>Add the required dependencies for
                            <code>spring-boot-starter-data-jpa</code>,
                            <code>h2</code>, and
                            <code>postgresql</code>
                            in <code>pom.xml</code>, similarly to what was done in the auditory exercises.
                        </p>
                    </li>
                    <li>
                        <p>Install PostgreSQL if it is not already installed, or skip this step if you will use Docker.</p>
                    </li>
                    <li>
                        <p>Create two Spring profiles:
                            <code>h2</code> (for an in-memory database) and
                            <code>prod</code> (for a PostgreSQL database).
                            The active profile should be the one that uses PostgreSQL.
                        </p>
                    </li>
                    <li>
                        <p>If you use Docker, create a <code>docker-compose.yml</code> file for configuring and running PostgreSQL.
                           If not, make sure you correctly configure the <code>username</code> and <code>password</code> parameters during PostgreSQL installation.
                        </p>
                    </li>
                    <li>
                        <p>Connect IntelliJ IDEA to the PostgreSQL database.
                           Make sure you use the correct values for <code>port</code>, <code>username</code>, <code>password</code>, and the database name.
                           The database name should be <code>books</code>.
                        </p>
                    </li>
                    <li>
                        <p>In <code>application-prod.properties</code>, make sure that
                           <code>spring.datasource.url</code>,
                           <code>spring.datasource.username</code>, and
                           <code>spring.datasource.password</code>
                           are correctly configured.
                        </p>
                    </li>
                    <li>
                        <p>Modify the <code>Book</code> class in the package <code>mk.ukim.finki.wp.lab.model</code>:</p>
                        <ul>
                            <li>Annotate it with <code>@Entity</code> to make it a JPA entity.</li>
                            <li>Provide a unique <code>id</code> for each book using <code>@Id</code> and <code>@GeneratedValue</code>.</li>
                        </ul>
                    </li>
                    <li>
                        <p>Modify the <code>Author</code> class:</p>
                        <ul>
                            <li>Annotate it with <code>@Entity</code>.</li>
                            <li>Provide a unique <code>id</code> using <code>@Id</code> and <code>@GeneratedValue</code>.</li>
                            <li>Add the relationship with <code>Book</code> using <code>@OneToMany</code>.</li>
                        </ul>
                    </li>
                    <li>
                        <p>Define the relationships between the <code>Book</code> and <code>Author</code> entities:</p>
                        <ul>
                            <li>In <code>Book</code>, use <code>@ManyToOne</code> for the relationship with <code>Author</code>.</li>
                            <li>In <code>Author</code>, add a list of <code>Book</code> entities and use <code>@OneToMany(mappedBy = "author")</code>.</li>
                        </ul>
                    </li>
                    <li>
                        <p>Create database tables for <code>Book</code> and <code>Author</code> using Spring Data JPA.</p>
                    </li>
                    <li>
                        <p>Make sure table names are unique, especially for entities such as <code>User</code>.
                           For example, if you have a table named <code>User</code>, rename it using
                           <code>@Table(name = "users")</code>.
                        </p>
                    </li>
                    <li>
                        <p>In the package <code>mk.ukim.finki.wp.lab.repository</code>:</p>
                        <ul>
                            <li>Create <code>BookRepository</code> and <code>AuthorRepository</code> interfaces that extend <code>JpaRepository</code>.</li>
                        </ul>
                    </li>
                    <li>
                        <p>Add a method to <code>BookRepository</code> that returns books by author:</p>
                        <pre><code>List&lt;Book&gt; findAllByAuthor_Id(Long authorId);</code></pre>
                    </li>
                    <li>
                        <p>In the package <code>mk.ukim.finki.wp.lab.service</code>:</p>
                        <ul>
                            <li>Modify <code>AuthorService</code> to use methods from <code>AuthorRepository</code>.</li>
                            <li>Modify <code>BookService</code> to use methods from <code>BookRepository</code>.</li>
                        </ul>
                    </li>
                    <li>
                        <p>Modify <code>BookController</code>:</p>
                        <ul>
                            <li>Add support for adding and updating books, persisting the data in the database.</li>
                            <li>Ensure that when updating, the data is retrieved from the database and displayed in the form.</li>
                        </ul>
                    </li>
                    <li>
                        <p>Modify the <code>getBooksPage</code> method to retrieve books from the database using <code>BookService</code>.</p>
                    </li>
                    <li>
                        <p>Ensure that <code>listBooks.html</code> and <code>book-form.html</code> work with data from the database.</p>
                    </li>
                    <li>
                        <p>When adding or updating a book, the user should be able to select an author from a list populated from the database via <code>AuthorService</code>.</p>
                    </li>
                    <li>
                        <p>Test the functionality:</p>
                        <ul>
                            <li>Adding a new book.</li>
                            <li>Updating a book.</li>
                            <li>Deleting a book.</li>
                            <li>Displaying books by author.</li>
                        </ul>
                    </li>
                </ol>
            </div>
        </div>
    </div>
</div>