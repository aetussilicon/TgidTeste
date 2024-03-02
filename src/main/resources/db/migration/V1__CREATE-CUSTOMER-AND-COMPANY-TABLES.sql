CREATE TABLE IF NOT EXISTS customers (
    geid UUID PRIMARY KEY NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    tax_number VARCHAR(18) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(13),
    balance DECIMAL(10, 2)
);

CREATE TABLE IF NOT EXISTS companies (
    geid UUID PRIMARY KEY NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    business_name VARCHAR(100) NOT NULL,
    tax_number VARCHAR(18) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(13),
    balance DECIMAL(10, 2),
    system_fee INTEGER
);