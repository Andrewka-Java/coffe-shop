CREATE TABLE IF NOT EXISTS coffee (
    "id" BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    "name" VARCHAR(255) NOT NULL,
    "price" DECIMAL(10, 2) NOT NULL CHECK "price" > 0,
    "country" VARCHAR(255) NOT NULL,
    "img_name" VARCHAR(255) NOT NULL
);