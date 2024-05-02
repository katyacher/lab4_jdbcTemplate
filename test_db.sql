--
-- PostgreSQL database dump
--

-- Dumped from database version 12.18 (Ubuntu 12.18-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.18 (Ubuntu 12.18-0ubuntu0.20.04.1)

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: jewel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.jewel (
    id integer NOT NULL,
    size integer,
    price integer NOT NULL,
    type text NOT NULL,
    metal text,
    stone text,
    CONSTRAINT jewel_price_check CHECK ((price > 0))
);


ALTER TABLE public.jewel OWNER TO postgres;

--
-- Name: jewel_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.jewel_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.jewel_id_seq OWNER TO postgres;

--
-- Name: jewel_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.jewel_id_seq OWNED BY public.jewel.id;


--
-- Name: jewel id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jewel ALTER COLUMN id SET DEFAULT nextval('public.jewel_id_seq'::regclass);


--
-- Data for Name: jewel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.jewel (id, size, price, type, metal, stone) FROM stdin;
1	3	10000	ring	gold	dimond
2	2	5000	ring	silver	gemstone
3	2	9000	ring	silver	dimond
4	3	11000	ring	platinum	dimond
\.


--
-- Name: jewel_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.jewel_id_seq', 1, false);


--
-- Name: jewel jewel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.jewel
    ADD CONSTRAINT jewel_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

