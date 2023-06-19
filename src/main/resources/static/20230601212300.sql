-- Criar o tipo de enumeração para o campo estado
--CREATE TYPE EstadoEnum AS ENUM ('AC', 'AL', 'AP', 'AM', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 'PA', 'PB', 'PR', 'PE', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 'SP', 'SE', 'TO');

-- Criar o tipo de enumeração para o campo cargo
--CREATE TYPE CargoEnum AS ENUM ('diretor', 'pedagogo', 'secretario', 'professor', 'servicos_gerais');

-- Tabela Endereco
CREATE TABLE endereco (
  id SERIAL PRIMARY KEY,
  rua VARCHAR(100),
  numero VARCHAR(10),
  cidade VARCHAR(100),
  bairro VARCHAR(100),
  estado VARCHAR(2),
  cep VARCHAR(8)
);

/* Tabela Instituicao
CREATE TABLE instituicao (
	id int4 NOT NULL,
	nome varchar(100) NULL,
	nucleo varchar(100) NULL,
	endereco_id int4 NULL,
	CONSTRAINT pk_id_instituicao PRIMARY KEY (id),
	CONSTRAINT instituicao_endereco_id_fkey FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

-- Tabela Funcionarios
CREATE TABLE funcionarios (
 id integer CONSTRAINT pk_id_funcionario PRIMARY KEY,
  nome VARCHAR(100),
  cpf VARCHAR(14),
  cargo CargoEnum,
  instituicao_id INT REFERENCES Instituicao(id)
);*/