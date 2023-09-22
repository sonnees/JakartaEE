# REST API Jakarta EE
- Sinh viên: **Nguyễn Văn Sơn**
- Hướng dẫn: **TS. Võ Văn Hải**

![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=black)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=black)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)

  <hr>

- Ý tưởng: Lập 1 API cho trang web bán hàng.
- Sử dụng: REST API Jakarta EE, CRUD JPA
- Mô tả:
  > Các thao tác CRUD cho các đối tượng, lập order. <br>
  > Thống kê order theo ngày, theo khoảng thời gian.<br>
  > Thống kê order theo nhân viên bán hàng trong 1 khoảng thời gian.
-  Entity Relationship Diagram:
  
    ![ERD](/img/ERD_lab02.png)
<br> <br>
> *[code tại đây](https://github.com/sonnees/JakartaEE/tree/Lab02)*
> ```git
> git clone -b Lab02 --single-branch https://github.com/sonnees/JakartaEE.git
> ```

<hr>

1. Product:
    > GET <br>
    >> .../api/Product  <br>
    >> .../api/Product/{id}  <br>
    >>.../api/Product/{x}-{y}  <br>

    > POST <br>
    >> .../api/Product  <br>
    >> .../api/Product/add-list  <br>

    > PUT <br>
    >> .../api/Product/{id}  <br>
    >> .../api/Product/{id}/update-field  <br>

    >DELETE <br>
    >> .../api/Product/{id}  <br>
    >> .../api/Product/delete-multiple  <br>

2. ProductPrice:
    >GET <br>
    >> .../api/ProductPrice/{product_id}  <br>
    >> .../api/ProductPrice/{product_id}/{x}-{y}  <br>

    >POST <br>
    >> .../api/ProductPrice  <br>
    >> .../api/ProductPrice/add-list  <br>

    > PUT <br>
    >> .../api/ProductPrice/{product_id}/update-field  <br>

    >DELETE <br>
    >> .../api/Product  <br>
    >> .../api/Product/delete-multiple  <br>











