# Projects Jakarta EE
- Sinh viên: **Nguyễn Văn Sơn**
- Hướng dẫn: **TS. Võ Văn Hải**

![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=black)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=black)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
![Spring Boot Badge](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff&style=for-the-badge)
# Branchs
<details>
  <summary><h3>👇 Lab01</h3> </summary>
  <hr>

- Ý tưởng: Quản lý đăng nhập.
- Sử dụng: Servlet Jakarta EE, JSP, CRUD JPA.
- Mô tả:
  > Một trang html hiển thị cửa sổ đăng nhập. Nếu đăng nhập thành công và là quyền admin
  thì hiển thị trang dashboard cho phép quản lý các account khác (bao gồm các quyền thêm,
  xóa, sửa và cấp quyền). Còn không (không phải admin) thì hiển thị thông tin của người
  đăng nhập cùng các quyền mà người đó có.
  >
  > Ghi log mỗi lần account đăng nhập, đăng xuất.
-  Entity Relationship Diagram:
  
    ![ERD](/img/ERD_lab01.png)
<br> <br>
> *[code tại đây](https://github.com/sonnees/JakartaEE/tree/Lab01)*
> ```git
> git clone -b Lab01 --single-branch https://github.com/sonnees/JakartaEE.git
> ```
</details>
<details>
  <summary><h3>👇 Lab02</h3> </summary>
  <hr>

1. **BackEnd** <br>
   - Ý tưởng: Lập 1 API cho trang web bán hàng. <br>
   - Sử dụng: REST API Jakarta EE, CRUD JPA <br>
   - Mô tả:<br>
     > Các thao tác CRUD cho các đối tượng, lập order. <br>
     > Thống kê order theo ngày, theo khoảng thời gian.  <br>
     > Thống kê order theo nhân viên bán hàng trong 1 khoảng thời gian. <br>
    - Entity Relationship Diagram:
  
       ![ERD](/img/ERD_lab02.png)
<br>

2. **FrontEnd** 
   - Ý tưởng: Tạo giao diện trang web bán hàng. <br>
   - Sử dụng: Servlet Jakarta EE <br>
   - Mô tả:<br>
     > Chạy song song với phần backend ở trên để lấy dữ liệu <br>
     > Role Admin: CRUD các đối tượng, thống kê <br>
     > Role User: xem sản phẩm, bỏ sản phẩm vào giỏ hàng
<br>
    <hr>
    
*[code tại đây](https://github.com/sonnees/JakartaEE/tree/Lab02)*
```git
git clone -b Lab02 --single-branch https://github.com/sonnees/JakartaEE.git
 ```
<br>
</details>

<details>
  <summary><h3>👇 Lab03</h3> </summary>
  <hr>

- Ý tưởng: Làm quen với Spring Boot.
- Sử dụng: Spring Boot, Spring Data - JdbcTemplate.
- Mô tả:
  > Ánh xạ các entity. <br>
  > Sử dụng JdbcTemplate để thao tác. Mục đích là hiểu được cốt lõi, sau này nếu Spring có sự thay đổi thì dể thích nghi hơn. <br>
  > Làm quen với Unit Test. <br>
-  Diagram:

    ![ERD](/img/ERD_lab03.png)
<br> <br>
> *[code tại đây](https://github.com/sonnees/JakartaEE/tree/Lab03)*
> ```git
> git clone -b Lab03 --single-branch https://github.com/sonnees/JakartaEE.git
> ```
</details>

<details>
  <summary><h3>👇 Lab04</h3> </summary>
  <hr>

  - Ý tưởng: Làm quen với Spring Boot. <br>
- Sử dụng: Spring Boot, Spring Data <br>
- Mô tả: <br>
  > Ánh xạ các entity, viết các lớp interface repository hiện thực từ interface JpaRepository  <br>
  > Làm quen với Spring Boot - REST API  <br>
  > (Đang hoàn thiện thêm các chức năng khác ...)  <br>
<br>

Diagram:

  ![ERD](/img/ERD_lab04.png)
<br> <br>
*[code tại đây](https://github.com/sonnees/JakartaEE/tree/Lab04)*
```git
git clone -b Lab04 --single-branch https://github.com/sonnees/JakartaEE.git
```
</details>








