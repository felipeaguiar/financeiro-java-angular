--liquibase formatted sql

--changeset felipe.aguiar:1
--rollback DROP TABLE categoria;
CREATE TABLE categoria (
	id bigserial NOT NULL,
	nome varchar(50) NOT NULL,
	version int8,
	CONSTRAINT pk_categoria PRIMARY KEY (id)
);

--changeset felipe.aguiar:2
--rollback DROP TABLE lancamento;
CREATE TABLE lancamento (
	id bigserial NOT NULL,
	data_pagamento date,
	data_vencimento date NOT NULL,
	descricao varchar(50) NOT NULL,
	observacao varchar(100),
	tipo int4 NOT NULL,
	valor numeric(19, 2) NOT NULL,
	version int8,
	id_categoria int8 NOT NULL,
	id_pessoa int8 NOT NULL,
	CONSTRAINT pk_lancamento PRIMARY KEY (id)
);

--changeset felipe.aguiar:3
--rollback DROP TABLE perfil;
CREATE TABLE perfil (
	id bigserial NOT NULL,
	nome varchar(50) NOT NULL,
	version int8,
	CONSTRAINT pk_perfil PRIMARY KEY (id)
);

--changeset felipe.aguiar:4
--rollback DROP TABLE perfil_permissao;
CREATE TABLE perfil_permissao (
	id_perfil int8 NOT NULL,
	id_permissao int8 NOT NULL,
	CONSTRAINT pk_perfil_permissao PRIMARY KEY (id_perfil, id_permissao)
);

--changeset felipe.aguiar:5
--rollback DROP TABLE permissao;
CREATE TABLE permissao (
	id int8 NOT NULL,
	descricao varchar(50) NOT NULL,
	CONSTRAINT pk_permissao PRIMARY KEY (id)
);

--changeset felipe.aguiar:6
--rollback DROP TABLE pessoa;
CREATE TABLE pessoa (
	id bigserial NOT NULL,
	ativo boolean NOT NULL,
	bairro varchar(30),
	cep varchar(30),
	cidade varchar(30),
	complemento varchar(30),
	estado varchar(30),
	logradouro varchar(30),
	numero varchar(30),
	nome varchar(50) NOT NULL,
	version int8,
	CONSTRAINT pk_pessoa PRIMARY KEY (id)
);

--changeset felipe.aguiar:7
--rollback DROP TABLE usuario;
CREATE TABLE usuario (
	id bigserial NOT NULL,
	email varchar(50) NOT NULL,
	nome varchar(50) NOT NULL,
	senha varchar(150) NOT NULL,
	version int8,
	CONSTRAINT pk_usuario PRIMARY KEY (id)
);

--changeset felipe.aguiar:8
--rollback DROP TABLE usuario_perfil;
CREATE TABLE usuario_perfil (
	id_usuario int8 NOT NULL,
	id_perfil int8 NOT NULL,
	CONSTRAINT pk_usuario_perfil PRIMARY KEY (id_usuario, id_perfil)
);

--changeset felipe.aguiar:9
--rollback ALTER TABLE lancamento DROP CONSTRAINT fk_lancamento_categoria;
ALTER TABLE IF EXISTS lancamento
	add CONSTRAINT fk_lancamento_categoria
	FOREIGN KEY (id_categoria)
	REFERENCES categoria;

--changeset felipe.aguiar:10
--rollback DROP INDEX idx_lancamento_id_categoria;
CREATE INDEX idx_lancamento_id_categoria ON lancamento (id_categoria);

--changeset felipe.aguiar:11
--rollback ALTER TABLE lancamento DROP CONSTRAINT fk_lancamento_pessoa;
ALTER TABLE IF EXISTS lancamento
	add CONSTRAINT fk_lancamento_pessoa
	FOREIGN KEY (id_pessoa)
	REFERENCES pessoa;

--changeset felipe.aguiar:12
--rollback DROP INDEX idx_lancamento_id_pessoa;
CREATE INDEX idx_lancamento_id_pessoa ON lancamento (id_pessoa);

--changeset felipe.aguiar:13
--rollback ALTER TABLE perfil_permissao DROP CONSTRAINT fk_perfil_permissao_permissao;
ALTER TABLE IF EXISTS perfil_permissao
	add CONSTRAINT fk_perfil_permissao_permissao
	FOREIGN KEY (id_permissao)
	REFERENCES permissao;

--changeset felipe.aguiar:14
--rollback DROP INDEX idx_perfil_permissao_id_permissao;
CREATE INDEX idx_perfil_permissao_id_permissao ON perfil_permissao (id_permissao);

--changeset felipe.aguiar:15
--rollback ALTER TABLE perfil_permissao DROP CONSTRAINT fk_perfil_permissao_perfil;
ALTER TABLE IF EXISTS perfil_permissao
	add CONSTRAINT fk_perfil_permissao_perfil
	FOREIGN KEY (id_perfil)
	REFERENCES perfil;

--changeset felipe.aguiar:16
--rollback DROP INDEX idx_perfil_permissao_id_perfil;
CREATE INDEX idx_perfil_permissao_id_perfil ON perfil_permissao (id_perfil);

--changeset felipe.aguiar:17
--rollback ALTER TABLE usuario_perfil DROP CONSTRAINT fk_usuario_perfil_perfil;
ALTER TABLE IF EXISTS usuario_perfil
	add CONSTRAINT fk_usuario_perfil_perfil
	FOREIGN KEY (id_perfil)
	REFERENCES perfil;

--changeset felipe.aguiar:18
--rollback DROP INDEX idx_usuario_perfil_id_perfil;
CREATE INDEX idx_usuario_perfil_id_perfil ON usuario_perfil (id_perfil);

--changeset felipe.aguiar:19
--rollback ALTER TABLE usuario_perfil DROP CONSTRAINT fk_usuario_perfil_usuario;
ALTER TABLE IF EXISTS usuario_perfil
	add CONSTRAINT fk_usuario_perfil_usuario
	FOREIGN KEY (id_usuario)
	REFERENCES usuario;

--changeset felipe.aguiar:20
--rollback DROP INDEX idx_usuario_perfil_id_usuario;
CREATE INDEX idx_usuario_perfil_id_usuario ON usuario_perfil (id_usuario);
