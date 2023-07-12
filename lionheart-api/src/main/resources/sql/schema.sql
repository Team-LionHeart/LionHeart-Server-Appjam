DROP TABLE IF EXISTS `MEMBER`;
DROP TABLE IF EXISTS `ONBOARDING`;
DROP TABLE IF EXISTS `ARTICLE`;
DROP TABLE IF EXISTS `CATEGORY`;
DROP TABLE IF EXISTS `ARTICLE_CATEGORY`;
DROP TABLE IF EXISTS `ARTICLE_BOOKMARK`;
DROP TABLE IF EXISTS `ATTENDANCE`;
DROP TABLE IF EXISTS `CHALLENGE`;
DROP TABLE IF EXISTS `ARTICLE_CONTENT`;
DROP TABLE IF EXISTS `ARTICLE_TAG`;

CREATE TABLE `MEMBER`
(
    `MEMBER_ID`         bigint auto_increment primary key,
    `SOCIAL_ID`         varchar(300) NOT NULL,
    `SOCIAL_TYPE`       varchar(30)  NOT NULL,
    `FCM_TOKEN`         varchar(300) NULL,
    `PROFILE_IMAGE_URL` varchar(300) NULL,
    `CREATED_AT`        datetime     NOT NULL,
    `MODIFIED_AT`       datetime     NOT NULL
);

CREATE TABLE `ONBOARDING`
(
    `ONBOARDING_ID`  bigint auto_increment primary key,
    `MEMBER_ID`      bigint      NOT NULL,
    `PREGNANT_WEEKS` tinyint     NOT NULL,
    `BABY_NICKNAME`  varchar(30) NOT NULL,
    `CREATED_AT`     datetime    NOT NULL,
    `MODIFIED_AT`    datetime    NOT NULL
);

CREATE TABLE `ARTICLE`
(
    `ARTICLE_ID`         bigint auto_increment primary key,
    `TITLE`              varchar(100) NOT NULL,
    `AUTHOR`             varchar(30)  NOT NULL,
    `MAIN_IMAGE_URL`     varchar(300) NOT NULL,
    `MAIN_IMAGE_CAPTION` varchar(100) NOT NULL,
    `WEEK`               tinyint      NOT NULL,
    `DAY`                tinyint      NOT NULL,
    `REQUIRED_TIME`               tinyint      NOT NULL,
    `POSTED_AT`          datetime     NOT NULL,
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
    `ORDER`              tinyint     NOT NULL,
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