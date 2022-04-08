-- Table: public.player

-- DROP TABLE IF EXISTS public.player;

CREATE TABLE IF NOT EXISTS public.player
(
    id integer NOT NULL,
    player_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT player_pkey PRIMARY KEY (id)
)

ALTER TABLE IF EXISTS public.player
    OWNER to postgres;