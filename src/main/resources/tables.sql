

CREATE TABLE book
(
  "name" character varying,
  id integer NOT NULL,
  CONSTRAINT book_pkey PRIMARY KEY (id)
)
WITH (OIDS=FALSE);
ALTER TABLE book OWNER TO tyrin;

CREATE TABLE writer
(
  id integer NOT NULL,
  "name" character varying,
  CONSTRAINT writer_id_pk PRIMARY KEY (id)
)
WITH (OIDS=FALSE);
ALTER TABLE writer OWNER TO tyrin;


ALTER TABLE writer
  ADD CONSTRAINT writer_id_pk PRIMARY KEY(id);



ALTER TABLE Writer
ADD CONSTRAINT WRITER_ID_PK
PRIMARY KEY (id)



ALTER TABLE Book
ADD CONSTRAINT WRITER_ID_FK
FOREIGN KEY (writer_id) REFERENCES Writer