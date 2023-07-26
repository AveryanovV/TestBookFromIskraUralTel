-- liquibase formatted sql

-- changeset AveryanovV:1.1

insert into GENRE (genre_id, GENRE_NAME) values ( 1, 'роман' );
insert into GENRE (genre_id, GENRE_NAME) values ( 2, 'повесть' );
insert into GENRE (genre_id, GENRE_NAME) values ( 3, 'рассказ' );
insert into GENRE (genre_id, GENRE_NAME) values ( 4, 'комедия' );
insert into GENRE (genre_id, GENRE_NAME) values ( 5, 'трагедия' );
insert into GENRE (genre_id, GENRE_NAME) values ( 6, 'драма' );
insert into GENRE (genre_id, GENRE_NAME) values ( 7, 'баллада' );
insert into GENRE (genre_id, GENRE_NAME) values ( 8, 'триллер' );

-- changeset AveryanovV:1.2

insert into AUTHORS (AUTHOR_ID, FIRST_NAME, LAST_NAME) values ( 1, 'Михаил', 'Булгаков' );
insert into AUTHORS (AUTHOR_ID, FIRST_NAME, LAST_NAME) values ( 2, 'Николай', 'Гоголь' );
insert into AUTHORS (AUTHOR_ID, FIRST_NAME, LAST_NAME) values ( 3, 'Александр', 'Дюма' );
insert into AUTHORS (AUTHOR_ID, FIRST_NAME, LAST_NAME) values ( 4, 'Александр', 'Пушкин' );
insert into AUTHORS (AUTHOR_ID, FIRST_NAME, LAST_NAME) values ( 5, 'Федор', 'Достоевский' );
insert into AUTHORS (AUTHOR_ID, FIRST_NAME, LAST_NAME) values ( 6, 'Лев', 'Толстой' );
insert into AUTHORS (AUTHOR_ID, FIRST_NAME, LAST_NAME) values ( 7, 'Иван', 'Тургенев' );
insert into AUTHORS (AUTHOR_ID, FIRST_NAME, LAST_NAME) values ( 8, 'Антон', 'Чехов' );
insert into AUTHORS (AUTHOR_ID, FIRST_NAME, LAST_NAME) values ( 9, 'Эрнест', 'Хемингуэй' );
insert into AUTHORS (AUTHOR_ID, FIRST_NAME, LAST_NAME) values ( 10, 'Жюль', 'Верн' );

-- changeset AveryanovV:1.3

insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 1, 'Мастер и Маргарита', 1940, 15, 1 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 2, 'Собачье сердце', 1925, 10, 1 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 3, 'Мёртвые души', 1842, 8, 2 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 4, 'Граф Монте-Кристо', 1845, 20, 3 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 5, 'Преступление и наказание', 1866, 5, 5 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 6, 'Война и мир', 1868, 15, 6 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 7, 'Повести Белкина', 1831, 2, 4 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 8, 'Ревизор', 1836, 15, 2 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 9, 'Село Степанчиково и его обитатели', 1859, 7, 5 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 10, 'Три мушкетера', 1844, 16, 3 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 11, 'Отцы и дети', 1861, 15, 7 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 12, 'Палата № 6', 1892, 50, 8 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 13, 'Братья Карамазовы', 1880, 6, 5 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 14, 'Старик и море', 1952, 18, 9 );
insert into BOOK (BOOK_ID, BOOK_NAME, BOOK_YEAR, COUNT, AUTHOR_ID) VALUES ( 15, 'Двадцать тысяч лье под водой', 1869, 22, 10 );

-- changeset AveryanovV:1.4

insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 1, 1 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 1, 2 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 1, 5 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 2, 4 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 2, 5 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 2, 6 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 2, 2 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 3, 2 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 3, 3 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 4, 1 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 4, 6 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 4, 8 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 5, 5 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 5, 6 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 6, 2 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 6, 8 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 7, 2 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 7, 4 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 8, 4 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 8, 3 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 9, 3 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 9, 6 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 10, 1 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 10, 4 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 10, 8 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 11, 1 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 11, 6 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 12, 4 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 12, 8 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 13, 1 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 13, 4 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 14, 1 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 14, 6 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 14, 8 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 15, 1 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 15, 6 );
insert into BOOK_GENRE (BOOK_ID, GENRE_ID) VALUES ( 15, 8 );
