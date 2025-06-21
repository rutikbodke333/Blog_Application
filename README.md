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
# 📊 Entity Overview – Blog Application

## 👤 Users

Represents individuals using the blog platform (authors or admins).

- **ID** – Unique identifier for the user  
- **Name** – Full name of the user  
- **Email** – User's email address  
- **Password** – Encrypted password  
- **Role** – _Either_ `ROLE_USER` _or_ `ROLE_ADMIN`  
- **Posts** – List of blog posts authored by the user  

---

## 📝 Posts

Contains blog articles created by users.

- **PostID** – Unique identifier for the blog post  
- **Title** – Title of the post  
- **Content** – Body/content of the post  
- **ImageName** – Name of the image file attached to the post  
- **AddedDate** – Date when the post was created  
- **User** – _Reference to the user who authored the post_  
- **Category** – _Reference to the post's category_  
- **Comments** – List of comments under this post  

---

## 🗂️ Categories

Groups posts under specific topics or themes.

- **CategoryID** – Unique identifier for the category  
- **CategoryTitle** – Title or name of the category  
- **CategoryDescription** – Description of the category  
- **Posts** – List of posts associated with this category  

---

## 💬 Comments

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

---

#### 1️⃣ _**Register User**_
- **📌 Endpoint:** `POST /engineeringstudy/auth/register`
- **🛠️ Functionality:** Accepts user details and registers a normal user.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Register User](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/create%20new%20user.png?raw=true)

---

#### 2️⃣ _**Login User**_
- **📌 Endpoint:** `POST /engineeringstudy/auth/login`
- **🛠️ Functionality:** Authenticates user and returns a JWT token.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Login User](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/user%20login.png?raw=true)

---

#### 3️⃣ _**Create User Profile (Admin)**_
- **📌 Endpoint:** `POST /engineeringstudy/admin/users`
- **🛠️ Functionality:** Allows admin to create  accounts with admin role.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Create User Admin](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/create%20new%20admin.png?raw=true)

---

#### 4️⃣ _**Admin Login**_
- **📌 Endpoint:** `POST /engineeringstudy/auth/login`
- **🛠️ Functionality:** Authenticates admin and returns a JWT token.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Admin Login](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/admin%20login.png?raw=true)

---

#### 5️⃣ _**Get All Users (Admin)**_
- **📌 Endpoint:** `GET /engineeringstudy/user/allUsers`
- **🛠️ Functionality:**  fetch all registered users.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Get All Users](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/Get%20All%20Users.png?raw=true)

---

### 6️⃣ _**Update User (Admin/User)**_
- **📌 Endpoint:** `PUT /engineeringstudy/user/{id}`
- **🛠️ Functionality:** update user details by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Update User](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/Update%20user.png?raw=true)

---

### 7️⃣ _**Get User by ID**_
- **📌 Endpoint:** `GET /engineeringstudy/user/{id}`
- **🛠️ Functionality:** Fetch user data by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Get User by ID](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/Get%20the%20user%20by%20userId.png?raw=true)

---

#### 8️⃣ _**Delete User by ID**_
- **📌 Endpoint:** `DELETE /engineeringstudy/user/{id}`
- **🛠️ Functionality:**  delete user by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Delete User](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/Delete%20User.png?raw=true)

---

#### 9️⃣ _**Create Announcement (Admin)**_
- **📌 Endpoint:** `POST /engineeringstudy/admin/announcements`
- **🛠️ Functionality:**  create a new announcement.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Create Announcement](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/Add%20announcemnt.png?raw=true)

---

#### 🔟 _**Get All Announcements**_
- **📌 Endpoint:** `GET /engineeringstudy/announcements`
- **🛠️ Functionality:** Returns all announcements visible to users.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Get All Announcements](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/Get%20all%20announcemnt.png?raw=true)

---

#### 1️⃣1️⃣ _**Get Announcement by ID**_
- **📌 Endpoint:** `GET /engineeringstudy/admin/announcements/{announcementId}`
- **🛠️ Functionality:** Fetch specific announcement by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Get Announcement by ID](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/get%20announcemnt%20by%20id.png?raw=true)

---

#### 1️⃣2️⃣ _**Update Announcement by ID**_
- **📌 Endpoint:** `PUT /engineeringstudy/admin/announcements/{announcementId}`
- **🛠️ Functionality:** Admin updates announcement details by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Update Announcement](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/update%20announcement%20by%20announcementId.png?raw=true)

---

#### 1️⃣3️⃣ _**Upload PDF (User)**_
- **📌 Endpoint:** `POST engineeringstudy/user/documents/upload/1?documentType=PDF&branch=Computer%20Engineering&semester=6&academicYear=2023-24&department=Engineering`
- **🛠️ Functionality:** Upload a document with metadata.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Upload PDF](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/upload%20new%20document.png?raw=true)

---

#### 1️⃣4️⃣ _**Get All Documents**_
- **📌 Endpoint:** `GET /engineeringstudy/user/documents`
- **🛠️ Functionality:** Fetch all uploaded documents.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Get All Documents](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/get%20all%20documents.png?raw=true)

---

#### 1️⃣5️⃣ _**Get Document by ID**_
- **📌 Endpoint:** `GET /engineeringstudy/user/documents/{id}`
- **🛠️ Functionality:** Fetch document details by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Get Document by ID](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/get%20document%20by%20id.png?raw=true)

---

#### 1️⃣6️⃣ _**Delete Document by ID**_
- **📌 Endpoint:** `DELETE /engineeringstudy/user/documents/{id}`
- **🛠️ Functionality:** Delete document by ID.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Delete Document](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/delete%20the%20document%20based%20id.png?raw=true)

---

#### 1️⃣7️⃣ _**Convert Percentage to CGPA (User)**_
- **📌 Endpoint:** `GET /engineeringstudy/user/convert?percentage=85`
- **🛠️ Functionality:** Returns CGPA equivalent of given percentage.
- **🧪 Tested with:** Postman  
- **🖼️ Screenshot:**  
  ![Convert Percentage to CGPA](https://github.com/rutikbodke333/Engineering_Study_Application/blob/main/images/cgpa%20to%20percentage.png?raw=true)

---


