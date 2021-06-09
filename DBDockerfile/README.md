/* sys계정 접속 : sqlplus sys/oracle as sysdba */ /* 사용 포트 : "49161:1521", sqldevelop 등으로 접근 시 포트번호 49161로 접근해야 함 */

1. docker-compose up 으로 실행

2. docker exec -it movierecommendationwebservice_db_1 /bin/bash 로 접속

3. 다음을 입력하여 sql 파일을 삭제

rm /docker-entrypoint-initdb.d/movies.sql
  
rm /docker-entrypoint-initdb.d/user.sql
  
rm /docker-entrypoint-initdb.d/ratings.sql

rm /docker-entrypoint-initdb.d/mgs.sql

rm /docker-entrypoint-initdb.d/init_movies_seq.sql

rm /docker-entrypoint-initdb.d/init_users_seq.sql

rm /docker-entrypoint-initdb.d/init_ratings_seq.sql

rm /docker-entrypoint-initdb.d/mgs.sql
