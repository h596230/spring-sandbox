-- create table student with id, name, lastname, course
CREATE TABLE students (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  course VARCHAR(50) NOT NULL
);
-- insert 10 students
INSERT INTO students (first_name, last_name, course) VALUES
  ('Alice', 'Smith', 'Mathematics'),
  ('Bob', 'Johnson', 'English'),
  ('Charlie', 'Brown', 'Science'),
  ('David', 'Jones', 'History'),
  ('Emma', 'Davis', 'Art'),
  ('Frank', 'Miller', 'Music'),
  ('Grace', 'Wilson', 'Economics'),
  ('Henry', 'Taylor', 'Biology'),
  ('Isabella', 'Moore', 'Physics'),
  ('John', 'Anderson', 'Chemistry');