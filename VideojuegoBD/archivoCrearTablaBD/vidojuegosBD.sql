create user videojuegoBD identified by videojuegoBD;
GRANT CONNECT, RESOURCE, DBA TO videojuegoBD;

CREATE TABLE videojuegos(
    nombre  VARCHAR2(20),
    precio  NUMBER(10,2),
    manual  VARCHAR2(2),
    extra   VARCHAR2(2),
    horas   NUMBER(10,2),
    CONSTRAINT PK_videojuegos PRIMARY KEY(nombre)
);
