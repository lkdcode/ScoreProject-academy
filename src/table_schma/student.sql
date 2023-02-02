CREATE TABLE student(
    mid NUMBER PRIMARY KEY,
    name NVARCHAR2(15) NOT NULL,
    kor NUMBER,
    eng NUMBER,
    mat NUMBER
);

SELECT * FROM student;
SELECT * FROM "STUDENT";
CREATE SEQUENCE m_mid INCREMENT by 1 START WITH 1 NOCYCLE NOCACHE;

INSERT INTO student
VALUES (m_mid.nextval, '민들래', 90, 88, 75);

INSERT INTO student
VALUES (m_mid.nextval, '진달래', 80, 88, 63);