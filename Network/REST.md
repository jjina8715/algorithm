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
  - 웹 표준 HTTP 프로토콜을 그대로 사용하므로 웹에서 사용하는 기존의 인프라를 그대로 활용가능
    - HTTP 프로토콜 표준에서 사용하는 Last-Modified 태그나 E-Tag를 이용하면 캐싱 구현이 가능
  - 대량의 요청을 효율적으로 처리하기 위해 캐시가 요구된다
  - 캐시 사용을 통해 응답시간이 빨라지고 REST Server 트랙잭션이 발생하지 않기 때문에 전체 응답시간, 성능, 서버의 자원 이용률을 향상 가능
- Layered System(계층화)
  - Client는 REST API Server만 호출
  - REST Server는 다중 계층으로 구성가능
    - API Server는 순수 비즈니스 로직으로 수행하고 그 앞단에 보안, 로드밸런싱, 암호화, 사용자 인증 등을 추가하여 구조상의 유연성을 줄 수 있다.
    - 로드 밸런신, 공유 캐시 등을 통해 확장성과 보안성 향상 가능
  - PROXY, 게이트웨이 같은 네트워크 기반의 중간 매체 사용 가능
- Code-On-Demand(optional)
  - Server로부터 스크립트를 받아서 Client에서 실행
  - 반드시 충족할 필요는 없다
- Uniform Interface(인터페이스 일관성)
  - URI로 지정한 Resource에 대한 조작을 통일되고 한정적인 인터페이스로 수행
  - HTTP 표준 프로토콜에 따르는 모든 플랫폼에서 사용 가능
    - 특정 언어나 기술에 종속되지 않는다

<h3>REST API</h3>

[REST API란]

- API(Application Programming Interface)
  - 데이터와 기능의 집합을 제공하여 컴퓨터 프로그램간 상호작용을 촉징하며, 서로 정보를 교환가능 하도록 하는 것
- REST API의 정의
  - REST 기반으로 서비스 API를 구현하는 것
  - 최근 Open API (누구나 사용할 수 있도록 공개된 API), 마이크로 서비스(하나의 큰 애플리케이션을 여러 개의 작은 애플리케이션으로 쪼개어 변겨오가 조합이 가능하도록 만든 아키텍처) 등을 제공하는 업체 대부분은 REST API를 제공

[특징]

- REST 기반으로 시스템을 분산해 확장성과 재사용성을 높여 유지보수 및 운용을 편리하게 할 수 있다
- REST는 HTTP 표준을 기반으로 구현하므로, HTTP를 지원하는 프로그램언어로 클라이언트, 서버 구현 가능
- REST API를 제작하면 델파이 클라이언트 뿐 아니라 자바, c#, 웹 등을 이용해 클라이언트를 제작 가능

[설계 기본 규칙]

- 리소스 원형
  - document : 객체 instance나 database record와 유사한 개념
  - collection : server에서 관리하는 directory라는 resource
  - store : client에서 관리하는 resource 저장소

1. URI는 정보의 자원을 표현해야 한다
   - resource는 동사보다는 명사를, 대문자보다는 소문자를 사용
   - resource의 document 이름으로는 단수 명사를 사용
   - resource의 collection 이름으로는 복수 명사를 사용
   - resource의 store 이름으로는 복수 명사를 사용
2. 자원에 대한 행위는 HTTP Method(GET, PUT, POST, DELETE 등)로 표현
   - URI에 HTTP Method가 들어가면 안된다.
   - URI에 행위에 대한 동사 표현이 들어가면 안 된다(CURD 기능을 나타내는 것은 URI에 사용하지 않는다)
   - 경로 부분 중 변하는 부분은 유일한 값으로 대체(:id는 하나의 특정 resource를 나타내는 고유값)

[설계 규칙]

- 슬래시 구분자(/)는 계츨 관계를 나타내는데 사용
- URI 마지막 문자로 /를 포함하지 않는다
  - URI에 포함되는 모든 글자는 resource의 유일한 식별자로 사용되어야 한다
  - 분명한 URI를 만들어 통신을 해야 하기 때문에 혼동을 주지 않도록 URI 경로의 마지막에는 /를 사용하지 않는다
- -은 URI 가독성을 높이는 데 사용
  - 불가피하게 긴 URI 경로를 사용하게 된다면 -을 사용해 가독성을 높인다
- _은 URI에 사용하지 않는다
  - _은 보기 어렵거나 밑줄 때문에 문자가 가려지기도 하므로 가독성을 위해 밑줄은 사용하지 않는다.
- URI 경로에는 소문자가 적합
  - URI 경로에 대문자 사용은 피하도록 한다
  - b/c RFC 3986(URI 문법 형식)은 URI 스키마와 호스트를 제외하고는 대소문자를 구별하도록 규정
- 파일확장자는 URI에 포함하지 않는다
  - REST API에서는 메시지 바디 내용의 포맷을 나타내기 위하 파일 확장자를 URI 안에 포함시키지 않는다
  - Accept header를 사용
-  리소스 간에 연관 관계가 있는 경우
  - /리소스명/리소스ID/관계가있는다른리소스명

[REST API 설계 예시]

| CRUD                        | HTTP verbs | Route         |
| --------------------------- | ---------- | ------------- |
| resource들의 목록을 표시    | GET        | /resource     |
| resource 하나의 내용을 표시 | GET        | /resource/:id |
| resource를 생성             | POST       | /resource     |
| resource를 수정             | PUT        | /resource/:id |
| resource를 삭제             | DELETE     | /resource/:id |

- 응답 상태 코드
  - 1xx : 전송 프로토콜 수준의 정보 교환
  - 2xx : client 요청이 성공적으로 수행
  - 3xx : client는 요청을 완료하기 위해 추가적인 행동을 취해야 함
  - 4xx : client의 잘못된 요청
  - 5xx : 서버쪽 오류로 인한 상태코드

<h3>RESTful</h3>

[RESTful이란]

- 일반적으로 REST라는 아키텍처를 구현하는 웹 서비스를 나타내기 위해 사용되는 용어
  - 'REST API'를 제공하는 웹 서비스를 'RESTful'하다고 할 수 있다.
- RESTful은 REST를 REST답게 쓰기 위한 방법, 비공식적 용어
  - REST 원리를 따르는 시스템은 RESTful이란 용어로 지칭

[목적]

- 이해하기 쉽고 사용하기 쉬운 REST API를 만드는 것
- RESTful한 API를 구현하는 근본적인 목적이 성능 향상에 있는 것이 아니라, 일관적인 컨벤션을 통한 API의 이해도 및 호환성을 높이는 것이 주 동기이니, 성능이 중요한 상황에서는 굳이 RESTful한 API를 구현할 필요는 없다

[RESTful하지 못한 경우]

- ex
  - CRUD 기능을 모두 POST로만 처리하는 API
  - route에 resource, id 외의 정보가 들어가는 경우

<h3>References</h3>

- https://gmlwjd9405.github.io/2018/09/21/rest-and-restful.html