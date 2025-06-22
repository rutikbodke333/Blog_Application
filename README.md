# 🎓 Blog Application
 

![SpringBoot](https://img.shields.io/badge/SpringBoot-2.7-green)  
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)  
![JPA](https://img.shields.io/badge/JPA-Hibernate-orange)  
![GitHub](https://img.shields.io/badge/GitHub-VersionControl-green)  
![Postman](https://img.shields.io/badge/Postman-API%20Testing-orange)
![JWT](https://img.shields.io/badge/JWT-Authentication-blue)


 ---

## 🚀 The Problem Statement and solution

In today’s digital age, individuals and organizations seek platforms to share ideas, express opinions, and publish content online. However, most traditional social media platforms limit customization, lack content organization, and don’t provide the structure needed for serious content creators. Many bloggers, writers, and professionals struggle to find a space where they can publish their thoughts in a clear, meaningful, and organized way—without distractions.

To solve this problem, I developed the Blog Application—a simple and powerful platform where users can create, update, and manage their own blog posts with ease. The application allows users to categorize their blogs, making content easier to discover and more meaningful to read. It also includes a commenting feature, so readers can engage in discussions and share their thoughts directly on each post. 




---
## 📊 Entity Overview – Blog Application

### 👤 Users

Represents individuals using the blog platform (authors or admins).

- **ID**   
- **Name** 
- **Email** 
- **Password**  
- **Role** – `ROLE_USER` _or_ `ROLE_ADMIN`  

---

### 📝 Posts

Contains blog articles created by users.

- **PostID** 
- **Title** 
- **Content** 
- **ImageName** 
- **AddedDate** 
- **User** –   Reference variable of User entity for mapping
- **Category** – Reference variable of Category entity for mapping 
- **Comments** –  List of comments associated with this post  

---

### 🗂️ Categories

Groups posts under specific topics or themes.

- **CategoryID** 
- **CategoryTitle** 
- **CategoryDescription**   
- **Posts** – List of posts associated with this category  

---

### 💬 Comments

Captures user feedback or interaction on posts.

- **ID** – Unique identifier for the comment  
- **Content** – Text content of the comment  
- **Post** – _Reference to the blog post associated with the comment_  

---


## 🧑‍💻 User Roles

The system supports two main user roles:

### ✅ Admin:
- Admin manages users, blog posts, categories, and comments to ensure the platform runs smoothly.
- Admin have full control to view, update, or delete any content and user accounts. 
 

### ✅ User:
- Users can create, update, and delete their profiles	         
- Users can create new blog posts, update existing ones, delete posts, and retrieve all posts  
- Users can create new categories, update categories, delete categories, and fetch all existing categories
- Users can also add comments to posts and delete comments when needed, enhancing user interaction  and engagement.

 

---

## 📌 Main Modules – Blog Application

- **Auth Module** – Handles user registration, login, and role-based access (`ROLE_USER`, `ROLE_ADMIN`)  
- **User Management Module** – Admins manage user accounts, update user roles, and delete users  
- **Post Module** – Users create, update, delete, and view blog posts  
- **Category Module** – Admins and users categorize posts for better content organization  
- **Comment Module** – Allows users to add, edit, or delete comments on blog posts  
- **Search & Pagination Module** – Enables searching blog posts by keywords and browsing posts with pagination  


  ## 🛠 Technologies Used

- **Backend:** Spring Boot,  Hibernate, JPA  
- **Database:** MySQL  
- **Security:** JWT-based authentication, role-based access control  
- **Build Tool:** Maven  
- **Version Control:**  Git & GitHub

---



## 🔐 Security Features

- JWT-based token authentication  
- Role-based access control (**ADMIN / USER**)  
- Secure password storage using hashing (e.g., BCrypt)  
- Stateless session management  

---

## 📡 API Endpoints

# 📡 API Endpoints – Engineering Study Application

---

## 🔐 Authentication & Users

### 1️⃣ _**Register User**_
- **📌 Endpoint:** `POST /engineeringstudy/auth/register`
- **🛠️ Functionality:** Registers a normal user.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Register User](https://github.com/rutikbodke333/Blog_Application/blob/main/images/register%20user.png?raw=true)

---

### 2️⃣ _**Login User**_
- **📌 Endpoint:** `POST /engineeringstudy/auth/login`
- **🛠️ Functionality:** Authenticates user and returns a JWT token.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Login User](https://github.com/rutikbodke333/Blog_Application/blob/main/images/login%20user.png?raw=true)

---

### 3️⃣ _**Create User Profile (Admin)**_
- **📌 Endpoint:** `POST /engineeringstudy/admin/users`
- **🛠️ Functionality:** Creates an account with admin role.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Create Admin](https://github.com/rutikbodke333/Blog_Application/blob/main/images/register%20admin.png?raw=true)

---

### 4️⃣ _**Admin Login**_
- **📌 Endpoint:** `POST /engineeringstudy/auth/login`
- **🛠️ Functionality:** Authenticates admin and returns a JWT token.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Admin Login](https://github.com/rutikbodke333/Blog_Application/blob/main/images/Admin%20login.png?raw=true)

---

### 5️⃣ _**Find All Users (Admin)**_
- **📌 Endpoint:** `GET /engineeringstudy/user/allUsers`
- **🛠️ Functionality:** Fetch all registered users.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![All Users](https://github.com/rutikbodke333/Blog_Application/blob/main/images/fetch%20all%20users.png?raw=true)

---

### 6️⃣ _**Update User (Admin/User)**_
- **📌 Endpoint:** `PUT /engineeringstudy/user/{id}`
- **🛠️ Functionality:** Update user details by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Update User](https://github.com/rutikbodke333/Blog_Application/blob/main/images/update%20user.png?raw=true)

---

### 7️⃣ _**Find User by ID**_
- **📌 Endpoint:** `GET /engineeringstudy/user/{id}`
- **🛠️ Functionality:** Fetch user data by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![User by ID](https://github.com/rutikbodke333/Blog_Application/blob/main/images/Find%20User%20by%20userId.png?raw=true)

---

### 8️⃣ _**Delete User**_
- **📌 Endpoint:** `DELETE /engineeringstudy/user/{id}`
- **🛠️ Functionality:** Delete user by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Delete User](https://github.com/rutikbodke333/Blog_Application/blob/main/images/Delete%20User.png?raw=true)

---

## 🗂️ Categories

### 9️⃣ _**Create Category**_
- **📌 Endpoint:** `POST /engineeringstudy/category/`
- **🛠️ Functionality:** Create a new category.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Create Category](https://github.com/rutikbodke333/Blog_Application/blob/main/images/add%20category.png?raw=true)

---

### 🔟 _**Find All Categories**_
- **📌 Endpoint:** `GET /engineeringstudy/category/`
- **🛠️ Functionality:** Fetch all categories.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![All Categories](https://github.com/rutikbodke333/Blog_Application/blob/main/images/find%20all%20categories.png?raw=true)

---

### 1️⃣1️⃣ _**Update Category**_
- **📌 Endpoint:** `PUT /engineeringstudy/category/{id}`
- **🛠️ Functionality:** Update category by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Update Category](https://github.com/rutikbodke333/Blog_Application/blob/main/images/update%20category.png?raw=true)

---

### 1️⃣2️⃣ _**Get Category by ID**_
- **📌 Endpoint:** `GET /engineeringstudy/category/{id}`
- **🛠️ Functionality:** Fetch category by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Category by ID](https://github.com/rutikbodke333/Blog_Application/blob/main/images/find%20category%20by%20CategoryId.png?raw=true)

---

### 1️⃣3️⃣ _**Delete Category**_
- **📌 Endpoint:** `DELETE /engineeringstudy/category/{id}`
- **🛠️ Functionality:** Delete category by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Delete Category](https://github.com/rutikbodke333/Blog_Application/blob/main/images/Delete%20Category.png?raw=true)

---

## 📝 Posts

### 1️⃣4️⃣ _**Create Post**_
- **📌 Endpoint:** `POST /engineeringstudy/posts/`
- **🛠️ Functionality:** Create a new blog post.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Create Post](https://github.com/rutikbodke333/Blog_Application/blob/main/images/create%20post.png?raw=true)

---

### 1️⃣5️⃣ _**Update Post**_
- **📌 Endpoint:** `PUT /engineeringstudy/posts/{id}`
- **🛠️ Functionality:** Update a blog post.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Update Post](https://github.com/rutikbodke333/Blog_Application/blob/main/images/update%20post.png?raw=true)

---

### 1️⃣6️⃣ _**Find All Posts**_
- **📌 Endpoint:** `GET /engineeringstudy/posts/`
- **🛠️ Functionality:** Fetch all blog posts.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![All Posts](https://github.com/rutikbodke333/Blog_Application/blob/main/images/fetch%20all%20post.png?raw=true)

---

### 1️⃣7️⃣ _**Find Post by ID**_
- **📌 Endpoint:** `GET /engineeringstudy/posts/{id}`
- **🛠️ Functionality:** Fetch post by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Post by ID](https://github.com/rutikbodke333/Blog_Application/blob/main/images/find%20post%20by%20postId.png?raw=true)

---

### 1️⃣8️⃣ _**Get All Posts by a Specific User**_
- **📌 Endpoint:** `GET /engineeringstudy/posts/user/{userId}`
- **🛠️ Functionality:** Fetch posts created by a specific user.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Posts by User](https://github.com/rutikbodke333/Blog_Application/blob/main/images/Get%20All%20Posts%20by%20a%20Specific%20User.png?raw=true)

---

### 1️⃣9️⃣ _**Get All Posts by Category**_
- **📌 Endpoint:** `GET /engineeringstudy/posts/category/{categoryId}`
- **🛠️ Functionality:** Fetch all posts in a specific category.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Posts by Category](https://github.com/rutikbodke333/Blog_Application/blob/main/images/Get%20All%20Posts%20by%20Category.png?raw=true)

---

### 2️⃣0️⃣ _**Delete Post**_
- **📌 Endpoint:** `DELETE /engineeringstudy/posts/{id}`
- **🛠️ Functionality:** Delete a blog post.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Delete Post](https://github.com/rutikbodke333/Blog_Application/blob/main/images/delete%20the%20post.png?raw=true)

---

## 💬 Comments

### 2️⃣1️⃣ _**Create Comment**_
- **📌 Endpoint:** `POST /engineeringstudy/comments/`
- **🛠️ Functionality:** Create a new comment on a post.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Create Comment](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/admin%20login.png?raw=true)

---

### 2️⃣2️⃣ _**Update Comment**_
- **📌 Endpoint:** `PUT /engineeringstudy/comments/{id}`
- **🛠️ Functionality:** Update a comment.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Update Comment](https://github.com/rutikbodke333/Blog_Application/blob/main/images/update%20comment.png?raw=true)

---

### 2️⃣3️⃣ _**Fetch All Comments**_
- **📌 Endpoint:** `GET /engineeringstudy/comments/`
- **🛠️ Functionality:** Retrieve all comments.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![All Comments](https://github.com/rutikbodke333/Blog_Application/blob/main/images/Get%20All%20Comments.png?raw=true)

---

### 2️⃣4️⃣ _**Find Comment by Comment ID**_
- **📌 Endpoint:** `GET /engineeringstudy/comments/{id}`
- **🛠️ Functionality:** Fetch comment by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Comment by ID](https://github.com/rutikbodke333/Blog_Application/blob/main/images/Get%20Comment%20by%20commentId.png?raw=true)

---

### 2️⃣5️⃣ _**Delete Comment**_
- **📌 Endpoint:** `DELETE /engineeringstudy/comments/{id}`
- **🛠️ Functionality:** Delete comment by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Delete Comment](https://github.com/rutikbodke333/Blog_Application/blob/main/images/delete%20the%20post.png?raw=true)
