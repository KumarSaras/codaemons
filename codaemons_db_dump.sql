--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-04-10 04:54:24

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

DROP DATABASE IF EXISTS "CodeDaemons";
--
-- TOC entry 2918 (class 1262 OID 16393)
-- Name: CodeDaemons; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "CodeDaemons" WITH TEMPLATE = template0 ENCODING = 'UTF8';


ALTER DATABASE "CodeDaemons" OWNER TO postgres;

\connect "CodeDaemons"

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
-- TOC entry 7 (class 2615 OID 16559)
-- Name: dev; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA dev;


ALTER SCHEMA dev OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 16600)
-- Name: contest_questions; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.contest_questions (
    contest_id integer NOT NULL,
    question_id integer NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE dev.contest_questions OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16594)
-- Name: contests; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.contests (
    contest_id integer NOT NULL,
    contest_name text NOT NULL,
    contest_type text,
    contest_description text,
    contest_duration integer NOT NULL,
    contest_start_date timestamp without time zone NOT NULL,
    contest_end_date timestamp without time zone NOT NULL,
    contest_active_flag "char" NOT NULL,
    updated_date timestamp without time zone,
    supported_language_id integer
);


ALTER TABLE dev.contests OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16603)
-- Name: languages; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.languages (
    language_id integer NOT NULL,
    language_name text NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE dev.languages OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16609)
-- Name: questions; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.questions (
    question_id serial,
    supported_language_id integer,
    question_type text,
    question_category text,
    difficulty_level text,
    question_description text NOT NULL,
    question_active_flag boolean NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE dev.questions OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16615)
-- Name: roles; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.roles (
    role_name text NOT NULL,
    role_id integer NOT NULL,
    role_active_flag "char" NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


ALTER TABLE dev.roles OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16621)
-- Name: test_cases; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.test_cases (
    test_case_id serial,
    question_id integer NOT NULL,
    contest_id integer,
    test_case_input text NOT NULL,
    test_case_output text NOT NULL,
    max_time_allowed double precision NOT NULL,
    max_memory_allowed double precision NOT NULL,
    test_case_active_flag boolean NOT NULL,
    test_case_default_flag boolean NOT NULL,
    updated_date timestamp without time zone NOT NULL
);


ALTER TABLE dev.test_cases OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16633)
-- Name: user_address; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.user_address (
    user_address_id integer NOT NULL,
    address_line_1 text NOT NULL,
    address_line_2 text,
    city text NOT NULL,
    state text NOT NULL,
    country text NOT NULL,
    zipcode integer NOT NULL,
    email_id text NOT NULL,
    contact_number integer NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE dev.user_address OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16639)
-- Name: user_contests; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.user_contests (
    user_id integer NOT NULL,
    contest_id integer,
    question_id integer NOT NULL,
    submission_id integer NOT NULL,
    submission_status text
);


ALTER TABLE dev.user_contests OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16645)
-- Name: user_roles; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.user_roles (
    user_id integer NOT NULL,
    role_id bigint NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE dev.user_roles OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16648)
-- Name: user_submissions; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.user_submissions (
    submission_id integer NOT NULL,
    submission_language_id integer NOT NULL,
    test_case_id integer,
    test_case_result text,
    test_case_exec_time integer,
    test_case_exec_memory text,
    submission_time_taken integer NOT NULL,
    source_code text NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE dev.user_submissions OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16627)
-- Name: users; Type: TABLE; Schema: dev; Owner: postgres
--

CREATE TABLE dev.users (
    user_id integer NOT NULL,
    user_first_name text NOT NULL,
    user_last_name text,
    username text NOT NULL,
    password text NOT NULL,
    user_address_id integer,
    user_org_id integer,
    user_active_flag "char" NOT NULL,
    updated_date timestamp without time zone
);


ALTER TABLE dev.users OWNER TO postgres;

--
-- TOC entry 2903 (class 0 OID 16600)
-- Dependencies: 203
-- Data for Name: contest_questions; Type: TABLE DATA; Schema: dev; Owner: postgres
--



--
-- TOC entry 2902 (class 0 OID 16594)
-- Dependencies: 202
-- Data for Name: contests; Type: TABLE DATA; Schema: dev; Owner: postgres
--



--
-- TOC entry 2904 (class 0 OID 16603)
-- Dependencies: 204
-- Data for Name: languages; Type: TABLE DATA; Schema: dev; Owner: postgres
--

INSERT INTO dev.languages (language_id, language_name, updated_date) VALUES (1, 'Java', '2020-04-10 19:10:25');
INSERT INTO dev.languages (language_id, language_name, updated_date) VALUES (2, 'Python', '2016-06-22 19:10:25');
INSERT INTO dev.languages (language_id, language_name, updated_date) VALUES (3, 'Perl', '2020-04-10 19:10:25');
INSERT INTO dev.questions (supported_language_id, question_type, question_category, difficulty_level, question_description, question_active_flag, updated_date) VALUES (1, 'Test type', 'Test category', 'Easy', 'Print Hello World.', TRUE, '2020-04-10 19:10:25');



