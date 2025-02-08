create table if not exists auth.user_auth
(
    user_id UUID primary key not null unique,
    username varchar not null unique,
    password varchar not null
);