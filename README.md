# FilmQueryProject
<a title="Thomas Wolf, www.foto-tw.de, CC BY-SA 3.0 &lt;https://creativecommons.org/licenses/by-sa/3.0&gt;, via Wikimedia Commons" href="https://commons.wikimedia.org/wiki/File:Hollywood_Sign_(Zuschnitt).jpg"><img width="512" alt="Hollywood Sign (Zuschnitt)" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Hollywood_Sign_%28Zuschnitt%29.jpg/512px-Hollywood_Sign_%28Zuschnitt%29.jpg"></a>

# Description
The Film Query Application is a command-line tool that provides users with a menu-driven interface to retrieve and display information about films from a database.  The primary goal is to encapsulate all JDBC code in a well-structured Java application, allowing users to perform various actions related to film queries.

User Stories:

1. Menu-Based Interface: Users can select actions from a menu.
2. Film Lookup by ID: Detailed film information is displayed when users provide an ID.
3. Film Lookup by Search Keyword: Users can find films matching a keyword.
4. Displaying Film Language: Film language is shown along with other details.
5. Displaying Cast: Users can view the film's cast.

# Tech Used
- **Programming Languages:**
    - Java 8 (version 1.8.0_391)
- **IDEs:**
    - Eclipse 2023-09 (https://www.eclipse.org/)
    - Visual Studio Code 1.84.2 (https://code.visualstudio.com/)
- **Version Control:**
    - Git 2.32.1 (https://git-scm.com/)
- **Database Management:**
    - MySQL (version 5.7.39)

# Lessons Learned
1. Establishing Database Connections:
- Properly configuring and managing database connections is crucial.
- Always close connections, statements, and result sets to prevent resource leaks.
2. Using Prepared Statements:
- Prepared statements help prevent SQL injection and improve performance.
- Parameterized queries are a safer and more efficient way to interact with databases.
3. Object-Relational Mapping (ORM)
 - Applying ORM principles can help in representing database tables as Java objects.
 - Mapping database entities to Java classes can simplify database interactions and make the code more maintainable.
