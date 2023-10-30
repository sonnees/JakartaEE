# Quản Lý Đăng Nhập
- Sinh viên: **Nguyễn Văn Sơn**
- Hướng dẫn: **TS. Võ Văn Hải**
- Thời gian: từ **10/09/2023**  đến **17/10/2023**
  
![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=black)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=black)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)

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









