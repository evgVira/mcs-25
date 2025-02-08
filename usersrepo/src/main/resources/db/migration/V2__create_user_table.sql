create table if not exists users.user
(
    user_id UUID primary key not null,
    username varchar not null,
    password varchar not null,
    email varchar not null
);