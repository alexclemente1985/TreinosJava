CREATE TABLE teste(
    nome varchar(255),
    idade integer
);
SET character_set_client = utf8;
SET character_set_connection = utf8;
SET character_set_results = utf8;
SET collation_connection = utf8_general_ci;
INSERT INTO teste (nome,idade) VALUES ('João Fulano',22);
commit;
