# Inventory Management System

A comprehensive Java-based Inventory Management System that helps businesses manage their products, customers, suppliers, sales, and inventory efficiently.

## Features

### 1. Product Management
- Add, update, and delete products
- Track product details including:
  - Product ID
  - Product Name
  - Barcode
  - Price
  - Quantity
  - Supplier ID
- Search products by name or ID
- Real-time inventory updates

### 2. Customer Management
- Maintain customer database
- Track customer details:
  - Customer ID
  - Customer Name
  - Contact Information
  - Address
- Search and filter customer records

### 3. Supplier Management
- Manage supplier information
- Track supplier details:
  - Supplier ID
  - Supplier Name
  - Contact Information
  - Address
- Search and filter supplier records

### 4. Sales Management
- Create and manage sales invoices
- Features include:
  - Automatic invoice number generation
  - Customer selection
  - Product selection with real-time price lookup
  - Quantity management
  - Total calculation
  - Payment status tracking (PAID/UNPAID/PARTIAL)
  - Balance calculation
- Print sales invoices

### 5. Employee Management
- Track employee information
- Manage employee details:
  - Employee ID
  - Employee Name
  - Contact Information
  - Role/Position

### 6. Reporting
- Generate sales reports
- View invoice details
- Print invoices with:
  - Customer information
  - Product details
  - Quantity and price information
  - Total calculations
  - Payment status
  - Balance information

## Technical Details

### Technology Stack
- Java
- MySQL Database
- Swing GUI Framework
- JDBC for database connectivity

### Database Structure
The system uses the following main tables:
- `product`: Stores product information
- `customer`: Maintains customer records
- `supplier`: Stores supplier information
- `employee`: Manages employee data
- `sale`: Records sales transactions
- `cart`: Stores individual sale items
- `extra`: Manages system settings

## Setup Instructions

1. **Prerequisites**
   - Java Development Kit (JDK)
   - MySQL Server
   - NetBeans IDE (recommended)

2. **Database Setup**
   - Create a MySQL database
   - Import the provided database schema
   - Update database connection settings in the project

3. **Project Setup**
   - Clone the repository
   - Open the project in NetBeans IDE
   - Build and run the project

## Usage

1. **Navigation**
   - Use the main menu to access different modules
   - Each module has its own interface for specific operations

2. **Sales Process**
   - Select a customer
   - Add products to cart
   - Enter quantities
   - Process payment
   - Generate invoice

3. **Reporting**
   - Access the reports section
   - Enter invoice number to view details
   - Print invoices as needed

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support, please open an issue in the GitHub repository or contact the development team.
