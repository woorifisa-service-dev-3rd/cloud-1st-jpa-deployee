FROM eclipse-temurin:17-jdk-alpine AS builder 

# 컨테이너 내부 디렉토리 경로
WORKDIR /usr/src/app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# 빌드 수행
RUN chmod +x gradlew
RUN ./gradlew build

# Application 실행에 관련된 스크립트 --------------------------------
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /usr/src/app/build/libs/*.jar app.jar

ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]