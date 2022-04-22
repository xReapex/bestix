CREATE TABLE IF NOT EXISTS public.favoris
(
    favoriteid integer NOT NULL,
    playerid integer,
    userid integer,
    CONSTRAINT favoris_pkey PRIMARY KEY (favoriteid)
)