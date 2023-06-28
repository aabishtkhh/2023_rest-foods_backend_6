INSERT INTO foods ("name", price, description, chefs_choice, category, is_it_pizza, image_url, "size")
VALUES
    ('Margherita', 16, 'Tomato, Mozzarella, Oregano', false, 'main', true, 'https://www.bettybossi.ch/rdbimg/bb_itku120801_0243a/bb_itku120801_0243a_r02_v003_x0020.jpg', 20),
    ('Prosciutto', 19.5, 'Ham, Tomato, Mozzarella', false, 'main', true , 'https://www.gutekueche.ch/upload/rezept/12049/1600x900_pizza-prosciutto-e-fungi.jpg', 20),
    ('Salami', 19, 'Salami, Tomato, Mozzarella', true, 'main', true, 'https://www.daskochrezept.de/sites/daskochrezept.de/files/styles/full_width_tablet_4_3/public/2021-05/pizza_salami.jpg?h=21272edb&itok=ipXn2R5l', 20),
    ('Funghi', 17.5, 'Tomato Sauce, Mozzarella, Fresh Champignons', false, 'main', true, 'https://media.istockphoto.com/id/1170797228/photo/pizza-with-mushrooms-on-dark-grey-concrete-table.jpg?s=612x612&w=0&k=20&c=fYRNQR_96SDtZlUMNscT1n38nSlKTVpk3DpwCSXakk0=', 20),
    ('Carbonara', 19, 'Cream, Pecorino Romano Cheese, Spring Onions, Eggs, Black Pepper', true, 'main', true , 'https://sushi24.ge/images/thumbs/0001700_carbonara-pizza-33-cm_510.jpeg', 20),

    ('Spagetti', 20, 'Tomato, Basil, Mozzarella', false, 'main', false, 'https://thekitchengirl.com/wp-content/uploads/Instant-Pot-Spaghetti-B_89.jpg', 7),
    ('Ravioli', 15, 'Cream, Parmesan Cheese, Shallot, Ham *Available without Ham*', true, 'main', false, 'https://anitalianinmykitchen.com/wp-content/uploads/2022/09/mushroom-rav-sq-1-of-1.jpg', 8),
    ('Tortellini', 15, 'Cream, Vegetable Bouillon,  Ham *Available without Ham*', true, 'main', false, 'https://plantifullybasedblog.com/wp-content/uploads/2019/03/tortellini-image.png', 8),
    ('Cappelletti', 15, 'Cream, Parmigiano Cheese, Chard, Thyme, Yellow Onion', true, 'main', false, 'https://images.squarespace-cdn.com/content/v1/5ea9a4e382294041c8e958f5/1611574637113-Q7P04WLU6Y9XV4NRMZXU/cappelletti.jpg', 6);

INSERT INTO drinks ("name", price, image_url, "size")
VALUES ('Cola', 3.5,
        'https://www.confiserie.ch/media/catalog/product/cache/4090234a56efcbb918fa5559d3e7cbe5/c/o/coca_cola_50cl_1.jpg',
        500),
       ('Fanta', 4.5, 'https://c-pi.niceshops.com/upload/image/product/large/default/45840_b68ef69a.512x512.jpg', 500),
       ('Sprite', 4, 'https://c-pi.niceshops.com/upload/image/product/large/default/49891_deefc18c.512x512.jpg', 500),
       ('Water', 3, 'https://westferry.fodal.co.uk/wp-content/uploads/2021/12/evian-50cl-800x800.png',  300),
       ('Pepsi', 3, 'https://m.media-amazon.com/images/I/51pGxfs4w1L.jpg', 500),
       ('Ice Tea', 3, 'https://natashaskitchen.com/wp-content/uploads/2021/07/Iced-Tea-3-1.jpg', 500),
       ('Wine', 5, 'https://www.varta-guide.de/wp-content/uploads/2018/03/wein-trauben.jpg', 500),
       ('Tee', 5, 'https://naturkost.de/wd/wp-content/uploads/2016/06/tee-fotolia-1024x640.jpg', 500);

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