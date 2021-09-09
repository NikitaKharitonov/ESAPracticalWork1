INSERT INTO public._group (id, year) VALUES (4, 3);
INSERT INTO public._group (id, year) VALUES (5, 2);
INSERT INTO public._group (id, year) VALUES (6, 1);

INSERT INTO public.course (id, hours, name, group_id) VALUES (11, 18, 'Geography', 5);
INSERT INTO public.course (id, hours, name, group_id) VALUES (12, 36, 'Sport', 6);
INSERT INTO public.course (id, hours, name, group_id) VALUES (13, 18, 'History', 6);
INSERT INTO public.course (id, hours, name, group_id) VALUES (14, 36, 'Chemistry', 5);
INSERT INTO public.course (id, hours, name, group_id) VALUES (15, 18, 'English', 6);
INSERT INTO public.course (id, hours, name, group_id) VALUES (16, 36, 'Technology', 5);
INSERT INTO public.course (id, hours, name, group_id) VALUES (17, 36, 'Physics', 4);
INSERT INTO public.course (id, hours, name, group_id) VALUES (18, 36, 'Biology', 5);
INSERT INTO public.course (id, hours, name, group_id) VALUES (19, 18, 'Literature', 6);
INSERT INTO public.course (id, hours, name, group_id) VALUES (20, 36, 'Math', 4);

INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (11, '1994-04-11', 'Roman', 'Romanov', 5);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (12, '1991-01-03', 'Petr', 'Petrov', 4);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (13, '1996-06-17', 'Olga', 'Olgova', 5);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (14, '1990-10-01', 'Ivan', 'Ivanov', 4);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (15, '1997-07-19', 'Nina', 'Ninova', 6);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (16, '1999-09-30', 'Petr', 'Ivanov', 6);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (17, '1992-02-05', 'Zakhar', 'Zakharov', 4);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (18, '1993-03-07', 'Anna', 'Annova', 5);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (19, '1998-08-23', 'Ivan', 'Petrov', 6);
INSERT INTO public.student (id, dateofbirth, firstname, lastname, group_id) VALUES (20, '1995-05-13', 'Vika', 'Vikova', 5);
