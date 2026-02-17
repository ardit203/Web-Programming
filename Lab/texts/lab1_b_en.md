# Laboratory Exercise 1 - for groups with prefix B
# Specification for the Laboratory Exercise

## 1. Creating a Spring Boot Project
Create a new Spring Boot project with the following characteristics:
- **groupId**: `mk.ukim.finki.wp`
- **artifactId**: `lab`
- **Dependencies**: The same as the project from the auditory exercises (see the `<dependency>` tags in `pom.xml`)

---

## 2. Creating `Model` Classes

Define the package `mk.ukim.finki.wp.lab.model` and create the following classes:

### 2.1 `Chef` class
Create a class `Chef` containing:
- `Long id`
- `String firstName`
- `String lastName`
- `String bio`
- `List<Dish> dishes`

A single chef can prepare multiple dishes.

### 2.2 `Dish` class
Create a class `Dish` containing:
- `String dishId`
- `String name`
- `String cuisine`
- `int preparationTime`

---

## 3. Creating the `DataHolder` Class
Create a class `DataHolder` in the package `mk.ukim.finki.wp.lab.bootstrap` which will contain:
- Static list: `public static List<Chef> chefs = new ArrayList<>();` initialized with **5 values**
- Static list: `public static List<Dish> dishes = new ArrayList<>();` initialized with **5 values**

---

## 4. Creating the `Repository` Layer

### 4.1 `ChefRepository` Interface
Define the interface `ChefRepository` in the package `mk.ukim.finki.wp.lab.repository`:
```java
public interface ChefRepository {
    List<Chef> findAll();
    Optional<Chef> findById(Long id);
    Chef save(Chef chef);
}
```

### 4.2 `InMemoryChefRepository` Implementation
Create a class `InMemoryChefRepository` that implements the `ChefRepository` interface.

**Implementation:**
- `findAll()` - returns the list from `DataHolder.chefs`
- `findById(Long id)` - returns the chef whose `id` matches the given parameter
- `save(Chef chef)` - if the chef already exists in the list, update it; otherwise, add a new chef. Return the saved chef

### 4.3 `DishRepository` Interface
Define the interface `DishRepository` in the package `mk.ukim.finki.wp.lab.repository`:
```java
public interface DishRepository {
    List<Dish> findAll();
    Dish findByDishId(String dishId);
}
```

### 4.4 `InMemoryDishRepository` Implementation
Create a class `InMemoryDishRepository` that implements the `DishRepository` interface.

**Implementation:**
- `findAll()` - returns the list from `DataHolder.dishes`
- `findByDishId(String dishId)` - returns the dish whose `dishId` matches the given parameter

---

## 5. Creating the `Service` Layer

### 5.1 `ChefService` Interface
Define the interface `ChefService` in the package `mk.ukim.finki.wp.lab.service`:
```java
public interface ChefService {
    List<Chef> listChefs();
    Chef findById(Long id);
    Chef addDishToChef(Long chefId, String dishId);
}
```

### 5.2 `DishService` Interface
Define the interface `DishService` in the package `mk.ukim.finki.wp.lab.service`:
```java
public interface DishService {
    List<Dish> listDishes();
    Dish findByDishId(String dishId);
}
```

### 5.3 Implementing the Services
Implement both services (`ChefServiceImpl` and `DishServiceImpl` classes).

`ChefService` should depend on `ChefRepository` and `DishRepository`.

The `addDishToChef` method should find the chef by `chefId`, find the dish by `dishId`, add the dish to the chef’s list of dishes, and then save the chef using the `save` method.

`DishService` should depend on `DishRepository`.

---

## 6. Creating the `Web` Layer (`Servlets`)

### 6.1 `ChefListServlet`
Create a servlet `ChefListServlet` in the package `mk.ukim.finki.lab.web` and map it to `/listChefs`.  
This servlet should depend on `ChefService` and display all chefs obtained from the `listChefs()` method.

