# 📱 Mini SNS Practice Project
> **Mini SNS 스터디 프로젝트**

[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/technologies/downloads/#java21)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-6DB33F)](https://spring.io/projects/spring-boot)

---

## 1. 📝 프로젝트 소개 (Introduction)

본 프로젝트는 소프트웨어 설계 및 AI 활용 능력 향상을 위함

## 2. 🏗 아키텍처 (Architecture)
프로젝트는 최상위 레벨에서 도메인 단위로 분할됨.

### 📦 패키지 구조 (Screaming Architecture)
```text
src/main/java/com/swm/sns_practice/
├── member/                    # [Member 도메인]
│   ├── domain/                # - Pure POJO: 비즈니스 규칙 및 도메인 객체 (lombok은 허용)
│   ├── application/           # - Service: 유즈케이스 및 트랜잭션 관리
│   ├── infrastructure/        # - Adapter: JPA Entity, Repository 구현체
│   └── presentation/          # - EntryPoint: Controller 및 DTO
├── post/                      # [Post 도메인]
│   ├── domain/                
│   ├── application/           
│   └── ...
├── global/                    # [Common] 공통 예외 처리, 보안, 유틸리티
└── SnsPracticeApplication.java
```

### 💎 도메인 모델 원칙
1. **의존성 배제**: `domain/` 패키지 내의 클래스들은 `import java.*` 외의 외부 라이브러리 임포트를 최소화하거나 배제(Lombok은 허용).
2. **풍부한 도메인 모델**: 데이터만 가진 DTO가 아닌, 비즈니스 검증과 행위를 스스로 수행하는 객체로 설계함.
3. **영속성 분리**: JPA Entity와 도메인 객체를 분리하여 인프라의 변경이 비즈니스 로직에 영향을 주지 않도록 함.

---

## 3. 🛠 기술 스택 (Tech Stack)
| 분류 | 기술 | 비고 |
| :--- | :--- | :--- |
| **Language** | Java 21 | Record, Pattern Matching 등 활용 |
| **Framework** | Spring Boot 4.0.5 | 최신 스프링 부트 기반 인프라 구성 |
| **Persistence** | Spring Data JPA | PostgreSQL 연동 및 데이터 영속화 |
| **Security** | Spring Security, JWT | 보안 및 인증 처리 |

---

## 4. 🚀 시작하기 (Getting Started)

### Prerequisites
- **JDK 21**
- **PostgreSQL** 15+

### Build & Run
```bash
# 빌드 및 테스트
./gradlew clean build

# 서버 실행
./gradlew bootRun
```