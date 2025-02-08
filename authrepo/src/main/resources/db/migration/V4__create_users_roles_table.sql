create table if not exists auth.users_roles
(
    user_id UUID not null,
    role_id UUID not null,
    foreign key (user_id) references auth.user_auth (user_id),
    foreign key (role_id) references auth.role_t (role_id)
);