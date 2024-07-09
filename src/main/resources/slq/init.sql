CREATE DATABASE IF NOT EXISTS wallet;

USE wallet;

CREATE TABLE IF NOT EXISTS clients (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    created_at DATE
);

CREATE TABLE IF NOT EXISTS accounts (
    id VARCHAR(255) PRIMARY KEY,
    client_id VARCHAR(255),
    balance FLOAT,
    created_at DATE,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE IF NOT EXISTS balances (
    id VARCHAR(255) PRIMARY KEY,
    client_id VARCHAR(255),
    balance FLOAT,
    updated_at DATE
);

CREATE TABLE IF NOT EXISTS transactions (
    id VARCHAR(255) PRIMARY KEY,
    account_id_from VARCHAR(255),
    account_id_to VARCHAR(255),
    amount INT,
    created_at DATE,
    FOREIGN KEY (account_id_from) REFERENCES accounts(id),
    FOREIGN KEY (account_id_to) REFERENCES accounts(id)
);

-- Insert initial data into clients with fixed UUIDs
INSERT INTO clients (id, name, email, created_at) VALUES
('a8098c1a-f86e-11da-bd1a-00112444be1e', 'John Doe', 'john@example.com', '2024-01-01'),
('a8098c1a-f86e-11da-bd1a-00112444be1f', 'Jane Smith', 'jane@example.com', '2024-01-02'),
('a8098c1a-f86e-11da-bd1a-00112444be20', 'Alice Johnson', 'alice@example.com', '2024-01-03'),
('a8098c1a-f86e-11da-bd1a-00112444be21', 'Bob Brown', 'bob@example.com', '2024-01-04'),
('a8098c1a-f86e-11da-bd1a-00112444be22', 'Charlie Davis', 'charlie@example.com', '2024-01-05'),
('a8098c1a-f86e-11da-bd1a-00112444be23', 'Diana Evans', 'diana@example.com', '2024-01-06'),
('a8098c1a-f86e-11da-bd1a-00112444be24', 'Eve Foster', 'eve@example.com', '2024-01-07'),
('a8098c1a-f86e-11da-bd1a-00112444be25', 'Frank Green', 'frank@example.com', '2024-01-08'),
('a8098c1a-f86e-11da-bd1a-00112444be26', 'Grace Harris', 'grace@example.com', '2024-01-09'),
('a8098c1a-f86e-11da-bd1a-00112444be27', 'Henry Irving', 'henry@example.com', '2024-01-10');

-- Insert initial data into accounts with fixed UUIDs
INSERT INTO accounts (id, client_id, balance, created_at) VALUES
('b8098c1a-f86e-11da-bd1a-00112444be1e', 'a8098c1a-f86e-11da-bd1a-00112444be1e', 1000, '2024-01-01'),
('b8098c1a-f86e-11da-bd1a-00112444be1f', 'a8098c1a-f86e-11da-bd1a-00112444be1f', 1500, '2024-01-02'),
('b8098c1a-f86e-11da-bd1a-00112444be20', 'a8098c1a-f86e-11da-bd1a-00112444be20', 2000, '2024-01-03'),
('b8098c1a-f86e-11da-bd1a-00112444be21', 'a8098c1a-f86e-11da-bd1a-00112444be21', 2500, '2024-01-04'),
('b8098c1a-f86e-11da-bd1a-00112444be22', 'a8098c1a-f86e-11da-bd1a-00112444be22', 3000, '2024-01-05'),
('b8098c1a-f86e-11da-bd1a-00112444be23', 'a8098c1a-f86e-11da-bd1a-00112444be23', 3500, '2024-01-06'),
('b8098c1a-f86e-11da-bd1a-00112444be24', 'a8098c1a-f86e-11da-bd1a-00112444be24', 4000, '2024-01-07'),
('b8098c1a-f86e-11da-bd1a-00112444be25', 'a8098c1a-f86e-11da-bd1a-00112444be25', 4500, '2024-01-08'),
('b8098c1a-f86e-11da-bd1a-00112444be26', 'a8098c1a-f86e-11da-bd1a-00112444be26', 5000, '2024-01-09'),
('b8098c1a-f86e-11da-bd1a-00112444be27', 'a8098c1a-f86e-11da-bd1a-00112444be27', 5500, '2024-01-10');
