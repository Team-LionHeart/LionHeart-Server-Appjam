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

<br><br>

## 📝 Coding Convention, Git flow

> [Convention and flow](https://www.notion.so/efe35fa22c0044b4bd4c0dd5ff014d04?pvs=4)

<br><br>


## 📒 Foldering

```
📦 LionHeart-Server
├─ .github
│  ├─ ISSUE_TEMPLATE
│  │  ├─ ✅-feature.md
│  │  └─ 🐞-bug.md
│  ├─ PULL_REQUEST_TEMPLATE.md
│  └─ workflows
│     ├─ api-cd-dev.yml
│     ├─ api-ci-dev.yml
│     ├─ notification-cd-dev.yml
│     └─ notification-ci-dev.yml
├─ .gitignore
├─ .gitmessage.txt
├─ README.md
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
│        │              │  ├─ WebConfig.java
│        │              │  ├─ interceptor
│        │              │  │  ├─ admin
│        │              │  │  │  ├─ Admin.java
│        │              │  │  │  ├─ AdminCheckHandler.java
│        │              │  │  │  └─ AdminInterceptor.java
│        │              │  │  └─ auth
│        │              │  │     ├─ Auth.java
│        │              │  │     ├─ AuthInterceptor.java
│        │              │  │     └─ LoginCheckHandler.java
│        │              │  ├─ redis
│        │              │  │  └─ RedisConfig.java
│        │              │  ├─ resolver
│        │              │  │  ├─ MemberId.java
│        │              │  │  └─ MemberIdResolver.java
│        │              │  ├─ sqs
│        │              │  │  ├─ SqsConfig.java
│        │              │  │  └─ producer
│        │              │  │     └─ SqsProducer.java
│        │              │  └─ swagger
│        │              │     └─ SwaggerConfig.java
│        │              ├─ controller
│        │              │  ├─ advice
│        │              │  │  └─ ControllerAdvice.java
│        │              │  ├─ article
│        │              │  │  └─ ArticleRetrieveController.java
│        │              │  ├─ articlebookmark
│        │              │  │  ├─ ArticleBookmarkController.java
│        │              │  │  └─ ArticleBookmarkRetrieveController.java
│        │              │  ├─ auth
│        │              │  │  └─ AuthController.java
│        │              │  ├─ challenge
│        │              │  │  └─ ChallengeRetrieveController.java
│        │              │  ├─ curriculum
│        │              │  │  └─ CurriculumRetrieveController.java
│        │              │  ├─ member
│        │              │  │  ├─ MemberController.java
│        │              │  │  └─ MemberRetrieveController.java
│        │              │  └─ notification
│        │              │     ├─ NotificationController.java
│        │              │     └─ dto
│        │              │        └─ request
│        │              │           ├─ CustomNotificationRequest.java
│        │              │           └─ SlackNotificationRequest.java
│        │              └─ service
│        │                 ├─ article
│        │                 │  ├─ ArticleRetrieveService.java
│        │                 │  ├─ ArticleServiceUtils.java
│        │                 │  ├─ articleContent
│        │                 │  │  └─ ArticleContentServiceUtils.java
│        │                 │  ├─ articleTag
│        │                 │  │  └─ ArticleTagServiceUtils.java
│        │                 │  └─ dto
│        │                 │     └─ response
│        │                 │        ├─ ArticleBookmarkSummaryDto.java
│        │                 │        ├─ ArticleContentDto.java
│        │                 │        ├─ ArticleDetailResponse.java
│        │                 │        ├─ ArticleSummaryDto.java
│        │                 │        ├─ ArticleSummaryResponse.java
│        │                 │        ├─ TodayArticleResponse.java
│        │                 │        └─ WeekArticleSummaryResponse.java
│        │                 ├─ articlebookmark
│        │                 │  ├─ ArticleBookmarkRetrieveService.java
│        │                 │  ├─ ArticleBookmarkService.java
│        │                 │  ├─ ArticleBookmarkServiceUtils.java
│        │                 │  └─ dto
│        │                 │     ├─ request
│        │                 │     │  └─ UpdateArticleBookmarkRequest.java
│        │                 │     └─ response
│        │                 │        ├─ ArticleBookmarkResponse.java
│        │                 │        └─ ArticleSummaryDto.java
│        │                 ├─ auth
│        │                 │  ├─ AuthService.java
│        │                 │  ├─ AuthServiceProvider.java
│        │                 │  ├─ CommonAuthService.java
│        │                 │  ├─ CreateTokenService.java
│        │                 │  ├─ dto
│        │                 │  │  ├─ request
│        │                 │  │  │  ├─ LoginRequest.java
│        │                 │  │  │  ├─ SignUpRequest.java
│        │                 │  │  │  └─ TokenRequest.java
│        │                 │  │  └─ response
│        │                 │  │     └─ TokenResponse.java
│        │                 │  └─ impl
│        │                 │     └─ KakaoAuthService.java
│        │                 ├─ challenge
│        │                 │  ├─ ChallengeRetrieveService.java
│        │                 │  ├─ ChallengeService.java
│        │                 │  ├─ ChallengeServiceUtils.java
│        │                 │  └─ dto
│        │                 │     └─ response
│        │                 │        └─ ChallengeProgressResponse.java
│        │                 ├─ curriculum
│        │                 │  ├─ CurriculumRetrieveService.java
│        │                 │  └─ dto
│        │                 │     └─ response
│        │                 │        └─ CurriculumProgressResponse.java
│        │                 ├─ member
│        │                 │  ├─ MemberRetrieveService.java
│        │                 │  ├─ MemberService.java
│        │                 │  ├─ MemberServiceUtils.java
│        │                 │  └─ dto
│        │                 │     ├─ request
│        │                 │     │  └─ CreateMemberRequest.java
│        │                 │     └─ response
│        │                 │        └─ ProfileResponse.java
│        │                 └─ notification
│        │                    └─ NotificationService.java
│        └─ resources
│           ├─ application-dev.yml
│           ├─ application-local.yml
│           ├─ application.yml
│           ├─ bootstrap.yml
│           ├─ messages
│           │  └─ validation.properties
│           └─ sql
│              ├─ data.sql
│              └─ schema.sql
├─ lionheart-common
│  ├─ build.gradle
│  └─ src
│     └─ main
│        └─ java
│           └─ com
│              └─ chiwawa
│                 └─ lionheart
│                    └─ common
│                       ├─ LionHeartCommonRoot.java
│                       ├─ constant
│                       │  ├─ Constraint.java
│                       │  ├─ JwtKey.java
│                       │  ├─ MessageType.java
│                       │  ├─ ProfileType.java
│                       │  ├─ RedisKey.java
│                       │  └─ message
│                       │     ├─ ArticleBookmarkErrorMessage.java
│                       │     ├─ ArticleErrorMessage.java
│                       │     ├─ AuthErrorMessage.java
│                       │     ├─ CategoryErrorMessage.java
│                       │     ├─ ChallengeErrorMessage.java
│                       │     ├─ FirebaseErrorMessage.java
│                       │     └─ MemberErrorMessage.java
│                       ├─ dto
│                       │  ├─ ApiResponse.java
│                       │  ├─ WeekAndDay.java
│                       │  └─ sqs
│                       │     ├─ FirebaseDto.java
│                       │     ├─ MessageDto.java
│                       │     └─ SlackDto.java
│                       ├─ exception
│                       │  ├─ ErrorCode.java
│                       │  └─ model
│                       │     ├─ BadGatewayException.java
│                       │     ├─ ConflictException.java
│                       │     ├─ ForbiddenException.java
│                       │     ├─ InternalServerException.java
│                       │     ├─ LionHeartException.java
│                       │     ├─ NotFoundException.java
│                       │     ├─ UnAuthorizedException.java
│                       │     └─ ValidationException.java
│                       └─ util
│                          ├─ DateUtils.java
│                          ├─ JwtUtils.java
│                          ├─ MessageUtils.java
│                          └─ UuidUtils.java
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
│                          │  ├─ ArticleType.java
│                          │  ├─ Category.java
│                          │  ├─ articleContent
│                          │  │  ├─ ArticleContent.java
│                          │  │  └─ ArticleContentType.java
│                          │  ├─ articleTag
│                          │  │  └─ ArticleTag.java
│                          │  └─ repository
│                          │     ├─ ArticleRepository.java
│                          │     ├─ ArticleRepositoryCustom.java
│                          │     └─ ArticleRepositoryImpl.java
│                          ├─ articlebookmark
│                          │  ├─ ArticleBookmark.java
│                          │  └─ repository
│                          │     ├─ ArticleBookmarkRepository.java
│                          │     ├─ ArticleBookmarkRepositoryCustom.java
│                          │     └─ ArticleBookmarkRepositoryImpl.java
│                          ├─ challenge
│                          │  ├─ Attendance.java
│                          │  ├─ Challenge.java
│                          │  ├─ ChallengeLevelType.java
│                          │  └─ repository
│                          │     ├─ AttendanceRepository.java
│                          │     ├─ AttendanceRepositoryCustom.java
│                          │     ├─ AttendanceRepositoryImpl.java
│                          │     ├─ ChallengeRepository.java
│                          │     ├─ ChallengeRepositoryCustom.java
│                          │     └─ ChallengeRepositoryImpl.java
│                          ├─ common
│                          │  └─ BaseEntity.java
│                          ├─ member
│                          │  ├─ Member.java
│                          │  ├─ MemberRole.java
│                          │  ├─ MemberSocialType.java
│                          │  ├─ NotificationStatus.java
│                          │  ├─ Onboarding.java
│                          │  ├─ Setting.java
│                          │  ├─ SocialInfo.java
│                          │  └─ repository
│                          │     ├─ MemberRepository.java
│                          │     ├─ MemberRepositoryCustom.java
│                          │     ├─ MemberRepositoryImpl.java
│                          │     ├─ OnboardingRepository.java
│                          │     ├─ OnboardingRepositoryCustom.java
│                          │     ├─ OnboardingRepositoryImpl.java
│                          │     ├─ SettingRepository.java
│                          │     └─ SettingRepositoryCustom.java
│                          └─ notification
│                             ├─ TodayArticleNotification.java
│                             └─ repository
│                                ├─ TodayArticleNotificationRepository.java
│                                ├─ TodayArticleNotificationRepositoryCustom.java
│                                └─ TodayArticleNotificationRepositoryImpl.java
├─ lionheart-external
│  ├─ build.gradle
│  └─ src
│     └─ main
│        └─ java
│           └─ com
│              └─ chiwawa
│                 └─ lionheart
│                    └─ external
│                       ├─ LionHeartExternalRoot.java
│                       ├─ client
│                       │  ├─ auth
│                       │  │  └─ kakao
│                       │  │     ├─ KakaoApiCaller.java
│                       │  │     ├─ WebClientKakaoCaller.java
│                       │  │     └─ dto
│                       │  │        └─ response
│                       │  │           └─ KakaoProfileResponse.java
│                       │  └─ firebase
│                       │     ├─ FirebaseApiCaller.java
│                       │     └─ WebClientFirebaseCaller.java
│                       └─ config
│                          └─ webclient
│                             └─ WebClientConfig.java
├─ lionheart-notification
│  ├─ build.gradle
│  └─ src
│     └─ main
│        ├─ java
│        │  └─ com
│        │     └─ chiwawa
│        │        └─ lionheart
│        │           └─ notification
│        │              ├─ NotificationApplication.java
│        │              ├─ config
│        │              │  ├─ scheduler
│        │              │  │  ├─ SchedulerConfig.java
│        │              │  │  └─ SchedulerErrorHandler.java
│        │              │  └─ sqs
│        │              │     ├─ SqsConfig.java
│        │              │     └─ consumer
│        │              │        └─ SqsConsumer.java
│        │              └─ service
│        │                 ├─ firebase
│        │                 │  ├─ FirebaseCloudMessageService.java
│        │                 │  └─ dto
│        │                 │     └─ request
│        │                 │        └─ FcmMessageRequest.java
│        │                 ├─ scheduler
│        │                 │  └─ SchedulerService.java
│        │                 └─ slack
│        │                    └─ SlackMessageService.java
│        └─ resources
│           ├─ application-dev.yml
│           ├─ application-local.yml
│           ├─ application.yml
│           └─ bootstrap.yml
├─ naver-intellij-formatter.xml
├─ scripts
│  ├─ lionheart-api
│  │  ├─ appspec.yml
│  │  ├─ health_check.sh
│  │  ├─ run_new_was.sh
│  │  └─ switch.sh
│  └─ lionheart-notification
│     ├─ appspec.yml
│     └─ deploy.sh
└─ settings.gradle
```
