INSERT INTO users (name, surname, gender, birthdate) VALUES ('Γιάννης', 'Παπαδόπουλος', 'M', '1990-05-15');
INSERT INTO addresses (type, details, user_id) VALUES ('HOME', 'Ερμού 15, Αθήνα 10563', (SELECT id FROM users WHERE name = 'Γιάννης' AND surname = 'Παπαδόπουλος'));
INSERT INTO addresses (type, details, user_id) VALUES ('WORK', 'Λεωφόρος Κηφισίας 32, Μαρούσι 15125', (SELECT id FROM users WHERE name = 'Γιάννης' AND surname = 'Παπαδόπουλος'));

INSERT INTO users (name, surname, gender, birthdate) VALUES ('Μαρία', 'Οικονόμου', 'F', '1992-08-22');
INSERT INTO addresses (type, details, user_id) VALUES ('HOME', 'Τσιμισκή 45, Θεσσαλονίκη 54623', (SELECT id FROM users WHERE name = 'Μαρία' AND surname = 'Οικονόμου'));
INSERT INTO addresses (type, details, user_id) VALUES ('WORK', 'Εγνατία 10, Θεσσαλονίκη 54626', (SELECT id FROM users WHERE name = 'Μαρία' AND surname = 'Οικονόμου'));

INSERT INTO users (name, surname, gender, birthdate) VALUES ('Κώστας', 'Νικολάου', 'M', '1985-11-03');
INSERT INTO addresses (type, details, user_id) VALUES ('HOME', 'Αγίου Ανδρέα 12, Πάτρα 26221', (SELECT id FROM users WHERE name = 'Κώστας' AND surname = 'Νικολάου'));
INSERT INTO addresses (type, details, user_id) VALUES ('WORK', 'Μαιζώνος 50, Πάτρα 26221', (SELECT id FROM users WHERE name = 'Κώστας' AND surname = 'Νικολάου'));

INSERT INTO users (name, surname, gender, birthdate) VALUES ('Ελένη', 'Γεωργίου', 'F', '1995-02-18');
INSERT INTO addresses (type, details, user_id) VALUES ('HOME', 'Αριστοτέλους 8, Αθήνα 10432', (SELECT id FROM users WHERE name = 'Ελένη' AND surname = 'Γεωργίου'));
INSERT INTO addresses (type, details, user_id) VALUES ('WORK', 'Συγγρού 120, Αθήνα 11741', (SELECT id FROM users WHERE name = 'Ελένη' AND surname = 'Γεωργίου'));

INSERT INTO users (name, surname, gender, birthdate) VALUES ('Δημήτρης', 'Αντωνίου', 'M', '1988-07-09');
INSERT INTO addresses (type, details, user_id) VALUES ('HOME', 'Βασιλίσσης Σοφίας 5, Αθήνα 10671', (SELECT id FROM users WHERE name = 'Δημήτρης' AND surname = 'Αντωνίου'));
INSERT INTO addresses (type, details, user_id) VALUES ('WORK', 'Πανεπιστημίου 30, Αθήνα 10679', (SELECT id FROM users WHERE name = 'Δημήτρης' AND surname = 'Αντωνίου'));

INSERT INTO users (name, surname, gender, birthdate) VALUES ('Άννα', 'Κωνσταντίνου', 'F', '1998-12-01');
INSERT INTO addresses (type, details, user_id) VALUES ('HOME', 'Ηρώων Πολυτεχνείου 40, Πειραιάς 18531', (SELECT id FROM users WHERE name = 'Άννα' AND surname = 'Κωνσταντίνου'));
INSERT INTO addresses (type, details, user_id) VALUES ('WORK', 'Ακτή Μιαούλη 15, Πειραιάς 18535', (SELECT id FROM users WHERE name = 'Άννα' AND surname = 'Κωνσταντίνου'));