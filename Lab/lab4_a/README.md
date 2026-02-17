# Lab Exercise 4 - for groups with prefix A

### Specification for the laboratory exercise

1. In this exercise, you need to continue working within the project from the previous laboratory exercise, while implementing access control using Spring Security.
2. First, you need to add the dependencies for Spring Security and testing that are provided in the `pom.xml` of the auditorial exercise.
3. You need to configure Spring Security in order to enable user login. While doing so, you should use `inMemoryAuthentication` and create a predefined **admin** user.
4. When there is no logged-in user:

    * all pages should be visible except those for adding and editing data.
    * the buttons for **adding**, **deleting**, and **editing (edit)** data should not be visible.
5. When the **admin** user logs in, they should have access to all functionalities of the application.

    * After logging in, the `/books` page should be opened.
