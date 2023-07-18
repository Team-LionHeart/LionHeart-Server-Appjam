DROP TABLE IF EXISTS `MEMBER`;
DROP TABLE IF EXISTS `ONBOARDING`;
DROP TABLE IF EXISTS `ARTICLE`;
DROP TABLE IF EXISTS `SETTING`;
DROP TABLE IF EXISTS `CATEGORY`;
DROP TABLE IF EXISTS `ARTICLE_CATEGORY`;
DROP TABLE IF EXISTS `ARTICLE_BOOKMARK`;
DROP TABLE IF EXISTS `ATTENDANCE`;
DROP TABLE IF EXISTS `CHALLENGE`;
DROP TABLE IF EXISTS `ARTICLE_CONTENT`;
DROP TABLE IF EXISTS `ARTICLE_TAG`;
DROP TABLE IF EXISTS `TODAY_ARTICLE_NOTIFICATION`;

CREATE TABLE `MEMBER`
(
    `MEMBER_ID`         bigint auto_increment primary key,
    `SOCIAL_ID`         varchar(300) NOT NULL,
    `SOCIAL_TYPE`       varchar(30)  NOT NULL,
    `MEMBER_ROLE`       varchar(30)  NOT NULL,
    `FCM_TOKEN`         varchar(300) NULL,
    `PROFILE_IMAGE_URL` varchar(300) NULL,
    `CREATED_AT`        datetime     NOT NULL,
    `MODIFIED_AT`       datetime     NOT NULL
);

CREATE TABLE `ONBOARDING`
(
    `ONBOARDING_ID`  bigint auto_increment primary key,
    `MEMBER_ID`      bigint      NOT NULL,
    `PREGNANT_WEEKS` smallint    NOT NULL,
    `BABY_NICKNAME`  varchar(30) NOT NULL,
    `CREATED_AT`     datetime    NOT NULL,
    `MODIFIED_AT`    datetime    NOT NULL
);

CREATE TABLE `ARTICLE`
(
    `ARTICLE_ID`         bigint auto_increment primary key,
    `TITLE`              varchar(100) NOT NULL,
    `AUTHOR`             varchar(30)  NOT NULL,
    `CATEGORY`           varchar(30)  NOT NULL,
    `MAIN_IMAGE_URL`     varchar(300) NOT NULL,
    `MAIN_IMAGE_CAPTION` varchar(100) NOT NULL,
    `WEEK`               smallint     NOT NULL,
    `DAY`                smallint     NOT NULL,
    `REQUIRED_TIME`      smallint     NOT NULL,
    `CREATED_AT`         datetime     NOT NULL,
    `MODIFIED_AT`        datetime     NOT NULL
);

CREATE TABLE `ARTICLE_BOOKMARK`
(
    `ARTICLE_BOOKMARK_ID` bigint auto_increment primary key,
    `MEMBER_ID`           bigint   NOT NULL,
    `ARTICLE_ID`          bigint   NOT NULL,
    `CREATED_AT`          datetime NOT NULL,
    `MODIFIED_AT`         datetime NOT NULL
);

CREATE TABLE `ATTENDANCE`
(
    `ATTENDANCE_ID` bigint auto_increment primary key,
    `MEMBER_ID`     bigint   NOT NULL,
    `CREATED_AT`    datetime NOT NULL,
    `MODIFIED_AT`   datetime NOT NULL
);

CREATE TABLE `CHALLENGE`
(
    `CHALLENGE_ID` bigint auto_increment primary key,
    `MEMBER_ID`    bigint      NOT NULL,
    `LEVEL`        varchar(30) NOT NULL,
    `POPUP`        varchar(30) NOT NULL,
    `CREATED_AT`   datetime    NOT NULL,
    `MODIFIED_AT`  datetime    NOT NULL
);

CREATE TABLE `ARTICLE_CONTENT`
(
    `ARTICLE_CONTENT_ID` bigint auto_increment primary key,
    `ARTICLE_ID`         bigint      NOT NULL,
    `TYPE`               varchar(30) NOT NULL,
    `ORDER`              smallint    NOT NULL,
    `CONTENT`            text        NOT NULL,
    `CAPTION`            varchar(100) NULL,
    `CREATED_AT`         datetime    NOT NULL,
    `MODIFIED_AT`        datetime    NOT NULL
);

CREATE TABLE `ARTICLE_TAG`
(
    `ARTICLE_TAG_ID` bigint auto_increment primary key,
    `ARTICLE_ID`     bigint      NOT NULL,
    `TAG_NAME`       varchar(30) NOT NULL,
    `CREATED_AT`     datetime    NOT NULL,
    `MODIFIED_AT`    datetime    NOT NULL
);

CREATE TABLE `SETTING`
(
    `SETTING_ID`          bigint auto_increment primary key,
    `MEMBER_ID`           bigint      NOT NULL,
    `NOTIFICATION_STATUS` varchar(30) NOT NULL,
    `CREATED_AT`          datetime    NOT NULL,
    `MODIFIED_AT`         datetime    NOT NULL
);

CREATE TABLE `TODAY_ARTICLE_NOTIFICATION`
(
    `TODAY_ARTICLE_NOTIFICATION_ID` bigint auto_increment primary key,
    `WEEK`                          smallint     NOT NULL,
    `DAY`                           smallint     NOT NULL,
    `TITLE`                         varchar(100) NOT NULL,
    `BODY`                          varchar(100) NOT NULL,
    `CREATED_AT`                    datetime     NOT NULL,
    `MODIFIED_AT`                   datetime     NOT NULL
);