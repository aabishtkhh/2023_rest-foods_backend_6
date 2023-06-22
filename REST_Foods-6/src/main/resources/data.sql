INSERT INTO pizzas ("name",price,description,chefs_choice,category,image_url,"size") VALUES
	 ('Margherita',16,'Tomaten, Mozarella, Oregano',false,'main','https://www.bettybossi.ch/rdbimg/bb_itku120801_0243a/bb_itku120801_0243a_r02_v003_x0020.jpg',20),
	 ('Prosciutto',19.5,'Hinterschinken',false,'main','https://www.gutekueche.ch/upload/rezept/12049/1600x900_pizza-prosciutto-e-fungi.jpg',20),
	 ('Salami',19,'Salami normal',true,'main','https://www.daskochrezept.de/sites/daskochrezept.de/files/styles/full_width_tablet_4_3/public/2021-05/pizza_salami.jpg?h=21272edb&itok=ipXn2R5l',20),
	 ('Margherita',16,'Tomaten, Mozarella, Oregano',false,'main','https://www.bettybossi.ch/rdbimg/bb_itku120801_0243a/bb_itku120801_0243a_r02_v003_x0020.jpg',20),
	 ('Prosciutto',19.5,'Hinterschinken',false,'main','https://www.gutekueche.ch/upload/rezept/12049/1600x900_pizza-prosciutto-e-fungi.jpg',20),
	 ('Salami',19,'Salami normal',true,'main','https://www.daskochrezept.de/sites/daskochrezept.de/files/styles/full_width_tablet_4_3/public/2021-05/pizza_salami.jpg?h=21272edb&itok=ipXn2R5l',20);

INSERT INTO drinks ("name",price,image_url,"size") VALUES
	 ('Cola',5,'https://www.confiserie.ch/media/catalog/product/cache/4090234a56efcbb918fa5559d3e7cbe5/c/o/coca_cola_50cl_1.jpg',500),
	 ('Fanta',4.5,'https://c-pi.niceshops.com/upload/image/product/large/default/45840_b68ef69a.512x512.jpg',500),
	 ('Sprite',5,'https://c-pi.niceshops.com/upload/image/product/large/default/49891_deefc18c.512x512.jpg',500),
	 ('Cola',5,'https://www.confiserie.ch/media/catalog/product/cache/4090234a56efcbb918fa5559d3e7cbe5/c/o/coca_cola_50cl_1.jpg',500),
	 ('Fanta',4.5,'https://c-pi.niceshops.com/upload/image/product/large/default/45840_b68ef69a.512x512.jpg',500),
	 ('Sprite',5,'https://c-pi.niceshops.com/upload/image/product/large/default/49891_deefc18c.512x512.jpg',500);

-- users
INSERT INTO RESTFOOD_users (name, password)
VALUES ('user', 'user01_uek295'),
       ('user2', 'user02_uek295') ON CONFLICT DO NOTHING;

-- roles
INSERT INTO RESTFOOD_roles(name)
VALUES ('ADMIN'),
       ('USER') ON CONFLICT DO NOTHING;

-- authorities
INSERT INTO RESTFOOD_authorities(name)
VALUES ('GET'),
       ('POST'),
       ('PUT'),
       ('DELETE') ON CONFLICT DO NOTHING;

-- assign roles to users
INSERT INTO RESTFOOD_users_roles (user_id, id_role)
VALUES (1, 1),
       (2, 2) ON CONFLICT DO NOTHING;

-- assign authorities to roles
INSERT INTO RESTFOOD_roles_authorities(id_role, id_auth)
VALUES (1, 1),
       (1, 2),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 4)
    ON CONFLICT DO NOTHING;






