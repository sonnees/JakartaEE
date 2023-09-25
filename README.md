# Projects Jakarta EE
- Sinh viên: **Nguyễn Văn Sơn**
- Hướng dẫn: **TS. Võ Văn Hải**

![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=black)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=black)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)

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








