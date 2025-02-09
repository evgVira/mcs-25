create table if not exists files.file_t
(
    file_id UUID primary key not null unique,
    user_id UUID not null,
    file_name varchar not null,
    file_status varchar not null
);