Adapt the `listChefs.html` file for the appearance of this page.

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Restaurant Chefs - Welcome to Our Restaurant</title>
    <style type="text/css">
        body {
            width: 800px;
            margin: auto;
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to Our Restaurant</h1>
    </header>
    <main>
        <h2>Choose a chef:</h2>
        <form action="/dish" method="POST">
            <!-- Display radio buttons for each chef,
                 the value should be the chef id 
                 and the displayed text should be: 
                 Name: <firstName> <lastName>, Bio: <bio> -->
            <input type="radio" name="chefId" value="1"> Chef 1 <br/>
            <input type="radio" name="chefId" value="2"> Chef 2 <br/>
            <input type="radio" name="chefId" value="3"> Chef 3 <br/>
            <input type="submit" value="Submit">
        </form>
    </main>
</body>
</html>
```

---

### 6.2 `DishServlet`
After selecting a chef, a page with dishes should appear.  
Create a servlet `DishServlet` mapped to `/dish`.  
This servlet should depend on `DishService` and `ChefService`.

The servlet should:
- Read the selected `chefId` from the form
- Display a page for choosing a dish to add to the chef’s dish list
- Show all available dishes from `listDishes()`
- Display information about the selected chef
- Allow sending the necessary data to the next servlet

Adapt the `dishesList.html` file in the `src/main/resources/templates` folder for the appearance of this page.

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Add Dish to Chef</title>
    <style type="text/css">
        body {
            width: 800px;
            margin: auto;
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }
        table, td, th {
            border: 1px solid black;
            padding: 10px;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        section {
            float: left;
            margin: 0 1.5%;
            width: 63%;
        }
        aside {
            float: right;
            margin: 0 1.5%;
            width: 30%;
        }
    </style>
</head>
<body>
    <header>
        <h1>Select the Dish to add to the Chef</h1>
    </header>
    <section>
        <h2>Select dish:</h2>
        <form action="/chefDetails" method="POST">
            <!-- Dynamically display radio buttons for each dish -->
            <input type="radio" name="dishId" value="1"> Pasta Carbonara <br/>
            <input type="radio" name="dishId" value="2"> Beef Wellington <br/>
            <input type="radio" name="dishId" value="3"> Chicken Tikka Masala <br/>
            <br/>
            <input type="submit" value="Add dish">
        </form>
    </section>
    <aside>
        <table>
            <tr>
                <td><b>Chef ID</b></td>
                <td><!-- Display selected chefId --></td>
            </tr>
            <tr>
                <td><b>Chef Name</b></td>
                <td><!-- Display chef name --></td>
            </tr>
        </table>
    </aside>
</body>
</html>
```

**Note:** The value of each item in the radio list is the `dishId` of the dish.

---

### 6.3 `ChefDetailsServlet`
Create a servlet named `ChefDetailsServlet` mapped to `/chefDetails`.  
This servlet should depend on `ChefService` and `DishService`.

The servlet should:
- Read the data from the form (`chefId` and `dishId`)
- Find the selected chef and dish
- Add the dish to the chef’s list of dishes
- Display all details for the chef: name, biography, and all dishes the chef prepares

Adapt the `chefDetails.html` file for the appearance of this page.

```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Chef Details</title>
    <style type="text/css">
        body {
            width: 800px;
            margin: auto;
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            padding: 5px;
            margin: 5px 0;
            background-color: #f5f5f5;
            border-radius: 3px;
        }
    </style>
</head>
<body>
    <!-- Dynamically display data -->
    <header>
        <h1>Chef: Gordon Ramsay</h1>
    </header>
    <section>
        <h2>Bio: World-renowned chef with 16 Michelin stars</h2>
        <h2>Dishes prepared by this chef:</h2>
        <ul>
            <li>Beef Wellington (British, 45 min)</li>
            <li>Sticky Toffee Pudding (British, 30 min)</li>
        </ul>
    </section>
</body>
</html>
```