----------------------------------------------------------------------------------------------------

CREATE TABLE "Clubes" (
    "ID_Clube"  INTEGER,
    "Nome"  VARCHAR(100) NOT NULL,
    "Ano_Fundacao"  INTEGER NOT NULL,
    "Apelido"   VARCHAR(50) NOT NULL,
    "Mascote"   VARCHAR(50) NOT NULL,
    "ID_Estadio"    INTEGER NOT NULL,
    PRIMARY KEY("ID_Clube"),
    FOREIGN KEY("ID_Estadio") REFERENCES "Estadios"("ID_Estadio")
);

CREATE TABLE "Estadios" (
    "ID_Estadio"    INTEGER,
    "Nome_Estadio"  VARCHAR(100) NOT NULL,
    "Apelido"   VARCHAR(100) NOT NULL,
    "ID_Localidade" INTEGER NOT NULL,
    "Capacidade"    INTEGER NOT NULL,
    FOREIGN KEY("ID_Localidade") REFERENCES "Localidades"("ID_Localidade"),
    PRIMARY KEY("ID_Estadio" AUTOINCREMENT)
);

CREATE TABLE "InfoPartida" (
    "ID_Partida"    INTEGER,
    "ID_Rodada" INTEGER,
    "ID_Estadio"    INTEGER,
    FOREIGN KEY("ID_Rodada") REFERENCES "RodadaTemporada"("ID_Rodada"),
    FOREIGN KEY("ID_Estadio") REFERENCES "Estadios"("ID_Estadio"),
    PRIMARY KEY("ID_Partida")
);

CREATE TABLE "Localidades" (
    "ID_Localidade" INTEGER NOT NULL,
    "Cidade"    VARCHAR(50) NOT NULL,
    "Estado"    VARCHAR(2) NOT NULL,
    PRIMARY KEY("ID_Localidade" AUTOINCREMENT)
);


CREATE TABLE "Pontos" (
	"ID_Pontos"	INTEGER,
	"Resultado_Pontos"	INTEGER,
	PRIMARY KEY("ID_Pontos")
);

CREATE TABLE "ResultadoPartida" (
    "ID_Partida"    INT,
    "ID_Clube"  INT,
    "Golos" INT,
    "Pontos"    INT,
    "CasaFora"  INT,
    FOREIGN KEY("ID_Partida") REFERENCES "InfoPartida"("ID_Partida"),
    FOREIGN KEY("ID_Clube") REFERENCES "Clubes"("ID_Clube"),
    PRIMARY KEY("ID_Partida","ID_Clube")
);

CREATE TABLE "RodadaTemporada" (
    "ID_Rodada" INTEGER,
    "Rodada"    INTEGER,
    "Temporada" INTEGER,
    PRIMARY KEY("ID_Rodada")
);






