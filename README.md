# 📚 HỆ THỐNG QUẢN LÝ TIỆM SÁCH

![Java](https://img.shields.io/badge/Java-blue)
![MySQL](https://img.shields.io/badge/MySQL-orange)
![Swing](https://img.shields.io/badge/GUI-Swing-yellowgreen)

## 🎯 GIỚI THIỆU DỰ ÁN
Ứng dụng Java Swing quản lý nhà sách với phân quyền Admin/User, xây dựng theo mô hình 3 lớp.

## ✨ TÍNH NĂNG CHÍNH

### 👨‍💼 QUẢN TRỊ VIÊN
| Tính năng | Mô tả |
|----------|-------|
| 📖 Thêm sách | Thêm đầu sách mới vào kho |
| ✏️ Sửa sách | Cập nhật thông tin sách |
| 🗑️ Xóa sách | Loại bỏ sách khỏi hệ thống |
| 🔍 Xem sách | Xem chi tiết thông tin sách |

### 👤 NGƯỜI DÙNG
| Tính năng | Mô tả |
|----------|-------|
| 📚 Thuê sách | Đăng ký mượn sách từ nhà sách |
| 🔙 Trả sách | Hoàn trả sách đã thuê |
| 🔎 Tìm sách | Xem thông tin chi tiết sách |

### 🔒 BẢO MẬT
- Mã hóa mật khẩu bằng BCrypt
- Phân quyền nghiêm ngặt Admin/User

## 🛠 CÔNG NGHỆ
- **Ngôn ngữ**: Java
- **Giao diện**: Java Swing (IntelliJ GUI Form)
- **Kiến trúc**: 3 lớp (Presentation-Business-Data)
- **Database**: MySQL
- **Bảo mật**: BCrypt

## 🚀 CÀI ĐẶT

### Yêu cầu
- JDK 17+
- MySQL Server 8.0
- IntelliJ IDEA (khuyên dùng)

### Hướng dẫn
1. **Clone dự án**:
   ```bash
   git clone https://github.com/BestYuuta/JavaMiniProject-BookStore.git
2. **Cấu hình database**:
- Tạo database quanly_nhasach
- Chạy file SQL trong thư mục database/
3. **Cấu hình ứng dụng**:
- Sửa file src/Config/dbHelper.java

  ```bash
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
4. **Chạy chương trình**:
Mở file Main.java và Run
### 👥 TÀI KHOẢN MẪU
| Username | Password |
|----------|-------|
| admin | admin |

