CREATE TABLE countries (
	country_id SERIAL PRIMARY KEY,
	name VARCHAR(50),
	area NUMERIC(10,2),
	national_day DATE,
	country_code2 CHAR(2),
	country_code3 CHAR(3)
);

CREATE SEQUENCE
IF NOT EXISTS
countries_seq
START WITH 1
;