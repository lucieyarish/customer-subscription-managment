INSERT INTO customer(first_name, middle_name, last_name, email, phone_number, birth_date)
VALUES ('Larry', 'John', 'Smith', 'larry.smith@gmail.com', '+420666222333', '1975-08-12'),
       ('Mike', 'Rowan', 'Hall', 'mike.hall@gmail.com', '+420555333222', '1984-01-01'),
       ('Kate', null, 'Williams', 'kate.will@gmail.com', '+420111222333', '1963-11-01');

INSERT INTO quotation(id, insurance_began_on, insured_amount, mortgage_signed_on, customer_id)
VALUES (1, '2022-08-12', 300000, '2020-03-01', 1),
       (2, '2018-01-02', 100000, '2017-11-29', 1);

INSERT INTO subscription(id, started_on, valid_to, quotation_id)
VALUES (1, '2023-03-03', '2024-03-03', 1);
