INSERT INTO role (role_id, name) VALUES
  (1, 'ROLE_USER'),
  (2, 'ROLE_OPERATOR'),
  (3, 'ROLE_ADMINISTRATOR') ON CONFLICT DO NOTHING;

INSERT INTO public.user (user_id, firstname, lastname, password, email, username, validated) VALUES
(1,'merlin', 'pelé', '$2a$10$uBiHxI1U2q4PWquM1cHBAOiCST079rJYlJOX9zTy6TYkG6MeqQjBG', 'merlin.pele@amaury.fr', 'merlin.pele', true),
(2,'christian', 'childeric', '$2a$10$uBiHxI1U2q4PWquM1cHBAOiCST079rJYlJOX9zTy6TYkG6MeqQjBG', 'christian.childeric@amaury.fr', 'christian.childeric', true),
(3,'bob', 'burgonde', '$2a$10$uBiHxI1U2q4PWquM1cHBAOiCST079rJYlJOX9zTy6TYkG6MeqQjBG', 'bob95@hotmail.fr', 'bob95', true) ON CONFLICT DO NOTHING;

INSERT INTO user_role(user_id, role_id) VALUES
(1,3),
(2,2),
(3,1) ON CONFLICT DO NOTHING;

SELECT setval('user_user_id_seq', (SELECT MAX(user_id) FROM public.user)+1);

INSERT INTO money_flow_state(money_flow_state_id, code, label) VALUES
(1, 'DEPOSIT', 'Dépôt d''argent'),
(2, 'WIDTHDRAW', 'Retrait d''argent')
ON CONFLICT DO NOTHING;