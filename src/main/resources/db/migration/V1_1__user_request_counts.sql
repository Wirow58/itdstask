create sequence user_request_counts_id_seq;

create table user_request_counts (
    id bigint primary key,
    login varchar(128) unique,
    request_count bigint
)