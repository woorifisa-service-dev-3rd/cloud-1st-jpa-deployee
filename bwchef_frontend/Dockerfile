# 빌드  ----------------------------------------
FROM node:18-alpine AS builder 

WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

# 실행  ----------------------------------------
FROM nginx:alpine
COPY --from=builder /app/build /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80