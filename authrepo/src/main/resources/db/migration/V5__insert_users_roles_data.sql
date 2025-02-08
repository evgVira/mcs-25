insert into auth.role_t (role_id, role_name)
select 'e0b7b71c-32a4-4e93-ad71-5e525b89f7d1'::UUID,
       'ROLE_USER' where not exists(
        select 1 from auth.role_t
        where role_id = 'e0b7b71c-32a4-4e93-ad71-5e525b89f7d1'::UUID
        and role_name = 'ROLE_USER'
    )
union all
select '705db394-ed4b-45c5-ae14-ccea358b38a8'::UUID,
       'ROLE_ADMIN' where not exists(
        select 1 from auth.role_t
        where role_id = '705db394-ed4b-45c5-ae14-ccea358b38a8'::UUID
        and role_name = 'ROLE_ADMIN'
    );
