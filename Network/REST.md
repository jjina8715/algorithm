# REST

<h3>REST</h3>

[REST란]

- 정의

  - Representational State Transfer

    - 자원을 이름(자원의 표현)으로 구분하여 해당 자원의 상태(정보)를 주고 받는 모든 것

    - 자원(resource)의 표현(representation)에 의한 상태 전달

      a. 자원의 표현

      - 자원 : 해당 소프트웨어가 관리하는 모든 것
      - 자원의 표현 : 그 자원을 표현하기 위한 이름

      b. 상태 

      - 데이터가 요청되어지는 시점에서 자원의 상태(정보)를 전달
      - JSON 혹은 XML를 통해 데이터를 주고 받는 것이 일반적

  - www과 같은 분산 하이퍼미디어 시스템을 위한 소프트웨어 개발 아키텍처의 한 형식

    - REST는 기본적으로 웹의 기존 기술과 HTTP 프로토콜을 그대로 활용 → 웹의 장점을 최대한 활용할 수 있는 아키텍처 스타일
    - REST는 네트워크 상에서 Client와 Server 사이의 통신 방식 중 하나

- 개념
  - HTTP URI(Uniform Resource Identifier)를 통해 자원(Source)을 명시하고, HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CURD Operation을 적용하는 것을 의미
    - 자원 기반의 구조(ROA, Resource Oriented Architecture) 설계의 중심에 Resource가 있고 HTTP Method를 통해 Resource를 처리하도록 설계된 아키텍처
    - 웹 사이트의 이미지, 텍스트, DB 내용 등의 모든 자원에 고유한 ID인 HTTP URI를 부여
    - CURD Operation
      - Create : 생성(POST)
      - Read : 조회(GET)
      - Update : 수정(PUT)
      - Delete : 삭제(DELETE)
      - HEAD : header 정보 조회(HEAD)

[REST의 장단점]

- 장점
  - HTTP 프로토콜의 인프라를 그대로 사용하므로 REST API 사용을 위한 별도의 인프라를 구출할 필요가 없다
  - HTTP 프로토콜의 표준을 최대한 활용하여 여러 추가적인 장점을 함께 가져갈 수 있게 해준다
  - HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용이 가능
  - Hypermedia API의 기본을 충실히 지키면서 범용성을 보장
  - REST API 메시지가 의도하는 바를 명확하게 나타내므로 의도하는 바를 쉽게 파악
  - 여러가지 서비스 디자인에서 생길 수 있는 문제를 최소화
  - 서버와 클라이언트의 역할을 명확하게 분리
- 단점
  - 표준이 없다
  - 사용할 수 있는 메소드가 4가지 밖에 없다
    - HTTP Method 형태가 제한적
  - 브라우저를 통해 테스트할 일이 많은 서비스라면 쉽게 고칠 수 있는 URL보다 Header 값이 왠지 더 어렵게 느껴진다
  - 구형 브라우저가 아직 제대로 지원해주지 못하는 부분이 존재
    - PUT, DELETE를 사용하지 못한다
    - pushState를 비지원

[REST의 필요성]

- 애플리케이션 분리 및 통합
- 다양한 클라이언트의 등장
- 최근의 서버 프로그램은 다양한 브라우저와 안드로이드폰, 아이폰과 같은 모바일 디바이스에서도 통신할 수 있어야 한다
- 멀티 플랫폼에 대한 지원을 위해 서비스 자원에 대한 아키텍처를 세우고 이용하는 방법

[REST 구성요소]

1. 자원(Resource) : URI
   - 모든 자원에 고유한 ID가 존재, 자원은 Server에 존재
   - 자원을 구별하는 ID는 HTTP URI
   - Client는 URI를 이용해서 자원을 지정하고 해당 자원의 상태(정보)에 대한 조작을 Server에 요청
2. 행위(Verb) : HTTP Method
   - HTTP 프로토콜의 Method를 사용
   - HTTP 프로포콜은 GET, POST, PUT, DELETE와 같은 메서드를 제공
3. 표현(Representation of Resource)
   - Client가 자원의 상태(정보)에 대한 조작을 요청하면 Server는 이에 적절한 응답(Representation)을 보낸다
   - REST에서 하나의 자원은 JSON, XML, TEXT, RSS 등 여러 형태의 Representation으로 표현 가능
   - JSON 혹은 XML을 통해 데이터를 주고 받는 것이 일반적

[REST 특징]

- Server-Client(서버-클라이언트 구조)
  -  자원이 있는 쪽이 Server, 자원을 요청하는 쪽이 Client
    - REST Server : API를 제공하고 비즈니스 로직 처리 및 저장을 책인
    - Client : 사용자 인증이나 context(세션, 로그인 정보) 등을 직접 관리하고 책임
  - 서로 간 의존성 감소
- Stateless(무상태)
  - HTTP 프로토콜이 Stateless Protocol이므로 REST도 무상태성
  - Client의 context를 Server에 비저장
    - 세션의 쿠키와 같은 context 정보를 신경쓰지 않아도 되므로 구현이 단순
  - Server는 각각의 요청을 완전히 별개의 것으로 인식, 처리
    - 각 API 서버는 Client의 요청만을 단순 처리
    - Server의 처리 방식에 일관성을 부여, 부담 감소, 서비스의 자유도 상승
- Cacheable(캐시 처리 가능)
  - 
- Layered System(계층화)
- Code-On-Demand(optional)
- Uniform Interface(인터페이스 일관성)

https://gmlwjd9405.github.io/2018/09/21/rest-and-restful.html