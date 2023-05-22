CREATE SCHEMA IF NOT EXISTS neeastestdb;
create table if not exists neeastestdb.statuses
(
    id             BIGSERIAL primary key,
    service_id     BIGSERIAL NOT NULL UNIQUE,
    service_status VARCHAR,
    time_stamp     timestamp
);
create table if not exists neeastestdb.messages
(
    message_id BIGSERIAL primary key,
    service_id BIGINT NOT NULL references neeastestdb.statuses (service_id) ON DELETE CASCADE,
    messages   VARCHAR,
    time_stamp timestamp
);
create table if not exists neeastestdb.activitylogs
(
    log_id     BIGSERIAL primary key,
    activity   VARCHAR,
    time_stamp timestamp
);