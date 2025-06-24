# Inventory Management System

## 📦 Brief Description

The **Inventory Management System** is a powerful desktop application designed to streamline the management of products, sales, suppliers, customers, employees, and reporting for businesses. Built with Java Swing for the user interface and MySQL for persistent data storage, this project offers a secure, user-friendly environment for administrators to efficiently handle day-to-day inventory and sales operations. The system supports full CRUD (Create, Read, Update, Delete) operations for all modules, real-time stock updates, and features a modern dashboard for easy navigation. Ideal for small to medium-sized businesses, retail stores, or as a learning project for mastering Java GUI development and database integration.

---

## ✨ Features

- **Dashboard**: Central hub to access all inventory, sales, and management features.
- **Product Management**:
  - Add, update, delete, and search products.
  - Track barcode, price, quantity, and supplier.
- **Customer Management**:
  - Maintain a searchable customer database.
  - Store contact information.
- **Supplier Management**:
  - Manage supplier records and contact details.
- **Employee Management**:
  - Add, update, and remove employee records.
- **Sales & Invoicing**:
  - Create sales, generate invoices, manage payments (PAID/UNPAID/PARTIAL), and calculate balances.
- **Reporting**:
  - Generate and print detailed sales and invoice reports.
- **Real-Time Inventory**: Automatic stock updates on sales and purchases.
- **Modern GUI**: Built with Java Swing and NetBeans GUI designer for a clean, intuitive interface.

---

## 🗂️ Project Structure

```
InventoryManagement/
├── src/
│   └── inventorymanagement/
│       ├── db.java
│       ├── Home.java / .form
│       ├── product.java / .form
│       ├── customer.java / .form
│       ├── supplier.java / .form
│       ├── employee.java / .form
│       ├── sales.java / .form
│       ├── Invoice.java / .form
│       ├── report.java
│       └── icons/
├── nbproject/
├── build.xml
├── manifest.mf
└── test/
```

---

## 🛠️ Technologies Used

- **Java Swing**: For building the graphical user interface.
- **MySQL**: Relational database for persistent storage.
- **JDBC**: Java Database Connectivity for MySQL integration.
- **NetBeans IDE**: (Recommended) for GUI design and project management.
- **Apache Ant**: For building and running the project.

---

## 🗄️ Database Schema

The MySQL database includes the following tables:

### `product`
| Column       | Type         | Description           |
|------------- |-------------|----------------------|
| pid          | INT         | Product ID (PK)      |
| product_name | VARCHAR     | Name of product      |
| barcode      | VARCHAR     | Barcode              |
| price        | DECIMAL     | Price per unit       |
| qty          | INT         | Quantity in stock    |
| sid          | INT         | Supplier ID (FK)     |

### `customer`
| Column        | Type         | Description           |
|-------------- |-------------|----------------------|
| cid           | INT         | Customer ID (PK)     |
| customer_name | VARCHAR     | Name of customer     |
| Tp_Number     | VARCHAR     | Contact number       |

### `supplier`
| Column        | Type         | Description           |
|-------------- |-------------|----------------------|
| sid           | INT         | Supplier ID (PK)     |
| supplier_name | VARCHAR     | Name of supplier     |
| Tp_Number     | VARCHAR     | Contact number       |

### `employee`
| Column        | Type         | Description           |
|-------------- |-------------|----------------------|
| eid           | INT         | Employee ID (PK)     |
| employee_name | VARCHAR     | Name of employee     |
| Tp_Number     | VARCHAR     | Contact number       |

### `sale`
| Column        | Type         | Description           |
|-------------- |-------------|----------------------|
| SaleID        | INT         | Sale ID (PK)         |
| INID          | INT         | Invoice number       |
| Cid           | INT         | Customer ID (FK)     |
| Customer_Name | VARCHAR     | Customer name        |
| Total_Qty     | INT         | Total quantity       |
| Total_Bill    | DECIMAL     | Total bill amount    |
| Status        | VARCHAR     | Payment status       |
| Balance       | DECIMAL     | Remaining balance    |

### `cart`
| Column        | Type         | Description           |
|-------------- |-------------|----------------------|
| INID          | INT         | Invoice number (FK)  |
| product_name  | VARCHAR     | Name of product      |
| barcode       | VARCHAR     | Barcode              |
| qty           | INT         | Quantity             |
| Unit_price    | DECIMAL     | Price per unit       |
| Total_price   | DECIMAL     | Total price          |

### `extra`
| Column        | Type         | Description           |
|-------------- |-------------|----------------------|
| exid          | INT         | Setting ID (PK)      |
| val           | VARCHAR     | Value                |

> **Note:** You must create the MySQL database and tables before running the application. Table creation scripts are not included by default.

---

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher
- MySQL Server
- NetBeans IDE (recommended)
- MySQL JDBC Driver (Connector/J)

### Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/yourusername/InventoryManagement.git
   cd InventoryManagement
   ```

2. **Database Setup:**
   - Create a new MySQL database (e.g., `inventory`).
   - Create the required tables as per the [Database Schema](#database-schema).
   - Update the database connection settings in `src/inventorymanagement/db.java` if needed (default: user `root`, no password).

3. **Add the MySQL JDBC driver:**
   - Download the JAR from [here](https://dev.mysql.com/downloads/connector/j/).
   - In NetBeans: Right-click your project > Properties > Libraries > Add JAR/Folder > select the downloaded JAR.

4. **Build & Run the project:**
   - Open the project in NetBeans.
   - Build (`Clean and Build`) and Run (`Run`).

   Or, using Ant:
   ```sh
   ant clean
   ant build
   ant run
   ```

---

## 🖥️ Application Modules

### 1. **Dashboard**
- Central navigation for all features.

### 2. **Product Management**
- Add, update, delete, and search products.
- Track barcode, price, quantity, and supplier.

### 3. **Customer Management**
- Add, update, delete, and search customers.
- Store contact information.

### 4. **Supplier Management**
- Add, update, delete, and search suppliers.
- Store contact information.

### 5. **Employee Management**
- Add, update, delete, and search employees.
- Store contact information.

### 6. **Sales & Invoicing**
- Create sales, generate invoices, manage payments, and calculate balances.

### 7. **Reporting**
- Generate and print detailed sales and invoice reports.

---

## 🧩 How It Works

- **Database Initialization:**
  On first run, ensure the MySQL database and tables exist. The app connects using the credentials in `db.java`.
- **CRUD Operations:**
  All add, remove, and update operations are performed using SQL statements via JDBC.
- **Navigation:**
  Each module is accessible from the Dashboard. Cancel/Back buttons return to the Dashboard.

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

---

## 📄 License

[MIT](LICENSE) (or your preferred license)

---

**Developed by Aayam Bajaj** 
