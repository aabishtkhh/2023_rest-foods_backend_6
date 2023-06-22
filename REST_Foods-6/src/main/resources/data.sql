-- users
INSERT INTO restfood_users(id_user, name, password)
VALUES (1, 'admin_user', '0987'),
       (2, 'user', '1234') ON CONFLICT DO NOTHING;

-- roles
INSERT INTO restfood_roles(id_role, name)
VALUES (1, 'ADMIN'),
       (2, 'USER') ON CONFLICT DO NOTHING;

-- authorities
INSERT INTO restfood_authorities(id_auth, name)
VALUES (1, 'GET'),
       (2, 'POST'),
       (3, 'PUT'),
       (4, 'DELETE') ON CONFLICT DO NOTHING;

-- assign roles to users
INSERT INTO restfood_users_roles(id_user, id_role)
VALUES (1, 1),
       (2, 2) ON CONFLICT DO NOTHING;

-- assign authorities to roles
INSERT INTO restfood_roles_authorities(id_role, id_auth)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),

       (2, 1) -- user can only use "get"
ON CONFLICT DO NOTHING;






