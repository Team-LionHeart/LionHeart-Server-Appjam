DROP TABLE IF EXISTS `MEMBER`;

CREATE TABLE `MEMBER`
(
    `MEMBER_ID`   bigint auto_increment primary key,
    `SOCIAL_ID`   varchar(300) NOT NULL,
    `SOCIAL_TYPE` varchar(30)  NOT NULL,
    `FCM_TOKEN`   varchar(300) NOT NULL,
    `NICKNAME`    varchar(30)  NOT NULL,
    `CREATED_AT`  datetime     NOT NULL,
    `MODIFIED_AT` datetime     NOT NULL
);