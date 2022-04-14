--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: projet; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA projet;


ALTER SCHEMA projet OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: players; Type: TABLE; Schema: projet; Owner: postgres
--

CREATE TABLE projet.players (
    id integer NOT NULL,
    "playerName" text
);


ALTER TABLE projet.players OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: player; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.player (
    id integer NOT NULL,
    player_name character varying(255)
);


ALTER TABLE public.player OWNER TO postgres;

--
-- Data for Name: players; Type: TABLE DATA; Schema: projet; Owner: postgres
--

COPY projet.players (id, "playerName") FROM stdin;
1	john
\.


--
-- Data for Name: player; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.player (id, player_name) FROM stdin;
1	Will
2	Smith
3	Slaps
4	Rock
5	Omelette du fromage
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 38, true);


--
-- Name: players players_pkey; Type: CONSTRAINT; Schema: projet; Owner: postgres
--

ALTER TABLE ONLY projet.players
    ADD CONSTRAINT players_pkey PRIMARY KEY (id);


--
-- Name: player player_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.player
    ADD CONSTRAINT player_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

