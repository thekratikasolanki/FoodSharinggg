-- data.sql

INSERT INTO user (email, password) VALUES ('test@example.com', '$2a$10$D4Oqk5i5E3e0Zg/CIXkhuOeTPo4sQEmKOe3V0y/B.GOo7x4jNXn/S'); -- password is 'password' encrypted using bcrypt

INSERT INTO food_giver (event_type, location, date, estimated_attendees, food_type, number_of_food_items, number_of_persons_served)
VALUES ('Charity Event', 'Community Hall', '2023-06-15', 100, 'Veg', 10, 50);

