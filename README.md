# 🦁 LionHeart-Server

> 하루 10분, 좋은 아빠가 되는 방법


<br><br>
##  💻 LionHeart-Server Developers



<img src="https://github.com/gosopt-LionHeart/LionHeart-Server/assets/64000241/08381e4c-15b5-42b9-8ffc-1e887e688f16" width="175"> | <img src="https://github.com/gosopt-LionHeart/LionHeart-Server/assets/64000241/08381e4c-15b5-42b9-8ffc-1e887e688f16" width="175"> | <img src="https://github.com/gosopt-LionHeart/LionHeart-Server/assets/64000241/08381e4c-15b5-42b9-8ffc-1e887e688f16" width="175"> |
:---------:|:----------:|:---------:|
최승준 | 공혁준 | 강수경 | 
[PgmJun](https://github.com/PgmJun) | [orijoon98](https://github.com/orijoon98) | [sookyungg](https://github.com/sookyungg) | 
<br>

<br><br>
##  💻 LionHeart-Server Developers Roles

최승준 | 공혁준 | 강수경 |
|:---------:|:----------:|:---------:|
CI/CD 배포 세팅 | 알림서버 구현 | OAuth2 로그인 구현 |
API 개발 | API 개발 | API 개발 |
<br>

<br><br>

## 💻 Development Environment

<img src ="https://img.shields.io/badge/spring-2.7.13-green?logo=spring" height="30"> <img src ="https://img.shields.io/badge/JAVA-11-white?logo=java" height="30"> 




<br>

## 📝 Coding Convention, Git flow
- [Convention and flow](https://www.notion.so/efe35fa22c0044b4bd4c0dd5ff014d04?pvs=4)


## 📒 Foldering

```
📦 LionHeart-Server
├─ .github
│  ├─ ISSUE_TEMPLATE
│  │  ├─ ✅-feature.md
│  │  └─ 🐞-bug.md
│  ├─ PULL_REQUEST_TEMPLATE.md
│  └─ workflows
│     ├─ CD-dev.yml
│     ├─ CD-prod.yml
│     ├─ CI-dev.yml
│     └─ CI-prod.yml
├─ .gitignore
├─ .gitmessage.txt
├─ README.md
├─ appspec.yml
├─ build.gradle
├─ docker-compose.yml
├─ gradle
│  └─ wrapper
│     ├─ gradle-wrapper.jar
│     └─ gradle-wrapper.properties
├─ gradlew
├─ gradlew.bat
├─ lionheart-api
│  ├─ build.gradle
│  └─ src
│     └─ main
│        ├─ java
│        │  └─ com
│        │     └─ chiwawa
│        │        └─ lionheart
│        │           └─ api
│        │              ├─ ApiApplication.java
│        │              ├─ config
│        │              │  └─ swagger
│        │              │     └─ SwaggerConfig.java
│        │              └─ controller
│        │                 └─ advice
│        │                    └─ ControllerAdvice.java
│        └─ resources
│           ├─ application-local.yml
│           ├─ application.yml
│           └─ sql
│              ├─ data.sql
│              └─ schema.sql
├─ lionheart-common
│  ├─ build.gradle
│  └─ src
│     └─ main
│        └─ java
│           └─ com.chiwawa.lionheart.common
│              ├─ LionHeartCommonRoot.java
│              ├─ dto
│              │  └─ ApiResponse.java
│              └─ exception
│                 ├─ BadGatewayException.java
│                 ├─ ConflictException.java
│                 ├─ ErrorCode.java
│                 ├─ ForbiddenException.java
│                 ├─ InternalServerException.java
│                 ├─ LionHeartException.java
│                 ├─ NotFoundException.java
│                 ├─ UnAuthorizedException.java
│                 └─ ValidationException.java
├─ lionheart-domain
│  ├─ build.gradle
│  └─ src
│     └─ main
│        └─ java
│           └─ com
│              └─ chiwawa
│                 └─ lionheart
│                    └─ domain
│                       ├─ LionHeartDomainRoot.java
│                       ├─ config
│                       │  ├─ jpa
│                       │  │  └─ JpaConfig.java
│                       │  └─ querydsl
│                       │     └─ QueryDslConfig.java
│                       └─ domain
│                          ├─ article
│                          │  ├─ Article.java
│                          │  ├─ ArticleCategory.java
│                          │  ├─ ArticleContent.java
│                          │  ├─ ArticleContentType.java
│                          │  ├─ ArticleImage.java
│                          │  └─ Category.java
│                          ├─ articlebookmark
│                          │  └─ ArticleBookmark.java
│                          ├─ challenge
│                          │  ├─ Attendance.java
│                          │  ├─ Challenge.java
│                          │  ├─ ChallengeLevelType.java
│                          │  └─ ChallengePopupType.java
│                          ├─ common
│                          │  └─ BaseEntity.java
│                          └─ member
│                             ├─ Member.java
│                             ├─ MemberSocialType.java
│                             ├─ Onboarding.java
│                             ├─ SocialInfo.java
│                             └─ repository
│                                ├─ MemberRepository.java
│                                ├─ MemberRepositoryCustom.java
│                                └─ MemberRepositoryImpl.java
├─ lionheart-external
│  ├─ build.gradle
│  └─ src
│     └─ main
│        └─ java
│           └─ com
│              └─ chiwawa
│                 └─ lionheart
│                    └─ external
│                       └─ LionHeartExternalRoot.java
├─ naver-intellij-formatter.xml
├─ scripts
│  ├─ deploy.sh
│  └─ switch.sh
└─ settings.gradle
```

