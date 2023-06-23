INSERT INTO foods ("name", price, description, chefs_choice, category, isItPizza, image_url, "size")
VALUES (('Margherita', 16, 'Tomaten, Mozzarella, Oregano', false, 'main', true, 'https://www.bettybossi.ch/rdbimg/bb_itku120801_0243a/bb_itku120801_0243a_r02_v003_x0020.jpg', 20),
        ('Prosciutto', 19.5, 'Hinterschinken, Tomaten, Mozzarella', false, 'main', true , 'https://www.gutekueche.ch/upload/rezept/12049/1600x900_pizza-prosciutto-e-fungi.jpg', 20),
        --('Salami', 19, 'Salami, Tomaten, Mozzarella', true, 'main', true, 'https://www.daskochrezept.de/sites/daskochrezept.de/files/styles/full_width_tablet_4_3/public/2021-05/pizza_salami.jpg?h=21272edb&itok=ipXn2R5l', 20),
        ('Funghi', 17.5, 'Tomatensauce, Mozzarella, frische Champignons', false, 'main', true ,
         '!!!!', 20),
        ('Carbonara', 19, 'Pecorino Romano Käse, Sahne, Frühlingszwiebeln, Eier, schwarzer Pfeffer', true, 'main', true ,
         '!!!!', 20),

        --pasta
       ('Spagetti', 20, 'Tomaten, Basilikum, Mozzarella', false, 'main', false,
        '!!!!', 7),
       ('Ravioli', 15, 'Cream, Parmesan Käse, Schalotte, Schinken *Auch Ohne Schinken Verfügbar*', true, 'main', false,
        '!!!!', 8),
       ('Tortellini', 15, 'Cream, Gemüsebouillon, Schinken *Auch Ohne Schinken Verfügbar*', true, 'main', false,
        '!!!!', 8),
       ('Cappelletti', 15, 'Parmigiano Käse, Gelbzwiebel', true, 'main', false,
        '!!!!', 6));

INSERT INTO drinks ("name", price, image_url, "size")
VALUES ('Cola', 3.5,
        'https://www.confiserie.ch/media/catalog/product/cache/4090234a56efcbb918fa5559d3e7cbe5/c/o/coca_cola_50cl_1.jpg',
        500),
       ('Fanta', 4.5, 'https://c-pi.niceshops.com/upload/image/product/large/default/45840_b68ef69a.512x512.jpg', 500),
       ('Sprite', 4, 'https://c-pi.niceshops.com/upload/image/product/large/default/49891_deefc18c.512x512.jpg', 500),
       ('Water', 3, '',  300),
       ('Pepsi', 3, '', 500),
       ('Ice Tea', 3, '', 500),
       ('Wein', 5, '', 500);

-- users
INSERT INTO restfood_users(user_Id, name, password)
VALUES (1, 'admin_user', '0987'),
       (2, 'user', '1234')
ON CONFLICT DO NOTHING;

-- roles
INSERT INTO restfood_roles(id_role, name)
VALUES (1, 'ADMIN'),
       (2, 'USER')
ON CONFLICT DO NOTHING;

-- authorities
INSERT INTO restfood_authorities(id_auth, name)
VALUES (1, 'GET'),
       (2, 'POST'),
       (3, 'PUT'),
       (4, 'DELETE')
ON CONFLICT DO NOTHING;

-- assign roles to users
INSERT INTO restfood_users_roles(user_Id, id_role)
VALUES (1, 1),
       (2, 2)
ON CONFLICT DO NOTHING;

-- assign authorities to roles
INSERT INTO restfood_roles_authorities(id_role, id_auth)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),

       (2, 1) -- user can only use "get"
ON CONFLICT DO NOTHING;