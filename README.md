# Spring Security, Primary and Secondary Datasource
- Sinh viên: **Nguyễn Văn Sơn**
- Hướng dẫn: **TS. Võ Văn Hải**
- Thời gian: từ **26/11/2023**  đến **03/11/2023**

![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=black)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=mariadb&logoColor=black)
<img src="https://th.bing.com/th/id/R.d433e5db311d0fe02f52e4db3b5cc743?rik=sNF4YqL55B8yYQ&riu=http%3a%2f%2fh2database.com%2fhtml%2fimages%2fh2-logo-2.png&ehk=IBnDTb4FFDrxdQ3V3Pbd6ZLsqndsNau6X862s8MAijg%3d&risl=&pid=ImgRaw&r=0?style=for-the-badge&logo=mariadb&logoColor=black" alt="MariaDB Badge" height="28" width="100">
![Spring Boot Badge](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=fff&style=for-the-badge)

  <hr>

## Spring Security
- Làm quen với spring security.
- Authentication: Bằng User name và User password lưu vào memory (inMemoryAuthentication) hoặc xuống database (jdbcAuthentication).
- Authorization: Khi đã xác thực thành công người dùng, dựa vào role, người dùng có thể sử dụng các dịch vụ được cấp từ trước.

## Primary and Secondary Datasource
- Secondary datasource (H2 database): Lưu các thực thể liên quan đến session và security.
- Primary datasource (Maria database): Lưu các thực thể còn lại.

<br>

```git
git clone -b Lab08 --single-branch https://github.com/sonnees/JakartaEE.git
```
 








