-- To make sure that we use correct database before we add data
USE superheroSightings;

INSERT INTO `organization` (organizationName, organizationDescription, organizationContactInfo) VALUES
	('A.I. Army', 'A.I. Bots', '23 Atlantic Ave, Boston'),
    ('Super Weather', 'Weatherization', '35 Main St, Boston'),
    ('Hulk LLC', 'Monster conversion', '2 St Paul St, Brookline'),
    ('Iron Man Inc', 'Technology advancement', '15 Atlantic Ave, Boston');
    
INSERT INTO location (locationName, locationDescription, locationAddress, latitude, longitude) VALUES
	('Time Square', 'Wonderful', 'One Time Square, New York', '40.75650', '-73.98647'),
    ('Copley', 'Ice sculptures', '1 Copley Square, Boston', '42.35028', '-71.07658'),
    ('Boston Common', 'Trees', '139 Tremont St, Boston', '42.35526', '-71.06570'),
    ('Public Garden', 'Urban park', '4 Charles St, Boston', '42.35481', '-71.07080');
    
INSERT INTO superpower (superpowerName) VALUES
	('Agility'),
    ('Armed combatant'),
    ('Breathing underwater'),
    ('Custom web-shooters'),
    ('Danger sense precognition'),
    ('Deception'),
    ('Disguise'),
    ('Durability'),
    ('Enhanced senses'),
    ('Expert tactician'),
    ('Fly'),
    ('Genius-level intellect'),
    ('Hacker'),
    ('Healing ability'),
    ('Indestructible shield'),
    ('Infiltration'),
    ('Jumping'),
    ('Leaping'),
    ('Magical resistance'),
    ('Manipulator'),
    ('Martial artist'),
    ('Master assassin'),
    ('Master spy'),
    ('Multiple powered armor suits'),
    ('Nigh invulnerability'),
    ('Regeneration'),
    ('Skills in espionage'),
    ('Speed'),
    ('Stamina'),
    ('Strength'),
    ('Superhuman condition'),
    ('Vibranium-assisted outfit');

INSERT INTO hero (heroName, heroDescription, superpowerId) VALUES
	('Captain America', 'The First Avenger by age', 15),
    ('Black Panther', 'A king of Wakanda', 32),
    ('Black Widow', 'Talented spy and lethal assassin', 23),
    ('Iron Man', 'Custom power armor', 24),
    ('Hulk', 'The strongest one', 30),
    ('Spider-Man', 'Spider-based powers', 4);
    
INSERT INTO hero_organization (heroId, organizationId) VALUES
	(1, 1),
	(2, 2),
	(3, 2),
	(4, 1),
	(4, 4),
	(5, 3),
	(6, 1);
    
INSERT INTO sighting (locationId, heroId, `date`) VALUES
(1, 1, '2021-06-11'),
(2,	2, '2021-06-12'),
(3,	3, '2021-06-13'),
(4,	4, '2021-06-14'),
(1,	5, '2021-06-15'),
(2,	6, '2021-06-06'),
(3,	1, '2021-06-07'),
(4,	2, '2021-06-08'),
(1,	3, '2021-06-09'),
(2,	4, '2021-06-10'),
(3,	5, '2021-06-01'),
(4,	6, '2021-06-02'),
(1,	1, '2021-06-03'),
(2,	2, '2021-06-04'),
(3,	3, '2021-06-05');