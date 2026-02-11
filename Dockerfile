
# 1단계: 빌드 (Gradle)

FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

# 1. gradlew와 설정 파일들만 먼저 복사함 (캐시 활용을 하기 위해서)
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# 2. 리눅스 환경에서 gradlew를 실행할 수 있게 실행 권한 부여
RUN chmod +x ./gradlew

# 3. 소스 코드를 복사하기 전에 종속성만 먼저 다운로드 받음.
#    소스 코드가 바뀌어도 라이브러리는 다시 다운받지 않아서 빌드가 빨라짐!!
RUN ./gradlew dependencies --no-daemon

# 4. 소스 코드를 복사
COPY src ./src

# 5. 빌드 실행
RUN ./gradlew clean build -x test --no-daemon

# 2단계: 실행

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
