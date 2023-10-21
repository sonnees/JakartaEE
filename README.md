# REST API Jakarta EE
- Sinh viên: **Nguyễn Văn Sơn**
- Hướng dẫn: **TS. Võ Văn Hải**
- Thời gian: từ **17/09/2023**  đến **01/10/2023**

![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=black)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=black)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)

  <hr>

- **Ý tưởng:** Lập 1 `REST API` cho trang web bán hàng. <br>
- **Sử dụng:** `REST API Jakarta EE`  `CRUD JPA` <br>
- **Mô tả:** <br>
  - Các thao tác  `CRUD` cho các đối tượng, lập order. <br>
  - Thống kê order theo ngày, theo khoảng thời gian.<br>
  - Thống kê order theo nhân viên bán hàng trong 1 khoảng thời gian.<br>
  - Tạo giao diện đển tương tác dể hơn.
<br>

**Diagram:**

  ![ERD](/img/ERD_lab02.png)
<br> <br>
```git
git clone -b Lab02 --single-branch https://github.com/sonnees/JakartaEE.git
```

<details>
  <summary><h3>👇 Back end</h3> </summary>
  <hr>
  
# BACK-END

## 1. Product:
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

## 2. ProductPrice:
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

## 3. ProductImage:
  > GET <br>
  >> .../api/ProductImage  <br>
  >> .../api/ProductImage/{id}  <br>

  > POST <br>
  >> .../api/ProductImage  <br>
  >> .../api/ProductImage/add-list  <br>

  > PUT <br>
  >> .../api/ProductImage/{id}  <br>
  >> .../api/ProductImage/{id}/update-field  <br>

  >DELETE <br>
  >> .../api/ProductImage/{id}  <br>
  >> .../api/ProductImage/delete-multiple  <br>

## 4. Customer:
  > GET <br>
  >> .../api/Customer  <br>
  >> .../api/Customer/{id}  <br>
  >> .../api/Customer/{x}-{y}  <br>

  > POST <br>
  >> .../api/Customer  <br>
  >> .../api/Customer/add-list  <br>

  > PUT <br>
  >> .../api/Customer/{id}  <br>
  >> .../api/Customer/{id}/update-field  <br>

  >DELETE <br>
  >> .../api/Customer/{id}  <br>
  >> .../api/Customer/delete-multiple  <br>

## 5. Employee:
  > GET <br>
  >> .../api/Employee  <br>
  >> .../api/Employee/{id}  <br>
  >> .../api/Employee/{x}-{y}  <br>

  > POST <br>
  >> .../api/Employee  <br>
  >> .../api/Employee/add-list  <br>

  > PUT <br>
  >> .../api/Employee/{id}  <br>
  >> .../api/Employee/{id}/update-field  <br>

  >DELETE <br>
  >> .../api/Employee/{id}  <br>
  >> .../api/Employee/delete-multiple  <br>

## 6. Orders:
  > GET <br>
  >> .../api/Orders  <br>
  >> .../api/Orders/{id}  <br>
  >> .../api/Orders/{x}-{y}  <br>
   
  > POST <br>
  >> .../api/Orders  <br>
  >> .../api/Orders/add-list  <br>
  >> .../api/Orders/Anal-Year-Month-Day  <br>
  >> .../api/Orders/Anal-Years-Months  <br>
   
  > PUT <br>
  >> .../api/Orders/{id}  <br>
  >> .../api/Orders/{id}/update-field  <br>

  > DELETE <br>
  >> .../api/Orders/{id}  <br>
  >> .../api/Orders/delete-multiple  <br>

## 7. OrderDetail:
  > GET <br>
  >> .../api/OrderDetail/{id}  <br>

  > POST <br>
  >> .../api/Orders  <br>
  >> .../api/Orders/add-list  <br>

  > PUT <br>
  >> .../api/Orders/{id}  <br>
  >> .../api/Orders/{id}/update-field  <br>

  > DELETE <br>
  >> .../api/Orders/{id}  <br>
  >> .../api/Orders/delete-multiple  <br>
</details>

<details>
  <summary><h3>👇 Front end </h3> </summary>
  <hr>
  
# FRONT-END 
 
- Ý tưởng: Tạo giao diện trang web bán hàng. <br>
- Sử dụng: `Servlet Jakarta EE` <br>
- Mô tả:<br>
  - Chạy song song với phần backend ở trên để lấy dữ liệu <br>
  - Role Admin: `CRUD` các đối tượng, thống kê <br>
  - Role User: xem sản phẩm, bỏ sản phẩm vào giỏ hàng
</details>







