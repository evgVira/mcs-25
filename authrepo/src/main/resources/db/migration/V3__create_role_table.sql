create table if not exists auth.role_t
(
    role_id UUID primary key not null unique,
    role_name varchar not null unique
);