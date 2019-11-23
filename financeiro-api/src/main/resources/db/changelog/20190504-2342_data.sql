--liquibase formatted sql

--changeset felipe.aguiar:1
--rollback DELETE FROM TABLE usuario;
INSERT INTO usuario (id, version, nome, email, senha) VALUES (1, 0, 'Administrador', 'admin@mail.com', '$2a$10$OpPp0rk9xVADhQ4Tgt2HluJm6nzQfPnBoSsuvMLsX4cN/8xuYcRbG');
INSERT INTO usuario (id, version, nome, email, senha) VALUES (2, 0, 'Visitor', 'visitor@mail.com', '$2a$10$OpPp0rk9xVADhQ4Tgt2HluJm6nzQfPnBoSsuvMLsX4cN/8xuYcRbG');

--changeset felipe.aguiar:2
--rollback DELETE FROM TABLE permissao;
INSERT INTO permissao (id, descricao) VALUES (1, 'PESQUISAR_CATEGORIA');
INSERT INTO permissao (id, descricao) VALUES (2, 'CADASTRAR_CATEGORIA');
INSERT INTO permissao (id, descricao) VALUES (3, 'REMOVER_CATEGORIA');

INSERT INTO permissao (id, descricao) VALUES (4, 'PESQUISAR_PESSOA');
INSERT INTO permissao (id, descricao) VALUES (5, 'CADASTRAR_PESSOA');
INSERT INTO permissao (id, descricao) VALUES (6, 'REMOVER_PESSOA');

INSERT INTO permissao (id, descricao) VALUES (7, 'PESQUISAR_LANCAMENTO');
INSERT INTO permissao (id, descricao) VALUES (8, 'CADASTRAR_LANCAMENTO');
INSERT INTO permissao (id, descricao) VALUES (9, 'REMOVER_LANCAMENTO');

--changeset felipe.aguiar:3
--rollback DELETE FROM TABLE perfil;
INSERT INTO perfil (id, version, nome) VALUES (1, 0, 'Adiministrador');
INSERT INTO perfil (id, version, nome) VALUES (2, 0, 'Visitante');

--changeset felipe.aguiar:4
--rollback DELETE FROM TABLE usuario_perfil;
INSERT INTO usuario_perfil (id_usuario, id_perfil) VALUES (1, 1);
INSERT INTO usuario_perfil (id_usuario, id_perfil) VALUES (2, 2);

--changeset felipe.aguiar:5
--rollback DELETE FROM TABLE perfil_permissao;
INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (1, 1);
INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (1, 2);
INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (1, 3);
INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (1, 4);
INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (1, 5);
INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (1, 6);
INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (1, 7);
INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (1, 8);
INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (1, 9);

INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (2, 1);
INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (2, 4);
INSERT INTO perfil_permissao (id_perfil, id_permissao) VALUES (2, 7);

--changeset felipe.aguiar:6 dbms:postgresql
--rollback SELECT setval('usuario_id_seq', 0, true)
SELECT setval('usuario_id_seq', MAX(id), true) FROM usuario;

--changeset felipe.aguiar:7 dbms:postgresql
--rollback SELECT setval('perfil_id_seq', 0, true)
SELECT setval('perfil_id_seq', MAX(id), true) FROM perfil;

--changeset felipe.aguiar:8
--rollback DELETE FROM TABLE categoria;
INSERT INTO categoria (version , nome) VALUES (0, 'Lazer');
INSERT INTO categoria (version , nome) VALUES (0, 'Alimentação');
INSERT INTO categoria (version , nome) VALUES (0, 'Supermercado');
INSERT INTO categoria (version , nome) VALUES (0, 'Farmácia');
INSERT INTO categoria (version , nome) VALUES (0, 'Outros');
