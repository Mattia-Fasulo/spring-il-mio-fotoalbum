INSERT INTO db_photoalbum.photos (description, name, url, visible) VALUES( 'Naturalistic photo in Antarctica', 'Seals', 'https://th.bing.com/th/id/R.1e246e0dd7b1c8085f23f4b8587796ab?rik=l%2b7BPvj5LuEdfg&riu=http%3a%2f%2fhighlike.org%2fmedia%2f2013%2f06%2fSEBASTIAO-SALGADO.jpg&ehk=AzCG50BWPLlgTDkwv7LtRknNH5OXU1VsfAmNJyPZ8as%3d&risl=&pid=ImgRaw&r=0', 0);
INSERT INTO db_photoalbum.photos (description, name, url, visible) VALUES( 'Oil well on fire in Kuwait', 'Fire', 'https://5287aa00874a313e299d-1850966fc307ff23e1e789aeafd2476b.ssl.cf5.rackcdn.com/PostImagem/31326/sebastiatildeo-salgado-o-famoso-fotoacutegrafo-brasileiro_o1drldjldbsts7mn1b721d5o1ek5s.jpg', 0);
INSERT INTO db_photoalbum.photos (description, name, url, visible) VALUES( 'Tribe of Eskimos in the snow', 'Snow', 'https://th.bing.com/th/id/R.7155b4ad1f61f154beb78604e26a1166?rik=LAsqlBWuu5ZTyA&riu=http%3a%2f%2fwww.lense.fr%2fwp-content%2fuploads%2f2013%2f10%2fSALGADO-10.jpg&ehk=R9UraV7b%2fcs1N01ufSzW8gpvfjaziuhG%2f1f5DpYABBk%3d&risl=&pid=ImgRaw&r=0', 0);
INSERT INTO db_photoalbum.photos (description, name, url, visible) VALUES( 'Worker in gold mines in Brazil', 'Gold', 'https://www.dodho.com/wp-content/uploads/2015/11/salgado2.jpg', 0);


INSERT INTO db_photoalbum.categories (name) VALUES('Reportage');
INSERT INTO db_photoalbum.categories (name) VALUES('Landscape');
INSERT INTO db_photoalbum.categories (name) VALUES('Architecture');
INSERT INTO db_photoalbum.categories (name) VALUES('Naturalistic');
INSERT INTO db_photoalbum.categories (name) VALUES('Fashion');
INSERT INTO db_photoalbum.categories (name) VALUES('Portraits');
INSERT INTO db_photoalbum.categories (name) VALUES('Animals');


INSERT INTO db_photoalbum.category_photo (photo_id, category_id) VALUES(1, 2);
INSERT INTO db_photoalbum.category_photo (photo_id, category_id) VALUES(1, 4);
INSERT INTO db_photoalbum.category_photo (photo_id, category_id) VALUES(1, 7);

INSERT INTO db_photoalbum.types (name) VALUES('Reportage');
INSERT INTO db_photoalbum.types (name) VALUES('Landscape');
INSERT INTO db_photoalbum.types (name) VALUES('Architecture');
INSERT INTO db_photoalbum.types (name) VALUES('Naturalistic');
INSERT INTO db_photoalbum.types (name) VALUES('Fashion');
INSERT INTO db_photoalbum.types (name) VALUES('Portraits');
INSERT INTO db_photoalbum.types (name) VALUES('Animals');

INSERT INTO db_photoalbum.photo_type (photo_id, type_id) VALUES(1, 2);
INSERT INTO db_photoalbum.photo_type (photo_id, type_id) VALUES(1, 4);
INSERT INTO db_photoalbum.photo_type (photo_id, type_id) VALUES(1, 5);

