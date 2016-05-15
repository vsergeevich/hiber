
CREATE TABLE hiber.book
(
  "name" character varying,
  id integer NOT NULL,
writer_id integer NOT NULL,
  CONSTRAINT book_pkey PRIMARY KEY (id)
)
WITH (OIDS=FALSE);
ALTER TABLE hiber.book OWNER TO hiber;

CREATE TABLE hiber.writer
(
  id integer NOT NULL,
  "name" character varying,
  CONSTRAINT writer_id_pk PRIMARY KEY (id)
)
WITH (OIDS=FALSE);
ALTER TABLE hiber.writer OWNER TO hiber;




ALTER TABLE hiber.book
ADD CONSTRAINT WRITER_ID_FK
FOREIGN KEY (writer_id) REFERENCES hiber.writer