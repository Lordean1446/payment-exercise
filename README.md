# Payment Exercise

## Overview

This application is an educational exercise that simulates contract payment processing using the Strategy pattern for different online payment services. It calculates monthly installments including interest rates and payment fees in a simulated manner.

## Features

- Contract management with number, date, and total value
- Installment calculation with monthly breakdown
- Simulated online payment service integration (PayPal)
- Interest and fee calculation per installment
- Console-based user interface

## Architecture

The project follows a clean architecture with the following main components:

### Entities
- **Contract**: Represents a payment contract with basic information and installments
- **Installment**: Represents individual payment installments with due date and amount

### Services
- **ContractService**: Processes contracts and generates installments
- **OnlinePaymentService**: Interface for online payment services
- **PaypalService**: Simulated PayPal implementation with 2% fee and 1% monthly interest

### Application
- **Main**: Console application entry point with user interaction

## Payment Calculation

The application calculates installments using the following formula:

1. **Base Installment**: Total contract value ÷ Number of months
2. **Interest**: Base installment × 1% × month number
3. **Payment Fee**: (Base installment + interest) × 2%
4. **Total Installment**: Base installment + interest + payment fee

## Requirements

- Java 8 or higher (compatible with Java 8-21+)
- Maven 3.0 or higher

## Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd payment-exercise
```

2. Build the project:
```bash
mvn clean compile
```

## Usage

Run the application:

```bash
mvn exec:java -Dexec.mainClass="com.lordean1446.application.Main"
```

Follow the prompts to enter:
- Contract number
- Contract date (dd/MM/yyyy format)
- Contract total value
- Number of installments

The application will display the calculated installments with due dates and amounts.

## Example

```
Entre os dados do contrato: 
Número: 1234
Data (dd/MM/yyyy): 25/06/2018
Valor do contrato: 600.00
Entre com o número de parcelas: 3
Parcelas:
25/07/2018 - 206.04
25/08/2018 - 208.08
25/09/2018 - 210.12
```

## Project Structure

```
src/main/java/com/lordean1446/
├── application/
│   └── Main.java
├── entities/
│   ├── Contract.java
│   └── Installment.java
└── services/
    ├── ContractService.java
    ├── OnlinePaymentService.java
    └── PaypalService.java
```

## Design Patterns

- **Strategy Pattern**: OnlinePaymentService interface allows different payment service implementations
- **Dependency Injection**: ContractService receives payment service through constructor

## License

**This project is for educational purposes only.** All operations are simulated and there is no real integration with payment services or actual financial transactions.
