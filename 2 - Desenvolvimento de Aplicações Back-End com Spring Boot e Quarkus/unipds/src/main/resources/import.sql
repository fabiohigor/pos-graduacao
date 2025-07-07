CREATE SEQUENCE IF NOT EXISTS pessoa_id_seq START WITH 6 INCREMENT BY 1;
ALTER SEQUENCE pessoa_id_seq RESTART WITH 6;


INSERT INTO Pessoa (id, nome, anoNascimento) VALUES
(1, 'João', 1992),
(2, 'Maria', 1992),
(3, 'José', 1983),
(4, 'Ana', 2001),
(5, 'Pedro', 1988);

