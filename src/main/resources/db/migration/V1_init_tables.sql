DROP DATABASE IF EXISTS AgencyKpopSpring;
CREATE DATABASE AgencyKpopSpring;

DROP TABLE IF EXISTS Agency CASCADE ;
DROP TABLE IF EXISTS KpopGroup CASCADE;
DROP TABLE IF EXISTS Member;

CREATE TABLE Agency
(
    agencyId serial8,
    agencyName text NOT NULL,
    directorName text NOT NULL,
    address text NOT NULL,
    telephoneNumber text NOT NULL,
    CONSTRAINT Agency_pkey PRIMARY KEY (agencyId)
);

CREATE TABLE KpopGroup
(
    groupId serial8,
    groupName text NOT NULL,
    dataStartContract date NOT NULL,
    dataEndContract date NOT NULL,
    managerName text NOT NULL,
    agencyIdFk int NOT NULL,
    CONSTRAINT KpopGroup_pkey PRIMARY KEY (groupId),
    CONSTRAINT agency_id_fk FOREIGN KEY (agencyIdFk) REFERENCES Agency(agencyId)
);

CREATE TABLE Member
(
    memberId serial8,
    name text NOT NULL,
    surname text NOT NULL,
    nickname text NOT NULL,
    telephoneNumber text NOT NULL,
    birth date NOT NULL,
    position text NOT NULL,
    groupIdFk int NOT NULL,
    CONSTRAINT Member_pkey PRIMARY KEY (memberId),
    CONSTRAINT group_id_fk FOREIGN KEY (groupIdFk) REFERENCES KpopGroup(groupId)
);