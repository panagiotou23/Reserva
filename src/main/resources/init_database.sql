create table client
(
    id           bigserial,
    name         varchar,
    phone_number varchar,
    primary key(id)
);

create table restaurant
(
    id           bigserial,
    name         varchar,
    phone_number varchar,
    address      varchar,
    opening_hour varchar,
    closing_hour varchar,
    primary key(id)
);

create table restaurant_open_days_mapping
(
    restaurant_id bigint,
    day varchar,
    foreign key(restaurant_id) references restaurant(id)
);

create table reservation
(
    id bigserial,
    client_id bigint,
    restaurant_id bigint,
    number_of_people int,
    time timestamp,
    primary key(id),
    foreign key(client_id) references client(id),
    foreign key(restaurant_id) references restaurant(id)
);

insert into client (name, phone_number)
values ('Alex Panagiotou', '+306912345678'),
       ('Ioannis Kazatzidis', '+306987654321'),
       ('Manos Nikopolitidis', '+306912367890');

insert into restaurant (name, phone_number, address, opening_hour, closing_hour)
values ('Local Restaurant', '+302310123456', 'Somewhere in Greece', '13:00', '23:59');

insert into reservation (client_id, restaurant_id, number_of_people, time)
values (1, 1, 4, current_timestamp);

insert into restaurant_open_days_mapping (restaurant_id, day)
values (1, 'TUESDAY'),
       (1, 'WEDNESDAY'),
       (1, 'THURSDAY'),
       (1, 'FRIDAY'),
       (1, 'SATURDAY'),
       (1, 'SUNDAY');