--
-- TOC entry 2905 (class 0 OID 16609)
-- Dependencies: 205
-- Data for Name: questions; Type: TABLE DATA; Schema: dev; Owner: postgres
--



--
-- TOC entry 2906 (class 0 OID 16615)
-- Dependencies: 206
-- Data for Name: roles; Type: TABLE DATA; Schema: dev; Owner: postgres
--



--
-- TOC entry 2907 (class 0 OID 16621)
-- Dependencies: 207
-- Data for Name: test_cases; Type: TABLE DATA; Schema: dev; Owner: postgres
--



--
-- TOC entry 2909 (class 0 OID 16633)
-- Dependencies: 209
-- Data for Name: user_address; Type: TABLE DATA; Schema: dev; Owner: postgres
--



--
-- TOC entry 2910 (class 0 OID 16639)
-- Dependencies: 210
-- Data for Name: user_contests; Type: TABLE DATA; Schema: dev; Owner: postgres
--



--
-- TOC entry 2911 (class 0 OID 16645)
-- Dependencies: 211
-- Data for Name: user_roles; Type: TABLE DATA; Schema: dev; Owner: postgres
--



--
-- TOC entry 2912 (class 0 OID 16648)
-- Dependencies: 212
-- Data for Name: user_submissions; Type: TABLE DATA; Schema: dev; Owner: postgres
--



--
-- TOC entry 2908 (class 0 OID 16627)
-- Dependencies: 208
-- Data for Name: users; Type: TABLE DATA; Schema: dev; Owner: postgres
--



--
-- TOC entry 2735 (class 2606 OID 16655)
-- Name: contests contests_pkey; Type: CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.contests
    ADD CONSTRAINT contests_pkey PRIMARY KEY (contest_id);


--
-- TOC entry 2740 (class 2606 OID 16657)
-- Name: languages languages_pkey; Type: CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.languages
    ADD CONSTRAINT languages_pkey PRIMARY KEY (language_id);


--
-- TOC entry 2758 (class 2606 OID 16659)
-- Name: user_contests pk_submission_id; Type: CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.user_contests
    ADD CONSTRAINT pk_submission_id PRIMARY KEY (submission_id);


--
-- TOC entry 2743 (class 2606 OID 16661)
-- Name: questions questions_pkey; Type: CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.questions
    ADD CONSTRAINT questions_pkey PRIMARY KEY (question_id);


--
-- TOC entry 2745 (class 2606 OID 16663)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (role_id);


--
-- TOC entry 2749 (class 2606 OID 16665)
-- Name: test_cases test_cases_pkey; Type: CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.test_cases
    ADD CONSTRAINT test_cases_pkey PRIMARY KEY (test_case_id);


--
-- TOC entry 2753 (class 2606 OID 16669)
-- Name: user_address user_address_pkey; Type: CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.user_address
    ADD CONSTRAINT user_address_pkey PRIMARY KEY (user_address_id);


--
-- TOC entry 2751 (class 2606 OID 16667)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- TOC entry 2746 (class 1259 OID 16670)
-- Name: fki_fk_contest_id; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_contest_id ON dev.test_cases USING btree (contest_id);


--
-- TOC entry 2737 (class 1259 OID 16671)
-- Name: fki_fk_contest_id_2; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_contest_id_2 ON dev.contest_questions USING btree (contest_id);


--
-- TOC entry 2754 (class 1259 OID 16672)
-- Name: fki_fk_contest_id_3; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_contest_id_3 ON dev.user_contests USING btree (contest_id);


--
-- TOC entry 2741 (class 1259 OID 16673)
-- Name: fki_fk_language_id_1; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_language_id_1 ON dev.questions USING btree (supported_language_id);


--
-- TOC entry 2736 (class 1259 OID 16674)
-- Name: fki_fk_language_id_2; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_language_id_2 ON dev.contests USING btree (supported_language_id);


--
-- TOC entry 2761 (class 1259 OID 16675)
-- Name: fki_fk_language_id_3; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_language_id_3 ON dev.user_submissions USING btree (submission_language_id);


--
-- TOC entry 2747 (class 1259 OID 16676)
-- Name: fki_fk_question_id; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_question_id ON dev.test_cases USING btree (question_id);


--
-- TOC entry 2738 (class 1259 OID 16677)
-- Name: fki_fk_question_id_2; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_question_id_2 ON dev.contest_questions USING btree (question_id);


--
-- TOC entry 2755 (class 1259 OID 16678)
-- Name: fki_fk_question_id_3; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_question_id_3 ON dev.user_contests USING btree (question_id);


