/* sys계정 접속 : sqlplus sys/oracle as sysdba */ /* 사용 포트 : "49161:1521", sqldevelop 등으로 접근 시 포트번호 49161로 접근해야 함 */

1. docker-compose up 으로 실행

2. docker exec -it movierecommendation_db_1 /bin/bash init.bash 로 초기화