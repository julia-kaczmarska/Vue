INSERT INTO users (email, name, password, role)
SELECT 'string@string.pl', 'string', '$2a$10$HYL/9hSCcBBe2i5s7pKK0.o4RZhfQQyIcpqOZFDRpNdO/AgZu30Ky', 'ADMIN'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE name = 'string');

INSERT INTO users (email, name, password, role)
SELECT 'adm@in.pl', 'admin', '$2a$12$EIouDfgg24ln9q4Q.tPuI.Z7zmm3IvtQwBz1jbhOKenUqLptHBxgu', 'ADMIN'
WHERE NOT EXISTS (SELECT 1 FROM users WHERE name = 'admin');

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

ALTER TABLE `users` CHANGE `name` `name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL AFTER `id`;

-- 1
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 1, 1, 1, 'Tuja Obronna', 'Odmiana bardzo odporna na mróz i choroby, idealna do tworzenia zielonych żywopłotów.', '150', 'Żywotnik zachodni (Thuja occidentalis)', 'OK'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Tuja Obronna');

-- 2
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 1, 2, 1, 'Cedr Libański', 'Wyjątkowy gatunek o intensywnym zapachu, idealny do sadzenia w ogrodach ziołowych.', '80', 'Cedr libański (Cedrus libani)', 'OK'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Cedr Libański');

-- 3
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 1, 3, 1, 'Cyprysik Lawsona', 'Krzew iglasty o dekoracyjnym pokroju, świetnie komponuje się w ogrodach japońskich.', '120', 'Cyprysik Lawsona (Chamaecyparis lawsoniana)', 'DAMAGED'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Cyprysik Lawsona');

-- 4
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 1, 4, 1, 'Jałowiec Pospolity', 'Odporny na warunki atmosferyczne gatunek, często wykorzystywany w projektach krajobrazowych.', '100', 'Jałowiec pospolity (Juniperus communis)', 'BORROWED'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Jałowiec Pospolity');

-- 5
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 2, 1, 1, 'Tuje Smaragd', 'Odmiana charakteryzująca się pięknym, gęstym pokrojem, idealna do ogrodów przydomowych.', '180', 'Żywotnik zachodni (Thuja occidentalis)', 'DAMAGED'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Tuje Smaragd');

-- 6
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 2, 2, 1, 'Cyprysy Gold Rider', 'Cyprysy o złocistych igłach, które nadają kompozycjom ogrodowym wyjątkowego charakteru.', '90', 'Cyprysik Lawsona (Chamaecyparis lawsoniana)', 'OK'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Cyprysy Gold Rider');

-- 7
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 2, 3, 1, 'Sosna Limba', 'Gatunek charakteryzujący się eleganckim pokrojem, świetnie sprawdza się w projektach krajobrazowych.', '70', 'Sosna limba (Pinus cembra)', 'BORROWED'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Sosna Limba');

-- 8
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 2, 4, 1, 'Jałowiec Blue Arrow', 'Odmiana o wąskim pokroju, doskonale nadaje się do tworzenia geometrycznych form w ogrodach.', '110', 'Jałowiec płożący (Juniperus squamata)', 'BORROWED'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Jałowiec Blue Arrow');

-- 9
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 3, 1, 1, 'Świerk Serbski', 'Gatunek o regularnym pokroju, doskonale sprawdzi się jako ozdobne drzewo w ogrodach parkowych.', '60', 'Świerk serbski (Picea omorika)', 'DAMAGED'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Świerk Serbski');

-- 10
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 3, 2, 1, 'Sosna Białe Pióra', 'Sosna o wyjątkowo delikatnych igłach, pięknie prezentuje się w ogrodach japońskich.', '40', 'Sosna limba (Pinus cembra)', 'BORROWED'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Sosna Białe Pióra');

-- 11
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 3, 3, 1, 'Cyprysik Filifera Aurea', 'Cyprysik o złocistych igłach, nadaje się do sadzenia w donicach na tarasach i balkonach.', '85', 'Cyprysik Filifera Aurea (Chamaecyparis lawsoniana)', 'DAMAGED'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Cyprysik Filifera Aurea');

-- 12
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 3, 4, 1, 'Cis pospolity', 'Cis o ciekawym pokroju, doskonale komponuje się w ogrodach naturalistycznych.', '75', 'Cis pospolity (Taxus baccata)', 'OK'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Cis pospolity');

-- 13
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 1, 1, 1, 'Tawuła Gęstolistna', 'Odmiana o bujnym pokroju, świetnie nadaje się do sadzenia w miejscach cienistych.', '95', 'Tawuła gęstolistna (Aucuba japonica)', 'OK'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Tawuła Gęstolistna');

-- 14
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 1, 2, 1, 'Modrzew Europejski', 'Drzewo iglaste o złocistożółtych igłach, pięknie prezentuje się w ogrodach o charakterze naturalnym.', '65', 'Modrzew europejski (Larix decidua)', 'BORROWED'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Modrzew Europejski');

-- 15
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 1, 3, 1, 'Sekwoja wieczniezielona', 'Imponujące drzewo o regularnym pokroju, doskonale sprawdza się w parkach i ogrodach reprezentacyjnych.', '55', 'Sekwoja wieczniezielona (Sequoia sempervirens)', 'OK'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Sekwoja wieczniezielona');

-- 16
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 2, 1, 1, 'Cis pospolity Fastigiata', 'Odmiana o wąskim, kolumnowym pokroju, idealna do ogrodów o niewielkiej powierzchni.', '75', 'Cis pospolity (Taxus baccata)', 'BORROWED'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Cis pospolity Fastigiata');

-- 17
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 2, 2, 1, 'Modrzew Japoński', 'Drzewo o subtelnym pokroju, wyjątkowo efektowne w japońskich ogrodach krajobrazowych.', '85', 'Modrzew japoński (Larix kaempferi)', 'OK'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Modrzew Japoński');

-- 18
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 2, 3, 1, 'Cyprysik Castlewellan', 'Odmiana o intensywnie zielonych igłach, pięknie kontrastuje z innymi roślinami iglastymi.', '100', 'Cyprysik Lawsona (Chamaecyparis lawsoniana)', 'OK'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Cyprysik Castlewellan');

-- 19
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 3, 1, 1, 'Jałowiec Górski', 'Gatunek o regularnym pokroju, doskonale nadaje się do tworzenia żywopłotów.', '120', 'Jałowiec pospolity (Juniperus communis)', 'BORROWED'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Jałowiec Górski');

-- 20
INSERT INTO inventory (id_place, id_source, id_user, name, notes, quantity, species, state)
SELECT 3, 2, 1, 'Sosna Kontorsjonistyczna', 'Sosna o nietypowym, skręconym pniu, dodaje ogrodowi oryginalności.', '45', 'Sosna limba (Pinus cembra)', 'OK'
WHERE NOT EXISTS (SELECT 1 FROM inventory WHERE name = 'Sosna Kontorsjonistyczna');