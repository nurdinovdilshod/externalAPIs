create table tasks
(
    id          serial primary key,
    name        varchar   not null,
    description varchar,
    label       varchar   not null default "Backend",
    created_at  timestamp NOT NULL default current_timestamp
);