--
-- TOC entry 2759 (class 1259 OID 16679)
-- Name: fki_fk_role_id_1; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_role_id_1 ON dev.user_roles USING btree (role_id);


--
-- TOC entry 2762 (class 1259 OID 16680)
-- Name: fki_fk_submission_id_1; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_submission_id_1 ON dev.user_submissions USING btree (submission_id);


--
-- TOC entry 2763 (class 1259 OID 16681)
-- Name: fki_fk_test_case_id_3; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_test_case_id_3 ON dev.user_submissions USING btree (test_case_id);


--
-- TOC entry 2760 (class 1259 OID 16682)
-- Name: fki_fk_user_id_2; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_user_id_2 ON dev.user_roles USING btree (user_id);


--
-- TOC entry 2756 (class 1259 OID 16683)
-- Name: fki_fk_user_id_3; Type: INDEX; Schema: dev; Owner: postgres
--

CREATE INDEX fki_fk_user_id_3 ON dev.user_contests USING btree (user_id);


--
-- TOC entry 2766 (class 2606 OID 16684)
-- Name: test_cases fk_contest_id; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.test_cases
    ADD CONSTRAINT fk_contest_id FOREIGN KEY (contest_id) REFERENCES dev.contests(contest_id) NOT VALID;


--
-- TOC entry 2764 (class 2606 OID 16689)
-- Name: contest_questions fk_contest_id_2; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.contest_questions
    ADD CONSTRAINT fk_contest_id_2 FOREIGN KEY (contest_id) REFERENCES dev.contests(contest_id) NOT VALID;


--
-- TOC entry 2768 (class 2606 OID 16694)
-- Name: user_contests fk_contest_id_3; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.user_contests
    ADD CONSTRAINT fk_contest_id_3 FOREIGN KEY (contest_id) REFERENCES dev.contests(contest_id) NOT VALID;


--
-- TOC entry 2773 (class 2606 OID 16699)
-- Name: user_submissions fk_language_id_3; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.user_submissions
    ADD CONSTRAINT fk_language_id_3 FOREIGN KEY (submission_language_id) REFERENCES dev.languages(language_id) NOT VALID;


--
-- TOC entry 2767 (class 2606 OID 16704)
-- Name: test_cases fk_question_id; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.test_cases
    ADD CONSTRAINT fk_question_id FOREIGN KEY (question_id) REFERENCES dev.questions(question_id) ON UPDATE RESTRICT ON DELETE RESTRICT NOT VALID;


--
-- TOC entry 2765 (class 2606 OID 16709)
-- Name: contest_questions fk_question_id_2; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.contest_questions
    ADD CONSTRAINT fk_question_id_2 FOREIGN KEY (question_id) REFERENCES dev.questions(question_id) NOT VALID;


--
-- TOC entry 2769 (class 2606 OID 16714)
-- Name: user_contests fk_question_id_3; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.user_contests
    ADD CONSTRAINT fk_question_id_3 FOREIGN KEY (question_id) REFERENCES dev.questions(question_id) NOT VALID;


--
-- TOC entry 2771 (class 2606 OID 16719)
-- Name: user_roles fk_role_id_1; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.user_roles
    ADD CONSTRAINT fk_role_id_1 FOREIGN KEY (role_id) REFERENCES dev.roles(role_id) ON UPDATE RESTRICT ON DELETE RESTRICT NOT VALID;


--
-- TOC entry 2774 (class 2606 OID 16724)
-- Name: user_submissions fk_submission_id_1; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.user_submissions
    ADD CONSTRAINT fk_submission_id_1 FOREIGN KEY (submission_id) REFERENCES dev.user_contests(submission_id) ON UPDATE RESTRICT ON DELETE RESTRICT NOT VALID;


--
-- TOC entry 2775 (class 2606 OID 16729)
-- Name: user_submissions fk_test_case_id_3; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.user_submissions
    ADD CONSTRAINT fk_test_case_id_3 FOREIGN KEY (test_case_id) REFERENCES dev.test_cases(test_case_id) NOT VALID;


--
-- TOC entry 2772 (class 2606 OID 16734)
-- Name: user_roles fk_user_id_2; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.user_roles
    ADD CONSTRAINT fk_user_id_2 FOREIGN KEY (user_id) REFERENCES dev.users(user_id) ON UPDATE RESTRICT ON DELETE RESTRICT NOT VALID;


--
-- TOC entry 2770 (class 2606 OID 16739)
-- Name: user_contests fk_user_id_3; Type: FK CONSTRAINT; Schema: dev; Owner: postgres
--

ALTER TABLE ONLY dev.user_contests
    ADD CONSTRAINT fk_user_id_3 FOREIGN KEY (user_id) REFERENCES dev.users(user_id) NOT VALID;


-- Completed on 2020-04-10 04:54:25

--
-- PostgreSQL database dump complete
--

