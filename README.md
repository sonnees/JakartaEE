```
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"  crossorigin="anonymous"></script>
```
```
compileOnly('jakarta.platform:jakarta.jakartaee-web-api:9.1.0')
implementation('org.hibernate:hibernate-core:6.0.2.Final')
implementation('org.glassfish.jaxb:jaxb-runtime:3.0.2')
implementation('org.glassfish:jakarta.faces:3.0.3')

testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
implementation 'org.mariadb.jdbc:mariadb-java-client:3.2.0'

implementation 'org.glassfish.web:jakarta.servlet.jsp.jstl:2.0.0'
implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:2.0.0'
```
```
<class></class>
<properties>
  <property name="jakarta.persistence.jdbc.driver" value="org.mariadb.jdbc.Driver"/>
  <property name="jakarta.persistence.jdbc.url" value="jdbc:mariadb://localhost:3306/gk?createDatabaseIfNotExist=true"/>
  <property name="jakarta.persistence.jdbc.password" value="password"/>
  <property name="jakarta.persistence.jdbc.user" value="root"/>

  <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
  <property name="hibernate.show_sql" value="true" />
  <property name="hibernate.hbm2ddl.auto" value="update" />
  <property name="hibernate.format_sql" value="true" />
</properties>
```


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









