# API Library
Repository untuk REST API Library App  

## How to Run
Untuk menjalankannya, clone dan jalankan perintah berikut:   
```mvnw spring-boot:run```

## List of Service Methods
- Authentication:
  - **Sign Up**: POST - http://localhost:9098/users
  - **Sign In**: POST - http://localhost:9098/users/login
  - **forgot pass**: PUT - http://127.0.0.1:9098/users/login
- news:
  - **Create news**: POST - http://127.0.0.1:9098/user/news
  - **Get All news or Get news by Deleted**: GET - http://127.0.0.1:9098/admin/news?deleted=false
  - **Get news By Id**: GET - http://127.0.0.1:9098/guest/6cc2d529-2bba-4c03-bf02-fa4de3c11f4c 
  <!-- - **Update Book**: PUT -  -->
  - **Delete Book**: DELETE - http://127.0.0.1:9098/admin/05f6afa8-2efe-4c53-83fa-09239dd8a1c9
- komentar:
  - **create komentar**: POST - http://127.0.0.1:9098/guest/komentar
  - **get komentar**: GET - http://127.0.0.1:9098/guest/komentar
  - **get komentar by id**: GET - http://127.0.0.1:9098/guest/komentar/1c3c8e10-0e79-4b70-84e8-8b4d138695a1
  - **delete komentar by id**: DELETE - http://127.0.0.1:9098/admin/komentar/1c3c8e10-0e79-4b70-84e8-8b4d138695a1
- recomended:
  - **add Recomended**: POST - http://127.0.0.1:9098/admin/recomended
  - **get Recomended**: GET -  http://127.0.0.1:9098/guest/recomended
- trending:
  - **get Trending**: GET - http://127.0.0.1:9098/guest/trending?deleted=false
- latest:
  - **get latest**: GET - http://127.0.0.1:9098/guest/latest
- image:
  - **create image**: POST - http://127.0.0.1:9098/admin/files/news
  - **get image**: GET - http://127.0.0.1:9098/guest/files/news/f30fa948-bd40-4f77-937d-d186d8429d0e

## Documentation API Online
For complete documentation REST API and example request body, can access to this link: **https://documenter.getpostman.com/view/24726848/2s9YBz3vT1#dcb4f288-b5dd-494c-9430-302db8c7b6da**

#

## Happy Coding~