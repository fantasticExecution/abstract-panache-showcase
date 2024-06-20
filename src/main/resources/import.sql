CREATE TABLE child_entity_a
(
    id               UUID         PRIMARY KEY,
    common_column    VARCHAR(255) NOT NULL UNIQUE,
    specific_field_a INTEGER
);

CREATE TABLE child_entity_b
(
    id               UUID         PRIMARY KEY,
    common_column    VARCHAR(255) NOT NULL UNIQUE,
    specific_field_b TIMESTAMP WITHOUT TIME ZONE
);