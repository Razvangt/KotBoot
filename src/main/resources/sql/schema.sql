CREATE TABLE IF NOT EXISTS TAG(
    id  varchar(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    name varchar(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS WORKSPACE(
    id  varchar(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    name varchar(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS LINK(
    id  varchar(60) DEFAULT RANDOM_UUID() PRIMARY KEY,
    name varchar(40) NOT NULL,
    url  varchar(300) NOT NULL,
    workspace_id varchar(60),
    foreign key (workspace_id) references WORKSPACE(id)
);

CREATE TABLE IF NOT EXISTS LINK_TAGS(
    link_id varchar(60),
    tag_id varchar(60),
    foreign key (link_id) references LINK(id),
    foreign key (tag_id)  references TAG(id)
);