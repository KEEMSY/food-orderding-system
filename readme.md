# Food-Ordering-System
*Microservices: Clean Architecture, DDD, SAGAm Outbox & Kafka*

[Udemy 강의 링크](https://www.udemy.com/course/microservices-clean-architecture-ddd-saga-outbox-kafka-kubernetes/)

Food-Ordering-System 은 클린 아키텍처, 아키텍처101, 도메인주도개설계핵심 등의 책을 독서하며, 실제 코드로 좀 더 깊게 알아보고자 공부하게되었습니다. 
이 프로젝트를 계기로 관련된(혹은 다른) 아키텍처, 코드 를 보고 관련 이야기를 나눠볼 수 있으면 좋을 것 같습니다! 

<br><hr>

## Overview

![project-overview-section-1.png](img/project-overview-section-1.png)

### **`food-ordering-system`** 은 **`클린 아키텍처`** 를 준수하는 **`마이크로서비스`** 입니다.

- 세분화된 `서비스(마이크로서비스)`로 인해 독립적인 개발 및 배포, 쉬운 수평적 확장이 가능합니다.
- 의존성역전을 통해 종속성 규칙을 엄격하게 관리합니다.(다형성을 사용하여 종속성 규칙을 생성하고, 도메인 계층을 가장 독립적이고 안정적인 계층으로 만들 수 있습니다.)



###  **`food-ordering-system`** 은 **`포트 및 어댑터패턴`** 으로도 알려진 **`헥사고날(육각형) 아키텍처`** 입니다.

- `포트` 는 잘 정의된 인터페이스를 말하며, 그리고 교체가능한 `어댑터` 로 인터페이스를 구현합니다.
- 인프라와 독립적인 소프트웨어의 비즈니스 로직을 개발하고 테스트하는데 도움이 됩니다..
- 오래 지속되는 애플리케이션을 개발하는데 도움이 됩니다.  

###  **`food-ordering-system`** 은 이해, 개발 및 유지 관리하기 쉬운 **`DDD`** 를 따릅니다. 

- 각 마이크로서비스에서 비즈니스로직을 구현할 때 `도메인 기반 디자인` 원칙을 준수합니다.
- `Entity`, `Aggregate`, `Value Object`,`Domain Service` 및 `Domain Application Service` 를 사용합니다.
- 경계에서는 다른 Service 에 대한 알림을 생성하는 `Domain Event` 로 `Kafaka` 를 사용합니다.

<br>

> **`Kafka` 는 `SaGa`, `Outbox` 및 `CQRS` 패턴의 구현에 사용된다.**

- `producer` 가 kafka topic 에 대한 데이터를 Publish 하며, `consumer` 는 kafka topic 에서 데이터를 읽는 역할을 합니다.
- `Saga` 는 장기 실행 트랜잭션을 완료하기 위해 서비스 전반에 걸쳐 로컬 ACID 트랜잭션 체인을 만드는 것을 말합니다.
- `OutBox` 는 이벤트를 직접 개시하지 않고 로컬 데이터베이스 테이블에 이벤트를 보관합니다.

`Outbox` 를 사용하면 단일 ACID 트랜잭션을 사용하여 서비스에서 데이터베이스 작업을 완료할 수 있습니다. 따라서 이를 통해 강한 일관성을 보장합니다.

<br>

> **`CQRS`(명령 쿼리 책임 분리) 를 통해 데이터를 좀 더 효과적으로 사용한다.**

- 시스템의 `read` 및 `write` 부분을 별도의 데이터베이스로 설계하여 `read` 부분을 좀 더 효과적으로 쿼리할 수 있게 합니다.
- `read` 및 `write` 시스템을 별도로 확장할 수 있습니다.
