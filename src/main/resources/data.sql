INSERT INTO users (email, name, password, role)
SELECT 'string@string.pl', 'string', '$2a$10$TOBl6zsdiFGFlyns1VMJG.LbgXKyHagvAksbGjDqQGWDJFh.RSiUe', 'ADMIN'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE name = 'string');

INSERT INTO source (name)
SELECT 'Sklep Pana Mietka'
WHERE NOT EXISTS (SELECT 1 FROM source WHERE name = 'Sklep Pana Mietka');

INSERT INTO source (name)
SELECT 'Ziarenko'
WHERE NOT EXISTS (SELECT 1 FROM source WHERE name = 'Ziarenko');

INSERT INTO source (name)
SELECT 'Ogrodnictwo Moskała'
WHERE NOT EXISTS (SELECT 1 FROM source WHERE name = 'Ogrodnictwo Moskała');

INSERT INTO source (name)
SELECT 'Miesiączek'
WHERE NOT EXISTS (SELECT 1 FROM source WHERE name = 'Miesiączek');

INSERT INTO place (name)
SELECT 'Pole 1'
WHERE NOT EXISTS (SELECT 1 FROM place WHERE name = 'Pole 1');

INSERT INTO place (name)
SELECT 'Pole 2'
WHERE NOT EXISTS (SELECT 1 FROM place WHERE name = 'Pole 2');

INSERT INTO place (name)
SELECT 'Tunel'
WHERE NOT EXISTS (SELECT 1 FROM place WHERE name = 'Tunel');

INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 2, 4, 1, 'Tuja Szmaragd', 'Jest doskonałą odmianą na żywopłoty nieformowane oraz do sadzenia w kompozycjach. Jej zielono-szmaragdowe łuski zachowują swoją barwę przez cały rok', '204', 'Żywotnik zachodni (Thuja occidentalis)', 'Na stanie - OK'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Tuja Szmaragd'
);

ALTER TABLE `users` CHANGE `name` `name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL AFTER `id`