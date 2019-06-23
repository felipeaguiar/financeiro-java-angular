INSERT INTO categoria
(version , nome) VALUES
(0       , 'Lazer')        ,
(0       , 'Alimentação')  ,
(0       , 'Supermercado') ,
(0       , 'Farmácia')     ,
(0       , 'Outros');

INSERT INTO pessoa
(version , nome                , logradouro         , numero , complemento , bairro               , cep         , cidade           , estado , ativo) VALUES
(0       , 'João Silva'        , 'Rua do Abacaxi'   , '10'   , null        , 'Brasil'             , '38.400-12' , 'Uberlândia'     , 'MG'   , true)         ,
(0       , 'Maria Rita'        , 'Rua do Sabiá'     , '110'  , 'Apto 101'  , 'Colina'             , '11.400-12' , 'Ribeirão Preto' , 'SP'   , true)         ,
(0       , 'Pedro Santos'      , 'Rua da Bateria'   , '23'   , null        , 'Morumbi'            , '54.212-12' , 'Goiânia'        , 'GO'   , true)         ,
(0       , 'Ricardo Pereira'   , 'Rua do Motorista' , '123'  , 'Apto 302'  , 'Aparecida'          , '38.400-12' , 'Salvador'       , 'BA'   , true)         ,
(0       , 'Josué Mariano'     , 'Av Rio Branco'    , '321'  , null        , 'Jardins'            , '56.400-12' , 'Natal'          , 'RN'   , true)         ,
(0       , 'Pedro Barbosa'     , 'Av Brasil'        , '100'  , null        , 'Tubalina'           , '77.400-12' , 'Porto Alegre'   , 'RS'   , true)         ,
(0       , 'Henrique Medeiros' , 'Rua do Sapo'      , '1120' , 'Apto 201'  , 'Centro'             , '12.400-12' , 'Rio de Janeiro' , 'RJ'   , true)         ,
(0       , 'Carlos Santana'    , 'Rua da Manga'     , '433'  , null        , 'Centro'             , '31.400-12' , 'Belo Horizonte' , 'MG'   , true)         ,
(0       , 'Leonardo Oliveira' , 'Rua do Músico'    , '566'  , null        , 'Segismundo Pereira' , '38.400-00' , 'Uberlândia'     , 'MG'   , true)         ,
(0       , 'Isabela Martins'   , 'Rua da Terra'     , '1233' , 'Apto 10'   , 'Vigilato'           , '99.400-12' , 'Manaus'         , 'AM'   , true);

INSERT INTO lancamento
(version , descricao        , data_vencimento , data_pagamento , valor   , observacao               , tipo , id_categoria , id_pessoa) VALUES
(0       , 'Salário mensal' , '2019-06-10'    , null           , 6500.00 , 'Distribuição de lucros' , 0    , 1            , 1)                ,
(0       , 'Bahamas'        , '2019-02-10'    , '2019-02-10'   , 100.32  , null                     , 1    , 2            , 2)                ,
(0       , 'Top Club'       , '2019-06-10'    , null           , 120     , null                     , 0    , 3            , 3)                ,
(0       , 'CEMIG'          , '2019-02-10'    , '2019-02-10'   , 110.44  , 'Geração'                , 0    , 3            , 4)                ,
(0       , 'DMAE'           , '2019-06-10'    , null           , 200.30  , null                     , 1    , 3            , 5)                ,
(0       , 'Extra'          , '2019-03-10'    , '2019-03-10'   , 1010.32 , null                     , 0    , 4            , 6)                ,
(0       , 'Bahamas'        , '2019-06-10'    , null           , 500     , null                     , 0    , 1            , 7)                ,
(0       , 'Top Club'       , '2019-03-10'    , '2019-03-10'   , 400.32  , null                     , 1    , 4            , 8)                ,
(0       , 'Despachante'    , '2019-06-10'    , null           , 123.64  , 'Multas'                 , 1    , 3            , 9)                ,
(0       , 'Pneus'          , '2019-04-10'    , '2019-04-10'   , 665.33  , null                     , 0    , 5            , 10)               ,
(0       , 'Café'           , '2019-06-10'    , null           , 8.32    , null                     , 1    , 1            , 5)                ,
(0       , 'Eletrônicos'    , '2019-04-10'    , '2019-04-10'   , 2100.32 , null                     , 1    , 5            , 4)                ,
(0       , 'Instrumentos'   , '2019-06-10'    , null           , 1040.32 , null                     , 1    , 4            , 3)                ,
(0       , 'Café'           , '2019-04-10'    , '2019-04-10'   , 4.32    , null                     , 1    , 4            , 2)                ,
(0       , 'Lanche'         , '2019-06-10'    , null           , 10.20   , null                     , 1    , 4            , 1);
